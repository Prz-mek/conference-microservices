package tech.unicorn.over.rainbow.conferenceservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class ConferenceServiceApplication

fun main(args: Array<String>) {
	runApplication<ConferenceServiceApplication>(*args)
}
