package com.agencia_viaje.back.service;

import java.util.List;

import com.agencia_viaje.back.model.mdl_Hoteles;

public interface itf_hoteles {
    public List<mdl_Hoteles> getHoteles(int id_modo_ciudad1);
    public mdl_Hoteles getHotelById(int id);
}
