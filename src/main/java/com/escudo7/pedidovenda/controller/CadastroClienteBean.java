package com.escudo7.pedidovenda.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.escudo7.pedidovenda.model.Cliente;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	public CadastroClienteBean() {
		cliente = new Cliente();
	}
	
	public void salvar(){		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

}
