package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Transportes;
import com.agencia_viaje.back.persistence.itf_pct_transporte;

@Service
public class svc_Transportes implements itf_transportes {

    @Autowired
    itf_pct_transporte repositorio;

    @Override
    public List<mdl_Transportes> getTransportes(int id_modo_transporte) {
        return repositorio.findAllByIdModoTransporte(id_modo_transporte);
    }

    @Override
    public mdl_Transportes getTransporteById(int id_transporte) {
        return repositorio.findById(id_transporte);
    }

}
