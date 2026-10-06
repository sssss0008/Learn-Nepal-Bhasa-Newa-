package com.example.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import com.example.model.AppLanguage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class TextToSpeechHelper(private val context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var isInitialized = false

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _currentSpokenText = MutableStateFlow<String?>(null)
    val currentSpokenText: StateFlow<String?> = _currentSpokenText.asStateFlow()

    private val _speechRate = MutableStateFlow(0.9f)
    val speechRate: StateFlow<Float> = _speechRate.asStateFlow()

    init {
        try {
            tts = TextToSpeech(context.applicationContext, this)
        } catch (e: Exception) {
            Log.e("TTSHelper", "Failed to initialize TTS", e)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isInitialized = true
            setupVoiceListener()
            setLocaleForLanguage(AppLanguage.NEWA)
        } else {
            Log.w("TTSHelper", "TTS Initialization failed with status: $status")
        }
    }

    private fun setupVoiceListener() {
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                _isSpeaking.value = true
            }

            override fun onDone(utteranceId: String?) {
                _isSpeaking.value = false
                _currentSpokenText.value = null
            }

            @Deprecated("Deprecated in Java")
            override fun onError(utteranceId: String?) {
                _isSpeaking.value = false
                _currentSpokenText.value = null
            }
        })
    }

    fun setSpeechRate(rate: Float) {
        _speechRate.value = rate
        tts?.setSpeechRate(rate)
    }

    private fun setLocaleForLanguage(lang: AppLanguage) {
        if (!isInitialized) return
        val targetLocale = when (lang) {
            AppLanguage.NEWA -> Locale("ne", "NP") // Nepal locale natively handles Devanagari phonology
            AppLanguage.NEPALI -> Locale("ne", "NP")
            AppLanguage.ENGLISH -> Locale.US
        }
        val result = tts?.setLanguage(targetLocale)
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            // Fallback to Hindi locale for Devanagari if Nepali voice is not pre-installed
            if (lang != AppLanguage.ENGLISH) {
                tts?.setLanguage(Locale("hi", "IN"))
            }
        }
    }

    fun speak(text: String, lang: AppLanguage = AppLanguage.NEWA) {
        if (text.isBlank()) return
        if (_isSpeaking.value && _currentSpokenText.value == text) {
            stop()
            return
        }
        setLocaleForLanguage(lang)
        tts?.setSpeechRate(_speechRate.value)
        _currentSpokenText.value = text
        _isSpeaking.value = true

        val utteranceId = "LhaTTS_${System.currentTimeMillis()}"
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
    }

    fun stop() {
        tts?.stop()
        _isSpeaking.value = false
        _currentSpokenText.value = null
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        isInitialized = false
    }
}
