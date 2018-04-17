package com.edulima.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edulima.model.Venta;
import com.edulima.service.IVentaService;

@RestController
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	private IVentaService service;

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Venta>> listar() {
		List<Venta> ventas = new ArrayList<>();
		try {
			ventas = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
		}

		return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Venta> listarId(@PathVariable("id") Integer id){
		Venta venta = new Venta();
		try {
			venta = service.listarId(id);
		}catch(Exception e) {
			return new ResponseEntity<Venta>(venta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Venta>(venta, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Venta> registrar(@RequestBody Venta venta) {
		Venta v = new Venta();
		try {
			v = service.registrar(venta);
		} catch (Exception e) {
			return new ResponseEntity<Venta>(v, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Venta>(v, HttpStatus.OK);
	}

}
