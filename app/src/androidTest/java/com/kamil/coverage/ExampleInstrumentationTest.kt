package com.kamil.coverage

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ExampleInstrumentationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenEnabledOnClickedItCallsCallback() {
        // Given
        var called = false
        composeTestRule.setContent {
            InstrumentationComposable(enabled = true) {
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
            InstrumentationComposable()
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
            InstrumentationComposable(enabled = false)
        }
        // Then
        composeTestRule
            .onNodeWithText("No clicking")
            .assertIsDisplayed()
    }
}