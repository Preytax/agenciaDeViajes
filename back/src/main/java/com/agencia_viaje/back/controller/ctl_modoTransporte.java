package com.agencia_viaje.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_ModoTransporte;
import com.agencia_viaje.back.service.svc_modoTransporte;;

@Controller
@RestController
public class ctl_modoTransporte {
    @Autowired
    svc_modoTransporte servicio;

    @GetMapping("/getTipoTransporte")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_ModoTransporte> getTipoTransporte(){
        List<mdl_ModoTransporte> listModoTransportes=null;
        listModoTransportes = servicio.getTipoTransporte();
        return listModoTransportes;
    }
}
