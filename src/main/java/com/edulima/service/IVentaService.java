package com.edulima.service;

import java.util.List;

import com.edulima.model.Venta;

public interface IVentaService {

	Venta registrar(Venta venta);

	Venta listarId(int idVenta);

	List<Venta> listar();
}
