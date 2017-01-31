/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maria
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z ORDER BY z.id")})
@Table(name = "zonas")
public class Zona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private int id;
    
    @Column(nullable = false, length = 1)
    private String letra;
    
    @Column(nullable = false, length = 3)
    private int profundidad;
    
    @Column(nullable = false, length = 45)
    private String dimensiones;
    
    @OneToMany(mappedBy = "zona", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Amarre> amarres;

    public Zona() {
    }

    public Zona(String letra, int profundidad, String dimensiones) {
        this.letra = letra;
        this.profundidad = profundidad;
        this.dimensiones = dimensiones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Set<Amarre> getAmarres() {
        return amarres;
    }

    public void setAmarres(Set<Amarre> amarres) {
        this.amarres = amarres;
    }
}
