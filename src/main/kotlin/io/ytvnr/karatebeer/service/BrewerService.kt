package io.ytvnr.karatebeer.service

import io.ytvnr.karatebeer.domain.Brewer
import io.ytvnr.karatebeer.repository.BeerRepository
import io.ytvnr.karatebeer.repository.BrewerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class BrewerService(private val beerRepository: BeerRepository, private val brewerRepository: BrewerRepository) {
    fun getAll(pageable: Pageable): Page<Brewer> = brewerRepository.findAll(pageable)

    fun getById(id: Long): Optional<Brewer> = brewerRepository.findById(id)

    fun insert(obj: Brewer): Brewer = brewerRepository.insert(obj)

    @Throws(Exception::class)
    fun update(obj: Brewer): Brewer {
        return if(brewerRepository.existsById(obj.id)){//check if Brewer exists because the save method will insert a record if does not exists
            brewerRepository.save(obj).apply { //update Brewer
                obj.id?.let { //if does has Id then
                    beerRepository.saveAll(beerRepository.findByBrewerId(it).map { it.also { it.brewer=this } })//update all his beer
                }
            }
        }else{
            throw object : Exception("The Brewer does not exists"){}
        }
    }

    fun deleteById(id: Long): Optional<Brewer> {
        return brewerRepository.findById(id).apply {
            this.ifPresent {
                brewerRepository.delete(it)
            }
        }
    }
}
