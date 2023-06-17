package com.agencia_viaje.back.service;

import java.util.List;

import com.agencia_viaje.back.model.mdl_Actividades;

public interface itf_actividades {
    public Boolean saveActividad(mdl_Actividades actividad);
    public List<mdl_Actividades> getActividadesByIdMultiuser(int idMultiuser);
    public List<mdl_Actividades> getActividadesByIdMultiuserAndIdCiudad(int idMultiuser, int idCiudad);
}
