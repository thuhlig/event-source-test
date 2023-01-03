package de.c4u.eventsourcetest.persistence.entity

import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
class Message {

    @Id
    var id = 0
    var name = ""
    var message = ""
}
