package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_crearPaquetesEstandar;

@Service
public interface itf_paquetesEstandar {

    public List<mdl_crearPaquetesEstandar> getPaquetes();
    public int savePaquete(mdl_crearPaquetesEstandar request);

}
