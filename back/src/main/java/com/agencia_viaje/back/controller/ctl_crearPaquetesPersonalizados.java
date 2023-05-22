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

import com.agencia_viaje.back.model.mdl_crearPaquetesPersonalizados;
import com.agencia_viaje.back.service.itf_paquetesPersonalizados;

@Controller
@RestController
public class ctl_crearPaquetesPersonalizados {
    @Autowired
    itf_paquetesPersonalizados servicio;

    @GetMapping("/getPaquetes")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_crearPaquetesPersonalizados> getDestino(){
        List<mdl_crearPaquetesPersonalizados> listPaqPers =null;
        listPaqPers = servicio.getPaquetes();

        return listPaqPers;
    }
    
    /**
     * @param paquetes
     * @return
     */
    @PostMapping("/savePaquete")
    @ResponseStatus(HttpStatus.CREATED)
    String savePaquete(@RequestBody mdl_crearPaquetesPersonalizados paquetes){
        String mensaje = "ER|Existe un error interno y no pudo registrarse.";

        {
            mensaje = "ER|No se pudo registrar al operador";
            int registro = servicio.savePaquete(paquetes);

            if(registro != 0){
                mensaje = "OK|Se registro el operador con exito";
            }
        }
        return mensaje;
    }    
}
