package com.agencia_viaje.back.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.agencia_viaje.back.model.mdl_Departamento;
import com.agencia_viaje.back.service.svc_Departamentos;

@Controller
@RestController

public class ctl_Departamento {
    @Autowired
    svc_Departamentos servicio;

    @GetMapping("/getDepartamento/{id_modo_pais}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Departamento> getDepartamento(@PathVariable int id_modo_pais){
        List<mdl_Departamento> listDepartamento = null;
        listDepartamento = servicio.getDepartamento(id_modo_pais);
        return listDepartamento;
    }
}
