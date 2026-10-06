package com.example.model

enum class NewsCategory(val label: LocalizedString) {
    ALL(LocalizedString("सकल", "सबै", "All")),
    CULTURE(LocalizedString("संस्कृति", "संस्कृति", "Culture")),
    HERITAGE(LocalizedString("सम्पदा", "सम्पदा", "Heritage")),
    LITERATURE(LocalizedString("साहित्य", "साहित्य", "Literature")),
    VALLEY(LocalizedString("उपत्यका", "उपत्यका", "Valley News")),
    SOCIETY(LocalizedString("समाज", "समाज", "Society"))
}

data class NewsArticle(
    val id: String,
    val category: NewsCategory,
    val title: LocalizedString,
    val subtitle: LocalizedString,
    val content: LocalizedString,
    val gregorianDate: String,
    val sambatDate: String,
    val readTimeMinutes: Int,
    val author: String,
    val keyVocabIds: List<String> = emptyList(),
    val iconEmoji: String = "📰"
)
