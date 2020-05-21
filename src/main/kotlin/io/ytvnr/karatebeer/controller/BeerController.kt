package io.ytvnr.karatebeer.controller

import io.ytvnr.karatebeer.domain.Beer
import io.ytvnr.karatebeer.service.BeerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/beers")
class BeerController(private val beerService: BeerService) {

    @GetMapping
    fun getBeers(pageable: Pageable): Page<Beer> = beerService.getAll(pageable)

    @GetMapping("{id}")
    fun getBeer(@PathVariable id: Long): Optional<Beer> = beerService.getById(id)

    @GetMapping("/byName/{regex}")
    fun getByName(@PathVariable regex:String):List<Beer> = beerService.findByNameRegex(regex)

    @PostMapping
    fun insert(@RequestBody beer: Beer): Beer = beerService.insert(beer)

    @PutMapping
    fun update(@RequestBody beer: Beer): Beer = beerService.update(beer)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): Optional<Beer> = beerService.deleteById(id)
}
