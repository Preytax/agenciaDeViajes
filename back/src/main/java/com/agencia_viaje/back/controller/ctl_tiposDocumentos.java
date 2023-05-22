package com.agencia_viaje.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.agencia_viaje.back.service.itf_tiposDocumentos;

import com.agencia_viaje.back.model.mdl_tiposDocumentos;
import java.util.List;

@Controller
@RestController
public class ctl_tiposDocumentos {
    @Autowired
    itf_tiposDocumentos servicio;

    @GetMapping("/getTiposDocumentos")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_tiposDocumentos> getPerfiles() {

        List<mdl_tiposDocumentos> listPerfiles = null;
        listPerfiles = servicio.getPerfiles();

        return listPerfiles;
    }
}
