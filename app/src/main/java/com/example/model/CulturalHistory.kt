package com.example.model

data class CulturalHistoryTopic(
    val id: String,
    val title: LocalizedString,
    val subtitle: LocalizedString,
    val content: LocalizedString,
    val drawableResId: Int,
    val periodOrContext: LocalizedString,
    val keyHighlights: List<LocalizedString>
)
