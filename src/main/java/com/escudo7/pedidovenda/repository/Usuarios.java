package com.escudo7.pedidovenda.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.escudo7.pedidovenda.model.Usuario;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario guardar(Usuario usuario){
		return manager.merge(usuario); 
	}
	
	public void remover(Usuario usuario){
		
	}
	
	public Usuario porEmail(String email){
		return null;
	}
	
	public Usuario porId(Long id){
		return manager.find(Usuario.class, id);
	}

}
