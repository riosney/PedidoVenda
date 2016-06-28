package com.escudo7.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.escudo7.pedidovenda.model.Cliente;
import com.escudo7.pedidovenda.repository.Clientes;
import com.escudo7.pedidovenda.util.jpa.Transactional;

public class CadastroClienteService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes clientes;
	
	@Transactional
	public Cliente salvar(Cliente cliente){
		return clientes.guardar(cliente);
	}

}
