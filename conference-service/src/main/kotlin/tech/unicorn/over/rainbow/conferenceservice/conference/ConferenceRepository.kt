package tech.unicorn.over.rainbow.conferenceservice.conference

import org.springframework.data.mongodb.repository.MongoRepository

interface ConferenceRepository: MongoRepository<Conference, String> {
}