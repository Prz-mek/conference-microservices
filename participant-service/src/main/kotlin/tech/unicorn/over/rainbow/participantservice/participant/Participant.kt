package tech.unicorn.over.rainbow.participantservice.participant

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Participant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String,
    val conferenceId: String? = null
)
