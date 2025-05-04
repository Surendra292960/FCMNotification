/*
package com.example.fcmnotification.sign_in
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.Test

@RunWith(CustomTestRunner::class)
class LoginScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val testEmail = "test@example.com"
    private val testPassword = "password123"

    @Before
    fun setup() {
        System.setProperty("android.os.build.fingerprint", "robolectric")
        // Mock Build.FINGERPRINT directly
        val buildClass = Build::class.java
        val fingerprintField = buildClass.getDeclaredField("FINGERPRINT")
        fingerprintField.isAccessible = true
        fingerprintField.set(null, "robolectric")
    }

    @Test
    fun loginScreen_displaysAllRequiredComponents() {
        composeTestRule.setContent {
            MaterialTheme {
                SignInScreenContent(
                    uiState = SignInUiState(),
                    onEmailChange = {},
                    onPasswordChange = {},
                    onLoginClick = {},
                    onForgotPasswordClick = {}
                )
            }
        }

        // Verify all static text elements exist
        composeTestRule.onNodeWithText("Welcome Back").assertExists()
        composeTestRule.onNodeWithText("Please sign in to continue").assertExists()
        composeTestRule.onNodeWithText("Email").assertExists()
        composeTestRule.onNodeWithText("Password").assertExists()
        composeTestRule.onNodeWithText("Login").assertExists()
        composeTestRule.onNodeWithText("Forgot Password?").assertExists()
    }

    @Test
    fun loginScreen_showsEmailErrorWhenPresent() {
        composeTestRule.setContent {
            MaterialTheme {
                SignInScreenContent(
                    uiState = SignInUiState(emailError = "Email is required"),
                    onEmailChange = {},
                    onPasswordChange = {},
                    onLoginClick = {},
                    onForgotPasswordClick = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Email is required")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun loginScreen_showsPasswordErrorWhenPresent() {
        composeTestRule.setContent {
            MaterialTheme {
                SignInScreenContent(
                    uiState = SignInUiState(passwordError = "Password must be at least 6 characters"),
                    onEmailChange = {},
                    onPasswordChange = {},
                    onLoginClick = {},
                    onForgotPasswordClick = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Password must be at least 6 characters")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun loginScreen_showsLoadingIndicatorWhenLoading() {
        composeTestRule.setContent {
            MaterialTheme {
                SignInScreenContent(
                    uiState = SignInUiState(isLoading = true),
                    onEmailChange = {},
                    onPasswordChange = {},
                    onLoginClick = {},
                    onForgotPasswordClick = {}
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("Circular progress indicator")
            .assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("Login").assertIsNotEnabled()
    }

    @Test
    fun loginScreen_showsLoginErrorWhenPresent() {
        val errorMessage = "Invalid credentials"
        composeTestRule.setContent {
            MaterialTheme {
                SignInScreenContent(
                    uiState = SignInUiState(loginError = errorMessage),
                    onEmailChange = {},
                    onPasswordChange = {},
                    onLoginClick = {},
                    onForgotPasswordClick = {}
                )
            }
        }

        composeTestRule.onNodeWithText(errorMessage)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun loginScreen_emailInput_triggersCallback() {
        var receivedEmail = ""

        composeTestRule.setContent {
            MaterialTheme {
                SignInScreenContent(
                    uiState = SignInUiState(),
                    onEmailChange = { email -> receivedEmail = email },
                    onPasswordChange = {},
                    onLoginClick = {},
                    onForgotPasswordClick = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Email")
            .performTextInput(testEmail)

        assert(receivedEmail == testEmail)
    }

    @Test
    fun loginScreen_passwordInput_triggersCallback() {
        var receivedPassword = ""

        composeTestRule.setContent {
            MaterialTheme {
                SignInScreenContent(
                    uiState = SignInUiState(),
                    onEmailChange = {},
                    onPasswordChange = { password -> receivedPassword = password },
                    onLoginClick = {},
                    onForgotPasswordClick = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Password")
            .performTextInput(testPassword)

        assert(receivedPassword == testPassword)
    }

    @Test
    fun loginScreen_loginButton_triggersCallback() {
        var loginClicked = false

        composeTestRule.setContent {
            MaterialTheme {
                SignInScreenContent(
                    uiState = SignInUiState(),
                    onEmailChange = {},
                    onPasswordChange = {},
                    onLoginClick = { loginClicked = true },
                    onForgotPasswordClick = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Login")
            .assertIsEnabled()
            .performClick()

        assert(loginClicked)
    }

    @Test
    fun loginScreen_forgotPasswordButton_triggersCallback() {
        var forgotPasswordClicked = false

        composeTestRule.setContent {
            MaterialTheme {
                SignInScreenContent(
                    uiState = SignInUiState(),
                    onEmailChange = {},
                    onPasswordChange = {},
                    onLoginClick = {},
                    onForgotPasswordClick = { forgotPasswordClicked = true }
                )
            }
        }

        composeTestRule.onNodeWithText("Forgot Password?")
            .performClick()

        assert(forgotPasswordClicked)
    }
}*/
