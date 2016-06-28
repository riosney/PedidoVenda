package com.escudo7.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.escudo7.pedidovenda.model.Usuario;
import com.escudo7.pedidovenda.repository.filter.UsuarioFilter;
import com.escudo7.pedidovenda.service.NegocioException;
import com.escudo7.pedidovenda.util.jpa.Transactional;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario guardar(Usuario usuario){
		return manager.merge(usuario); 
	}
	
	@Transactional
	public void remover(Usuario usuario){
		try {
			usuario = porId(usuario.getId());
			manager.remove(usuario);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Usuário não pode ser excluído");
		}
	}
	
	public Usuario porEmail(String email){
		try {
			return manager.createQuery("from Usuario where email = :email", Usuario.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Usuario porId(Long id){
		return manager.find(Usuario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> filtrados(UsuarioFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);
		
		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}

}
