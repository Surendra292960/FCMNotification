/*
package com.example.fcmnotification.FCMTest

import com.example.fcmnotification.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FCMServiceTest {
    private var myFirebaseMessagingService: FirebaseMessagingService? = null

    @Mock
    var remoteMessage: RemoteMessage? = null

    @Before
    fun setup() {
        // Initialize the service and mocks
        MockitoAnnotations.initMocks(this)
        myFirebaseMessagingService = FirebaseMessagingService()
    }

    @Test
    fun testOnMessageReceived_withNotification() {
        // Prepare a mock notification payload
        Mockito.`when`(remoteMessage?.notification).thenReturn(remoteMessage?.notification)

        // Mock the notification's title and body
        Mockito.`when`(remoteMessage?.notification?.title).thenReturn("Foreground Notification")
        Mockito.`when`(remoteMessage?.notification?.body).thenReturn("Test in Foreground")

        // Call the onMessageReceived() method in the foreground
        myFirebaseMessagingService?.onMessageReceived(remoteMessage!!)

        // Verify if the notification body was processed
        // In this case, we would typically check if the notification was sent to NotificationManager
        // Since we're doing unit testing, we will verify method calls using mock verifications
        Mockito.verify(remoteMessage, Mockito.times(1))!!.notification
    }

    @Test
    fun testOnMessageReceived_withData() {
        // Prepare a mock data payload
        Mockito.`when`(remoteMessage!!.data).thenReturn(object : HashMap<String?, String?>() {
            init {
                put("key", "value")
            }
        })

        // Simulate the onMessageReceived() call
        myFirebaseMessagingService!!.onMessageReceived(remoteMessage!!)

        // Check that the data payload was processed correctly
        Assert.assertTrue("Data should contain key", remoteMessage!!.data.containsKey("key"))
    }
}
*/
