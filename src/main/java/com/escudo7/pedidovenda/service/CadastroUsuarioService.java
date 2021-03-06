package com.escudo7.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.escudo7.pedidovenda.model.Usuario;
import com.escudo7.pedidovenda.repository.Usuarios;
import com.escudo7.pedidovenda.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Transactional
	public Usuario salvar(Usuario usuario){
		Usuario usuarioExistente = usuarios.porEmail(usuario.getEmail());
		
		if (usuarioExistente != null && !usuarioExistente.equals(usuario)) {
			throw new NegocioException("Email já cadastrado.");
		}
		
		return usuarios.guardar(usuario);
	}

}
