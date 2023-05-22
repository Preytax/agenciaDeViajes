package com.agencia_viaje.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_crearPaquetesEstandar;
import com.agencia_viaje.back.service.itf_paquetesEstandar;

@Controller
@RestController
public class ctl_crearPaquetesEstandar {
    @Autowired
    itf_paquetesEstandar servicio;

    @GetMapping("/getPaquetesEstandar")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_crearPaquetesEstandar> getDestino(){
        List<mdl_crearPaquetesEstandar> listPaqPers =null;
        listPaqPers = servicio.getPaquetes();

        return listPaqPers;
    }
    
    /**
     * @param paquetes
     * @return
     */
    @PostMapping("/savePaqueteEstandar")
    @ResponseStatus(HttpStatus.CREATED)
    String savePaquete(@RequestBody mdl_crearPaquetesEstandar paquetes){
        String mensaje = "ER|Existe un error y no se puede guardar el paquete.";

        {
            mensaje = "ER|No se pudo guardar el paqueter";
            int registro = servicio.savePaquete(paquetes);

            if(registro != 0){
                mensaje = "OK|Se guardo el paquete con exito";
            }
        }
        return mensaje;
    }  
}
