package ar.edu.video.aves.domain

import javax.persistence.*

@Entity
class Entrenador(
    @Column(length=150)
    var nombre: String = "",

    @ManyToOne
    var aveFavorita: Ave? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}