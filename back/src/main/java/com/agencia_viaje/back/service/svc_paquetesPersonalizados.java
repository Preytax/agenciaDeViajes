package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_crearPaquetesPersonalizados;
import com.agencia_viaje.back.repocitory.itf_rct_paquetesPersonalizados;

@Service
public class svc_paquetesPersonalizados implements itf_paquetesPersonalizados {
    @Autowired
    itf_rct_paquetesPersonalizados repocitorio;

    @Override
    public List<mdl_crearPaquetesPersonalizados> getPaquetes() {
        return repocitorio.getPaquetes();
    }

    @Override
    public int savePaquete(mdl_crearPaquetesPersonalizados request) {
        return repocitorio.savePaquete(request);
    }

}
