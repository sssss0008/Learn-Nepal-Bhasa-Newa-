package com.example.model

enum class AppLanguage(val displayName: String, val nativeName: String, val code: String) {
    NEWA("Nepal Bhasa", "नेपाल भाषा", "new"),
    NEPALI("Nepali", "नेपाली", "ne"),
    ENGLISH("English", "English", "en")
}

data class LocalizedString(
    val newa: String,
    val nepali: String,
    val english: String
) {
    fun get(lang: AppLanguage): String = when (lang) {
        AppLanguage.NEWA -> newa
        AppLanguage.NEPALI -> nepali
        AppLanguage.ENGLISH -> english
    }
}
