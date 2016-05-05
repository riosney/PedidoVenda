package com.escudo7.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.escudo7.pedidovenda.model.Grupo;
import com.escudo7.pedidovenda.model.Usuario;
import com.escudo7.pedidovenda.repository.Grupos;
import com.escudo7.pedidovenda.service.CadastroUsuarioService;
import com.escudo7.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Grupo grupo;

	@Inject
	private CadastroUsuarioService cadastroUsuarioService;

	@Inject
	private Grupos grupos;

	private List<Grupo> gruposRaizes;

	public CadastroUsuarioBean() {
		limpar();
	}

	public void inicializar() {
		gruposRaizes = grupos.raizes();
	}

	public void carregarGrupo() {
//		usuario.setGrupos(this.grupo);
	}

	public void salvar() {
		this.usuario = cadastroUsuarioService.salvar(this.usuario);
		limpar();
		FacesUtil.addInfoMessage("Usuário salvo com sucesso!");
	}

	public void limpar() {
		usuario = new Usuario();
		grupo = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Grupo> getGruposRaizes() {
		return gruposRaizes;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
