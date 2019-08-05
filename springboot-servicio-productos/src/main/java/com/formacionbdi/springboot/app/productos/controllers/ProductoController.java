package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;
//Controlador REST de Spring
@RestController
public class ProductoController {
	
	//@Autowired 
	//private Environment env;
	@Value("${server.port}")
	private Integer port;
	
	//Inyección de dependencia de la clase productoService
	@Autowired
	private IProductoService productoService;
	
	//Mapear endpoint a los métodos
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto ->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;

		}).collect(Collectors.toList());
	}
	
	//pasar el valor de id a la ruta url
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) throws Exception {
		Producto producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		
		//try {
		//	Thread.sleep(2000L);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		
		return producto;
	}

}
