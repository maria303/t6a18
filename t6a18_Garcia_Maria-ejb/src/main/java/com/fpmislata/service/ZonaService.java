/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Zona;
import com.fpmislata.repository.ZonaDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Maria
 */
@Stateless
public class ZonaService implements ZonaServiceLocal {

    @EJB
    private ZonaDAOLocal zonaDAO;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List listZonas() {
        return zonaDAO.listZonas();
    }

    @Override
    public void addZona(Zona zona) {
        zonaDAO.addZona(zona);
    }

    @Override
    public Zona findZonaById(Zona zona) {        
        return zonaDAO.findZonaById(zona);
    }

    @Override
    public void updateZona(Zona zona) {
        zonaDAO.updateZona(zona);
    }

    @Override
    public void deleteZona(Zona zona) {
        zonaDAO.deleteZona(zona);
    }
}
