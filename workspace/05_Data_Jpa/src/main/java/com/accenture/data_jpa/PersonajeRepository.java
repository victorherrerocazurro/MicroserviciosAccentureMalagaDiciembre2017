package com.accenture.data_jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonajeRepository extends JpaRepository<Personaje, Long>{

	@Query("select p from Personaje p where p.apellido = :apellido")
	List<Personaje> buscarPorApellido(@Param("apellido") String apellido);
	
	List<Personaje> findByApellido(String apellido);
	
}
