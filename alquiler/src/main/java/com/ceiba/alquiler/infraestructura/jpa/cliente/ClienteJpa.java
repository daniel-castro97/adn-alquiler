package com.ceiba.alquiler.infraestructura.jpa.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.alquiler.infraestructura.entidades.ClienteEntity;

@Repository
public interface ClienteJpa extends JpaRepository<ClienteEntity, Long>{
	
	List<ClienteEntity> findByCedula(Long cedula);
	
	Long deleteByCedula(Long cedula);

}
