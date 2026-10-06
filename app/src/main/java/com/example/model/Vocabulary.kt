package com.example.model

enum class VocabCategory(val title: LocalizedString) {
    GREETINGS(LocalizedString("ज्वजलपा व भद्रता", "अभिवादन र शिष्टाचार", "Greetings & Courtesies")),
    FOOD(LocalizedString("नसात्वँसा", "परिकार र भोजन", "Food & Feasts")),
    FAMILY(LocalizedString("छेँजः व स्वापू", "परिवार र नातागोता", "Family & Kinship")),
    NUMBERS(LocalizedString("ल्याःचाः", "अंक र गन्ती", "Numbers & Quantities")),
    DAILY(LocalizedString("न्हियान्हिथं", "दैनिक बोलीचाली", "Daily Expressions")),
    VERBS(LocalizedString("क्रिया खँग्वः", "क्रियापद", "Actions & Verbs")),
    CULTURE(LocalizedString("संस्कृति व जात्रा", "संस्कृति र चाडपर्व", "Culture & Tradition")),
    IDIOMS(LocalizedString("खँत्वाः", "उखान र टुक्का", "Proverbs & Idioms"))
}

data class VocabularyWord(
    val id: String,
    val wordNewa: String,
    val phonetic: String,
    val nepaliMeaning: String,
    val englishMeaning: String,
    val category: VocabCategory,
    val partOfSpeech: String = "Noun",
    val honorificNote: String? = null,
    val exampleNewa: String,
    val exampleNepali: String,
    val exampleEnglish: String
)
