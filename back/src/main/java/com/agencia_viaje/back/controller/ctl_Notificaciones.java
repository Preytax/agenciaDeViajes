package com.agencia_viaje.back.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ctl_Notificaciones {

    public static final String ACCOUNT_SID = "AC6caf804c4bd3a5966e89a2375ac20fac";
    public static final String AUTH_TOKEN = "09a5edb195d7032578617cc7a9f28f3f";

    static {
      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @GetMapping("/sendMessage/{cabecera}/{correo}/{numero}")
    public String sendMessage(@PathVariable String cabecera, @PathVariable String correo, @PathVariable String numero) {

        try {
            Message message = Message.creator(
            new PhoneNumber("whatsapp:+51942263335"),
            new PhoneNumber("whatsapp:+14155238886"),
            "*"+cabecera+"* \n\nUn cliente esta solicitando ayuda desde el formulario del login, los datos de contacto son:\n\n*Numero:* "+numero+"\n*Correo:* "+correo+"\n\n *Comuníquese con el cliente*")
            .create();

            if(!message.getSid().equals(""))
            {
                return "OK|Mensaje Enviado.";
            }else{
                return "ER|El mensaje no se pudo enviar.";
            }

        } catch (Exception e) {
            return "ER|El mensaje no se pudo Enviar.";
        }
    }
}
