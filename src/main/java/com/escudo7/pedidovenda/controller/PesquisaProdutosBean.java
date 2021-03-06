package com.escudo7.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.escudo7.pedidovenda.model.Produto;
import com.escudo7.pedidovenda.repository.Produtos;
import com.escudo7.pedidovenda.repository.filter.ProdutoFilter;
import com.escudo7.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	
	private Produto produtoSelecionado;
	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;
	
	public PesquisaProdutosBean(){
		filtro = new ProdutoFilter();		
	}
	
	public void excluir(){
		produtos.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto " + produtoSelecionado.getSku() 
				+ " excluído com sucesso");
	}
	
	public void pesquisar(){
		produtosFiltrados = produtos.filtrados(filtro);
	}
	
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
}
