/*
package com.example.fcmnotification.FCMTest

import com.example.fcmnotification.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FCMDataMessageTest {
    private var myFirebaseMessagingService: FirebaseMessagingService? = null

    @Mock
    var remoteMessage: RemoteMessage? = null

    @Before
    fun setup() {
        // Initialize mocks
        MockitoAnnotations.initMocks(this)
        myFirebaseMessagingService = FirebaseMessagingService()
    }

    @Test
    fun testDataMessageProcessing() {
        // Prepare a data payload
        Mockito.`when`(remoteMessage!!.data).thenReturn(object : HashMap<String?, String?>() {
            init {
                put("action", "sync_data")
            }
        })

        // Simulate receiving a data-only message
        myFirebaseMessagingService!!.onMessageReceived(remoteMessage!!)

        // Assert that the data is handled correctly
        Mockito.verify<FirebaseMessagingService?>(myFirebaseMessagingService, Mockito.times(1))
    }
}
*/
