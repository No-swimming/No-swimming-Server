package com.example.noswimmingserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class NoSwimmingServerApplication

fun main(args: Array<String>) {
    runApplication<NoSwimmingServerApplication>(*args)
}
