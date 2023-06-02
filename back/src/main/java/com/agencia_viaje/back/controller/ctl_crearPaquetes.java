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

import com.agencia_viaje.back.model.mdl_Paquetes;
import com.agencia_viaje.back.service.itf_paquetes;

@Controller
@RestController
public class ctl_crearPaquetes {
    @Autowired
    itf_paquetes servicio;

    @GetMapping("/getPaquetes")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Paquetes> getDestino(){
        List<mdl_Paquetes> listPaqPers =null;
        listPaqPers = servicio.getPaquetes();

        return listPaqPers;
    }
    
    @PostMapping("/savePaquete")
    @ResponseStatus(HttpStatus.CREATED)
    String savePaquete(@RequestBody mdl_Paquetes paquetes){
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
