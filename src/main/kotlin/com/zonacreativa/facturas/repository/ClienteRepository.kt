package com.zonacreativa.facturas.repository

import com.zonacreativa.facturas.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long?> {

    fun findById(id: Long?): Cliente?


}