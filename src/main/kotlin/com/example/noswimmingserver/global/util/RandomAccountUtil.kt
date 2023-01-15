package com.example.noswimmingserver.global.util

import org.springframework.stereotype.Component

@Component
class RandomAccountUtil {

    fun createRandomEmail(): String {
        val emailList = StringBuilder()

        for (i in 1..8 step (1)) {
            val randomChar = ('a'..'z').random()
            emailList.append(randomChar)
        }

        return emailList.toString()
    }

    fun createRandomPassword(): String {
        val passwordList = StringBuilder()

        for (i in 1..8 step (1)) {
            val randomChar = ('a'..'z').random()
            passwordList.append(randomChar)
        }

        return passwordList.toString()
    }
}