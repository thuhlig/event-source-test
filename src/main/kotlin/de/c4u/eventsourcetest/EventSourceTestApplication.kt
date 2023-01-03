package de.c4u.eventsourcetest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EventSourceTestApplication

fun main(args: Array<String>) {
	runApplication<EventSourceTestApplication>(*args)
}
