package com.example.ui.screens.about

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SampleData
import com.example.model.AppLanguage
import com.example.model.CulturalHistoryTopic
import com.example.ui.theme.*

@Composable
fun AboutAppScreen(
    currentLanguage: AppLanguage,
    onOpenHistoryTopic: (CulturalHistoryTopic) -> Unit,
    onSpeak: (String) -> Unit
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("about_app_screen"),
        contentPadding = PaddingValues(16.dp, bottom = 90.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // App Identity Header Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(NewaRedDark, NewaRed)
                            )
                        )
                        .padding(22.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Surface(
                            shape = CircleShape,
                            color = NewaGoldContainer,
                            modifier = Modifier.size(70.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Image(
                                    painter = painterResource(id = com.example.R.drawable.ic_pagoda_temple),
                                    contentDescription = "App Emblem",
                                    modifier = Modifier.size(46.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "ल्हा: नेपाल भाषा",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                        Text(
                            text = "Nepal Bhasa News & Language Academy",
                            fontSize = 13.sp,
                            color = NewaGoldLight,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Surface(
                            color = Color.White.copy(alpha = 0.18f),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "संस्करण १.० (Version 1.0) • ने.सं. ११४६",
                                fontSize = 11.sp,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }

        // App Purpose & Mission Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "📱 उद्देश्य व परिकल्पना (Mission & Overview):",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.NEWA -> "ल्हा: नेपाल भाषा एप काठमाडौँ उपत्यकाया प्राचीन व समृद्ध नेपाल भाषा, साहित्य, रञ्जना लिपि व ऐतिहासिक संस्कृतियात संरक्षण यायेगु उद्देश्यं दयेकातःगु खः।"
                            AppLanguage.NEPALI -> "'ल्हा: नेपाल भाषा' एप काठमाडौँ उपत्यकाको प्राचीन र समृद्ध नेपाल भाषा, साहित्य, रञ्जना लिपि तथा ऐतिहासिक संस्कृतिको संरक्षण र प्रवर्धनका लागि निर्माण गरिएको हो।"
                            AppLanguage.ENGLISH -> "'Lha: Nepal Bhasa' is dedicated to revitalising and celebrating the indigenous language, ancient literature, Ranjana/Prachalit scripts, and living cultural heritage of the Kathmandu Valley."
                        },
                        fontSize = 13.sp,
                        lineHeight = 19.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("🌐 ३ भाषा", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = MaterialTheme.colorScheme.onPrimaryContainer)
                                Text("Newa, Nepali, Eng", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = NewaGoldContainer.copy(alpha = 0.7f),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("🔊 आवाज (Audio)", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = NewaOnGoldContainer)
                                Text("Natural TTS Reader", fontSize = 10.sp, color = NewaOnGoldContainer.copy(alpha = 0.8f))
                            }
                        }
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("📚 ६ एकाइ", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface)
                                Text("Lessons & Quizzes", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    }
                }
            }
        }

        // Direct Feedback & Developer Contact Section (PROMINENT)
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("developer_feedback_card"),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = NewaRedContainer.copy(alpha = 0.35f)),
                border = CardDefaults.outlinedCardBorder().copy(brush = Brush.horizontalGradient(listOf(NewaRed, NewaTerracotta)))
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Feedback, contentDescription = null, tint = NewaRed, modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "सल्लाह व सुझाव (Feedback & Contact)",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = NewaRedDark
                            )
                            Text(
                                text = "We value your valuable feedback and inquiries!",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // 1. Email Action
                    ContactFeedbackAction(
                        icon = Icons.Default.Email,
                        title = "Email Us",
                        value = SampleData.DEVELOPER_EMAIL,
                        actionLabel = "Send Mail",
                        buttonColor = MaterialTheme.colorScheme.primary,
                        onClick = {
                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:${SampleData.DEVELOPER_EMAIL}?subject=Lha%20Nepal%20Bhasa%20Feedback")
                            }
                            context.startActivity(Intent.createChooser(intent, "Send Email"))
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // 2. WhatsApp Action
                    ContactFeedbackAction(
                        icon = Icons.Default.Chat,
                        title = "WhatsApp Support",
                        value = SampleData.DEVELOPER_WHATSAPP,
                        actionLabel = "Open Chat",
                        buttonColor = Color(0xFF25D366),
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(SampleData.DEVELOPER_WHATSAPP_LINK))
                            context.startActivity(intent)
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // 3. LinkedIn Action
                    ContactFeedbackAction(
                        icon = Icons.Default.Public,
                        title = "LinkedIn Network",
                        value = "Awiskar Acharya",
                        actionLabel = "View Profile",
                        buttonColor = Color(0xFF0077B5),
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(SampleData.DEVELOPER_LINKEDIN))
                            context.startActivity(intent)
                        }
                    )
                }
            }
        }

        // Cultural Traditions & History Deep-Dive List (With Images)
        item {
            Text(
                text = "🏛️ इतिहास व परम्परा (Heritage Deep-Dive - Tap to Read):",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        items(SampleData.culturalHistoryTopics, key = { it.id }) { topic ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOpenHistoryTopic(topic) }
                    .testTag("about_history_${topic.id}"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(68.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = topic.drawableResId),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = topic.periodOrContext.get(currentLanguage),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = topic.title.get(currentLanguage),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = topic.subtitle.get(currentLanguage),
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 2
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Read Topic",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun ContactFeedbackAction(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    value: String,
    actionLabel: String,
    buttonColor: Color,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                Surface(
                    shape = CircleShape,
                    color = buttonColor.copy(alpha = 0.15f),
                    modifier = Modifier.size(36.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(icon, contentDescription = null, tint = buttonColor, modifier = Modifier.size(20.dp))
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                    Text(text = value, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = buttonColor
            ) {
                Text(
                    text = actionLabel,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                )
            }
        }
    }
}
