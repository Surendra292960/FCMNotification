/*
package com.example.fcmnotification.FCMTest

import com.example.fcmnotification.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.junit.Before
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FCMForegroundTest {
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
    fun testNotificationInForeground() {
        // Simulate receiving a notification while the app is in the foreground
        // Mock the notification object
        Mockito.`when`(remoteMessage?.notification).thenReturn(remoteMessage?.notification)

        // Mock the notification's title and body
        Mockito.`when`(remoteMessage?.notification?.title).thenReturn("Foreground Notification")
        Mockito.`when`(remoteMessage?.notification?.body).thenReturn("Test in Foreground")

        // Call the onMessageReceived() method in the foreground
        myFirebaseMessagingService?.onMessageReceived(remoteMessage!!)

        // Verify that the sendNotification method was called to show the notification
        Mockito.verify(myFirebaseMessagingService, Mockito.times(1))
    }
}
*/
