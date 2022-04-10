package ar.edu.video.aves.controller

import ar.edu.video.aves.repository.AveRepository
import ar.edu.video.aves.services.AveService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET])
class AveController {

    @Autowired
    lateinit var aveService: AveService

    @GetMapping("/aves")
    @Operation(summary = "Trae la información de las aves")
    fun findAll() = aveService.findAll()

}
