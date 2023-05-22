package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_crearPaquetesPersonalizados;

@Service
public interface itf_paquetesPersonalizados {
    public List<mdl_crearPaquetesPersonalizados> getPaquetes();

    public int savePaquete(mdl_crearPaquetesPersonalizados request);

}
