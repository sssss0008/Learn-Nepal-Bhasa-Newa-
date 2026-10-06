package com.example.ui.screens.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SampleData
import com.example.model.AppLanguage
import com.example.model.LessonUnit
import com.example.ui.theme.*

@Composable
fun PracticeHubScreen(
    currentLanguage: AppLanguage,
    streakDays: Int,
    totalPoints: Int,
    onStartFlashcards: (LessonUnit) -> Unit,
    onStartQuiz: (LessonUnit) -> Unit,
    onOpenDictionary: () -> Unit,
    onOpenScripts: () -> Unit
) {
    val defaultUnit = SampleData.lessonUnits.first()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("practice_hub_screen"),
        contentPadding = PaddingValues(16.dp, bottom = 90.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Practice Stats Banner
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(NewaTerracotta, NewaRed)
                            )
                        )
                        .padding(18.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "नेपाल भाषा अभ्यास केन्द्र",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Practice & Master Skills Daily",
                                fontSize = 12.sp,
                                color = NewaGoldLight
                            )
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Surface(
                                color = Color.White.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(Icons.Default.LocalFireDepartment, contentDescription = null, tint = NewaGoldLight, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text(text = "$streakDays Days", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                }
                            }
                        }
                    }
                }
            }
        }

        // Section Title
        item {
            Text(
                text = when (currentLanguage) {
                    AppLanguage.NEWA -> "अभ्यास मोड (Interactive Practice Modes):"
                    AppLanguage.NEPALI -> "अभ्यासका प्रकारहरू:"
                    AppLanguage.ENGLISH -> "Practice Modules:"
                },
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        // 1. Flashcards Mode Card
        item {
            PracticeActionCard(
                title = "१. फ्लेशकार्ड अभ्यास (Flashcards)",
                subtitle = "स्मरण शक्ति व उच्चारण सयेकेगु",
                description = "Flip cards, listen to authentic Nepal Bhasa pronunciations, and test your memory.",
                emoji = "🃏",
                buttonText = "फ्लेशकार्ड सुरु यायेगु (Start)",
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                onClick = { onStartFlashcards(defaultUnit) }
            )
        }

        // 2. Quiz Challenge Mode Card
        item {
            PracticeActionCard(
                title = "२. ज्ञान धेंधेंबल्लाः (Quiz Challenge)",
                subtitle = "अंक व ज्ञानया जाँच (Earn +50 XP)",
                description = "Answer multiple-choice cultural questions with instant explanations and score tracking.",
                emoji = "🏆",
                buttonText = "क्विज न्ह्याकेगु (Start Quiz)",
                containerColor = NewaGoldContainer,
                onClick = { onStartQuiz(defaultUnit) }
            )
        }

        // 3. Dictionary & Phrasebook Mode Card
        item {
            PracticeActionCard(
                title = "३. खँग्वःधुकू (Dictionary & Phrasebook)",
                subtitle = "सयौं खँग्वःत व दसि वाक्य (Words & Sentences)",
                description = "Search 60+ curated vocabulary items with parts of speech, roots, and audio sentences.",
                emoji = "📖",
                buttonText = "खँग्वःधुकू स्वयेगु (Explore)",
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                onClick = onOpenDictionary
            )
        }

        // 4. Script & Transliteration Explorer
        item {
            PracticeActionCard(
                title = "४. नेपाल लिपि व ट्रान्सलिटरेसन (Scripts)",
                subtitle = "रञ्जना व प्रचलित आखः (Ancient Calligraphy)",
                description = "Explore 24 alphabet glyphs, sound guide, and live phonetic transliteration test.",
                emoji = "📜",
                buttonText = "लिपि अभ्यास (Scripts)",
                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f),
                onClick = onOpenScripts
            )
        }
    }
}

@Composable
fun PracticeActionCard(
    title: String,
    subtitle: String,
    description: String,
    emoji: String,
    buttonText: String,
    containerColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = emoji, fontSize = 28.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = title,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = subtitle,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 17.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(text = buttonText, fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }
        }
    }
}
