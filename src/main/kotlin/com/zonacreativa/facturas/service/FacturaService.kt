package com.zonacreativa.facturas.service

import com.zonacreativa.facturas.model.Factura
import com.zonacreativa.facturas.repository.FacturaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class FacturaService {

    @Autowired
    lateinit var facturaRepository: FacturaRepository

    fun list ():List<Factura>{
        return facturaRepository.findAll()
    }
    //clase service

    fun save(details: Factura): Factura {
        try{
            return facturaRepository.save(details)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    //clase service

    fun update(factura: Factura): Factura {
        try {
            facturaRepository.findById(factura.id)
                    ?: throw Exception("ID no existe")

            return facturaRepository.save(factura)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    //clase service

    fun updateDescription (factura: Factura): Factura {
        try{
            val response = facturaRepository.findById(factura.id)
                    ?: throw Exception("ID no existe")
            response.apply {
precio=factura.precio
            }
            return facturaRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
//Clase Service

    fun listById (id:Long?): Factura?{
        return facturaRepository.findById(id)
    }

    //clase service

    fun delete (id: Long?):Boolean?{
        try{
            val response = facturaRepository.findById(id)
                    ?: throw Exception("ID no existe")
            facturaRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}