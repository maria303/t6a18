/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Amarre;
import com.fpmislata.repository.AmarreDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Maria
 */
@Stateless
public class AmarreService implements AmarreServiceLocal {

    @EJB
    private AmarreDAOLocal amarreDAO;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listAmarres() {
        return amarreDAO.listAmarres();
    }

    @Override
    public void addAmarre(Amarre amarre) {
        amarreDAO.addAmarre(amarre);
    }

    @Override
    public Amarre findAmarreById(Amarre amarre) {
        return amarreDAO.findAmarreById(amarre);
    }

    @Override
    public void updateAmarre(Amarre amarre) {
        amarreDAO.updateAmarre(amarre);
    }

    @Override
    public void deleteAmarre(Amarre amarre) {
        amarreDAO.deleteAmarre(amarre);
    }
}
