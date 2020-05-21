package io.ytvnr.karatebeer.repository

import io.ytvnr.karatebeer.domain.Beer
import io.ytvnr.karatebeer.domain.Brewer
import org.springframework.data.mongodb.repository.MongoRepository

interface BeerRepository:MongoRepository<Beer, Long> {
    fun findByBrewerId(id: Long): List<Beer>
    fun findByNameRegex(name: String): List<Beer>
}

interface BrewerRepository:MongoRepository<Brewer, Long>
