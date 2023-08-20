package tech.unicorn.over.rainbow.participantservice.participant

import org.springframework.stereotype.Service
import tech.unicorn.over.rainbow.participantservice.participant.dto.CreateParticipantDTO
import tech.unicorn.over.rainbow.participantservice.participant.dto.ParticipantDTO

@Service
class ParticipantService(
    val participantRepository: ParticipantRepository
) {
    fun saveParticipant(participant: CreateParticipantDTO) {
        participantRepository.save(
            Participant(
                firstName = participant.firstName,
                lastName = participant.lastName,
                email = participant.email
            )
        )
    }

    fun findAllParticipants(): List<ParticipantDTO> {
        return participantRepository.findAll()
            .map { participant ->
                ParticipantDTO(
                    id = participant.id,
                    firstName = participant.firstName,
                    lastName = participant.lastName,
                    email = participant.email
                )
            }
    }

    fun getParticipantsByConferenceId(conferenceId: String): List<ParticipantDTO> {
        return participantRepository.findAllByConferenceId(conferenceId)
            .map { participant ->
                ParticipantDTO(
                    id = participant.id,
                    firstName = participant.firstName,
                    lastName = participant.lastName,
                    email = participant.email
                )
            }
    }
}