package ar.edu.video.aves.repository

import ar.edu.video.aves.domain.Ave
import org.springframework.data.repository.CrudRepository

interface AveRepository : CrudRepository<Ave, Long>