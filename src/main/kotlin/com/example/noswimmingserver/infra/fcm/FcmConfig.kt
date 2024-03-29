package com.example.noswimmingserver.infra.fcm

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.ByteArrayInputStream
import java.io.IOException
import java.nio.charset.StandardCharsets
import javax.annotation.PostConstruct

@Component
class FcmConfig(
    @Value("\${firebase.path}")
    private val fcmValue: String
) {

    @PostConstruct
    private fun initialize() {
        try {
            if (FirebaseApp.getApps().isEmpty()) {
                val options: FirebaseOptions = FirebaseOptions.builder()
                    .setCredentials(
                        GoogleCredentials.fromStream(
                            ByteArrayInputStream(
                                fcmValue.toByteArray(StandardCharsets.UTF_8)
                            )
                        )
                    )
                    .build()
                FirebaseApp.initializeApp(options)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}