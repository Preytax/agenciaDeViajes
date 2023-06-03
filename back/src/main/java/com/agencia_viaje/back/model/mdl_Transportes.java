package com.agencia_viaje.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="agv_transportes")
public class mdl_Transportes {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="id_modo_transporte")
    private int id_modo_transporte;
    @Column(name="nombre")
    private String nombre;

    public mdl_Transportes() {
    }

    public mdl_Transportes(int id, int id_modo_transporte, String nombre) {
        this.id = id;
        this.id_modo_transporte = id_modo_transporte;
        this.nombre = nombre;
    }

    public int getId_modo_transporte() {
        return id_modo_transporte;
    }

    public void setId_modo_transporte(int id_modo_transporte) {
        this.id_modo_transporte = id_modo_transporte;
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
    
}
