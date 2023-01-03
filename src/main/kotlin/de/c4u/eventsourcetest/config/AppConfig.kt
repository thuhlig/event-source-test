package de.c4u.eventsourcetest.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "event.source.test")
data class AppConfig(
    var port: Int,
    var dbName: String
)
