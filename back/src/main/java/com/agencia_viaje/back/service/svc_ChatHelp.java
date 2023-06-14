package com.agencia_viaje.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.agencia_viaje.back.model.mdl_ChatHelp;
import com.agencia_viaje.back.persistence.itf_pct_chatHelp;

import java.util.List;

@Repository
public class svc_ChatHelp implements itf_chatHelp {
    
   /* QUERY CON JPA */
    @Autowired
    itf_pct_chatHelp persistence;

     @Override
    public Boolean nuevoChat(mdl_ChatHelp chat) {
        try {
            persistence.save(chat);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<mdl_ChatHelp> getChats() {
        return (List<mdl_ChatHelp>) persistence.findAllGroupedByNumero();
    }

    @Override
    public List<mdl_ChatHelp> getMensajes(String numero) {
        return (List<mdl_ChatHelp>) persistence.findAllByNumero(numero);
    }

    @Override
    public List<mdl_ChatHelp> getMensajesByNumero(String numero) {
        return (List<mdl_ChatHelp>) persistence.findGroupedByNumero(numero);
    }

    @Override
    public List<mdl_ChatHelp> getMensajeById(String id) {
        return (List<mdl_ChatHelp>) persistence.findById(id);
    }

}