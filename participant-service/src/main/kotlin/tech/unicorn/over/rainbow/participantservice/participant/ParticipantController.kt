package tech.unicorn.over.rainbow.participantservice.participant

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.unicorn.over.rainbow.participantservice.participant.dto.CreateParticipantDTO
import tech.unicorn.over.rainbow.participantservice.participant.dto.ParticipantDTO

@RestController
@RequestMapping("/api/participants")
class ParticipantController(
    val participantService: ParticipantService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addParticipant(@RequestBody participant: CreateParticipantDTO) {
        participantService.saveParticipant(participant)
    }

    @GetMapping
    fun findAllParticipants(): ResponseEntity<List<ParticipantDTO>> {
        return ResponseEntity.ok(participantService.findAllParticipants())
    }

    @GetMapping("/conference/{conference-id}")
    fun findAllParticipantsOfConference(@PathVariable("conference-id") conferenceId: String): ResponseEntity<List<ParticipantDTO>> {
        return ResponseEntity.ok(participantService.getParticipantsByConferenceId(conferenceId))
    }
}