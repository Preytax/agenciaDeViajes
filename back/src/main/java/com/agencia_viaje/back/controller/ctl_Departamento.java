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
import com.agencia_viaje.back.model.mdl_Departamento;
import com.agencia_viaje.back.service.svc_Departamentos;

@Controller
@RestController

public class ctl_Departamento {
    @Autowired
    svc_Departamentos servicio;

    @PostMapping("/saveDepartamento")
    @ResponseStatus(HttpStatus.CREATED)
    String saveOperador(@RequestBody mdl_Departamento departamento) {
        String mensaje = "ER|Existe un error interno y no pudo registrarse.";

        if (
            !departamento.getNombre().equals("") && !departamento.getNombre().isEmpty() &&
            departamento.getIdUsuario() != 0 &&
            departamento.getIdPais() != 0
            ) 
        {
            mensaje = "ER|No se pudo registrar el departamento.";
            if (servicio.saveDepartamento(departamento)) {
                mensaje = "OK|Se registro el departamento con exito.";
            }
        }
        return mensaje;
    }

    @GetMapping("/getDepartamentosbyidusuario/{idusuario}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Departamento> getDepartamento(@PathVariable int idusuario){
        List<mdl_Departamento> listDepartamento = null;
        listDepartamento = servicio.getDepartamentosbyidusuario(idusuario);
        return listDepartamento;
    }

    @GetMapping("/getDepartamentosbyidusuariobyidpais/{idusuario}/{id_pais}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Departamento> getDepartamentosbyidusuariobyidpais(@PathVariable int idusuario, @PathVariable int id_pais){
        List<mdl_Departamento> listDepartamento = null;
        listDepartamento = servicio.getDepartamentosbyidusuariobyidpais(idusuario, id_pais);
        return listDepartamento;
    }
}
