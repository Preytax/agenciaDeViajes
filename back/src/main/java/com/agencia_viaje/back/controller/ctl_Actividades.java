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

import com.agencia_viaje.back.model.mdl_Actividades;
import com.agencia_viaje.back.service.svc_Actividades;

@Controller
@RestController
public class ctl_Actividades {
    @Autowired
    svc_Actividades servicio;

    @PostMapping("/saveActividad")
    @ResponseStatus(HttpStatus.CREATED)
    String saveOperador(@RequestBody mdl_Actividades actividad) {
        String mensaje = "ER|Existe un error interno y no pudo registrarse.";

        if (
            !actividad.getNombre().equals("") && !actividad.getNombre().isEmpty() &&
            actividad.getIdMultiuser() != 0 &&
            actividad.getIdCiudad() != 0
            ) 
        {
            mensaje = "ER|No se pudo registrar la actividad.";
            if (servicio.saveActividad(actividad)) {
                mensaje = "OK|Se registro la ciudad con exito.";
            }
        }
        return mensaje;
    }

    @GetMapping("/getActividadesByIdMultiuser/{idMultiuser}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Actividades> getActividadesByIdMultiuser(@PathVariable int idMultiuser){
        List<mdl_Actividades> listActividades =null;
        listActividades = servicio.getActividadesByIdMultiuser(idMultiuser);
        return listActividades;
    }

    @GetMapping("/getActividades/{idMultiuser}/{idCiudad}")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_Actividades> getActividades(@PathVariable int idMultiuser, @PathVariable int idCiudad){
        List<mdl_Actividades> listActividades =null;
        listActividades = servicio.getActividadesByIdMultiuserAndIdCiudad(idMultiuser, idCiudad);
        return listActividades;
    }

    @GetMapping("/getActividadById/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    mdl_Actividades getActividadById( @PathVariable int id){
        mdl_Actividades listActividades =null;
        listActividades = servicio.getActividadById(id);
        return listActividades;
    }
}
