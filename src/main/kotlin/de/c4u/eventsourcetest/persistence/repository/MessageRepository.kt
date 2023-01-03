package de.c4u.eventsourcetest.persistence.repository

import de.c4u.eventsourcetest.persistence.entity.Message
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MessageRepository : ReactiveMongoRepository<Message, Int>
