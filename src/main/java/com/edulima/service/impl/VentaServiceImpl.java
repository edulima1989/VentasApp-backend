package com.edulima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edulima.dao.IVentaDAO;
import com.edulima.model.Venta;
import com.edulima.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaDAO dao;

	@Override
	public Venta registrar(Venta venta) {
		venta.getDetalleVenta().forEach(x -> x.setVenta(venta));
		return dao.save(venta);
	}

	@Override
	public Venta listarId(int idVenta) {
		return dao.findOne(idVenta);
	}

	@Override
	public List<Venta> listar() {
		return dao.findAll();
	}
	
}
