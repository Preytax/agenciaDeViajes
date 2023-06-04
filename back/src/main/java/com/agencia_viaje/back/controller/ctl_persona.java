package com.agencia_viaje.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    List<mdl_persona> getOperadores() {

        List<mdl_persona> listOpe = null;
        listOpe = servicio.getPersonasJPA();

        return listOpe;
    }

    @GetMapping("/singIn/{correo}/{password}")
    @ResponseStatus(HttpStatus.OK)
    List<mdl_persona>  singIn(@PathVariable String correo, @PathVariable String password) {
        return servicio.singIn(correo, password);
    }

    @GetMapping("/getOperador/{id}")
    @ResponseStatus(HttpStatus.OK)
    mdl_persona getOperador(@PathVariable Long id) {
        return servicio.getPersonaJPA(1);
    }

    @PostMapping("/saveOperador")
    @ResponseStatus(HttpStatus.CREATED)
    String saveOperador(@RequestBody mdl_persona operador) {
        String mensaje = "ER|Existe un error interno y no pudo registrarse.";

        if (!operador.getNombres().equals("") && !operador.getNombres().isEmpty() &&
                !operador.getApellidoPaterno().equals("") && !operador.getApellidoPaterno().isEmpty() &&
                !operador.getApellidoMaterno().equals("") && !operador.getApellidoMaterno().isEmpty() &&
                !operador.getTipoDocumento().equals("") && !operador.getTipoDocumento().isEmpty() &&
                !operador.getNroDocumento().equals("") && !operador.getNroDocumento().isEmpty() &&
                !operador.getFechaNacimiento().equals("") && !operador.getFechaNacimiento().isEmpty() &&
                !operador.getCorreo().equals("") && !operador.getCorreo().isEmpty() &&
                !operador.getPassword().equals("") && !operador.getPassword().isEmpty()) {
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
            persona.setUsuarioRegistra("1");//recibir de sesion
            persona.setEstado("1");
            persona.setIpRegistra(operador.capturarIp());

            if (servicio.savePersonaJPA(persona)) {
                mensaje = "OK|" + ((operador.getIdPerfil() == "2") ? "Se registro el operador con exito"
                        : "Su registro ha sido exitoso");
            }
        }

        return mensaje;
    }

    @PutMapping("/updatePersona")
    @ResponseStatus(HttpStatus.OK)
    String updatePersona(@RequestBody mdl_persona operador) {
        String mensaje = "ER|Existe un error interno y no pudo actualizar.";
        if (!operador.getNombres().equals("") && !operador.getNombres().isEmpty() &&
                !operador.getApellidoPaterno().equals("") && !operador.getApellidoPaterno().isEmpty() &&
                !operador.getApellidoMaterno().equals("") && !operador.getApellidoMaterno().isEmpty() &&
                !operador.getTipoDocumento().equals("") && !operador.getTipoDocumento().isEmpty() &&
                !operador.getNroDocumento().equals("") && !operador.getNroDocumento().isEmpty() &&
                !operador.getFechaNacimiento().equals("") && !operador.getFechaNacimiento().isEmpty() &&
                !operador.getCorreo().equals("") && !operador.getCorreo().isEmpty()) {
            mensaje = "ER|No se pudo actualizar la información";

            mdl_persona persona = new mdl_persona();

            persona.setId(operador.getId());
            persona.setNombres(operador.getNombres());
            persona.setApellidoPaterno(operador.getApellidoPaterno());
            persona.setApellidoMaterno(operador.getApellidoMaterno());
            persona.setTipoDocumento(operador.getTipoDocumento());
            persona.setNroDocumento(operador.getNroDocumento());
            persona.setFechaNacimiento(operador.getFechaNacimiento());
            persona.setCorreo(operador.getCorreo());

            if (operador.getPassword() != null) {
                persona.setPassword(operador.getPassword());
            }

            persona.setUsuarioModifica("1");//recibir de sesion
            persona.setFechaModifica(operador.capturaraFecha());
            persona.setIpModifica(operador.capturarIp());

            if (servicio.updatePersonajdbc(persona) != 0) {
                mensaje = "OK|"
                        + ((operador.getIdPerfil() == "2") ? "Se actualizó; la informción del operador"
                                : "Su informción se ha actualizado");
            }
        }

        return mensaje;
    }
}
