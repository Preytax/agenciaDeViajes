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
@Table(name="agv_departamentos")
@AllArgsConstructor
@NoArgsConstructor
public class mdl_Departamento {
    @Id
    @Column(name="ID")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ID_PAIS")
    @Getter @Setter
    private int idPais;
    
    @Column(name = "ID_USUARIO")
    @Getter @Setter
    private int idUsuario;

    @Column(name="NOMBRE")
    @Getter @Setter
    private String nombre;

   
}
