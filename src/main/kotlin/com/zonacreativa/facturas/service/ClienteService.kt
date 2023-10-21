package com.zonacreativa.facturas.service

import com.zonacreativa.facturas.model.Cliente
import com.zonacreativa.facturas.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ClienteService {
    @Autowired
    lateinit var clienteRepository: ClienteRepository

    fun list ():List<Cliente>{
        return clienteRepository.findAll()
    }
    //clase service

    fun save(details: Cliente): Cliente {
        try{
            return clienteRepository.save(details)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    //clase service

    fun update(cliente: Cliente): Cliente {
        try {
            clienteRepository.findById(cliente.id)
                    ?: throw Exception("ID no existe")

            return clienteRepository.save(cliente)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    //clase service

    fun updateDescription (cliente:Cliente): Cliente {
        try{
            val response = clienteRepository.findById(cliente.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                description=cliente.description
            }
            return clienteRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
//Clase Service

    fun listById (id:Long?):Cliente?{
        return clienteRepository.findById(id)
    }

    //clase service

    fun delete (id: Long?):Boolean?{
        try{
            val response = clienteRepository.findById(id)
                    ?: throw Exception("ID no existe")
            clienteRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}