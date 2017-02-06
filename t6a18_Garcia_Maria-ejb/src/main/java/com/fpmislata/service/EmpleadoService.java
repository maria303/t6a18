/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Empleado;
import com.fpmislata.repository.EmpleadoDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Maria
 */
@Stateless
public class EmpleadoService implements EmpleadoServiceLocal {

    @EJB
    private EmpleadoDAOLocal empleadoDAO;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List listEmpleados() {
        return empleadoDAO.listEmpleados();
    }

    @Override
    public void addEmpleado(Empleado empleado) {
        empleadoDAO.addEmpleado(empleado);
    }

    @Override
    public Empleado findEmpleadoById(Empleado empleado) {
        return empleadoDAO.findEmpleadoById(empleado);
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        empleadoDAO.updateEmpleado(empleado);
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        empleadoDAO.deleteEmpleado(empleado);
    }
}
