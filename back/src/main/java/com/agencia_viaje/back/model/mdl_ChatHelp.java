package com.agencia_viaje.back.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "agv_chat_help")
@AllArgsConstructor
@NoArgsConstructor
public class mdl_ChatHelp {
    
    @Id
    @Getter @Setter
    @Column(name="ID")
    private String id;
    
    @Getter @Setter
    @Column(name = "ID_USUARIO")
    private String id_usuario;

    @Getter @Setter
    @Column(name = "TIPO")
    private int tipo;

    @Getter @Setter
    @Column(name = "NOMBRE")
    private String nombre;

    @Getter @Setter
    @Column(name = "NUMERO")
    private String numero;

    @Getter @Setter
    @Column(name = "FECHA")
    private String fecha;

    @Getter @Setter
    @Column(name = "MENSAJE")
    private String mensaje;

    
    public mdl_ChatHelp(String id, String numero, String mensaje) {
        this.id = id;
        this.numero = numero;
        this.mensaje = mensaje;
    }

    public String capturaraFecha(){
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate.toString();
    }
}