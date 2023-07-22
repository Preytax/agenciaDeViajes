package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Paquetes;

@Service
public interface itf_paquetes {
    public List<mdl_Paquetes> getPaquetes();

    public int savePaquete(mdl_Paquetes request);
    
    public List<mdl_Paquetes> getPaquetesByFiltros(String idCiudadPartida, String idCiudadDestino);

    /* QUERY CON JPA */
    public Boolean savePaqueteJPA(mdl_Paquetes request);
    /* END QUERY CON JPA */
}
