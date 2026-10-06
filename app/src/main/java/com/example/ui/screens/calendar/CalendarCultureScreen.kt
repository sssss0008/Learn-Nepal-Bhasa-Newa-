package com.example.ui.screens.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Celebration
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.VolumeUp
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
import com.example.model.CulturalFestival
import com.example.ui.theme.*

@Composable
fun CalendarCultureScreen(
    currentLanguage: AppLanguage,
    festivals: List<CulturalFestival>,
    onSpeak: (String) -> Unit
) {
    val sambatMonths = listOf(
        "१. कछला (Kachhala)" to "कार्तिक (Oct/Nov)",
        "२. थिंला (Thinla)" to "मंसिर (Nov/Dec)",
        "३. पोँहेला (Pohela)" to "पुष (Dec/Jan)",
        "४. सिल्ला (Silla)" to "माघ (Jan/Feb)",
        "५. चिल्ला (Chilla)" to "फागुन (Feb/Mar)",
        "६. चौला (Chaula)" to "चैत (Mar/Apr)",
        "७. बछला (Bachhala)" to "वैशाख (Apr/May)",
        "८. तछला (Tachhala)" to "जेठ (May/Jun)",
        "९. दिल्ला (Dilla)" to "असार (Jun/Jul)",
        "१०. गुंला (Gunla)" to "साउन (Jul/Aug)",
        "११. ञंला (Yenla)" to "भदौ (Aug/Sep)",
        "१२. कौला (Kaula)" to "असोज (Sep/Oct)"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("calendar_culture_screen"),
        contentPadding = PaddingValues(16.dp, bottom = 90.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Nepal Sambat Hero Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(NewaRedDark, NewaRed)
                            )
                        )
                        .padding(20.dp)
                ) {
                    Column {
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
                                    text = "नेपाल संवत् राष्ट्रिय क्यालेन्डर",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = NewaOnGoldContainer,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }

                            IconButton(
                                onClick = { onSpeak("नेपाल संवत् ११४६ कछलाथ्व पारु") },
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(Icons.Default.VolumeUp, contentDescription = "Speak date", tint = Color.White)
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Year & Tithi
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "ने.सं. ${SampleData.currentNepalSambatYear}",
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color.White
                                )
                                Text(
                                    text = "महिना: ${SampleData.currentNepalSambatMonth.get(currentLanguage)} (${SampleData.currentPaksha.get(currentLanguage)})",
                                    fontSize = 14.sp,
                                    color = NewaGoldLight,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Surface(
                                color = Color.White.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "तिथि (Tithi)", fontSize = 10.sp, color = Color.White.copy(alpha = 0.8f))
                                    Text(
                                        text = SampleData.currentTithi.get(currentLanguage),
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))
                        HorizontalDivider(color = Color.White.copy(alpha = 0.2f))
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "संस्थापक: राष्ट्रिय विभूति शंखधर साख्वा (Shankhadhar Sakhwa, 879 CE) • गरिब जनताको ऋण मुक्ति दिवस",
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.85f),
                            lineHeight = 15.sp
                        )
                    }
                }
            }
        }

        // 12 Months of Nepal Sambat Slider
        item {
            Column {
                Text(
                    text = "नेपाल संवत्का १२ महिनाहरू (12 Sambat Months):",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    sambatMonths.forEach { (name, approx) ->
                        Surface(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .clickable { onSpeak(name) },
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f)
                        ) {
                            Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                                Text(text = name, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimaryContainer)
                                Text(text = approx, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    }
                }
            }
        }

        // Cultural Wisdom (खँत्वाः) Feature Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = NewaGoldContainer.copy(alpha = 0.6f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.FormatQuote, contentDescription = null, tint = NewaTerracotta)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "नेवाः खँत्वाः (Cultural Wisdom)",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = NewaOnGoldContainer
                            )
                        }

                        IconButton(onClick = { onSpeak("मनू सियाः नां ल्यनी, सिमा सिनाः सि ल्यनी।") }) {
                            Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = NewaTerracotta)
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "“मनू सियाः नां ल्यनी, सिमा सिनाः सि ल्यनी”",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "भावार्थ: मान्छे बितेर गए पनि उसले गरेको राम्रो कर्म र कीर्ति सधैँ अमर रहन्छ, जसरी रुख ढले पनि काठ उपयोगी रहन्छ।",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 17.sp
                    )
                }
            }
        }

        // Major Cultural Festivals Section Title
        item {
            Text(
                text = "प्रमुख नेवाः नखः व जात्रा (Major Cultural Festivals):",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        // Festivals List
        items(festivals, key = { it.id }) { fest ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = fest.iconEmoji, fontSize = 24.sp)
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = fest.name.get(currentLanguage),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "${fest.sambatDate} • ${fest.gregorianMonth}",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }

                        IconButton(onClick = { onSpeak(fest.name.newa) }) {
                            Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = MaterialTheme.colorScheme.primary)
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = fest.description.get(currentLanguage),
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 18.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Special Foods & Rituals
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "🍽️ परिकार (Food): ${fest.specialFood.get(currentLanguage)}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "🪔 परम्परा (Rituals): ${fest.traditions.get(currentLanguage)}",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}
