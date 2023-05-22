package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Paises;
import com.agencia_viaje.back.repocitory.itf_rct_paises;

@Service
public class svc_Paises implements itf_rct_paises {

    @Autowired
    itf_rct_paises repositorio;

    @Override
    public List<mdl_Paises> getPaises() {
        return repositorio.getPaises();
    }

}
