package ar.edu.video.aves.services

import ar.edu.video.aves.repository.AveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AveService {
   @Autowired
   lateinit var aveRepository: AveRepository

   @Transactional(readOnly = true)
   fun findAll() = aveRepository.findAll()
}