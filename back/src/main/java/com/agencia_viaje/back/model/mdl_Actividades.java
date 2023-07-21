package com.agencia_viaje.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "agv_actividades")
@AllArgsConstructor
@NoArgsConstructor
public class mdl_Actividades {

    @Id
    @Column(name="ID")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USUARIO_REGISTRA")
    @Getter @Setter
    private int usuarioRegistra;
    
    @Column(name = "ID_MULTIUSER")
    @Getter @Setter
    private int idMultiuser;

    @Column(name = "ID_CIUDAD")
    @Getter @Setter
    private int idCiudad;

    @Column(name="NOMBRE")
    @Getter @Setter
    private String nombre;
    
    @Column(name="PRECIO")
    @Getter @Setter
    private double precio;
}