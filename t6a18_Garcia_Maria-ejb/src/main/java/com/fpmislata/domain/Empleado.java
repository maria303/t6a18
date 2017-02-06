/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Maria
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e ORDER BY e.id")})
@Table(name="empleados")
public class Empleado implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_empleado")
    private int id;
    
    @Column(nullable = false, length=45)
    private String nombre;
    
    @Column(nullable = false, length = 45)
    private String apellidos;
    
    @Column(nullable = false, length = 9)
    private String dni;
    
    @Column(nullable = false, length =9)
    private int telefono;
    
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "direccion")
    private Direccion direccion;

    @OneToMany(mappedBy="empleado", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Zona> zonas;
    
    public Empleado() {
        this.zonas = new HashSet<>();
    }

    public Empleado(String nombre, String apellidos, String dni, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.zonas = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(Set<Zona> zonas) {
        this.zonas = zonas;
    }
}
