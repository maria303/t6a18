/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Zona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maria
 */
@Local
public interface ZonaDAOLocal {
    
    List listZonas();

    void addZona(Zona zona);

    Zona findZonaById(Zona zona);

    void updateZona(Zona zona);

    void deleteZona(Zona zona);
    
}
