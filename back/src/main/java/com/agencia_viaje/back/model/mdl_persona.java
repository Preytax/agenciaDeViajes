package com.agencia_viaje.back.model;

import java.net.InetAddress;
import java.time.LocalDateTime;
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
@Table(name = "agv_personas")
@AllArgsConstructor
@NoArgsConstructor
public class mdl_persona {

    @Id
    @Column(name = "ID")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter
    @Column(name = "ID_PERFIL")
    private String idPerfil;

    @Getter @Setter
    @Column(name = "NOMBRES")
    private String nombres;

    @Getter @Setter
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Getter @Setter
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Getter @Setter
    @Column(name = "ID_DOCUMENTO")
    private String tipoDocumento;

    @Getter @Setter
    @Column(name = "NRO_DOCUMENTO")
    private String nroDocumento;

    @Getter @Setter
    @Column(name = "CORREO")
    private String correo;

    @Getter @Setter
    @Column(name = "PASSWORD")
    private String password;

    @Getter @Setter
    @Column(name = "ESTADO")
    private String estado;

    @Getter @Setter
    @Column(name = "FECHA_NACIMIENTO")
    private String fechaNacimiento;

    @Getter @Setter
    @Column(name = "USUARIO_REGISTRA")
    private String usuarioRegistra;

    @Getter @Setter
    @Column(name = "USUARIO_MODIFICA")
    private String usuarioModifica;

    @Getter @Setter
    @Column(name = "USUARIO_ELIMINA")
    private String usuarioElimina;

    @Getter @Setter
    @Column(name = "FECHA_REGISTRA")
    private String fechaRegistro;

    @Getter @Setter
    @Column(name = "FECHA_MODIFICA")
    private String fechaModifica;

    @Getter @Setter
    @Column(name = "FECHA_ELIMINA")
    private String fechaElimina;
    
    @Getter @Setter
    @Column(name = "IP_REGISTRA")
    private String ipRegistra;

    @Getter @Setter
    @Column(name = "IP_MODIFICA")
    private String ipModifica;

    @Getter @Setter
    @Column(name = "IP_ELIMINA")
    private String ipElimina;

    public mdl_persona(int id, String idPerfil, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.id = id;
        this.idPerfil = idPerfil;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public mdl_persona(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public String capturarIp() {
        String miVariable = "";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            miVariable = ip.getHostAddress();
        } catch (Exception e) {
            miVariable = "0000000000";
        }
        return miVariable;
    }    

    public String capturaraFecha(){
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate.toString();
    }
}