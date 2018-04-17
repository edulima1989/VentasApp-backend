package com.edulima.service;

import java.util.List;

import com.edulima.model.Persona;

public interface IPersonaService {

	Persona registrar(Persona persona);

	void modificar(Persona persona);

	void eliminar(int idPersona);

	Persona listarId(int idPersona);

	List<Persona> listar();
}
