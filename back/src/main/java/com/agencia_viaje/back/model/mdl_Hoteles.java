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
@Table(name="agv_hoteles")
public class mdl_Hoteles {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ID_CIUDAD")
    @Getter @Setter
    private int id_ciudad;

    @Column(name="NOMBRE")
    @Getter @Setter
    private String nombre;

    @Column(name="PRECIO_DIA")
    @Getter @Setter
    private double precioDia;
  
}
