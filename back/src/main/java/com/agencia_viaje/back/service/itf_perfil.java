package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_perfil;

@Service
public interface itf_perfil {
    public List<mdl_perfil> getPerfiles();
}
