package com.example.ui.screens.home

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SampleData
import com.example.model.AppLanguage
import com.example.model.CulturalHistoryTopic
import com.example.model.NewsArticle
import com.example.model.NewsCategory
import com.example.ui.screens.news.NewsCardItem
import com.example.ui.theme.*

@Composable
fun HomeScreen(
    articles: List<NewsArticle>,
    currentLanguage: AppLanguage,
    selectedCategory: NewsCategory,
    searchQuery: String,
    bookmarkedIds: Set<String>,
    onCategorySelect: (NewsCategory) -> Unit,
    onSearchChange: (String) -> Unit,
    onArticleClick: (NewsArticle) -> Unit,
    onToggleBookmark: (String) -> Unit,
    onSpeak: (String) -> Unit,
    onOpenHistoryTopic: (CulturalHistoryTopic) -> Unit
) {
    val filteredArticles = articles.filter { article ->
        val matchesCategory = selectedCategory == NewsCategory.ALL || article.category == selectedCategory
        val matchesSearch = searchQuery.isBlank() ||
                article.title.get(currentLanguage).contains(searchQuery, ignoreCase = true) ||
                article.subtitle.get(currentLanguage).contains(searchQuery, ignoreCase = true)
        matchesCategory && matchesSearch
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("home_screen_feed"),
        contentPadding = PaddingValues(bottom = 90.dp)
    ) {
        // Hero Cultural Heritage Carousel / Banner
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
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
                        .padding(18.dp)
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
                                    text = "नेपाल संवत् ${SampleData.currentNepalSambatYear}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = NewaOnGoldContainer,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                            Text(
                                text = "${SampleData.currentNepalSambatMonth.get(currentLanguage)} • ${SampleData.currentTithi.get(currentLanguage)}",
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.85f),
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = when (currentLanguage) {
                                        AppLanguage.NEWA -> "ज्वजलपा! लसकुस!"
                                        AppLanguage.NEPALI -> "नमस्ते! हार्दिक स्वागतम्!"
                                        AppLanguage.ENGLISH -> "Jwajalapa! Welcome!"
                                    },
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = when (currentLanguage) {
                                        AppLanguage.NEWA -> "नेपाल भाषाया ताजा बुखँ व सम्पदा अध्ययन यानादिसँ।"
                                        AppLanguage.NEPALI -> "नेपाल भाषाका ताजा समाचार र ऐतिहासिक सम्पदा अन्वेषण गर्नुहोस्।"
                                        AppLanguage.ENGLISH -> "Explore Nepal Bhasa news, rich history, and cultural traditions."
                                    },
                                    fontSize = 12.sp,
                                    color = Color.White.copy(alpha = 0.9f),
                                    lineHeight = 16.sp
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Image(
                                painter = painterResource(id = com.example.R.drawable.ic_pagoda_temple),
                                contentDescription = "Pagoda Temple",
                                modifier = Modifier.size(76.dp)
                            )
                        }
                    }
                }
            }
        }

        // Cultural Traditions & History Quick Exploration Row (with Images)
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = when (currentLanguage) {
                        AppLanguage.NEWA -> "इतिहास व संस्कृति झलक (Heritage Highlights):"
                        AppLanguage.NEPALI -> "इतिहास र संस्कृति झलक:"
                        AppLanguage.ENGLISH -> "Heritage & History Highlights:"
                    },
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    SampleData.culturalHistoryTopics.forEach { topic ->
                        Card(
                            modifier = Modifier
                                .width(220.dp)
                                .clickable { onOpenHistoryTopic(topic) },
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(80.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = topic.drawableResId),
                                        contentDescription = null,
                                        modifier = Modifier.size(54.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = topic.title.get(currentLanguage),
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = topic.periodOrContext.get(currentLanguage),
                                    fontSize = 10.sp,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(14.dp))
        }

        // Search Bar & News Categories
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("home_search_input"),
                    placeholder = {
                        Text(
                            text = when (currentLanguage) {
                                AppLanguage.NEWA -> "बुखँ मालादिसँ... (Search news)"
                                AppLanguage.NEPALI -> "समाचार खोज्नुहोस्..."
                                AppLanguage.ENGLISH -> "Search news articles..."
                            },
                            fontSize = 13.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    trailingIcon = {
                        if (searchQuery.isNotBlank()) {
                            IconButton(onClick = { onSearchChange("") }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    },
                    shape = RoundedCornerShape(14.dp),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Category Chips
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    NewsCategory.values().forEach { cat ->
                        val isSelected = cat == selectedCategory
                        FilterChip(
                            selected = isSelected,
                            onClick = { onCategorySelect(cat) },
                            label = {
                                Text(
                                    text = cat.label.get(currentLanguage),
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    fontSize = 12.sp
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primary,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }
            }
        }

        // Section Title: Recent News
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = when (currentLanguage) {
                        AppLanguage.NEWA -> "ताजा बुखँ (Latest News)"
                        AppLanguage.NEPALI -> "ताजा समाचार"
                        AppLanguage.ENGLISH -> "Recent News"
                    },
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "${filteredArticles.size} articles",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // News List Items
        if (filteredArticles.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "बुखँ लुइके मफुत / No articles found",
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            items(filteredArticles, key = { it.id }) { article ->
                NewsCardItem(
                    article = article,
                    currentLanguage = currentLanguage,
                    isBookmarked = bookmarkedIds.contains(article.id),
                    onArticleClick = onArticleClick,
                    onToggleBookmark = onToggleBookmark,
                    onSpeak = onSpeak
                )
            }
        }
    }
}
