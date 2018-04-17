package com.edulima.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edulima.model.Venta;

@Repository
public interface IVentaDAO extends JpaRepository<Venta, Integer>{

}
