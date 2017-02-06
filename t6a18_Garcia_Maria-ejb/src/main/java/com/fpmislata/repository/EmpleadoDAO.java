/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maria
 */
@Stateless
public class EmpleadoDAO implements EmpleadoDAOLocal {
    
    @PersistenceContext(unitName = "EmpleadoPU")
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List listEmpleados() {
        return em.createNamedQuery("Empleado.findAll").getResultList();
    }

    @Override
    public void addEmpleado(Empleado empleado) {
        em.persist(empleado);
    }

    @Override
    public Empleado findEmpleadoById(Empleado empleado) {
        return em.find(Empleado.class, empleado.getId());
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        em.merge(empleado);
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        empleado = findEmpleadoById(empleado);
        em.remove(empleado);
    }
}
