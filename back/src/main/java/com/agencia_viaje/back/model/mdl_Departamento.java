package com.agencia_viaje.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="agv_departamentos")

public class mdl_Departamento {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_ciudad")
    private int id_ciudad;
    @Column(name="nombre")
    private String nombre;

    public mdl_Departamento(){

    }
    public mdl_Departamento(int id, int id_ciudad, String nombre){
        this.id = id;
        this.id_ciudad=id_ciudad;
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
    public int getId_ciudad() {
        return id_ciudad;
    }
    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
   
}
