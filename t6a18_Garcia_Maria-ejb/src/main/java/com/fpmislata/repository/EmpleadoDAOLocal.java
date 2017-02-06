/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Empleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maria
 */
@Local
public interface EmpleadoDAOLocal {
    
    List listEmpleados();

    void addEmpleado(Empleado empleado);

    Empleado findEmpleadoById(Empleado empleado);

    void updateEmpleado(Empleado empleado);

    void deleteEmpleado(Empleado empleado);
    
}
