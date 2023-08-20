package tech.unicorn.over.rainbow.participantservice.participant

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParticipantRepository: JpaRepository<Participant, Long> {
    fun findAllByConferenceId(conferenceId: String): List<Participant>
}