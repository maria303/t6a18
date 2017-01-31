/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Amarre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maria
 */
@Local
public interface AmarreServiceLocal {

    List listAmarres();

    void addAmarre(Amarre amarre);

    Amarre findAmarreById(Amarre amarre);

    void updateAmarre(Amarre amarre);

    void deleteAmarre(Amarre amarre);
    
}
