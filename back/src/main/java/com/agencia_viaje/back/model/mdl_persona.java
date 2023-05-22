package com.agencia_viaje.back.model;

import java.net.InetAddress;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agv_personas")
public class mdl_persona {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ID_PERFIL")
    private String idPerfil;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Column(name = "ID_DOCUMENTO")
    private String tipoDocumento;
    @Column(name = "NRO_DOCUMENTO")
    private String nroDocumento;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHA_NACIMIENTO")
    private String fechaNacimiento;
    @Column(name = "USUARIO_REGISTRA")
    private int usuarioRegistra;
    @Column(name = "FECHA_REGISTRA")
    private String fechaRegistro;
    @Column(name = "IP_REGISTRA")
    private String ip;

    public mdl_persona(int id, String idPerfil, String nombres, String apellidoPaterno, String apellidoMaterno,
            String tipoDocumento, String nroDocumento, String correo, String password, String estado,
            int usuarioRegistra, String fechaNacimiento, String fechaRegistro, String ip) {
        this.id = id;
        this.idPerfil = idPerfil;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.usuarioRegistra = usuarioRegistra;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.ip = ip;
    }

    public mdl_persona() {
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

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getUsuarioRegistra() {
        return /*usuarioRegistra*/1;
    }

    public void setUsuarioRegistra(int usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getIp() {
        return capturarIp();
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}