package tech.unicorn.over.rainbow.conferenceservice.exceptions

open class ApiException(override val message: String?): IllegalArgumentException(message)

class ConferenceNotFoundException(message: String) : ApiException(message)
