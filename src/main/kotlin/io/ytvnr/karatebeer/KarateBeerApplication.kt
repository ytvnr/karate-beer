package io.ytvnr.karatebeer

import io.ytvnr.karatebeer.domain.Beer
import io.ytvnr.karatebeer.domain.Brewer
import io.ytvnr.karatebeer.repository.BeerRepository
import io.ytvnr.karatebeer.repository.BrewerRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KarateBeerApplication(
        private val beerRepository: BeerRepository,
        private val brewerRepository: BrewerRepository)
    : ApplicationRunner {
    /* This will run after springboot full load*/
    override fun run(args: ApplicationArguments?) {
        this.createBeers()
    }

    private fun createBeers() {
        this.cleanCollections()

        val trappist = brewerRepository.insert(Brewer(id = 1L, name="Trappist Brothers", country = "Belgium"))
        val cambier = brewerRepository.insert(Brewer(id = 2L, name="Cambier", country = "France"))

        val beers = listOf(
                Beer(id = 1L, name = "Karmeliet Tripel", strength = 10.0, brewer = trappist),
                Beer(id = 2L, name = "La Chouffe", strength = 9.5, brewer = trappist),
                Beer(id = 3L, name = "Jupiler", strength = 0.2, brewer = trappist),
                Beer(id = 4L, name = "L'arrageoise", strength = 5.0, brewer = cambier),
                Beer(id = 5L, name = "Heineken", strength = 0.0, brewer = cambier)
        )

        beerRepository.insert(beers);
    }

    private fun cleanCollections() {
        beerRepository.deleteAll()
        brewerRepository.deleteAll()
    }
}

fun main(args: Array<String>) {
    runApplication<KarateBeerApplication>(*args)
}
