package com.agencia_viaje.back.model;

import java.net.InetAddress;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agv_ventas")

public class mdl_registroVenta {
    @Id
    @Column(name ="ID")
    private int id;
    @Column(name = "ID_USUAROIO")
    private int idUsuario;
    @Column(name = "ID_DESTINO")
    private int idDestino;
    @Column(name = "ID_CRONOGRAMA")
    private int idCronograma;
    @Column(name = "ID_HOTEL")
    private int idHotel;
    @Column(name = "ID_TRANSPORTE")
    private int idTransporte ;
    @Column(name = "ESTADO")
    private int estado;
    @Column(name = "USUARIO_REGISTRADO")
    private String usuarioRegistrado;
    @Column(name = "FECHA_REGISTRA")
    private String fechaRegistro;
    @Column(name = "IP_REGISTRA")
    private String ip;

    public mdl_registroVenta(){
    }

    public mdl_registroVenta(int id,
    int idUsuario,int idDestino,int idCronograma, int idHotel,int idTransporte , int estado,String usuarioRegistrado,String fechaRegistro,String ip){
        this.id=id;
        this.idUsuario=idUsuario;
        this.idDestino=idDestino;
        this.idCronograma=idCronograma;
        this.idHotel=idHotel;
        this.idTransporte=idTransporte ;
        this.estado=estado;
        this.usuarioRegistrado=usuarioRegistrado;
        this.fechaRegistro=fechaRegistro;
        this.ip=ip;
    }
    public String capturarIp(){
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public int getIdCronograma() {
        return idCronograma;
    }

    public void setIdCronograma(int idCronograma) {
        this.idCronograma = idCronograma;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    public void setUsuarioRegistrado(String usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
    
}