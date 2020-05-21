package io.ytvnr.karatebeer.service

import io.ytvnr.karatebeer.domain.Beer
import io.ytvnr.karatebeer.repository.BeerRepository
import io.ytvnr.karatebeer.repository.BrewerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class BeerService(private val beerRepository: BeerRepository, private val brewerRepository: BrewerRepository) {

    fun getAll(pageable: Pageable): Page<Beer> = beerRepository.findAll(pageable)

    fun getById(id: Long): Optional<Beer> = beerRepository.findById(id)

    fun findByNameRegex(nameRegex: String): List<Beer> = beerRepository.findByNameRegex(nameRegex)

    fun insert(beer: Beer): Beer {
        return beerRepository.insert(
                // re-insert brewer from db to avoid inconsistency
                beer.apply { this.brewer = brewerRepository.findById(beer.brewer.id).get() }
        )
    }

    @Throws(Exception::class)
    fun update(beer: Beer): Beer {
        return if (beerRepository.existsById(beer.id)) {
            beerRepository.save(
                beer.apply { this.brewer = brewerRepository.findById(beer.brewer.id).get() }
            )
        } else {
            throw object: Exception("Beer not found") {}
        }
    }

    fun deleteById(id: Long): Optional<Beer> {
        return beerRepository.findById(id).apply {
            this.ifPresent { beerRepository.delete(it) }
        }
    }
}
