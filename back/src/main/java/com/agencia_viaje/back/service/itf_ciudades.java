package com.agencia_viaje.back.service;

import java.util.List;

import com.agencia_viaje.back.model.mdl_Ciudades;

public interface itf_ciudades {
    public Boolean saveCiudad(mdl_Ciudades ciudad);
    public List<mdl_Ciudades> getCiudadById(int id);
    public List<mdl_Ciudades> getCiudadesByIdMultiuser(int idUsuario);
    public List<mdl_Ciudades> getCiudadesByIdMultiuserAndIdDepartamento(int idUsuario, int idDepartamento);

    public List<mdl_Ciudades> getCiudadesByIdPais(int idPais);
}
