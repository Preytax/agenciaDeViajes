package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Actividades;
import com.agencia_viaje.back.persistence.itf_pct_actividad;

@Service
public class svc_Actividades implements itf_actividades{

    @Autowired
    itf_pct_actividad repocitorio;
    
    @Override
    public Boolean saveActividad(mdl_Actividades actividad) {
        try {
            repocitorio.save(actividad);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<mdl_Actividades> getActividadesByIdMultiuser(int idMultiuser) {
        return repocitorio.findAllByIdMultiuser(idMultiuser);
    }

    @Override
    public List<mdl_Actividades> getActividadesByIdMultiuserAndIdCiudad(int idMultiuser, int idCiudad) {
        return repocitorio.findAllByIdMultiuserAndIdCiudad(idMultiuser, idCiudad);
    }

    @Override
    public mdl_Actividades getActividadById(int idCiudad) {
        return repocitorio.findById(idCiudad);
    }
    
}
