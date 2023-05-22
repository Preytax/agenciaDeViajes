package com.agencia_viaje.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_Actividades;
import com.agencia_viaje.back.service.svc_Actividades;

@Controller
@RestController
public class ctl_Actividades {
    @Autowired
    svc_Actividades servicio;

    @GetMapping("/getActividades")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Actividades> getActividades(){
        List<mdl_Actividades> listActividades =null;
        listActividades = servicio.getActividades();

        return listActividades;
    }
}
