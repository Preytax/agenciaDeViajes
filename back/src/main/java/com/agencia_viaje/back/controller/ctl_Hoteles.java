package com.agencia_viaje.back.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_Hoteles;
import com.agencia_viaje.back.service.svc_Hoteles;

@Controller
@RestController
public class ctl_Hoteles {
    @Autowired
    svc_Hoteles servicio;

    @GetMapping("/getHoteles")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Hoteles> getHoteles(){
        List<mdl_Hoteles> listHoteles =null;
        listHoteles = servicio.getHoteles();

        return listHoteles;
    }
}