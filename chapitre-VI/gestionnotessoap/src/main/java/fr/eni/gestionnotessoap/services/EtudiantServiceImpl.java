/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gestionnotessoap.services;

import fr.eni.gestionnotessoap.dto.EtudiantRequest;
import fr.eni.gestionnotessoap.dto.EtudiantResponse;
import fr.eni.gestionnotessoap.entities.Etudiants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.springframework.stereotype.Service;


@Service
public class EtudiantServiceImpl implements EtudiantService{

    private EntityManagerFactory entityManagerFactory;
 
    public EtudiantServiceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    
    @Override
    public EtudiantResponse getEtudiantById(EtudiantRequest request) {   
        Long idEtudiant = request.getIdEtudiant();
 
        EntityManager entityManager = entityManagerFactory.createEntityManager();
 
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Etudiants a WHERE a.idEtudiant = :idEtudiant");
        query.setParameter("idEtudiant", idEtudiant);
        Etudiants etudiant = (Etudiants) query.getSingleResult();
        entityManager.getTransaction().commit();
         
        EtudiantResponse response = new EtudiantResponse();   
        response.setEtudiant(etudiant);
        return response;
    }
    
    @Override
    public EtudiantResponse getEtudiants() {  
        EntityManager entityManager = entityManagerFactory.createEntityManager();
 
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Etudiants a");
        List<Etudiants> etudiants = (List<Etudiants>) query.getResultList();
        entityManager.getTransaction().commit();
         
        EtudiantResponse response = new EtudiantResponse();   
        response.setEtudiants(etudiants);
        return response;
    }
}
