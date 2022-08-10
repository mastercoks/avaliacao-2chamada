package com.ifba.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.ifba.model.Aplicacao;
import com.ifba.repository.Aplicacoes;
import com.ifba.util.JpaUtil;

@FacesConverter(forClass = Aplicacao.class)
public class AplicacaoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Aplicacao retorno = null;
		EntityManager manager = JpaUtil.getManager();
		
		try {
			if (value != null && !"".equals(value)) {
				Aplicacoes aplicacoes = new Aplicacoes(manager);
				retorno = aplicacoes.porId(Long.parseLong(value));
			}			
			return retorno;
		} finally {
			manager.close();
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && ((Aplicacao) value).getId() != null) {
			return ((Aplicacao) value).getId().toString();
		}
			return null;
		}

}
