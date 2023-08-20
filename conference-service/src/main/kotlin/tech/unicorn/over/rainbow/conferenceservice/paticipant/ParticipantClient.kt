package tech.unicorn.over.rainbow.conferenceservice.paticipant

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import tech.unicorn.over.rainbow.conferenceservice.paticipant.dto.ParticipantDTO

@FeignClient(name = "participant-service", url = "\${application.config.participant.url}")
interface ParticipantClient {

    @GetMapping("/conference/{conference-id}")
    fun getParticipantsOfConference(@PathVariable("conference-id") conferenceId: String):List<ParticipantDTO>

}