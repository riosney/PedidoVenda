package com.escudo7.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EnderecoBean {
	
	private List<Integer> enderecos;
	
	public EnderecoBean() {
		enderecos = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			enderecos.add(i);
		}
	}
	
	public List<Integer> getEnderecos() {
		return enderecos;
	}

}
