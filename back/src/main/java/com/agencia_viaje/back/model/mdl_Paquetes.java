package com.agencia_viaje.back.model;

import java.sql.Date;

import java.net.InetAddress;
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
@Table(name = "agv_paquetes")
@AllArgsConstructor
@NoArgsConstructor
public class mdl_Paquetes {

    @Id
    @Column(name = "id")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_modo")
    @Getter @Setter
    private int idmodo;

    @Column(name = "id_usuario")
    @Getter @Setter
    private int idusuario;

    @Column(name = "id_pais")
    @Getter @Setter
    private int idpais;

    @Column(name = "id_departamento")
    @Getter @Setter
    private int iddepartamento;

    @Column(name = "id_ciudad")
    @Getter @Setter
    private int idciudad;

    @Column(name = "id_actividades")
    @Getter @Setter
    private int idactividades;

    @Column(name = "id_hoteles")
    @Getter @Setter
    private int idhotel;

    @Column(name = "id_modo_transporte")
    @Getter @Setter
    private int idmodotransporte;

    @Column(name = "id_transporte")
    @Getter @Setter
    private int idtransporte;

    @Column(name = "fecha_Inicio")
    @Getter @Setter
    private String fechaInicio;

    @Column(name = "fecha_final")
    @Getter @Setter
    private String fechaFinal;

    @Column(name = "usuario_registra")
    @Getter @Setter
    private int usuarioRegistra;

    @Column(name = "monto")
    @Getter @Setter
    private int monto;

    @Column(name = "usuario_modifica")
    @Getter @Setter
    private int usuarioModifica;

    @Column(name = "usuario_elimina")
    @Getter @Setter
    private int usuarioElimina;

    @Column(name = "fecha_registra")
    @Getter @Setter
    private String fechaRegistra;

    @Column(name = "fecha_modifica")
    @Getter @Setter
    private String fechaModifica;

    @Column(name = "fecha_elimina")
    @Getter @Setter
    private String fechaElimina;

    @Column(name = "ip_registra")
    @Getter @Setter
    private String ipRegistra;

    @Column(name = "ip_modifica")
    @Getter @Setter
    private String ipModifica;

    @Column(name = "ip_elimina")
    @Getter @Setter
    private String ipElimina;


    public String capturarIp() {
        String miVariable = "";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            miVariable = ip.getHostAddress();
        } catch (Exception e) {
            miVariable = "null";
        }
        return miVariable;
    }   

}
