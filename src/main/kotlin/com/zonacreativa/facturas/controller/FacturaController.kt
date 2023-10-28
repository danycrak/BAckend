package com.zonacreativa.facturas.controller;

import com.zonacreativa.facturas.model.Factura
import com.zonacreativa.facturas.service.FacturaService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/factura")   //endpoint
class FacturaController {

    @Autowired
    lateinit var facturaService: FacturaService

    @GetMapping
    fun list ():List <Factura>{
        return facturaService.list()
    }

    @PostMapping
    fun save (@RequestBody factura:Factura): ResponseEntity<Factura> {
        return ResponseEntity(facturaService.save(factura), HttpStatus.OK)
    }
    //clase controller
    @PutMapping
    fun update (@RequestBody factura: Factura): ResponseEntity<Factura> {
        return ResponseEntity(facturaService.update(factura), HttpStatus.OK)
    }
    //clase  controller
    @PatchMapping
    fun updateDescription (@RequestBody factura: Factura): ResponseEntity<Factura> {
        return ResponseEntity(facturaService.updateDescription(factura), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(facturaService.listById (id), HttpStatus.OK)

    }

    //clase  controller
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return facturaService.delete(id)
    }

}