package com.escudo7.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PesquisaUsuariosBean {
	
	private List<Integer> usuariosFiltrados;
	
	public PesquisaUsuariosBean() {
		usuariosFiltrados = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			usuariosFiltrados.add(i);
		}
	}
	
	public List<Integer> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}

}
