/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amavenspringjpa.dao;

import com.mycompany.amavenspringjpa.entities.Trainer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author giorgos
 */
public class TrainerDao {
    public List<Trainer> getTrainers() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_aMavenSpringJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        List<Trainer> list = new ArrayList();
        
        try {
            list = em.createNamedQuery("Trainer.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        
        return list;
    }
    
    
    public Trainer getTrainerById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_aMavenSpringJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Trainer t = null;
        try {
            t = (Trainer)em.createNamedQuery("Trainer.findById")
                .setParameter("id", id)
                .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        
        return t;
    }
    
    public boolean addTrainer(Trainer t) {
        boolean insertOK = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_aMavenSpringJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(t);
            em.getTransaction().commit();
            insertOK = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return insertOK;
    }
    
    public boolean updateTrainer(Trainer t) {
        boolean updateOK = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_aMavenSpringJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try {
            Trainer trainer = em.find(Trainer.class, t.getId());
            em.persist(trainer);
            trainer.setTfname(t.getTfname());
            trainer.setTlname(t.getTlname());
            trainer.setTsubject(t.getTsubject());
            trainer.setTdob(t.getTdob());
            em.getTransaction().commit();
            updateOK = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return updateOK;
    }
    
    public boolean deleteTrainer(Integer id) {
        boolean deleteOK = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_aMavenSpringJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Trainer t = em.find(Trainer.class, id);
        try {
            em.persist(t);
            em.remove(t);
            em.getTransaction().commit();
            deleteOK = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return deleteOK;
    }
    
    
    
    
    
}
