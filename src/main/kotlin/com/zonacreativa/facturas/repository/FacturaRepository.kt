package com.zonacreativa.facturas.repository


import com.zonacreativa.facturas.model.Factura
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository



@Repository
interface FacturaRepository : JpaRepository<Factura, Long?> {

    fun findById(id: Long?): Factura?


}


