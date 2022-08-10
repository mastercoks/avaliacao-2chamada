package com.ifba.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.ifba.model.Pessoa;
import com.ifba.repository.Pessoas;
import com.ifba.util.JpaUtil;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		EntityManager manager = JpaUtil.getManager();
		
		try {
			if (value != null && !"".equals(value)) {
				Pessoas pessoas = new Pessoas(manager);
				retorno = pessoas.porId(Long.parseLong(value));
			}			
			return retorno;
		} finally {
			manager.close();
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && ((Pessoa) value).getId() != null) {
			return ((Pessoa) value).getId().toString();
		}
			return null;
		}

}
