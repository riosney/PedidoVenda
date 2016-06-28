package com.escudo7.pedidovenda.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.escudo7.pedidovenda.model.Cliente;
import com.escudo7.pedidovenda.model.TipoPessoa;
import com.escudo7.pedidovenda.service.CadastroClienteService;
import com.escudo7.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	@Inject
	private CadastroClienteService cadastroClienteService;
	
	public CadastroClienteBean() {
		limpar();
	}
	
	public void salvar(){	
		this.cliente = cadastroClienteService.salvar(this.cliente);
		limpar();
		FacesUtil.addInfoMessage("Cliente salvo com sucesso!");
	}
	
	public void limpar(){
		cliente = new Cliente();
	}
	
	public boolean isEditando(){
		return this.cliente.getId() != null;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public TipoPessoa[] getTiposPessoas() {
		return TipoPessoa.values();
	}

}
