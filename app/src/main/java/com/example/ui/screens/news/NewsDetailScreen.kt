package com.example.ui.screens.news

import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SampleData
import com.example.model.AppLanguage
import com.example.model.NewsArticle
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailScreen(
    article: NewsArticle,
    appLanguage: AppLanguage,
    isBookmarked: Boolean,
    isSpeaking: Boolean,
    onBack: () -> Unit,
    onToggleBookmark: (String) -> Unit,
    onSpeak: (String) -> Unit,
    onStopSpeaking: () -> Unit,
    onInspectVocab: (String) -> Unit
) {
    BackHandler { onBack() }
    val context = LocalContext.current

    // Local reading language toggle for this article (default to app language)
    var readingLanguage by remember { mutableStateOf(appLanguage) }
    var fontSizeMultiplier by remember { mutableStateOf(1.0f) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "बुखँ ब्वनेगु (Article Reader)",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("news_back_button")) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    // Font scale adjuster
                    IconButton(onClick = {
                        fontSizeMultiplier = if (fontSizeMultiplier >= 1.3f) 1.0f else fontSizeMultiplier + 0.15f
                    }) {
                        Icon(Icons.Default.FormatSize, contentDescription = "Adjust Font Size")
                    }
                    // Bookmark
                    IconButton(onClick = { onToggleBookmark(article.id) }) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = "Bookmark",
                            tint = if (isBookmarked) NewaRed else MaterialTheme.colorScheme.onSurface
                        )
                    }
                    // Share
                    IconButton(onClick = {
                        val shareIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "${article.title.get(readingLanguage)}\n\n${article.content.get(readingLanguage)}")
                            type = "text/plain"
                        }
                        context.startActivity(Intent.createChooser(shareIntent, "Share Article"))
                    }) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Language Selection Chips for Article
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = NewaGoldContainer,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "${article.category.label.get(appLanguage)} • ${article.sambatDate}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = NewaOnGoldContainer,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                // Switch article language
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    AppLanguage.values().forEach { lang ->
                        val isSelected = lang == readingLanguage
                        Surface(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { readingLanguage = lang }
                                .testTag("article_lang_${lang.name.lowercase()}"),
                            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Text(
                                text = when (lang) {
                                    AppLanguage.NEWA -> "नेवाः"
                                    AppLanguage.NEPALI -> "नेपाली"
                                    AppLanguage.ENGLISH -> "EN"
                                },
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Article Title
            Text(
                text = article.title.get(readingLanguage),
                fontSize = (22 * fontSizeMultiplier).sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = (28 * fontSizeMultiplier).sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Subtitle
            Text(
                text = article.subtitle.get(readingLanguage),
                fontSize = (14 * fontSizeMultiplier).sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = (20 * fontSizeMultiplier).sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Metadata row: Author & Read Time
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "✍️ ${article.author}",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "📅 ${article.gregorianDate}",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Audio Reader Bar
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .testTag("news_audio_player_bar"),
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                tonalElevation = 2.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .size(40.dp)
                                .clickable {
                                    if (isSpeaking) onStopSpeaking()
                                    else onSpeak(article.content.get(readingLanguage))
                                }
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = if (isSpeaking) Icons.Default.Pause else Icons.Default.PlayArrow,
                                    contentDescription = if (isSpeaking) "Pause" else "Listen",
                                    tint = Color.White
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = if (isSpeaking) "सः न्ह्यानाच्वंगु दु... (Listening)" else "बुखँ न्यनेगु (Listen to Article)",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Text(
                                text = "Natural Nepal Bhasa Audio Reader",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    if (isSpeaking) {
                        IconButton(onClick = onStopSpeaking) {
                            Icon(Icons.Default.Stop, contentDescription = "Stop", tint = NewaRed)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(16.dp))

            // Main Body Content
            Text(
                text = article.content.get(readingLanguage),
                fontSize = (16 * fontSizeMultiplier).sp,
                lineHeight = (26 * fontSizeMultiplier).sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Interactive Vocabulary in this Article
            if (article.keyVocabIds.isNotEmpty()) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "💡", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = when (appLanguage) {
                                    AppLanguage.NEWA -> "थ्व बुखँया मुख्य खँग्वःत (Tap word to learn meaning):"
                                    AppLanguage.NEPALI -> "यस समाचारका मुख्य शब्दहरू (अर्थ हेर्नुहोस्):"
                                    AppLanguage.ENGLISH -> "Key Vocabulary in this Article (Tap to inspect):"
                                },
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Chips for key vocabulary
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            article.keyVocabIds.forEach { vocabId ->
                                val vocab = SampleData.vocabularies.find { it.id == vocabId }
                                if (vocab != null) {
                                    ElevatedSuggestionChip(
                                        onClick = { onInspectVocab(vocab.id) },
                                        label = {
                                            Text(
                                                text = "${vocab.wordNewa} (${vocab.phonetic})",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 12.sp
                                            )
                                        },
                                        icon = {
                                            Icon(
                                                Icons.Default.VolumeUp,
                                                contentDescription = "Speak",
                                                modifier = Modifier.size(14.dp),
                                                tint = MaterialTheme.colorScheme.primary
                                            )
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}
