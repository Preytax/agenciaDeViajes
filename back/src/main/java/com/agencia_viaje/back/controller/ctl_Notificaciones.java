package com.agencia_viaje.back.controller;

import com.agencia_viaje.back.model.mdl_ChatHelp;
import com.agencia_viaje.back.service.itf_chatHelp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
//import com.twilio.rest.api.v2010.account.IncomingPhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ctl_Notificaciones {

    @Autowired
    itf_chatHelp servicio;

    public static final String ACCOUNT_SID  = "AC6caf804c4bd3a5966e89a2375ac20fac";
    public static final String AUTH_TOKEN   = "a3d272423d08d8ec33a8afda6408e810";
    public static final String TO_FOPHE     = "whatsapp:+51942263335";
    public static final String FROM_FOPHE   = "whatsapp:+14155238886 ";

    static {
      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @PostMapping("/receiveWhatsAppMessage")
    @ResponseStatus(HttpStatus.OK)
    @Scheduled(fixedDelay = 1000)
    public String receiveWhatsAppMessage() throws JsonProcessingException {
        // Obtén los mensajes de WhatsApp entrantes
        ResourceSet<Message> messages = Message.reader()
                .setTo(new PhoneNumber(TO_FOPHE))
                .setFrom(new PhoneNumber(FROM_FOPHE))
                .read();

                // Verifica si hay al menos un mensaje recibido
        if (!messages.toString().isEmpty()) {
            try {
                Message firstMessage = messages.iterator().next();
                String numero = firstMessage.getFrom().toString().replace("whatsapp:+51", "");
                //List <mdl_ChatHelp> whatsApp = servicio.getMensajeById(firstMessage.getSid());

                if(servicio.getMensajeById(firstMessage.getSid()).isEmpty() && !servicio.getMensajesByNumero(numero).isEmpty()){
                    mdl_ChatHelp whatsAppMessage = new mdl_ChatHelp();

                    whatsAppMessage.setId(firstMessage.getSid());
                    whatsAppMessage.setTipo(2);
                    whatsAppMessage.setNombre("");
                    whatsAppMessage.setNumero(numero);
                    whatsAppMessage.setFecha(whatsAppMessage.capturaraFecha());
                    whatsAppMessage.setMensaje(firstMessage.getBody());

                    servicio.nuevoChat(whatsAppMessage);
                    return "OK|Mensaje guardado";

                }
                else{
                    return "ER|El mensaje ya existe";
                }

            } catch (Exception e) {
                return "ER|Mensaje no guardado";
            }
        }
        return "ER|No se capturo el mensaje";
    }

    @PostMapping("/sendHelpMessage")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendHelpMessage(@RequestBody mdl_ChatHelp chat) {
        String mensajeChat = "*Solicitud de Ayuda* \n\n"+chat.getNombre()+" está solicitando ayuda desde el formulario del login, los datos de contacto son:\n\n*Numero:* "+chat.getNumero()+"\n\n *Comuníquese con el cliente*";
        try {
            Message message = Message.creator(
                new PhoneNumber("whatsapp:+51942263335"),
                new PhoneNumber("whatsapp:+14155238886"),
                mensajeChat)
            .create();

            if(!message.getSid().equals(""))
            {
                chat.setId(message.getSid());
                chat.setTipo(2);
                chat.setFecha(chat.capturaraFecha());
                chat.setMensaje(mensajeChat);
                servicio.nuevoChat(chat);
                return "OK|Mensaje Enviado.";
            }else{
                return "ER|El mensaje no se pudo enviar con exito.";
            }

        } catch (Exception e) {
            System.out.println(e);
            return e+"ER|El mensaje no se pudo enviar.";
        }
    }

    @PostMapping("/sendMessage")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendMessage(@RequestBody mdl_ChatHelp chat) {
        String mensajeChat = chat.getMensaje();
        try {
            Message message = Message.creator(
                new PhoneNumber("whatsapp:+51"+chat.getNumero()),
                new PhoneNumber("whatsapp:+14155238886"),
                mensajeChat)
            .create();

            if(!message.getSid().equals(""))
            {
                chat.setId(message.getSid());
                chat.setTipo(1);
                //chat.setNumero(message.getTo().toString().replace("whatsapp:+51", ""));
                chat.setFecha(chat.capturaraFecha());
                chat.setMensaje(mensajeChat);
                servicio.nuevoChat(chat);
                return "OK|Mensaje Enviado.";
            }else{
                return "ER|El mensaje no se pudo enviar con exito.";
            }

        } catch (Exception e) {
            return "ER|El mensaje no se pudo Enviar.";
        }
    }
}
