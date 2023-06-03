package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Paquetes;
import com.agencia_viaje.back.persistence.itf_pct_paqueteStandar;
import com.agencia_viaje.back.repocitory.itf_rct_paquetes;

@Service
public class svc_paquetes implements itf_paquetes {
    @Autowired
    itf_rct_paquetes repocitorio;

    @Override
    public List<mdl_Paquetes> getPaquetes() {
        return repocitorio.getPaquetes();
    }

    @Override
    public int savePaquete(mdl_Paquetes request) {
        return repocitorio.savePaquete(request);
    }

    /* QUERY CON JPA */
    @Autowired
    itf_pct_paqueteStandar persistence;

    @Override
    public Boolean savePaqueteJPA(mdl_Paquetes request) {
        try {
            persistence.save(request);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
