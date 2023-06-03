package com.agencia_viaje.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="agv_ciudades")
public class mdl_Ciudades {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="ID_DEPARTAMENTO")
    private int id_departamento;
    @Column(name="NOMBRE")
    private String nombre;
    
    public mdl_Ciudades() {
    }

    public mdl_Ciudades(int id,int id_departamento,  String nombre) {
        this.id = id;
        this.id_departamento=id_departamento;
        this.nombre = nombre;
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

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }
    
}
