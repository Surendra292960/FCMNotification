package com.example.fcmnotification

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fcmnotification.ui.theme.FCMNotificationTheme
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FCMNotificationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

    FirebaseMessaging.getInstance().token.addOnSuccessListener { token: String ->
        if (!TextUtils.isEmpty(token)) {
            Log.d("TAG", "retrieve token successful : $token")
        } else {
            Log.w("TAG", "token should not be null...")
        }
    }.addOnFailureListener { e: Exception ->
        Log.d("TAG", "Greeting: ${e.message}")
    }.addOnCanceledListener {}
        .addOnCompleteListener { task: Task<String> ->
            Log.v(
                "TAG",
                "This is the token : " + task.result
            )
        }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FCMNotificationTheme {
        Greeting("Android")
    }
}