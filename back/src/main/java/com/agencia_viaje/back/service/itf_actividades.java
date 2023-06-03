package com.agencia_viaje.back.service;

import java.util.List;

import com.agencia_viaje.back.model.mdl_Actividades;

public interface itf_actividades {
    public List<mdl_Actividades> getActividades(int id_modo_ciudad2);
}
