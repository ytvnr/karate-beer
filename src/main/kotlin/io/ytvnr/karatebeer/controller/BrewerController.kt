package io.ytvnr.karatebeer.controller

import io.ytvnr.karatebeer.domain.Brewer
import io.ytvnr.karatebeer.service.BrewerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/brewers")
class BrewerController(private val brewerService: BrewerService) {

    @GetMapping
    fun getBrewers(pageable: Pageable): Page<Brewer> = brewerService.getAll(pageable)

    @GetMapping("{id}")
    fun getBrewer(@PathVariable id: Long): Optional<Brewer> = brewerService.getById(id)

    @PostMapping
    fun insert(@RequestBody brewer: Brewer): Brewer = brewerService.insert(brewer)

    @PutMapping
    fun update(@RequestBody brewer: Brewer): Brewer = brewerService.update(brewer)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): Optional<Brewer> = brewerService.deleteById(id)
}
