package ar.edu.video.aves

import ar.edu.video.aves.domain.Entrenador
import ar.edu.video.aves.domain.Golondrina
import ar.edu.video.aves.domain.Petrel
import ar.edu.video.aves.domain.PetrelGigante
import ar.edu.video.aves.repository.AveRepository
import ar.edu.video.aves.repository.EntrenadorRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.stereotype.Service

@Service
class AveBootstrap : InitializingBean {

    @Autowired
    lateinit var aveRepository: AveRepository

    @Autowired
    lateinit var entrenadorRepository: EntrenadorRepository

    override fun afterPropertiesSet() {
        println("************************************************************************")
        println("Running initialization")
        println("************************************************************************")
        val pepe = Petrel("pepe").apply {
            comer(5)
            volar(2)
        }
        aveRepository.save(pepe)
        val pepon = PetrelGigante(5, "pepón")
        pepon.apply {
            comer(3)
            volar(2)
        }
        aveRepository.save(pepon)

        val pepita = Golondrina("pepita")
        pepita.apply {
            comer(5)
            volar(4)
        }
        aveRepository.save(pepita)

        entrenadorRepository.save(Entrenador("victor", pepita))
    }

}

class ServletInitializer : SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(AveApplication::class.java)
    }
}