package de.c4u.eventsourcetest.persistence.service

import de.c4u.eventsourcetest.persistence.entity.Message
import de.c4u.eventsourcetest.persistence.repository.MessageRepository
import de.c4u.eventsourcetest.web.dto.MessageRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class MessageService(val messageRepository: MessageRepository) {

    fun save(request: MessageRequest) {
        val message = Message()
        message.name = request.name
        message.message = request.message

        this.messageRepository.save(message)
    }

    fun findAll(): Flux<Message> = this.messageRepository.findAll()
}
