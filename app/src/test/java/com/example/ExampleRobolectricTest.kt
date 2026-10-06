package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.AppRepository
import com.example.data.SampleData
import com.example.model.AppLanguage
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `verify app name resource`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Lha Nepal Bhasa", appName)
    }

    @Test
    fun `verify sample data collections`() {
        assertTrue("News articles must not be empty", SampleData.newsArticles.isNotEmpty())
        assertTrue("Lesson units must not be empty", SampleData.lessonUnits.isNotEmpty())
        assertTrue("Vocabulary words must not be empty", SampleData.vocabularies.isNotEmpty())
        assertTrue("Festivals must not be empty", SampleData.culturalFestivals.isNotEmpty())
        assertTrue("Script glyphs must not be empty", SampleData.scriptGlyphs.isNotEmpty())
        assertTrue("Cultural history topics must not be empty", SampleData.culturalHistoryTopics.isNotEmpty())
        assertEquals("awiskaracharya@gmail.com", SampleData.DEVELOPER_EMAIL)
        assertEquals("+9779827106244", SampleData.DEVELOPER_WHATSAPP)
    }

    @Test
    fun `verify tri-lingual localized string`() {
        val article = SampleData.newsArticles.first()
        val newaTitle = article.title.get(AppLanguage.NEWA)
        val nepaliTitle = article.title.get(AppLanguage.NEPALI)
        val englishTitle = article.title.get(AppLanguage.ENGLISH)

        assertTrue(newaTitle.contains("नेपाल संवत्"))
        assertTrue(nepaliTitle.contains("नेपाल संवत्"))
        assertTrue(englishTitle.contains("Nepal Sambat"))
    }

    @Test
    fun `verify repository bookmarking and points`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val repo = AppRepository(context)

        val initialPoints = repo.totalPoints.value
        repo.addPoints(50)
        assertEquals(initialPoints + 50, repo.totalPoints.value)

        val testNewsId = "news_test_123"
        repo.toggleNewsBookmark(testNewsId)
        assertTrue(repo.bookmarkedNewsIds.value.contains(testNewsId))

        repo.toggleNewsBookmark(testNewsId)
        assertTrue(!repo.bookmarkedNewsIds.value.contains(testNewsId))
    }
}
