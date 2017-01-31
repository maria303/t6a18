/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Amarre;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maria
 */
@Stateless
public class AmarreDAO implements AmarreDAOLocal {

    @PersistenceContext(unitName = "AmarrePU")
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List listAmarres() {
        return em.createNamedQuery("Amarre.findAll").getResultList();
    }

    @Override
    public void addAmarre(Amarre amarre) {
        em.persist(amarre);
    }

    @Override
    public Amarre findAmarreById(Amarre amarre) {
        return em.find(Amarre.class, amarre.getId());
    }

    @Override
    public void updateAmarre(Amarre amarre) {
        em.merge(amarre);
    }

    @Override
    public void deleteAmarre(Amarre amarre) {
        amarre = findAmarreById(amarre);
        em.remove(amarre);
    }
}
