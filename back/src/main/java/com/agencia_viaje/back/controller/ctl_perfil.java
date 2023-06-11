package com.agencia_viaje.back.controller;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_perfil;
import com.agencia_viaje.back.service.itf_perfil;

import java.util.List;

@Controller
@RestController
public class ctl_perfil {
    @Autowired
    itf_perfil servicio;

    @GetMapping("/getPerfiles")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_perfil> getPerfiles(){

        List<mdl_perfil> listPerfiles = null;
        listPerfiles = servicio.getPerfiles();
        
        return listPerfiles;
    }

    @GetMapping("/getPerfil/{id}")
    @ResponseStatus(HttpStatus.OK)
    mdl_perfil getOperador(@PathVariable Long id) {
        return servicio.getPerfilJPA(id);
    }
}
