package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_crearPaquetesEstandar;
import com.agencia_viaje.back.repocitory.itf_rct_paquetesEstandar;

@Service
public class svc_paqueteEstandar implements itf_paquetesEstandar {
    @Autowired
    itf_rct_paquetesEstandar repocitorio;

    @Override
    public List<mdl_crearPaquetesEstandar> getPaquetes() {
        return repocitorio.getPaquetes();
    }

    @Override
    public int savePaquete(mdl_crearPaquetesEstandar request) {
        return repocitorio.savePaquete(request);
    }
}
