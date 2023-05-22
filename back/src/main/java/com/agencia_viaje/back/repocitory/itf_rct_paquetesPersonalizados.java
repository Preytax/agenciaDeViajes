package com.agencia_viaje.back.repocitory;

import java.util.List;
import com.agencia_viaje.back.model.mdl_crearPaquetesPersonalizados;

public interface itf_rct_paquetesPersonalizados {

    public List<mdl_crearPaquetesPersonalizados> getPaquetes();

    public int savePaquete (mdl_crearPaquetesPersonalizados request);
}
