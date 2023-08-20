package tech.unicorn.over.rainbow.conferenceservice.conference

import org.springframework.stereotype.Service
import tech.unicorn.over.rainbow.conferenceservice.conference.dto.ConferenceDTO
import tech.unicorn.over.rainbow.conferenceservice.conference.dto.ConferenceWithParticipantsDTO
import tech.unicorn.over.rainbow.conferenceservice.conference.dto.CreateConferenceDTO
import tech.unicorn.over.rainbow.conferenceservice.exceptions.ConferenceNotFoundException
import tech.unicorn.over.rainbow.conferenceservice.paticipant.ParticipantClient

@Service
class ConferenceService(
    private val conferenceRepository: ConferenceRepository,
    private val participantClient: ParticipantClient
) {
    fun getAllConferences(): List<ConferenceDTO> = conferenceRepository.findAll()
        .map { ConferenceDTO(id = it?.id, title = it.title, description = it?.description) }

    fun getConferenceDetails(id: String): ConferenceWithParticipantsDTO {
        val conference = conferenceRepository.findById(id)
            .orElseThrow { ConferenceNotFoundException("There is no conference with id: $id.") }

        val participants = participantClient.getParticipantsOfConference(conferenceId = id)

        return ConferenceWithParticipantsDTO(
            id = conference.id,
            title = conference.title,
            description = conference.description,
            participants = participants
        )
    }

    fun addConference(conference: CreateConferenceDTO) {
        conferenceRepository.save(Conference(title = conference.title, description = conference.description))
    }
}