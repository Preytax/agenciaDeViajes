package com.agencia_viaje.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_ChatHelp;
import com.agencia_viaje.back.service.itf_chatHelp;

@Controller
@RestController
public class ctl_ChatHelp {
    
    @Autowired
    itf_chatHelp servicio;

    @GetMapping("/getChats")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_ChatHelp> getChats() {
        List<mdl_ChatHelp> listOpe = null;
        listOpe = servicio.getChats();

        return listOpe;
    }

    @GetMapping("/getMensajes/{numero}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_ChatHelp> getMensajes(@PathVariable String numero) {
        List<mdl_ChatHelp> listOpe = null;
        listOpe = servicio.getMensajes(numero);

        return listOpe;
    }
}
