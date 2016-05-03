package com.escudo7.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.escudo7.pedidovenda.model.Produto;
import com.escudo7.pedidovenda.repository.Produtos;
import com.escudo7.pedidovenda.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	
	@Transactional
	public Produto salvar(Produto produto){
		Produto produtoExistente = produtos.porSku(produto.getSku());
		
		if(produtoExistente != null && !produtoExistente.equals(produto)){
			throw new NegocioException("Já existe um produto com o SKU informado.");
		}
		
		return produtos.guardar(produto);
	}

}
