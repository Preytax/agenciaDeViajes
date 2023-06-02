package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_ModoTransporte;
import com.agencia_viaje.back.repocitory.itf_rct_modotransporte;

@Service
public class svc_modoTransporte implements itf_rct_modotransporte{
    @Autowired
    itf_rct_modotransporte repositorio;

    @Override
    public List<mdl_ModoTransporte> getTipoTransporte() {
        return repositorio.getTipoTransporte();
    }
}
