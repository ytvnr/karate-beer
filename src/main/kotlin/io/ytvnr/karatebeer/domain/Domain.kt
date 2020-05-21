package io.ytvnr.karatebeer.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Brewer(@Id val id:Long, val name:String, val country:String)

@Document
data class Beer(@Id val id: Long, val name: String, val strength: Double, var brewer: Brewer)
