package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;
//Controlador REST de Spring
@RestController
public class ProductoController {
	
	//Inyección de dependencia de la clase productoService
	@Autowired
	private IProductoService productoService;
	
	//Mapear endpoint a los métodos
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll();
	}
	
	//pasar el valor de id a la ruta url
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		return productoService.findById(id);
	}

}
