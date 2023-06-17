package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Ciudades;
import com.agencia_viaje.back.model.mdl_Departamento;
import com.agencia_viaje.back.persistence.itf_pct_ciudad;

@Service
public class svc_Ciudades implements itf_ciudades {

    @Autowired
    itf_pct_ciudad repocitorio;

    @Override
    public Boolean saveCiudad(mdl_Ciudades ciudad) {
        try {
            repocitorio.save(ciudad);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<mdl_Ciudades> getCiudadesByIdusuario(int idUsuario) {
        return repocitorio.findAllByIdUsuario(idUsuario);
    }

    @Override
    public List<mdl_Ciudades> getCiudadesByIdUsuarioAndIdDepartamento(int idUsuario, int idDepartamento) {
        return repocitorio.findAllByIdUsuarioAndIdDepartamento(idUsuario, idDepartamento);
    }

}
