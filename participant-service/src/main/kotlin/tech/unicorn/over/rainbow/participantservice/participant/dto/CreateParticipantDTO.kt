package tech.unicorn.over.rainbow.participantservice.participant.dto

data class CreateParticipantDTO(
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String,
)
