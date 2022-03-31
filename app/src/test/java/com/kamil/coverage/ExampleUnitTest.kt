package com.kamil.coverage

import android.app.Application
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

class EmptyApplication : Application()


@RunWith(RobolectricTestRunner::class)
@Config(
    instrumentedPackages = ["androidx.loader.content"],
    application = EmptyApplication::class,
)
class ExampleUnitTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenEnabledOnClickedItCallsCallback() {
        // Given
        var called = false
        composeTestRule.setContent {
            UnitComposable(enabled = true) {
                called = true
            }
        }
        // When
        composeTestRule
            .onNodeWithText("Click me")
            .performClick()
        // Then
        Assert.assertTrue(called)
    }

    @Test
    fun testDefaultArgs() {
        // Given
        composeTestRule.setContent {
            UnitComposable()
        }
        // Then
        composeTestRule
            .onNodeWithText("Click me")
            .assertIsDisplayed()
    }


    @Test
    fun whenNotEnabledOnClickedItShowsText() {
        // Given
        composeTestRule.setContent {
            UnitComposable(enabled = false)
        }
        // Then
        composeTestRule
            .onNodeWithText("No clicking")
            .assertIsDisplayed()
    }

}