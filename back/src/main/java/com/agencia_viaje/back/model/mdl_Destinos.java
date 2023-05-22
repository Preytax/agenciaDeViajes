package com.agencia_viaje.back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name="agv_destinos")
public class mdl_Destinos {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="id_paises")
    private int id_paises;
    @Column(name="nombre")
    private String nombre;

    public mdl_Destinos() {
    }

    public mdl_Destinos(int id, int id_paises, String nombre) {
        this.id = id;
        this.id_paises = id_paises;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId_paises() {
        return id_paises;
    }
    public void setId_paises(int id_paises) {
        this.id_paises = id_paises;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
