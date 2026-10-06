package com.example.data

import android.content.Context
import android.content.SharedPreferences
import com.example.model.AppLanguage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppRepository(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("lha_nepalbhasa_prefs", Context.MODE_PRIVATE)

    private val _currentLanguage = MutableStateFlow(
        try {
            AppLanguage.valueOf(prefs.getString("pref_language", AppLanguage.NEWA.name) ?: AppLanguage.NEWA.name)
        } catch (e: Exception) {
            AppLanguage.NEWA
        }
    )
    val currentLanguage: StateFlow<AppLanguage> = _currentLanguage.asStateFlow()

    private val _bookmarkedNewsIds = MutableStateFlow(
        prefs.getStringSet("pref_news_bookmarks", setOf("news_1"))?.toSet() ?: setOf("news_1")
    )
    val bookmarkedNewsIds: StateFlow<Set<String>> = _bookmarkedNewsIds.asStateFlow()

    private val _bookmarkedVocabIds = MutableStateFlow(
        prefs.getStringSet("pref_vocab_bookmarks", setOf("v_jwajalapa", "v_samaybaji"))?.toSet() ?: setOf("v_jwajalapa", "v_samaybaji")
    )
    val bookmarkedVocabIds: StateFlow<Set<String>> = _bookmarkedVocabIds.asStateFlow()

    private val _completedUnits = MutableStateFlow(
        prefs.getStringSet("pref_completed_units", setOf("unit_1"))?.toSet() ?: setOf("unit_1")
    )
    val completedUnits: StateFlow<Set<String>> = _completedUnits.asStateFlow()

    private val _streakDays = MutableStateFlow(
        prefs.getInt("pref_streak_days", 4)
    )
    val streakDays: StateFlow<Int> = _streakDays.asStateFlow()

    private val _totalPoints = MutableStateFlow(
        prefs.getInt("pref_total_points", 120)
    )
    val totalPoints: StateFlow<Int> = _totalPoints.asStateFlow()

    fun setLanguage(language: AppLanguage) {
        _currentLanguage.value = language
        prefs.edit().putString("pref_language", language.name).apply()
    }

    fun toggleNewsBookmark(newsId: String) {
        val current = _bookmarkedNewsIds.value.toMutableSet()
        if (current.contains(newsId)) {
            current.remove(newsId)
        } else {
            current.add(newsId)
        }
        _bookmarkedNewsIds.value = current
        prefs.edit().putStringSet("pref_news_bookmarks", current).apply()
    }

    fun toggleVocabBookmark(vocabId: String) {
        val current = _bookmarkedVocabIds.value.toMutableSet()
        if (current.contains(vocabId)) {
            current.remove(vocabId)
        } else {
            current.add(vocabId)
        }
        _bookmarkedVocabIds.value = current
        prefs.edit().putStringSet("pref_vocab_bookmarks", current).apply()
    }

    fun markUnitCompleted(unitId: String) {
        val current = _completedUnits.value.toMutableSet()
        if (!current.contains(unitId)) {
            current.add(unitId)
            _completedUnits.value = current
            prefs.edit().putStringSet("pref_completed_units", current).apply()
            addPoints(50)
        }
    }

    fun addPoints(points: Int) {
        val updated = _totalPoints.value + points
        _totalPoints.value = updated
        prefs.edit().putInt("pref_total_points", updated).apply()
    }
}
