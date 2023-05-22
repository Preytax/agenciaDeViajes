package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Ciudades;
import com.agencia_viaje.back.repocitory.itf_rct_ciudades;

@Service
public class svc_Ciudades implements itf_rct_ciudades {

    @Autowired
    itf_rct_ciudades repocitorio;

    @Override
    public List<mdl_Ciudades> getCiudades() {
        return repocitorio.getCiudades();
    }

}
