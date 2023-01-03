package de.c4u.eventsourcetest.persistence.service

import de.c4u.eventsourcetest.persistence.entity.Message
import de.c4u.eventsourcetest.persistence.repository.MessageRepository
import de.c4u.eventsourcetest.web.dto.MessageRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.*

@Service
class MessageService(val messageRepository: MessageRepository) {

    fun save(request: MessageRequest) {
        val message = Message(UUID.randomUUID().toString(), request.name, request.message)

        this.messageRepository.save(message).subscribe()
    }

    fun findAll(): Flux<Message> = this.messageRepository.findAll()
}
