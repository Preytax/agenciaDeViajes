package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Destinos;
import com.agencia_viaje.back.repocitory.itf_rct_destinos;

@Service
public class svc_Destinos implements itf_rct_destinos {

    @Autowired
    itf_rct_destinos repositorio;

    @Override
    public List<mdl_Destinos> getDestinos() {
        return repositorio.getDestinos();
    }

}
