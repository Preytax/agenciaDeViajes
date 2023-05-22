package com.agencia_viaje.back.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_Destinos;
import com.agencia_viaje.back.service.svc_Destinos;

@Controller
@RestController
public class ctl_Destinos {
    @Autowired
    svc_Destinos servicio;

    @GetMapping("/getDestinos")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Destinos> getActividades(){
        List<mdl_Destinos> listDestinos =null;
        listDestinos = servicio.getDestinos();

        return listDestinos;
    }
}