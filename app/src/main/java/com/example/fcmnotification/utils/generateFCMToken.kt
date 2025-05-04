package com.example.fcmnotification.utils

import android.text.TextUtils
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging

object Utils{

    fun generateFCMToken() {
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
}