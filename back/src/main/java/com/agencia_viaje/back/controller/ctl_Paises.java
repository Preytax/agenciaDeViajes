package com.agencia_viaje.back.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_Paises;
import com.agencia_viaje.back.service.svc_Paises;

@Controller
@RestController
public class ctl_Paises {
    @Autowired
    svc_Paises servicio;

    @GetMapping("/getPaises")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Paises> getActividades(){
        List<mdl_Paises> listPaises =null;
        listPaises = servicio.getPaises();

        return listPaises;
    }
}