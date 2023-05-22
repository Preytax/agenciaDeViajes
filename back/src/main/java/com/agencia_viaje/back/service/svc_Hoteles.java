package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Hoteles;
import com.agencia_viaje.back.repocitory.itf_rct_hoteles;

@Service
public class svc_Hoteles implements itf_rct_hoteles {

    @Autowired
    itf_rct_hoteles repositorio;

    @Override
    public List<mdl_Hoteles> getHoteles() {
        return repositorio.getHoteles();
    }

}
