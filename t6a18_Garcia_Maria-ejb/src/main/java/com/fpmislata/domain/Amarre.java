/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Maria
 */
@Entity
@Table(name = "amarres")
@NamedQueries({
    @NamedQuery(name = "Amarre.findAll", query = "SELECT a FROM Amarre a ORDER BY a.id")})
public class Amarre implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_amarre")
    private int id;
    
    @Column(nullable = false)
    private int numero;
    
    @Column(nullable = false, length = 45)
    private String tipo;
    
    @Column(nullable = false, length = 45)
    private String dimensiones;
    
    @ManyToOne
    @JoinColumn(name = "zona")
    private Zona zona;

    public Amarre() {
    }

    public Amarre(int numero, String tipo, String dimensiones) {
        this.numero = numero;
        this.tipo = tipo;
        this.dimensiones = dimensiones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
}
