package com.agencia_viaje.back.repocitory;

import java.util.List;

import com.agencia_viaje.back.model.mdl_crearPaquetesEstandar;

public interface itf_rct_paquetesEstandar {

    public List<mdl_crearPaquetesEstandar> getPaquetes();

    public int savePaquete (mdl_crearPaquetesEstandar request);
}
