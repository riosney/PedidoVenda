package com.escudo7.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.escudo7.pedidovenda.model.Usuario;
import com.escudo7.pedidovenda.repository.Usuarios;
import com.escudo7.pedidovenda.repository.filter.UsuarioFilter;
import com.escudo7.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaUsuariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	private Usuario usuarioSelecionado;
	private UsuarioFilter filtro;
	private List<Usuario> usuariosFiltrados;

	public PesquisaUsuariosBean() {
		filtro = new UsuarioFilter();
	}

	public void excluir() {
		usuarios.remover(usuarioSelecionado);
		usuariosFiltrados.remove(usuarioSelecionado);
		
		FacesUtil.addInfoMessage("Usuário " + usuarioSelecionado.getEmail()
				+ " excluído com sucesso.");
	}

	public void pesquisar() {
		usuariosFiltrados = usuarios.filtrados(filtro);
	}

	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}

	public UsuarioFilter getFiltro() {
		return filtro;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

}
