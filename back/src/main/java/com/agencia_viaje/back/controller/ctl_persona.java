package com.agencia_viaje.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.agencia_viaje.back.model.mdl_persona;
import com.agencia_viaje.back.service.itf_persona;
import java.util.List;

@Controller
@RestController
public class ctl_persona {

    @Autowired
    itf_persona servicio;

    @GetMapping("/getOperadores")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_persona> getOperadores(){

        List<mdl_persona> listOpe = null;
        listOpe = servicio.getOperadores();
        
        return listOpe;
    }

    @PostMapping("/getOperador")
    @ResponseStatus(HttpStatus.CREATED)
    List<mdl_persona> getOperador(@RequestBody mdl_persona operador){

        List<mdl_persona> listOpe = null;
        //String mensaje = "ER|Existe un error interno y no pudo registrarse.";

        if(operador.getId() != 0)
        {
            listOpe = servicio.getOperador(operador.getId());
            
            /*mensaje = "ER|Este perfil no puede crear operadores";
            mensaje = "OK|Se registro el operador con exito";*/
        }
        return listOpe;
    }

    /* QUERY CON JDBC **SE REMPLAZO POR JPA
    @PostMapping("/saveOperador")
    @ResponseStatus(HttpStatus.CREATED)
    String saveOperador(@RequestBody mdl_persona operador){

        String mensaje = "ER|Existe un error interno y no pudo registrarse.";

        if(
            !operador.getNombres().equals("") && !operador.getNombres().isEmpty() &&
            !operador.getApellidoPaterno().equals("") && !operador.getApellidoPaterno().isEmpty() &&
            !operador.getApellidoMaterno().equals("") && !operador.getApellidoMaterno().isEmpty() &&
            !operador.getTipoDocumento().equals("") && !operador.getTipoDocumento().isEmpty() &&
            !operador.getNroDocumento().equals("") && !operador.getNroDocumento().isEmpty() &&
            !operador.getFechaNacimiento().equals("") && !operador.getFechaNacimiento().isEmpty() &&
            !operador.getIp().equals("") && !operador.getIp().isEmpty()
        )
        {
            mensaje = "ER|No se pudo registrar al operador";
            int registro = servicio.saveOperador(operador);

            if(registro != 0){
                mensaje = "OK|Se registro el operador con exito";
            }
        }
       
        return mensaje;
    }*/


    @PostMapping("/saveOperador")
    @ResponseStatus(HttpStatus.CREATED)
    String saveOperador(@RequestBody mdl_persona operador){
        String mensaje = "ER|Existe un error interno y no pudo registrarse.";

        if(
            !operador.getNombres().equals("") && !operador.getNombres().isEmpty() &&
            !operador.getApellidoPaterno().equals("") && !operador.getApellidoPaterno().isEmpty() &&
            !operador.getApellidoMaterno().equals("") && !operador.getApellidoMaterno().isEmpty() &&
            !operador.getTipoDocumento().equals("") && !operador.getTipoDocumento().isEmpty() &&
            !operador.getNroDocumento().equals("") && !operador.getNroDocumento().isEmpty() &&
            !operador.getFechaNacimiento().equals("") && !operador.getFechaNacimiento().isEmpty() &&
            !operador.getCorreo().equals("") && !operador.getCorreo().isEmpty() &&
            !operador.getPassword().equals("") && !operador.getPassword().isEmpty() &&
            !operador.getIp().equals("") && !operador.getIp().isEmpty()
        )
        {
            mensaje = "ER|No se pudo registrar al operador";

            mdl_persona persona = new mdl_persona();

            persona.setIdPerfil(operador.getIdPerfil());
            persona.setNombres(operador.getNombres());
            persona.setApellidoPaterno(operador.getApellidoPaterno());
            persona.setApellidoMaterno(operador.getApellidoMaterno());
            persona.setTipoDocumento(operador.getTipoDocumento());
            persona.setNroDocumento(operador.getNroDocumento());
            persona.setFechaNacimiento(operador.getFechaNacimiento());
            persona.setCorreo(operador.getCorreo());
            persona.setPassword(operador.getPassword());
            persona.setUsuarioRegistra(operador.getUsuarioRegistra());
            persona.setEstado("1");
            persona.setIp(operador.getIp());
            
            if(servicio.savePersonaJPA(persona)){
                mensaje = "OK|Se registro el operador con exito";
            }
        }
       
        return mensaje;
    }
}
