package de.c4u.eventsourcetest.web.async

import de.c4u.eventsourcetest.persistence.entity.Message
import de.c4u.eventsourcetest.persistence.service.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
@RequestMapping("/messages")
class MessageController(val messageService: MessageService) {

    @GetMapping
    fun sendRandomMessages(): Flux<Message> {
//        val messages = mutableListOf<String>()
//
//        for (i in 1..100)
//            messages.add("foo $i")
//
//        return Flux
//            .fromIterable(messages)
//            .delayElements(Duration.ofSeconds(1))

        return this.messageService.findAll()
    }
}
