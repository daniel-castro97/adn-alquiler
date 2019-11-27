package com.ceiba.alquiler.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.alquiler.aplicacion.comando.ComandoCliente;
import com.ceiba.alquiler.dominio.entidades.Cliente;
import com.ceiba.alquiler.dominio.repositorio.RepositorioCliente;
import com.ceiba.alquiler.infraestructura.entidades.ClienteEntity;
import com.ceiba.alquiler.infraestructura.jpa.cliente.ClienteJpa;

@Repository
public class RepositorioClienteJpa implements RepositorioCliente{
	
	@Autowired
	private final ClienteJpa clienteJpa;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	
	
	public RepositorioClienteJpa(ClienteJpa clienteJpa) {
		
		this.clienteJpa = clienteJpa;
	}

	@Override
	public void crear(Cliente cliente) {
		ClienteEntity clienteEntity = modelMapper.map(cliente, ClienteEntity.class);
		clienteJpa.save(clienteEntity);
		
	}

	@Override
	public boolean existe(Cliente cliente) {
		List<ClienteEntity> aux;
		ClienteEntity clienteEntity = modelMapper.map(cliente, ClienteEntity.class);
		aux = clienteJpa.findByCedula(clienteEntity.getCedula());
		return !aux.isEmpty();
	}

	@Override
	public void eliminar(Cliente cliente) {
		clienteJpa.deleteByCedula(cliente.getCedula());
		
	}

	@Override
	public List<ComandoCliente> listar() {
		List<ClienteEntity> clienteEntities = clienteJpa.findAll();
		List<ComandoCliente> list = new ArrayList<>();
		for(int i=0;i<clienteEntities.size();i++) {
			list.add(modelMapper.map(clienteEntities.get(i),ComandoCliente.class));
		}
		return list;
	}

	@Override
	public ComandoCliente buscar(int cedula) {
		List<ClienteEntity> clienteEntities = clienteJpa.findAll();
		ComandoCliente comandoCliente = null;
		if(!clienteEntities.isEmpty()) {
			comandoCliente = modelMapper.map(clienteEntities.get(0), ComandoCliente.class);
		}
		return comandoCliente;
	}

}
