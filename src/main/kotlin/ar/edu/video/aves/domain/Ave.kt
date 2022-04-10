package ar.edu.video.aves.domain

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value = Petrel::class, name = "P"),
    JsonSubTypes.Type(value = PetrelGigante::class, name = "W"),
    JsonSubTypes.Type(value = Golondrina::class, name = "G")
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class Ave(
    @Column(length = 100)
    open var nombre: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long? = null

    @Column
    open var energia = 100

    @Column
    open var fechaNacimiento = LocalDate.now()

    open fun volar(minutos: Int) {
        energia = energia - (minutos * 2)
    }

    open fun comer(gramos: Int) {
        energia = energia + (gramos * 5)
    }
}

@Entity
class Golondrina(nombre: String = "") : Ave(nombre) {
    @Column
    var vecesQueVolo = 0

    override fun volar(minutos: Int) {
        super.volar(minutos)
        vecesQueVolo++
    }
}

@Entity
open class Petrel(nombre: String = "") : Ave(nombre) {
    @Column
    open var estaFeliz = false

    override fun comer(gramos: Int) {
        super.comer(gramos)
        estaFeliz = energia > 50
    }
}

@Entity
class PetrelGigante(@Column var tamanio: Int = 0, nombre: String = "") : Petrel(nombre) {
    @Column
    var ultimaVezQueComio: LocalDateTime? = null

    override fun comer(gramos: Int) {
        super.comer(gramos)
        tamanio += 2
        ultimaVezQueComio = LocalDateTime.now()
    }
}
