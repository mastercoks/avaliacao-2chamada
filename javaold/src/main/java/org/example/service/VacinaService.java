package com.example.demo.service;

import com.example.demo.entity.Vacina;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.io.Serializable;

@Stateless
public class VacinaService implements Serializable {

    public void criar(Vacina vacina) {
        System.out.println("VacinaService: " + vacina);
//        System.out.println("VacinaService: " + vacinaRepository);
//        this.vacinaRepository.criar(vacina);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            System.err.println("Erro VacinaService: " + vacina);

            entityManager.persist(vacina);

            transaction.commit();
        } finally {
            System.err.println("Erro VacinaService: " + vacina);
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
