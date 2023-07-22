package com.agencia_viaje.back.repocitory;

import java.util.List;
import com.agencia_viaje.back.model.mdl_Paquetes;

public interface itf_rct_paquetes {

    public List<mdl_Paquetes> getPaquetes();

    public int savePaquete (mdl_Paquetes request);

    public List<mdl_Paquetes> getPaquetesByFiltros(String idCiudadPartida, String idCiudadDestino);
}
