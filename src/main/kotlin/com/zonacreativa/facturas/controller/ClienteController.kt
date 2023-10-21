package com.zonacreativa.facturas.controller

import com.zonacreativa.facturas.model.Cliente
import com.zonacreativa.facturas.service.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cliente")   //endpoint
class ClienteController {

    @Autowired
    lateinit var clienteService: ClienteService

    @GetMapping
    fun list ():List <Cliente>{
        return clienteService.list()
    }

    @PostMapping
    fun save (@RequestBody cliente:Cliente): ResponseEntity<Cliente> {
        return ResponseEntity(clienteService.save(cliente), HttpStatus.OK)
    }
    //clase controller
    @PutMapping
    fun update (@RequestBody cliente:Cliente):ResponseEntity<Cliente>{
        return ResponseEntity(clienteService.update(cliente), HttpStatus.OK)
    }
    //clase  controller
    @PatchMapping
    fun updateDescription (@RequestBody cliente:Cliente):ResponseEntity<Cliente>{
        return ResponseEntity(clienteService.updateDescription(cliente), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(clienteService.listById (id), HttpStatus.OK)

    }

    //clase  controller
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return clienteService.delete(id)
    }

}