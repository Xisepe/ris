package ru.golubev.manager.config

import com.mongodb.WriteConcern
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
class MongoConfig {

    @Bean
    @Primary
    fun configMongoTemplate(mongoDatabaseFactory: MongoDatabaseFactory): MongoOperations {
        return MongoTemplate(mongoDatabaseFactory).apply {
            // Set write concern: Ensures data is written to primary and at least one secondary
            setWriteConcern(WriteConcern.W2);
        }
    }
}