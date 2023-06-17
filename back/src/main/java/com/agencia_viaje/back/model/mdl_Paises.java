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
@Table(name="agv_paises")
@AllArgsConstructor
@NoArgsConstructor
public class mdl_Paises {

    @Id
    @Column(name="id")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="id_usuario")
    @Getter @Setter
    private String idUsuario;
    
    @Column(name="nombre")
    @Getter @Setter
    private String nombre;
}
