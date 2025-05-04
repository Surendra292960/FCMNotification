package com.example.fcmnotification

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fcmnotification.sign_in.SignInScreen
import com.example.fcmnotification.sign_in.SignInViewModel
import com.example.fcmnotification.ui.theme.FCMNotificationTheme
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : ComponentActivity() {
    private val sinInViewModel:SignInViewModel by viewModels<SignInViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FCMNotificationTheme {
                var isLoggedIn by remember { mutableStateOf(false) }
                if (isLoggedIn) {
                    // Show main app content after login
                    // SignInScreen(onLogout = { isLoggedIn = false })
                } else {
                    // Show login screen
                    SignInScreen(
                        onSuccess = { isLoggedIn = true },
                        viewModel = sinInViewModel
                    )
                }
            }
        }
    }
}
