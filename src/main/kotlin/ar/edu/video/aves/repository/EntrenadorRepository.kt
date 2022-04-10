package ar.edu.video.aves.repository

import ar.edu.video.aves.domain.Entrenador
import org.springframework.data.repository.CrudRepository

interface EntrenadorRepository : CrudRepository<Entrenador, Long> {
}