package com.escudo7.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.escudo7.pedidovenda.model.Cliente;
import com.escudo7.pedidovenda.repository.filter.ClienteFilter;
import com.escudo7.pedidovenda.service.NegocioException;
import com.escudo7.pedidovenda.util.jpa.Transactional;

public class Clientes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cliente guardar(Cliente cliente){
		return manager.merge(cliente);
	}
	
	@Transactional
	public void remover(Cliente cliente){
		try{
			cliente = porId(cliente.getId());
			manager.remove(cliente);
			manager.flush();
		}catch(PersistenceException e){
			throw new NegocioException("Cliente não pode ser excluído");
		}
	}
	
	public Cliente porId(Long id){
		return manager.find(Cliente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> filtrados(ClienteFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Cliente.class);
		
		if (StringUtils.isNotBlank(filtro.getDocumentoReceitaFederal())) {
			criteria.add(Restrictions.ilike("documentoReceitaFederal", 
				filtro.getDocumentoReceitaFederal(), MatchMode.ANYWHERE));
		}
		
		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));			
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}

}
