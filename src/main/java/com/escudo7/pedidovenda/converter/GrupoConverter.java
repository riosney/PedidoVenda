package com.escudo7.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.escudo7.pedidovenda.model.Grupo;
import com.escudo7.pedidovenda.repository.Grupos;
import com.escudo7.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter{
	
	//@Inject
	private Grupos grupos;
	
	public GrupoConverter(){
		grupos = CDIServiceLocator.getBean(Grupos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = grupos.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			//Grupo grupo = (Grupo) value;
			//return grupo.getId() == null ? null : grupo.getId().toString();
			return ((Grupo) value).getId().toString();
		}
		return "";
	}

}
