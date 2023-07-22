package com.agencia_viaje.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_Paquetes;
import com.agencia_viaje.back.service.itf_paquetes;

@Controller
@RestController
public class ctl_Paquetes {
    @Autowired
    itf_paquetes servicio;

    @GetMapping("/getPaquetes")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Paquetes> getDestino(){
        List<mdl_Paquetes> listPaqPers =null;
        listPaqPers = servicio.getPaquetes();

        return listPaqPers;
    }

    @GetMapping("/getPaquetesByFiltros/{idCiudadPartida}/{idCiudadDestino}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Paquetes> getPaquetesByFiltros(@PathVariable String idCiudadPartida, @PathVariable String idCiudadDestino){
        List<mdl_Paquetes> listPaqPers =null;

        listPaqPers = servicio.getPaquetesByFiltros(idCiudadPartida, idCiudadDestino);
        return listPaqPers;
    }
    
    @PostMapping("/savePaquete")
    @ResponseStatus(HttpStatus.CREATED)
    String savePaquete(@RequestBody mdl_Paquetes paquetes){
        String mensaje = "ER|Existe un error interno y no pudo registrarse.";
        {
            mensaje = "ER|No se pudo registrar al operador";

            mdl_Paquetes paquete = new mdl_Paquetes();
            paquete.setIdmodo(paquetes.getIdmodo());
            paquete.setIdusuario(paquetes.getIdusuario());
            /* paquete.setIdpais(paquetes.getIdpais()); */
            paquete.setIddepartamento(paquetes.getIddepartamento());
            /* paquete.setIdciudad(paquetes.getIdciudad()); */
            paquete.setIdhotel(paquetes.getIdhotel());
            paquete.setIdmodotransporte(paquetes.getIdmodotransporte());
            paquete.setIdtransporte(paquetes.getIdtransporte());
            paquete.setFechaInicio(paquetes.getFechaInicio());
            paquete.setFechaFinal(paquetes.getFechaFinal());
            paquete.setMonto(paquetes.getMonto());
            paquete.setIpRegistra(paquetes.capturarIp());
            paquete.setUsuarioRegistra(paquetes.getUsuarioRegistra());
            paquete.setActividades(paquetes.getActividades());

            if(servicio.savePaqueteJPA(paquete)){
                mensaje = "OK|Se registro el operador con exito";
            }
        }
        return mensaje;
    }    
}
