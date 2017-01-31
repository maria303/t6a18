/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Zona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maria
 */
@Stateless
public class ZonaDAO implements ZonaDAOLocal {

    @PersistenceContext(unitName = "ZonaPU")
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List listZonas() {
        return em.createNamedQuery("Zona.findAll").getResultList();
    }

    @Override
    public void addZona(Zona zona) {
        em.persist(zona);
    }

    @Override
    public Zona findZonaById(Zona zona) {
        return em.find(Zona.class, zona.getId());
    }

    @Override
    public void updateZona(Zona zona) {
        em.merge(zona);
    }

    @Override
    public void deleteZona(Zona zona) {
        zona = findZonaById(zona);
        em.remove(zona);
    }
}
