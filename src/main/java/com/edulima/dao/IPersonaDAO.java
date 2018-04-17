package com.edulima.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edulima.model.Persona;

@Repository
public interface IPersonaDAO extends JpaRepository<Persona, Integer> {

}
