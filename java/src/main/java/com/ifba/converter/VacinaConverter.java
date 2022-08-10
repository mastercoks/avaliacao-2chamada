package com.ifba.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.ifba.model.Vacina;
import com.ifba.repository.Vacinas;
import com.ifba.util.JpaUtil;

@FacesConverter(forClass = Vacina.class)
public class VacinaConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Vacina retorno = null;
		EntityManager manager = JpaUtil.getManager();
		
		try {
			if (value != null && !"".equals(value)) {
				Vacinas vacinas = new Vacinas(manager);
				retorno = vacinas.porId(Long.parseLong(value));
			}			
			return retorno;
		} finally {
			manager.close();
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && ((Vacina) value).getId() != null) {
			return ((Vacina) value).getId().toString();
		}
			return null;
		}

}
