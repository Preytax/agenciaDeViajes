package com.agencia_viaje.back.repocitory;

import java.util.List;

import com.agencia_viaje.back.model.mdl_Hoteles;

public interface itf_rct_hoteles {
    public List<mdl_Hoteles> getHoteles(int id_modo_ciudad1);
}
