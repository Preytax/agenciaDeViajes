package com.agencia_viaje.back.service;

import java.util.List;
import com.agencia_viaje.back.model.mdl_ChatHelp;

public interface itf_chatHelp {
    public Boolean nuevoChat(mdl_ChatHelp chat);
    public List<mdl_ChatHelp> getChats();
    public List<mdl_ChatHelp> getMensajes(String nuemro);
    public List<mdl_ChatHelp> getMensajesByNumero(String nuemro);
    public List<mdl_ChatHelp> getMensajeById(String id);

}
