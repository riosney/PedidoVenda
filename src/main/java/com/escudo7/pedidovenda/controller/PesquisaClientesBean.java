package com.escudo7.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.escudo7.pedidovenda.model.Cliente;
import com.escudo7.pedidovenda.repository.Clientes;
import com.escudo7.pedidovenda.repository.filter.ClienteFilter;
import com.escudo7.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaClientesBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes clientes;
	
	private Cliente clienteSelecionado; 
	private ClienteFilter filtro;
	private List<Cliente> clientesFiltrados;

	public PesquisaClientesBean(){
		filtro = new ClienteFilter();
	}
	
	public void excluir(){
		clientes.remover(clienteSelecionado);
		clientesFiltrados.remove(clienteSelecionado);
		
		FacesUtil.addInfoMessage("Cliente " + clienteSelecionado.getEmail()
				+ " excluído com sucesso.");
	}
	
	public void pesquisar(){
		clientesFiltrados = clientes.filtrados(filtro);
	}
	
	public ClienteFilter getFiltro() {
		return filtro;
	}
	
	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}
	
	public Cliente getClienteSelecionado(){
		return clienteSelecionado;
	}
	
	public void setClienteSelecionado(Cliente clienteSelecionado){
		this.clienteSelecionado = clienteSelecionado;
	}

}
