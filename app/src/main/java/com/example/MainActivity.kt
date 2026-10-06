package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.SampleData
import com.example.model.AppLanguage
import com.example.ui.LearnSubScreen
import com.example.ui.MainTab
import com.example.ui.MainViewModel
import com.example.ui.components.AppDrawerContent
import com.example.ui.components.AppTopBar
import com.example.ui.components.HistoryDetailModal
import com.example.ui.components.LanguagePickerDialog
import com.example.ui.components.VocabDetailBottomSheet
import com.example.ui.screens.about.AboutAppScreen
import com.example.ui.screens.dictionary.DictionaryScreen
import com.example.ui.screens.home.HomeScreen
import com.example.ui.screens.learn.AcademyScreen
import com.example.ui.screens.learn.FlashcardsScreen
import com.example.ui.screens.learn.LessonDetailScreen
import com.example.ui.screens.learn.QuizScreen
import com.example.ui.screens.news.NewsDetailScreen
import com.example.ui.screens.practice.PracticeHubScreen
import com.example.ui.screens.scripts.ScriptExplorerScreen
import com.example.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(viewModel: MainViewModel = viewModel()) {
    val currentLanguage by viewModel.currentLanguage.collectAsStateWithLifecycle()
    val selectedTab by viewModel.selectedTab.collectAsStateWithLifecycle()
    val activeNewsArticle by viewModel.activeNewsArticle.collectAsStateWithLifecycle()
    val newsCategory by viewModel.newsCategory.collectAsStateWithLifecycle()
    val newsSearchQuery by viewModel.newsSearchQuery.collectAsStateWithLifecycle()
    val bookmarkedNewsIds by viewModel.bookmarkedNewsIds.collectAsStateWithLifecycle()
    val bookmarkedVocabIds by viewModel.bookmarkedVocabIds.collectAsStateWithLifecycle()
    val completedUnits by viewModel.completedUnits.collectAsStateWithLifecycle()
    val streakDays by viewModel.streakDays.collectAsStateWithLifecycle()
    val totalPoints by viewModel.totalPoints.collectAsStateWithLifecycle()

    val learnSubScreen by viewModel.learnSubScreen.collectAsStateWithLifecycle()
    val activeUnit by viewModel.activeUnit.collectAsStateWithLifecycle()
    val flashcardIndex by viewModel.flashcardIndex.collectAsStateWithLifecycle()
    val isCardFlipped by viewModel.isCardFlipped.collectAsStateWithLifecycle()

    val quizQuestionIndex by viewModel.quizQuestionIndex.collectAsStateWithLifecycle()
    val selectedOptionIndex by viewModel.selectedOptionIndex.collectAsStateWithLifecycle()
    val isAnswerSubmitted by viewModel.isAnswerSubmitted.collectAsStateWithLifecycle()
    val quizScore by viewModel.quizScore.collectAsStateWithLifecycle()
    val isQuizCompleted by viewModel.isQuizCompleted.collectAsStateWithLifecycle()

    val dictSearchQuery by viewModel.dictSearchQuery.collectAsStateWithLifecycle()
    val selectedVocabCategory by viewModel.selectedVocabCategory.collectAsStateWithLifecycle()
    val inspectingVocab by viewModel.inspectingVocab.collectAsStateWithLifecycle()
    val showLanguageDialog by viewModel.showLanguageDialog.collectAsStateWithLifecycle()
    val selectedHistoryTopic by viewModel.selectedHistoryTopic.collectAsStateWithLifecycle()

    val isSpeaking by viewModel.tts.isSpeaking.collectAsStateWithLifecycle()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    var showDictionaryDialog by remember { mutableStateOf(false) }
    var showScriptsDialog by remember { mutableStateOf(false) }

    // Language Picker Dialog
    if (showLanguageDialog) {
        LanguagePickerDialog(
            currentLanguage = currentLanguage,
            onLanguageSelected = { viewModel.setLanguage(it) },
            onDismiss = { viewModel.showLanguagePicker(false) }
        )
    }

    // Inspect Vocabulary Bottom Sheet
    inspectingVocab?.let { vocab ->
        VocabDetailBottomSheet(
            vocab = vocab,
            currentLanguage = currentLanguage,
            isBookmarked = bookmarkedVocabIds.contains(vocab.id),
            onToggleBookmark = { viewModel.toggleVocabBookmark(vocab.id) },
            onSpeak = { viewModel.speak(it) },
            onDismiss = { viewModel.dismissInspectVocab() }
        )
    }

    // Cultural History & Tradition Deep-Dive Modal
    selectedHistoryTopic?.let { topic ->
        HistoryDetailModal(
            topic = topic,
            appLanguage = currentLanguage,
            onSpeak = { viewModel.speak(it) },
            onDismiss = { viewModel.closeHistoryTopic() }
        )
    }

    // Fullscreen News Detail Reader
    if (activeNewsArticle != null) {
        NewsDetailScreen(
            article = activeNewsArticle!!,
            appLanguage = currentLanguage,
            isBookmarked = bookmarkedNewsIds.contains(activeNewsArticle!!.id),
            isSpeaking = isSpeaking,
            onBack = { viewModel.closeNewsDetail() },
            onToggleBookmark = { viewModel.toggleNewsBookmark(it) },
            onSpeak = { viewModel.speak(it) },
            onStopSpeaking = { viewModel.stopSpeaking() },
            onInspectVocab = { viewModel.inspectVocabById(it) }
        )
        return
    }

    // Sub-screens for Learn / Academy
    if (selectedTab == MainTab.LEARN) {
        when (learnSubScreen) {
            LearnSubScreen.UNIT_DETAIL -> {
                activeUnit?.let { unit ->
                    LessonDetailScreen(
                        unit = unit,
                        currentLanguage = currentLanguage,
                        onBack = { viewModel.backToUnitList() },
                        onStartFlashcards = { viewModel.startFlashcards(unit) },
                        onStartQuiz = { viewModel.startQuiz(unit) },
                        onSpeak = { viewModel.speak(it) },
                        onInspectVocab = { viewModel.inspectVocab(it) }
                    )
                    return
                }
            }
            LearnSubScreen.FLASHCARDS -> {
                activeUnit?.let { unit ->
                    FlashcardsScreen(
                        unit = unit,
                        currentLanguage = currentLanguage,
                        cardIndex = flashcardIndex,
                        isFlipped = isCardFlipped,
                        onFlip = { viewModel.flipCard() },
                        onNext = { viewModel.nextFlashcard(unit.vocabularies.size) },
                        onPrev = { viewModel.prevFlashcard() },
                        onSpeak = { viewModel.speak(it) },
                        onBack = { viewModel.backToUnitDetail() }
                    )
                    return
                }
            }
            LearnSubScreen.QUIZ -> {
                activeUnit?.let { unit ->
                    QuizScreen(
                        unit = unit,
                        currentLanguage = currentLanguage,
                        questionIndex = quizQuestionIndex,
                        selectedOptionIndex = selectedOptionIndex,
                        isAnswerSubmitted = isAnswerSubmitted,
                        score = quizScore,
                        isQuizCompleted = isQuizCompleted,
                        onSelectOption = { viewModel.selectQuizOption(it) },
                        onSubmitAnswer = { viewModel.submitQuizAnswer(it) },
                        onNextQuestion = { viewModel.nextQuizQuestion(it) },
                        onSpeak = { viewModel.speak(it) },
                        onBack = { viewModel.backToUnitList() }
                    )
                    return
                }
            }
            LearnSubScreen.UNIT_LIST -> {
                // fall through to main scaffold
            }
        }
    }

    // Modal Navigation Drawer wrapping the main layout
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawerContent(
                currentTab = selectedTab,
                currentLanguage = currentLanguage,
                onTabSelected = { tab ->
                    viewModel.selectTab(tab)
                    coroutineScope.launch { drawerState.close() }
                },
                onSelectHistoryTopic = { topic ->
                    viewModel.openHistoryTopic(topic)
                    coroutineScope.launch { drawerState.close() }
                },
                onOpenLanguagePicker = {
                    viewModel.showLanguagePicker(true)
                    coroutineScope.launch { drawerState.close() }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    currentLanguage = currentLanguage,
                    streakDays = streakDays,
                    totalPoints = totalPoints,
                    onMenuClick = {
                        coroutineScope.launch { drawerState.open() }
                    },
                    onLanguageClick = { viewModel.showLanguagePicker(true) }
                )
            },
            bottomBar = {
                // Exactly 4 Navigation Tabs: Home, Learn, Practice, About
                NavigationBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("main_bottom_nav"),
                    windowInsets = WindowInsets.navigationBars,
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 4.dp
                ) {
                    // Tab 1: Home
                    NavigationBarItem(
                        selected = selectedTab == MainTab.HOME,
                        onClick = { viewModel.selectTab(MainTab.HOME) },
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = {
                            Text(
                                text = when (currentLanguage) {
                                    AppLanguage.NEWA -> "गृह"
                                    AppLanguage.NEPALI -> "गृह"
                                    AppLanguage.ENGLISH -> "Home"
                                },
                                fontSize = 11.sp,
                                fontWeight = if (selectedTab == MainTab.HOME) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        modifier = Modifier.testTag("nav_tab_home")
                    )

                    // Tab 2: Learn
                    NavigationBarItem(
                        selected = selectedTab == MainTab.LEARN,
                        onClick = { viewModel.selectTab(MainTab.LEARN) },
                        icon = { Icon(Icons.Default.School, contentDescription = "Learn") },
                        label = {
                            Text(
                                text = when (currentLanguage) {
                                    AppLanguage.NEWA -> "सयेकेगु"
                                    AppLanguage.NEPALI -> "सिक्नुहोस्"
                                    AppLanguage.ENGLISH -> "Learn"
                                },
                                fontSize = 11.sp,
                                fontWeight = if (selectedTab == MainTab.LEARN) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        modifier = Modifier.testTag("nav_tab_learn")
                    )

                    // Tab 3: Practice
                    NavigationBarItem(
                        selected = selectedTab == MainTab.PRACTICE,
                        onClick = { viewModel.selectTab(MainTab.PRACTICE) },
                        icon = { Icon(Icons.Default.FitnessCenter, contentDescription = "Practice") },
                        label = {
                            Text(
                                text = when (currentLanguage) {
                                    AppLanguage.NEWA -> "अभ्यास"
                                    AppLanguage.NEPALI -> "अभ्यास"
                                    AppLanguage.ENGLISH -> "Practice"
                                },
                                fontSize = 11.sp,
                                fontWeight = if (selectedTab == MainTab.PRACTICE) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        modifier = Modifier.testTag("nav_tab_practice")
                    )

                    // Tab 4: About
                    NavigationBarItem(
                        selected = selectedTab == MainTab.ABOUT,
                        onClick = { viewModel.selectTab(MainTab.ABOUT) },
                        icon = { Icon(Icons.Default.Info, contentDescription = "About") },
                        label = {
                            Text(
                                text = when (currentLanguage) {
                                    AppLanguage.NEWA -> "बारेमा"
                                    AppLanguage.NEPALI -> "बारेमा"
                                    AppLanguage.ENGLISH -> "About"
                                },
                                fontSize = 11.sp,
                                fontWeight = if (selectedTab == MainTab.ABOUT) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        modifier = Modifier.testTag("nav_tab_about")
                    )
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (selectedTab) {
                    MainTab.HOME -> {
                        HomeScreen(
                            articles = SampleData.newsArticles,
                            currentLanguage = currentLanguage,
                            selectedCategory = newsCategory,
                            searchQuery = newsSearchQuery,
                            bookmarkedIds = bookmarkedNewsIds,
                            onCategorySelect = { viewModel.setNewsCategory(it) },
                            onSearchChange = { viewModel.setNewsSearchQuery(it) },
                            onArticleClick = { viewModel.openNewsDetail(it) },
                            onToggleBookmark = { viewModel.toggleNewsBookmark(it) },
                            onSpeak = { viewModel.speak(it) },
                            onOpenHistoryTopic = { viewModel.openHistoryTopic(it) }
                        )
                    }

                    MainTab.LEARN -> {
                        AcademyScreen(
                            units = SampleData.lessonUnits,
                            currentLanguage = currentLanguage,
                            completedUnitIds = completedUnits,
                            streakDays = streakDays,
                            totalPoints = totalPoints,
                            onOpenUnit = { viewModel.openUnit(it) },
                            onQuickFlashcards = {
                                viewModel.startFlashcards(SampleData.lessonUnits.first())
                            },
                            onQuickQuiz = {
                                viewModel.startQuiz(SampleData.lessonUnits.first())
                            }
                        )
                    }

                    MainTab.PRACTICE -> {
                        PracticeHubScreen(
                            currentLanguage = currentLanguage,
                            streakDays = streakDays,
                            totalPoints = totalPoints,
                            onStartFlashcards = { unit ->
                                viewModel.startFlashcards(unit)
                            },
                            onStartQuiz = { unit ->
                                viewModel.startQuiz(unit)
                            },
                            onOpenDictionary = { showDictionaryDialog = true },
                            onOpenScripts = { showScriptsDialog = true }
                        )
                    }

                    MainTab.ABOUT -> {
                        AboutAppScreen(
                            currentLanguage = currentLanguage,
                            onOpenHistoryTopic = { viewModel.openHistoryTopic(it) },
                            onSpeak = { viewModel.speak(it) }
                        )
                    }
                }
            }
        }
    }

    // Practice Module: Dictionary Modal
    if (showDictionaryDialog) {
        ModalBottomSheet(
            onDismissRequest = { showDictionaryDialog = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth()
            ) {
                DictionaryScreen(
                    vocabularies = SampleData.vocabularies,
                    currentLanguage = currentLanguage,
                    searchQuery = dictSearchQuery,
                    selectedCategory = selectedVocabCategory,
                    bookmarkedIds = bookmarkedVocabIds,
                    onSearchChange = { viewModel.setDictSearch(it) },
                    onCategorySelect = { viewModel.setVocabCategory(it) },
                    onWordClick = { viewModel.inspectVocab(it) },
                    onToggleBookmark = { viewModel.toggleVocabBookmark(it) },
                    onSpeak = { viewModel.speak(it) }
                )
            }
        }
    }

    // Practice Module: Script Explorer Modal
    if (showScriptsDialog) {
        ModalBottomSheet(
            onDismissRequest = { showScriptsDialog = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth()
            ) {
                ScriptExplorerScreen(
                    currentLanguage = currentLanguage,
                    bookmarkedNewsIds = bookmarkedNewsIds,
                    bookmarkedVocabIds = bookmarkedVocabIds,
                    onNewsClick = {
                        showScriptsDialog = false
                        viewModel.openNewsDetail(it)
                    },
                    onVocabClick = {
                        showScriptsDialog = false
                        viewModel.inspectVocab(it)
                    },
                    onToggleNewsBookmark = { viewModel.toggleNewsBookmark(it) },
                    onToggleVocabBookmark = { viewModel.toggleVocabBookmark(it) },
                    onSpeak = { viewModel.speak(it) }
                )
            }
        }
    }
}
