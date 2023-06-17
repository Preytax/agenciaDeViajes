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
import com.agencia_viaje.back.model.mdl_Paises;
import com.agencia_viaje.back.service.svc_Paises;

@Controller
@RestController
public class ctl_Paises {
    @Autowired
    svc_Paises servicio;

    @GetMapping("/getPaises/{idUsuario}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Paises> getPaises(@PathVariable String idUsuario){
        List<mdl_Paises> listPaises =null;
        listPaises = servicio.getPaises(idUsuario);

        return listPaises;
    }

    @GetMapping("/getPaisesById/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Paises> getPaisesById(@PathVariable int id){
        List<mdl_Paises> listPaises =null;
        listPaises = servicio.getPaisesById(id);

        return listPaises;
    }

    @PostMapping("/savePais")
    @ResponseStatus(HttpStatus.CREATED)
    String saveOperador(@RequestBody mdl_Paises pais) {
        String mensaje = "ER|Existe un error interno y no pudo registrarse.";

        if (
            !pais.getNombre().equals("") && !pais.getNombre().isEmpty() &&
            !pais.getIdUsuario().equals("")
            ) 
        {
            mensaje = "ER|No se pudo registrar al país.";
            if (servicio.savePais(pais)) {
                mensaje = "OK|Se registro el país con exito.";
            }
        }

        return mensaje;
    }
}