package com.ceiba.alquiler.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.infraestructura.entidades.MotoEntity;
import com.ceiba.alquiler.infraestructura.jpa.moto.MotoJpa;

/**
 * Clase de repositorio de capa de infraestructura
 * @author daniel.castro
 *
 */
@Repository
public class RepositorioMotoJpa implements RepositorioMoto{
	
	
	@Autowired
	private final MotoJpa motoJpa; 
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public  RepositorioMotoJpa(MotoJpa jpa) {
		this.motoJpa = jpa;
	}
	@Override
	public void crear(Moto moto) {
		MotoEntity motoEntity = modelMapper.map(moto, MotoEntity.class);
		motoJpa.save(motoEntity);
	}

	@Override
	public boolean existe(Moto moto) {
		List<MotoEntity> aux;
		MotoEntity motoEntity = modelMapper.map(moto, MotoEntity.class);
		aux = motoJpa.findByPlaca(motoEntity.getPlaca());
		return !aux.isEmpty();
	}

	@Override
	public void eliminar(Moto moto) {
		motoJpa.deleteByPlaca(moto.getPlaca());
		
	}
	@Override
	public List<ComandoMoto> listar() {
		List<MotoEntity> motoEntities = motoJpa.findAll();
		List<ComandoMoto> list = new ArrayList<>();
		for(int i =0; i< motoEntities.size();i++) {
			list.add(modelMapper.map(motoEntities.get(i), ComandoMoto.class));
		}
		return list;
	}
	@Override
	public ComandoMoto buscar(String placa) {
		List<MotoEntity> motoEntities = motoJpa.findByPlaca(placa);
		ComandoMoto coomandoMoto = null;
		if(!motoEntities.isEmpty()) {
			coomandoMoto = modelMapper.map(motoEntities.get(0), ComandoMoto.class);
		}
		return coomandoMoto;
	}
	@Override
	public void actualizar(Moto moto) {
		MotoEntity motoEntity = modelMapper.map(moto, MotoEntity.class);
		motoJpa.save(motoEntity);
		
	}

}
