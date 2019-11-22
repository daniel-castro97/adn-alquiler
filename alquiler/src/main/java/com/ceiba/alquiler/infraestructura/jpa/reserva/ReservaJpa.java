package com.ceiba.alquiler.infraestructura.jpa.reserva;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.alquiler.infraestructura.entidades.ReservaEntity;

@Repository
public interface ReservaJpa extends JpaRepository<ReservaEntity, Integer>{
	
	List<ReservaEntity> findById(int id);
	
	Long deleteById(int id);

}
