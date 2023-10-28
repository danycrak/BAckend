package com.zonacreativa.facturas.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "Cliente")
class Cliente {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var nombre: String? = null
    var fecha: Date? = null


}
