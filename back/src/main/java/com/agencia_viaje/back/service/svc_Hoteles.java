package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Hoteles;
import com.agencia_viaje.back.persistence.itf_pct_hotel;
import com.agencia_viaje.back.repocitory.itf_rct_hoteles;

@Service
public class svc_Hoteles implements itf_rct_hoteles {

    @Autowired
    itf_pct_hotel repositorio;

    @Override
    public List<mdl_Hoteles> getHoteles(int id_modo_ciudad1) {
        return repositorio.findByIdCiudad(id_modo_ciudad1);
    }

}
