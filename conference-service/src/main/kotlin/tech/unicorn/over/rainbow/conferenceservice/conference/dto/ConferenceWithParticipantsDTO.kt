package tech.unicorn.over.rainbow.conferenceservice.conference.dto

import tech.unicorn.over.rainbow.conferenceservice.paticipant.dto.ParticipantDTO

data class ConferenceWithParticipantsDTO(
    val id: String?,
    val title: String,
    val description: String?,
    val participants: List<ParticipantDTO>?
)