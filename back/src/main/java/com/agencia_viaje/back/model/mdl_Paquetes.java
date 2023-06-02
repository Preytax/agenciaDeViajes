package com.agencia_viaje.back.model;

import java.sql.Date;

import java.net.InetAddress;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agv_paquetes")
public class mdl_Paquetes {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_usuario")
    private int idusuario;
    @Column(name = "id_pais")
    private int idpais;
    @Column(name = "id_departamento")
    private int iddepartamento;
    @Column(name = "id_ciudad")
    private int idciudad;
    @Column(name = "id_actividades")
    private int idactividades;
    @Column(name = "id_hoteles")
    private int idhotel;
    @Column(name = "id_modo_transporte")
    private int idmodotransporte;
    @Column(name = "id_transporte")
    private int idtransporte;
    @Column(name = "fechaInicio")
    private String fechaInicio;
    @Column(name = "fechaFinal")
    private String fechaFinal;
    @Column(name = "usuario_registra")
    private int usuarioRegistra;
    @Column(name = "usuario_modifica")
    private int usuarioModifica;
    @Column(name = "usuario_elimina")
    private int usuarioElimina;
    @Column(name = "fecha_registra")
    private Date fechaRegistra;
    @Column(name = "fecha_modifica")
    private Date fechaModifica;
    @Column(name = "fecha_elimina")
    private Date fechaElimina;
    @Column(name = "ip_registra")
    private String ipRegistra;
    @Column(name = "ip_modifica")
    private String ipModifica;
    @Column(name = "ip_elimina")
    private String ipElimina;

    public mdl_Paquetes() {
    }

    public mdl_Paquetes(int id, int idusuario, int idpais, int iddepartamento, int idciudad, int idactividades,
            int idhotel, int idmodotransporte, int idtransporte, String fechaInicio,
            String fechaFinal) {
        this.id = id;
        this.idusuario = idusuario;
        this.idpais = idpais;
        this.iddepartamento = iddepartamento;
        this.idciudad = idciudad;
        this.idactividades = idactividades;
        this.idhotel = idhotel;
        this.idmodotransporte = idmodotransporte;
        this.idtransporte = idtransporte;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        // this.usuarioRegistra= usuarioRegistra;
        // this.usuarioModifica= usuarioModifica;
        // this.usuarioElimina= usuarioElimina;
        // this.fechaRegistra= fechaRegistra;
        // this.fechaModifica= fechaModifica;
        // this.fechaElimina= fechaElimina;
        // this.ipRegistra= ipRegistra;
        // this.ipModifica= ipModifica;
        // this.ipElimina= ipElimina;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public int getIdactividades() {
        return idactividades;
    }

    public void setIdactividades(int idactividades) {
        this.idactividades = idactividades;
    }

    public int getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(int idhotel) {
        this.idhotel = idhotel;
    }

    public int getIdmodotransporte() {
        return idmodotransporte;
    }

    public void setIdmodotransporte(int idmodotransporte) {
        this.idmodotransporte = idmodotransporte;
    }

    public int getIdtransporte() {
        return idtransporte;
    }

    public void setIdtransporte(int idtransporte) {
        this.idtransporte = idtransporte;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

}
