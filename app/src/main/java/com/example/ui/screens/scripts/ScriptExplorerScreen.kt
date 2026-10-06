package com.example.ui.screens.scripts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SampleData
import com.example.model.AppLanguage
import com.example.model.NewsArticle
import com.example.model.ScriptGlyph
import com.example.model.VocabularyWord
import com.example.ui.theme.*

@Composable
fun ScriptExplorerScreen(
    currentLanguage: AppLanguage,
    bookmarkedNewsIds: Set<String>,
    bookmarkedVocabIds: Set<String>,
    onNewsClick: (NewsArticle) -> Unit,
    onVocabClick: (VocabularyWord) -> Unit,
    onToggleNewsBookmark: (String) -> Unit,
    onToggleVocabBookmark: (String) -> Unit,
    onSpeak: (String) -> Unit
) {
    var subTab by remember { mutableStateOf(0) } // 0: Script Explorer, 1: Saved Bookmarks

    val savedArticles = SampleData.newsArticles.filter { bookmarkedNewsIds.contains(it.id) }
    val savedVocabs = SampleData.vocabularies.filter { bookmarkedVocabIds.contains(it.id) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("script_explorer_screen")
    ) {
        // Tab Row
        TabRow(
            selectedTabIndex = subTab,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            Tab(
                selected = subTab == 0,
                onClick = { subTab = 0 },
                text = { Text("नेपाल लिपि (Scripts)", fontWeight = FontWeight.Bold, fontSize = 13.sp) }
            )
            Tab(
                selected = subTab == 1,
                onClick = { subTab = 1 },
                text = { Text("संकलन (${savedArticles.size + savedVocabs.size})", fontWeight = FontWeight.Bold, fontSize = 13.sp) }
            )
        }

        if (subTab == 0) {
            ScriptExplorerTab(onSpeak = onSpeak)
        } else {
            BookmarksTab(
                savedArticles = savedArticles,
                savedVocabs = savedVocabs,
                currentLanguage = currentLanguage,
                onNewsClick = onNewsClick,
                onVocabClick = onVocabClick,
                onToggleNewsBookmark = onToggleNewsBookmark,
                onToggleVocabBookmark = onToggleVocabBookmark,
                onSpeak = onSpeak
            )
        }
    }
}

@Composable
fun ScriptExplorerTab(onSpeak: (String) -> Unit) {
    var transliterationInput by remember { mutableStateOf("") }
    var selectedGlyph by remember { mutableStateOf<ScriptGlyph?>(SampleData.scriptGlyphs.first()) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp, bottom = 90.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Scripts Header Information
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "नेपाल लिपि व रञ्जना लिपि (Ancient Scripts of Nepal)",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "नेपाल भाषा ऐतिहासिक रुपमा रञ्जना, प्रचलित, भुजिंमोल जस्ता विभिन्न लिपिमा लेखिन्छ। हाल देवनागरी र प्रचलित नेपाल लिपि व्यापक प्रयोगमा छन्।",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 17.sp
                    )
                }
            }
        }

        // Selected Glyph Preview Card
        item {
            selectedGlyph?.let { glyph ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = NewaGoldContainer.copy(alpha = 0.5f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = glyph.devanagari,
                                fontSize = 48.sp,
                                fontWeight = FontWeight.Black,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Phonetic: /${glyph.phonetic}/ (${glyph.name})",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = NewaOnGoldContainer
                            )
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            IconButton(onClick = { onSpeak(glyph.sampleWordNewa) }) {
                                Icon(Icons.Default.VolumeUp, contentDescription = "Listen", tint = MaterialTheme.colorScheme.primary)
                            }
                            Text(
                                text = "दसि: ${glyph.sampleWordNewa}",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = glyph.meaningEnglish,
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }

        // Live Transliteration Playground
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Translate, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "रोमन / देवनागरी ट्रान्सलिटरेसन अभ्यास:",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = transliterationInput,
                        onValueChange = { transliterationInput = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Type any phrase, e.g., Jwajalapa, Bhintuna...", fontSize = 13.sp) },
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true
                    )

                    if (transliterationInput.isNotBlank()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Preview: $transliterationInput",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                IconButton(onClick = { onSpeak(transliterationInput) }) {
                                    Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = MaterialTheme.colorScheme.primary)
                                }
                            }
                        }
                    }
                }
            }
        }

        // Letters Grid Title
        item {
            Text(
                text = "आखः सूची (Alphabet & Glyph Grid - Tap letter to listen):",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        // Grid of Glyphs
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SampleData.scriptGlyphs.chunked(4).forEach { rowGlyphs ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        rowGlyphs.forEach { glyph ->
                            val isSelected = selectedGlyph?.devanagari == glyph.devanagari
                            Surface(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(12.dp))
                                    .clickable {
                                        selectedGlyph = glyph
                                        onSpeak(glyph.devanagari)
                                    },
                                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                                tonalElevation = if (isSelected) 3.dp else 0.dp
                            ) {
                                Column(
                                    modifier = Modifier.padding(10.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = glyph.devanagari,
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = glyph.phonetic,
                                        fontSize = 11.sp,
                                        color = if (isSelected) Color.White.copy(alpha = 0.8f) else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                        // Fill empty slots if last row has fewer than 4 items
                        for (i in 0 until (4 - rowGlyphs.size)) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BookmarksTab(
    savedArticles: List<NewsArticle>,
    savedVocabs: List<VocabularyWord>,
    currentLanguage: AppLanguage,
    onNewsClick: (NewsArticle) -> Unit,
    onVocabClick: (VocabularyWord) -> Unit,
    onToggleNewsBookmark: (String) -> Unit,
    onToggleVocabBookmark: (String) -> Unit,
    onSpeak: (String) -> Unit
) {
    if (savedArticles.isEmpty() && savedVocabs.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "🔖", fontSize = 48.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "बुकमार्क यानातःगु मदु",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Bookmark news or vocabulary words to review them anytime.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
        return
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp, bottom = 90.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Saved Articles Section
        if (savedArticles.isNotEmpty()) {
            item {
                Text(
                    text = "बचत यानातःगु बुखँ (Saved Articles - ${savedArticles.size}):",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            items(savedArticles, key = { "art_${it.id}" }) { article ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNewsClick(article) },
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = article.title.get(currentLanguage),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "${article.sambatDate} • ${article.category.label.get(currentLanguage)}",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        IconButton(onClick = { onToggleNewsBookmark(article.id) }) {
                            Icon(Icons.Default.Bookmark, contentDescription = "Unbookmark", tint = NewaRed)
                        }
                    }
                }
            }
        }

        // Saved Vocabulary Section
        if (savedVocabs.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "सुरक्षित खँग्वःत (Saved Vocabulary - ${savedVocabs.size}):",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            items(savedVocabs, key = { "voc_${it.id}" }) { word ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onVocabClick(word) },
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = word.wordNewa,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = word.phonetic,
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "नेपाली: ${word.nepaliMeaning}",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "English: ${word.englishMeaning}",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Row {
                            IconButton(onClick = { onSpeak(word.wordNewa) }) {
                                Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = MaterialTheme.colorScheme.primary)
                            }
                            IconButton(onClick = { onToggleVocabBookmark(word.id) }) {
                                Icon(Icons.Default.Bookmark, contentDescription = "Unbookmark", tint = NewaRed)
                            }
                        }
                    }
                }
            }
        }
    }
}
