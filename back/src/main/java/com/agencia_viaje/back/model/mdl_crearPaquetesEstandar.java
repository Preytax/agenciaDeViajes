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
@Table (name = "agv_paquetes")
public class mdl_crearPaquetesEstandar{
    
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    @Column(name ="id_modo")
    private int idModo;
    @Column(name ="id_destino")
    private int idDestino;
    @Column(name ="id_cronograma")
    private int idCronograma;
    @Column(name ="id_hotel")
    private int idHotel;
    @Column(name ="id_transporte")
    private int idTransporte;
    @Column(name ="id_usuario")
    private int idUsaurio;
    @Column(name ="estado")
    private int estado;
    @Column(name ="usuario_registra")
    private int usuarioRegistra;
    @Column(name ="usuario_modifica")
    private int usuarioModifica;
    @Column(name ="usuario_elimina")
    private int usuarioElimina;
    @Column(name ="fecha_registra")
    private Date fechaRegistra;
    @Column(name ="fecha_modifica")
    private Date fechaModifica;
    @Column(name ="fecha_elimina")
    private Date fechaElimina;
    @Column(name ="ip_registra")
    private String ipRegistra;
    @Column(name ="ip_modifica")
    private String ipModifica;
    @Column(name ="ip_elimina")
    private String ipElimina; 
    
    public mdl_crearPaquetesEstandar() {
    }

    public mdl_crearPaquetesEstandar(int id, int idModo, int idDestino, int idCronograma, int idHotel, int idTransporte, int idUsaurio, int estado, 
    int usuarioRegistra, int usuarioModifica, int usuarioElimina,Date fechaRegistra, Date fechaModifica, Date fechaElimina, String ipRegistra, String ipModifica, String ipElimina) {
        this.id= id;
        this.idModo= idModo;
        this.idDestino= idDestino;
        this.idCronograma= idCronograma;
        this.idHotel= idHotel;
        this.idTransporte= idTransporte;
        this.idUsaurio= idUsaurio;
        this.estado= estado;
        this.usuarioRegistra= usuarioRegistra;
        this.usuarioModifica= usuarioModifica;
        this.usuarioElimina= usuarioElimina;
        this.fechaRegistra= fechaRegistra;
        this.fechaModifica= fechaModifica;
        this.fechaElimina= fechaElimina;
        this.ipRegistra= ipRegistra;
        this.ipModifica= ipModifica;
        this.ipElimina= ipElimina;   
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
    public int getIdModo() {
        return idModo;
    }
    public void setIdModo(int idModo) {
        this.idModo = idModo;
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
    public int getIdHotel() {
        return idHotel;
    }
    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
    public int getIdTransporte() {
        return idTransporte;
    }
    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }
    public int getIdUsaurio() {
        return idUsaurio;
    }
    public void setIdUsaurio(int idUsaurio) {
        this.idUsaurio = idUsaurio;
    }
    public int getUsuarioRegistra() {
        return usuarioRegistra;
    }
    public void setUsuarioRegistra(int usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
    }
    public int getUsuarioModifica() {
        return usuarioModifica;
    }
    public void setUsuarioModifica(int usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }
    public int getUsuarioElimina() {
        return usuarioElimina;
    }
    public void setUsuarioElimina(int usuarioElimina) {
        this.usuarioElimina = usuarioElimina;
    }
    public Date getFechaRegistra() {
        return fechaRegistra;
    }
    public void setFechaRegistra(Date fechaRegistra) {
        this.fechaRegistra = fechaRegistra;
    }
    public Date getFechaModifica() {
        return fechaModifica;
    }
    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }
    public Date getFechaElimina() {
        return fechaElimina;
    }
    public void setFechaElimina(Date fechaElimina) {
        this.fechaElimina = fechaElimina;
    }
    public String getIpRegistra() {
        return capturarIp();
    }
    public void setIpRegistra(String ipRegistra) {
        this.ipRegistra = ipRegistra;
    }
    public String getIpModifica() {
        return ipModifica;
    }
    public void setIpModifica(String ipModifica) {
        this.ipModifica = ipModifica;
    }
    public String getIpElimina() {
        return ipElimina;
    }
    public void setIpElimina(String ipElimina) {
        this.ipElimina = ipElimina;
    }
}
