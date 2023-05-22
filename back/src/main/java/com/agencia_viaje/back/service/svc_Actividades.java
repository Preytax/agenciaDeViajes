package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Actividades;
import com.agencia_viaje.back.repocitory.itf_rct_actividades;

@Service
public class svc_Actividades implements itf_rct_actividades{

    @Autowired
    itf_rct_actividades repocitorio;
    
    @Override
    public List<mdl_Actividades> getActividades() {
        return repocitorio.getActividades();
    }
    
}
