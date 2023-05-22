package com.agencia_viaje.back.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_Ciudades;
import com.agencia_viaje.back.service.svc_Ciudades;

@Controller
@RestController
public class ctl_Ciudades {
    @Autowired
    svc_Ciudades servicio;

    @GetMapping("/getCiudades")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Ciudades> getActividades(){
        List<mdl_Ciudades> listCiudades =null;
        listCiudades = servicio.getCiudades();

        return listCiudades;
    }
}