package com.example.javaapp.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {
    @PersistenceUnit(unitName = "default")
    private EntityManagerFactory factory;

    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public void close(@Disposes EntityManager manager) {
        manager.close();
    }
}
