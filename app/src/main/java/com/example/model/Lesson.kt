package com.example.model

enum class QuizType {
    MULTIPLE_CHOICE,
    MATCHING,
    TRANSLATION
}

data class QuizQuestion(
    val id: String,
    val question: LocalizedString,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: LocalizedString,
    val type: QuizType = QuizType.MULTIPLE_CHOICE
)

data class DialogueLine(
    val speakerNewa: String,
    val speakerRole: LocalizedString,
    val textNewa: String,
    val phonetic: String,
    val textNepali: String,
    val textEnglish: String
)

data class LessonUnit(
    val id: String,
    val unitNumber: Int,
    val title: LocalizedString,
    val description: LocalizedString,
    val iconEmoji: String,
    val dialogues: List<DialogueLine> = emptyList(),
    val vocabularies: List<VocabularyWord> = emptyList(),
    val grammarNotes: LocalizedString? = null,
    val quizzes: List<QuizQuestion> = emptyList()
)

data class CulturalFestival(
    val id: String,
    val name: LocalizedString,
    val sambatDate: String,
    val gregorianMonth: String,
    val description: LocalizedString,
    val traditions: LocalizedString,
    val specialFood: LocalizedString,
    val iconEmoji: String
)

data class ScriptGlyph(
    val devanagari: String,
    val name: String,
    val phonetic: String,
    val sampleWordNewa: String,
    val meaningEnglish: String,
    val isVowel: Boolean
)
