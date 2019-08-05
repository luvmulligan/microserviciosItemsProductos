package com.formacionbdi.springboot.app.productos.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{


}
