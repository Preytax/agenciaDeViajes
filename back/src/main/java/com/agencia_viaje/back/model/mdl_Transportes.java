package com.agencia_viaje.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="agv_transportes")
public class mdl_Transportes {
    @Id
    @Column(name="id")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ID_MODO_TRANSPORTE")
    @Getter @Setter
    private int idModoTransporte;

    @Column(name="NOMBRE")
    @Getter @Setter
    private String nombre;

    @Column(name="PRECIO_KM")
    @Getter @Setter
    private double precioKm;
    
}
