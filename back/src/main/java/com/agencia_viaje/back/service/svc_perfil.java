package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_perfil;
import com.agencia_viaje.back.repocitory.itf_rct_perfil;

@Service
public class svc_perfil implements itf_perfil {
    @Autowired
    itf_rct_perfil repocitorio;

    @Override
    public List<mdl_perfil> getPerfiles() {
        return repocitorio.getPerfiles();
    }
}
