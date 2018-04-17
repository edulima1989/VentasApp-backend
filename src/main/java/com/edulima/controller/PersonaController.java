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

import com.edulima.model.Persona;
import com.edulima.service.IPersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private IPersonaService service;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> personas = new ArrayList<>();
		try {
			personas = service.listar();
		}catch(Exception e) {
			return new ResponseEntity<List<Persona>>(personas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> listarId(@PathVariable("id") Integer id){
		Persona persona = new Persona();
		try {
			persona = service.listarId(id);
		}catch(Exception e) {
			return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> registrar(@RequestBody Persona persona) {
		Persona per = new Persona();
		try {
			per = service.registrar(persona);			
		} catch (Exception e) {
			return new ResponseEntity<Persona>(per, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Persona>(per, HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Persona persona) {
		int resultado = 0;
		try {
			service.modificar(persona);
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
