package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AppRepository
import com.example.data.SampleData
import com.example.model.*
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

enum class MainTab {
    HOME,
    LEARN,
    PRACTICE,
    ABOUT
}

enum class LearnSubScreen {
    UNIT_LIST,
    UNIT_DETAIL,
    FLASHCARDS,
    QUIZ
}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val repository = AppRepository(application)
    val tts = TextToSpeechHelper(application)

    val currentLanguage: StateFlow<AppLanguage> = repository.currentLanguage
    val bookmarkedNewsIds: StateFlow<Set<String>> = repository.bookmarkedNewsIds
    val bookmarkedVocabIds: StateFlow<Set<String>> = repository.bookmarkedVocabIds
    val completedUnits: StateFlow<Set<String>> = repository.completedUnits
    val streakDays: StateFlow<Int> = repository.streakDays
    val totalPoints: StateFlow<Int> = repository.totalPoints

    // Navigation state
    private val _selectedTab = MutableStateFlow(MainTab.HOME)
    val selectedTab: StateFlow<MainTab> = _selectedTab.asStateFlow()

    private val _selectedHistoryTopic = MutableStateFlow<CulturalHistoryTopic?>(null)
    val selectedHistoryTopic: StateFlow<CulturalHistoryTopic?> = _selectedHistoryTopic.asStateFlow()

    fun openHistoryTopic(topic: CulturalHistoryTopic) {
        _selectedHistoryTopic.value = topic
    }

    fun closeHistoryTopic() {
        _selectedHistoryTopic.value = null
    }

    private val _activeNewsArticle = MutableStateFlow<NewsArticle?>(null)
    val activeNewsArticle: StateFlow<NewsArticle?> = _activeNewsArticle.asStateFlow()

    private val _newsCategory = MutableStateFlow(NewsCategory.ALL)
    val newsCategory: StateFlow<NewsCategory> = _newsCategory.asStateFlow()

    private val _newsSearchQuery = MutableStateFlow("")
    val newsSearchQuery: StateFlow<String> = _newsSearchQuery.asStateFlow()

    // Learn Screen State
    private val _learnSubScreen = MutableStateFlow(LearnSubScreen.UNIT_LIST)
    val learnSubScreen: StateFlow<LearnSubScreen> = _learnSubScreen.asStateFlow()

    private val _activeUnit = MutableStateFlow<LessonUnit?>(null)
    val activeUnit: StateFlow<LessonUnit?> = _activeUnit.asStateFlow()

    // Flashcard State
    private val _flashcardIndex = MutableStateFlow(0)
    val flashcardIndex: StateFlow<Int> = _flashcardIndex.asStateFlow()

    private val _isCardFlipped = MutableStateFlow(false)
    val isCardFlipped: StateFlow<Boolean> = _isCardFlipped.asStateFlow()

    // Quiz State
    private val _quizQuestionIndex = MutableStateFlow(0)
    val quizQuestionIndex: StateFlow<Int> = _quizQuestionIndex.asStateFlow()

    private val _selectedOptionIndex = MutableStateFlow<Int?>(null)
    val selectedOptionIndex: StateFlow<Int?> = _selectedOptionIndex.asStateFlow()

    private val _isAnswerSubmitted = MutableStateFlow(false)
    val isAnswerSubmitted: StateFlow<Boolean> = _isAnswerSubmitted.asStateFlow()

    private val _quizScore = MutableStateFlow(0)
    val quizScore: StateFlow<Int> = _quizScore.asStateFlow()

    private val _isQuizCompleted = MutableStateFlow(false)
    val isQuizCompleted: StateFlow<Boolean> = _isQuizCompleted.asStateFlow()

    // Dictionary State
    private val _dictSearchQuery = MutableStateFlow("")
    val dictSearchQuery: StateFlow<String> = _dictSearchQuery.asStateFlow()

    private val _selectedVocabCategory = MutableStateFlow<VocabCategory?>(null)
    val selectedVocabCategory: StateFlow<VocabCategory?> = _selectedVocabCategory.asStateFlow()

    // Inspection Vocab BottomSheet
    private val _inspectingVocab = MutableStateFlow<VocabularyWord?>(null)
    val inspectingVocab: StateFlow<VocabularyWord?> = _inspectingVocab.asStateFlow()

    // Language Selector Dialog
    private val _showLanguageDialog = MutableStateFlow(false)
    val showLanguageDialog: StateFlow<Boolean> = _showLanguageDialog.asStateFlow()

    fun selectTab(tab: MainTab) {
        _selectedTab.value = tab
        // If moving away from reader or quiz, stop speech
        tts.stop()
    }

    fun openNewsDetail(article: NewsArticle) {
        _activeNewsArticle.value = article
    }

    fun closeNewsDetail() {
        tts.stop()
        _activeNewsArticle.value = null
    }

    fun setNewsCategory(category: NewsCategory) {
        _newsCategory.value = category
    }

    fun setNewsSearchQuery(query: String) {
        _newsSearchQuery.value = query
    }

    fun toggleNewsBookmark(id: String) {
        repository.toggleNewsBookmark(id)
    }

    fun openUnit(unit: LessonUnit) {
        _activeUnit.value = unit
        _learnSubScreen.value = LearnSubScreen.UNIT_DETAIL
    }

    fun startFlashcards(unit: LessonUnit) {
        _activeUnit.value = unit
        _flashcardIndex.value = 0
        _isCardFlipped.value = false
        _learnSubScreen.value = LearnSubScreen.FLASHCARDS
    }

    fun flipCard() {
        _isCardFlipped.value = !_isCardFlipped.value
    }

    fun nextFlashcard(totalCards: Int) {
        if (_flashcardIndex.value < totalCards - 1) {
            _flashcardIndex.value += 1
            _isCardFlipped.value = false
        }
    }

    fun prevFlashcard() {
        if (_flashcardIndex.value > 0) {
            _flashcardIndex.value -= 1
            _isCardFlipped.value = false
        }
    }

    fun startQuiz(unit: LessonUnit) {
        _activeUnit.value = unit
        _quizQuestionIndex.value = 0
        _selectedOptionIndex.value = null
        _isAnswerSubmitted.value = false
        _quizScore.value = 0
        _isQuizCompleted.value = false
        _learnSubScreen.value = LearnSubScreen.QUIZ
    }

    fun selectQuizOption(index: Int) {
        if (!_isAnswerSubmitted.value) {
            _selectedOptionIndex.value = index
        }
    }

    fun submitQuizAnswer(currentQuestion: QuizQuestion) {
        if (_selectedOptionIndex.value != null && !_isAnswerSubmitted.value) {
            _isAnswerSubmitted.value = true
            if (_selectedOptionIndex.value == currentQuestion.correctIndex) {
                _quizScore.value += 1
                repository.addPoints(10)
            }
        }
    }

    fun nextQuizQuestion(totalQuestions: Int) {
        if (_quizQuestionIndex.value < totalQuestions - 1) {
            _quizQuestionIndex.value += 1
            _selectedOptionIndex.value = null
            _isAnswerSubmitted.value = false
        } else {
            _isQuizCompleted.value = true
            _activeUnit.value?.let { repository.markUnitCompleted(it.id) }
        }
    }

    fun backToUnitList() {
        tts.stop()
        _learnSubScreen.value = LearnSubScreen.UNIT_LIST
        _activeUnit.value = null
    }

    fun backToUnitDetail() {
        tts.stop()
        _learnSubScreen.value = LearnSubScreen.UNIT_DETAIL
    }

    fun setDictSearch(query: String) {
        _dictSearchQuery.value = query
    }

    fun setVocabCategory(category: VocabCategory?) {
        _selectedVocabCategory.value = category
    }

    fun toggleVocabBookmark(id: String) {
        repository.toggleVocabBookmark(id)
    }

    fun inspectVocab(word: VocabularyWord) {
        _inspectingVocab.value = word
    }

    fun inspectVocabById(id: String) {
        val word = SampleData.vocabularies.find { it.id == id }
        if (word != null) {
            _inspectingVocab.value = word
        }
    }

    fun dismissInspectVocab() {
        _inspectingVocab.value = null
    }

    fun showLanguagePicker(show: Boolean) {
        _showLanguageDialog.value = show
    }

    fun setLanguage(language: AppLanguage) {
        repository.setLanguage(language)
        _showLanguageDialog.value = false
    }

    fun speak(text: String, lang: AppLanguage = currentLanguage.value) {
        tts.speak(text, lang)
    }

    fun stopSpeaking() {
        tts.stop()
    }

    override fun onCleared() {
        super.onCleared()
        tts.shutdown()
    }
}
