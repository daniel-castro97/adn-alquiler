package com.ceiba.alquiler.infraestructura.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.alquiler.infraestructura.entidades.MotoEntity;

/**
 * Interface de JPA
 * @author daniel.castro
 *
 */
@Repository
public interface MotoJpa extends JpaRepository<MotoEntity, String>{

	List<MotoEntity> findByPlaca(String placa);
	
	Long deleteByPlaca(String placa);

}
