package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_tiposDocumentos;
import com.agencia_viaje.back.repocitory.itf_rct_tiposDocumentos;

@Service
public class svc_tiposDocumentos implements itf_tiposDocumentos {
    @Autowired
    itf_rct_tiposDocumentos repocitorio;

    @Override
    public List<mdl_tiposDocumentos> getPerfiles() {
        return repocitorio.getPerfiles();
    }
}
