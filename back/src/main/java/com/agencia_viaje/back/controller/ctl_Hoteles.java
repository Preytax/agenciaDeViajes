package com.agencia_viaje.back.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_Hoteles;
import com.agencia_viaje.back.service.svc_Hoteles;

@Controller
@RestController
public class ctl_Hoteles {
    @Autowired
    svc_Hoteles servicio;

    @GetMapping("/getHoteles/{id_modo_ciudad1}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Hoteles> getHoteles(@PathVariable int id_modo_ciudad1){
        List<mdl_Hoteles> listHoteles =null;
        listHoteles = servicio.getHoteles(id_modo_ciudad1);

        return listHoteles;
    }

    @GetMapping("/getHotelById/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    mdl_Hoteles getHotelById(@PathVariable int id){
        mdl_Hoteles listHoteles =null;
        listHoteles = servicio.getHotelById(id);

        return listHoteles;
    }
}