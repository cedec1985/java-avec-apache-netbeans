/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gestionnotesjsf.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author romai
 */
@Stateless
public class ModulesFacade extends AbstractFacade<Modules> {

    @PersistenceContext(unitName = "fr.eni_GestionNotesJsf_war_1.0.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModulesFacade() {
        super(Modules.class);
    }
    
}
