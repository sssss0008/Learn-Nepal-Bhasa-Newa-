package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SampleData
import com.example.model.AppLanguage
import com.example.model.CulturalHistoryTopic
import com.example.ui.MainTab
import com.example.ui.theme.*

@Composable
fun AppDrawerContent(
    currentTab: MainTab,
    currentLanguage: AppLanguage,
    onTabSelected: (MainTab) -> Unit,
    onSelectHistoryTopic: (CulturalHistoryTopic) -> Unit,
    onOpenLanguagePicker: () -> Unit
) {
    val context = LocalContext.current

    ModalDrawerSheet(
        modifier = Modifier.width(320.dp),
        drawerContainerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Cultural Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(NewaRedDark, NewaRed)
                        )
                    )
                    .statusBarsPadding()
                    .padding(20.dp)
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = NewaGoldContainer,
                            modifier = Modifier.size(50.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(text = "🪔", fontSize = 26.sp)
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "ल्हा: नेपाल भाषा",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                            Text(
                                text = "News & Language Academy",
                                fontSize = 12.sp,
                                color = NewaGoldLight
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Surface(
                        color = Color.White.copy(alpha = 0.18f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "ने.सं. ${SampleData.currentNepalSambatYear} • ${SampleData.currentNepalSambatMonth.get(currentLanguage)} ${SampleData.currentPaksha.get(currentLanguage)}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Navigation Tabs Section
            Text(
                text = "नेभिगेसन (Navigation):",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp)
            )

            // 1. Home
            NavigationDrawerItem(
                label = { Text("गृह (Home & News)", fontWeight = FontWeight.Bold) },
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                selected = currentTab == MainTab.HOME,
                onClick = { onTabSelected(MainTab.HOME) },
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
            )

            // 2. Learn
            NavigationDrawerItem(
                label = { Text("सयेकेगु (Learn Academy)", fontWeight = FontWeight.Bold) },
                icon = { Icon(Icons.Default.School, contentDescription = null) },
                selected = currentTab == MainTab.LEARN,
                onClick = { onTabSelected(MainTab.LEARN) },
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
            )

            // 3. Practice
            NavigationDrawerItem(
                label = { Text("अभ्यास (Practice & Quizzes)", fontWeight = FontWeight.Bold) },
                icon = { Icon(Icons.Default.FitnessCenter, contentDescription = null) },
                selected = currentTab == MainTab.PRACTICE,
                onClick = { onTabSelected(MainTab.PRACTICE) },
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
            )

            // 4. About
            NavigationDrawerItem(
                label = { Text("बारेमा (About & Feedback)", fontWeight = FontWeight.Bold) },
                icon = { Icon(Icons.Default.Info, contentDescription = null) },
                selected = currentTab == MainTab.ABOUT,
                onClick = { onTabSelected(MainTab.ABOUT) },
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 20.dp))
            Spacer(modifier = Modifier.height(10.dp))

            // Cultural Traditions & History Quick Links
            Text(
                text = "इतिहास व संस्कृति (Culture & History):",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp)
            )

            SampleData.culturalHistoryTopics.forEach { topic ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 3.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { onSelectHistoryTopic(topic) },
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = topic.drawableResId),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = topic.title.get(currentLanguage),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = topic.periodOrContext.get(currentLanguage),
                                fontSize = 10.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 20.dp))
            Spacer(modifier = Modifier.height(10.dp))

            // Direct Feedback & Developer Contacts
            Text(
                text = "सम्पर्क व प्रतिक्रिया (Feedback & Connect):",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = NewaTerracotta,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp)
            )

            // Email
            ContactRowItem(
                icon = Icons.Default.Email,
                title = "Email Feedback",
                detail = SampleData.DEVELOPER_EMAIL,
                onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:${SampleData.DEVELOPER_EMAIL}?subject=Lha%20Nepal%20Bhasa%20Feedback")
                    }
                    context.startActivity(Intent.createChooser(intent, "Send Email"))
                }
            )

            // WhatsApp
            ContactRowItem(
                icon = Icons.Default.Phone,
                title = "WhatsApp Direct",
                detail = SampleData.DEVELOPER_WHATSAPP,
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(SampleData.DEVELOPER_WHATSAPP_LINK))
                    context.startActivity(intent)
                }
            )

            // LinkedIn
            ContactRowItem(
                icon = Icons.Default.Link,
                title = "LinkedIn Profile",
                detail = "awiskaracharya",
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(SampleData.DEVELOPER_LINKEDIN))
                    context.startActivity(intent)
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Language Selector button in drawer footer
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onOpenLanguagePicker() },
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Language, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "भाषा (Language): ${currentLanguage.nativeName}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun ContactRowItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    detail: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 2.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                Text(text = detail, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
