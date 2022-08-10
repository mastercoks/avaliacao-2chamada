package com.ifba.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("AtividadePU");
	
//	static {
//		factory = Persistence.createEntityManagerFactory("AtividadePU");
//	}
	
	public static EntityManager getManager() {
		return factory.createEntityManager();
	}

}
