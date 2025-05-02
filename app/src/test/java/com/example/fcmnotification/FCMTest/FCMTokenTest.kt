/*
package com.example.fcmnotification.FCMTest

import com.google.firebase.messaging.FirebaseMessaging
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FCMTokenTest {
    @Mock
    var firebaseMessaging: FirebaseMessaging? = null // Mock FirebaseMessaging service

    @Before
    fun setup() {
        // Initialize mocks
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testFCMTokenGeneration() {
        // Define the expected behavior for FirebaseMessaging mock
        Mockito.`when`(firebaseMessaging!!.token).thenReturn("mock_token")

        // Call the method that fetches the token
        val token = firebaseMessaging!!.token.result

        // Verify if the token is not null or empty
        Assert.assertNotNull("Token should not be null", token)
        Assert.assertEquals("mock_token", token)
    }
}
*/
