package com.edulima.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edulima.model.Producto;
import com.edulima.service.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> listar(){
		List<Producto> productos = new ArrayList<>();
		try {
			productos = service.listar();
		}catch(Exception e) {
			return new ResponseEntity<List<Producto>>(productos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> listarId(@PathVariable("id") Integer id){
		Producto producto = new Producto();
		try {
			producto = service.listarId(id);
		}catch(Exception e) {
			return new ResponseEntity<Producto>(producto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> registrar(@RequestBody Producto producto) {
		Producto pro = new Producto();
		try {
			pro = service.registrar(producto);			
		} catch (Exception e) {
			return new ResponseEntity<Producto>(pro, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Producto>(pro, HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Producto producto) {
		int resultado = 0;
		try {
			service.modificar(producto);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
		int resultado = 0;
		try {
			service.eliminar(id);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

}
