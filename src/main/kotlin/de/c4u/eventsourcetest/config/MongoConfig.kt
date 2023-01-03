package de.c4u.eventsourcetest.config

import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(basePackages = ["de.c4u.eventsourcetest.persistence.repository"])
class MongoConfig : AbstractReactiveMongoConfiguration() {

    override fun getDatabaseName() = "testdb"

    override fun reactiveMongoClient() = mongoClient()

    @Bean
    fun mongoClient() = MongoClients.create("mongodb://test:test@localhost:27017/testdb")

    @Bean
    fun reactiveMongoTemplate() = ReactiveMongoTemplate(mongoClient(), databaseName)
}
