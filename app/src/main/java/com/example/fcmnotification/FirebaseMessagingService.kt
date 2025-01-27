package com.example.fcmnotification;
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessagingService : FirebaseMessagingService() {
    // Should not change the channel ID's
    private val NOTIFICATION_EMERGENCY_CHANNEL_ID = "1101"
    private val NOTIFICATION_DEFAULT_CHANNEL_ID = "1001"
    private val DEFAULT_VIBRATE_PATTERN = longArrayOf(0, 250, 250, 250)
    private var SOUND_URI: Uri? = null
    private var channelId: String? = null

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.notification != null) {
            sendMyNotification(remoteMessage)
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("TAG", "onNewToken: $token")
    }

    private fun sendMyNotification(message: RemoteMessage) {
        // The notification sound is based on the channel id. So it is mandatory to sent channel id from backend

        if (message.notification?.channelId == NOTIFICATION_EMERGENCY_CHANNEL_ID) {
            channelId = NOTIFICATION_EMERGENCY_CHANNEL_ID
            SOUND_URI = Uri.parse("android.resource://" + applicationContext.packageName + "/" + R.raw.sapna_choudhary_ringtone)
        } else {
            channelId = NOTIFICATION_DEFAULT_CHANNEL_ID
            SOUND_URI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }

        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)


        val notificationBuilder: NotificationCompat.Builder = NotificationCompat.Builder(this, channelId!!)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(if (message.notification?.title == null) resources.getString(R.string.app_name) else message.notification!!.title)
            .setContentText(if (message.notification?.body == null) "" else message.notification!!.body)
            .setAutoCancel(true)
            .setSound(SOUND_URI)
            .setVibrate(DEFAULT_VIBRATE_PATTERN)
            .setContentIntent(pendingIntent)

        val mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (SOUND_URI != null) {
                // Changing Default mode of notification
                notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE)
                // Creating an Audio Attribute
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()

                // Creating Channel
                val notificationChannel = NotificationChannel(channelId, "Testing_Audio", NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.setSound(SOUND_URI, audioAttributes)
                notificationChannel.vibrationPattern = DEFAULT_VIBRATE_PATTERN
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.RED
                mNotificationManager.createNotificationChannel(notificationChannel)
            }
        }
        mNotificationManager.notify(0, notificationBuilder.build())
    }
}