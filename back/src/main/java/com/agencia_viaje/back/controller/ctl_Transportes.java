package com.agencia_viaje.back.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_Transportes;
import com.agencia_viaje.back.service.svc_Transportes;

@Controller
@RestController
public class ctl_Transportes {
    @Autowired
    svc_Transportes servicio;

    @GetMapping("/getTransportes")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Transportes> getTransportes(){
        List<mdl_Transportes> listTransportes =null;
        listTransportes = servicio.getTransportes();

        return listTransportes;
    }
}