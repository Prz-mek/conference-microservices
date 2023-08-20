package tech.unicorn.over.rainbow.conferenceservice.conference

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import tech.unicorn.over.rainbow.conferenceservice.conference.dto.ConferenceWithParticipantsDTO
import tech.unicorn.over.rainbow.conferenceservice.conference.dto.CreateConferenceDTO

@RestController
class ConferenceController(
    private val conferenceService: ConferenceService
) {

    @GetMapping
    fun getAllConferences() = conferenceService.getAllConferences()

    @PostMapping
    fun addConference(@RequestBody conference: CreateConferenceDTO) {
        conferenceService.addConference(conference)
    }

    @GetMapping("/{id}")
    fun getConferenceDetails(@PathVariable("id") id: String): ConferenceWithParticipantsDTO =
        conferenceService.getConferenceDetails(id)
}