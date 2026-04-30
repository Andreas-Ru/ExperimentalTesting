package com.example.experimentaltesting

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.experimentaltesting.ui.theme.ExperimentalTestingTheme
import org.junit.Rule
import org.junit.Test


class MyTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun dogSuccessfullyAdopted() {

        composeTestRule.setContent {
            ExperimentalTestingTheme {
                HomeScreen(androidx.compose.ui.Modifier)
            }
        }

        composeTestRule.onNodeWithText("Name").performTextInput("My Name")
        composeTestRule.onNodeWithText("Address").performTextInput("My Address")
        composeTestRule.onNodeWithText("Telephone Number").performTextInput("0112345678")

        composeTestRule.onNodeWithContentDescription("Are you rich?").performClick()

        composeTestRule.waitUntil(500) {
            composeTestRule.onNodeWithText("jetzt adoptieren").isDisplayed()
        }

        composeTestRule.onNodeWithText("jetzt adoptieren").performClick()

        composeTestRule.waitUntil(2000) {
            composeTestRule.onNodeWithText("Adopted!").isDisplayed()
        }

        composeTestRule.onNodeWithText("Adopted!").assertIsDisplayed()
    }
}