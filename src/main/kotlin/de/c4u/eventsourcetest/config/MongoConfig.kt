package de.c4u.eventsourcetest.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories


@Configuration
@EnableConfigurationProperties(value = [AppConfig::class])
@EnableReactiveMongoRepositories(basePackages = ["de.c4u.eventsourcetest.persistence.repository"])
class MongoConfig : AbstractReactiveMongoConfiguration() {

    @Autowired
    lateinit var appConfig: AppConfig

    override fun reactiveMongoClient(): MongoClient {
        return MongoClients.create()
    }

    override fun getDatabaseName(): String {
        return this.appConfig.dbName
    }

    @Bean
    fun reactiveMongoTemplate(): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(reactiveMongoClient(), databaseName)
    }
}
