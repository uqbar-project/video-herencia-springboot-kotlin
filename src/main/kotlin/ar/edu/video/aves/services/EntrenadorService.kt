package ar.edu.video.aves.services

import ar.edu.video.aves.repository.EntrenadorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EntrenadorService {
   @Autowired
   lateinit var entrenadorRepository: EntrenadorRepository

   @Transactional(readOnly = true)
   fun findAll() = entrenadorRepository.findAll()
}