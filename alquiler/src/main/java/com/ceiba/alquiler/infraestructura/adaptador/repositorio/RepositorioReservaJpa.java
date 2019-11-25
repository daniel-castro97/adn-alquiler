package com.ceiba.alquiler.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.dominio.entidades.Reserva;
import com.ceiba.alquiler.dominio.repositorio.RepositorioReserva;
import com.ceiba.alquiler.infraestructura.entidades.ReservaEntity;
import com.ceiba.alquiler.infraestructura.jpa.reserva.ReservaJpa;

@Repository
public class RepositorioReservaJpa implements RepositorioReserva {
	
	@Autowired
	private final ReservaJpa reservaJpa;

	private ModelMapper modelMapper = new ModelMapper();
	
	public RepositorioReservaJpa(ReservaJpa reservaJpa) {
		
		this.reservaJpa = reservaJpa;
	}

	@Override
	public void crear(Reserva reserva) {
		ReservaEntity reservaEntity = modelMapper.map(reserva, ReservaEntity.class);
		reservaJpa.save(reservaEntity);
	}

	@Override
	public boolean existe(Reserva reserva) {
		List<ReservaEntity> aux;
		ReservaEntity reservaEntity = modelMapper.map(reserva, ReservaEntity.class);
		aux = reservaJpa.findById(reservaEntity.getIdReserva());
		return !aux.isEmpty();
	}

	@Override
	public void eliminar(int id) {
		
		reservaJpa.deleteById(id);
	}

	@Override
	public void actualizar(Reserva reserva) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ComandoReserva> listar() {
		List<ReservaEntity > reservaEntities = reservaJpa.findAll();
		List<ComandoReserva> list = new ArrayList<>();
		for (int i = 0; i < reservaEntities.size(); i++) {
			list.add(modelMapper.map(reservaEntities.get(i), ComandoReserva.class));
		}
		return list;
	}

	@Override
	public ComandoReserva buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
