package com.agencia_viaje.back.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agencia_viaje.back.model.mdl_Ciudades;
import com.agencia_viaje.back.model.mdl_Departamento;
import com.agencia_viaje.back.service.svc_Ciudades;

@Controller
@RestController
public class ctl_Ciudades {
    @Autowired
    svc_Ciudades servicio;

    @PostMapping("/saveCiudad")
    @ResponseStatus(HttpStatus.CREATED)
    String saveOperador(@RequestBody mdl_Ciudades ciudad) {
        String mensaje = "ER|Existe un error interno y no pudo registrarse.";

        if (
            !ciudad.getNombre().equals("") && !ciudad.getNombre().isEmpty() &&
            ciudad.getIdUsuario() != 0 &&
            ciudad.getIdDepartamento() != 0
            ) 
        {
            mensaje = "ER|No se pudo registrar la ciudad.";
            if (servicio.saveCiudad(ciudad)) {
                mensaje = "OK|Se registro la ciudad con exito.";
            }
        }
        return mensaje;
    }

    @GetMapping("/getCiudadesByIdusuario/{idusuario}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Ciudades> getCiudadesByIdusuario(@PathVariable int idusuario){
        List<mdl_Ciudades> listDepartamento = null;
        listDepartamento = servicio.getCiudadesByIdusuario(idusuario);
        return listDepartamento;
    }

    @GetMapping("/getCiudadesByIdUsuarioAndIdDepartamento/{idUsuario}/{idDepartamento}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Ciudades> getCiudadesByIdUsuarioAndIdDepartamento(@PathVariable int idUsuario, @PathVariable int idDepartamento){
        List<mdl_Ciudades> listCiudades =null;
        listCiudades = servicio.getCiudadesByIdUsuarioAndIdDepartamento(idUsuario, idDepartamento);

        return listCiudades;
    }
}