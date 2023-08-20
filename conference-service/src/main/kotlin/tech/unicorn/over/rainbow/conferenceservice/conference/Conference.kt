package tech.unicorn.over.rainbow.conferenceservice.conference

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
data class Conference(
    @Id
    val id: String? = null,
    val title: String,
    val description: String? = null
)
