package com.zonacreativa.facturas.model

import jakarta.persistence.*

@Entity
@Table(name = "Factura")
class Factura {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "cliente_id")
    var clienteId: Long?=null
    var cantidad: Int? = null
    var ciudad: String? = null
    var email: String? = null
    var telefono: Int? = null
    var precio: Int? = null

}