package com.agencia_viaje.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia_viaje.back.model.mdl_Transportes;
import com.agencia_viaje.back.persistence.itf_pct_transporte;
import com.agencia_viaje.back.repocitory.itf_rct_transportes;

@Service
public class svc_Transportes implements itf_rct_transportes {

    @Autowired
    itf_pct_transporte repositorio;

    @Override
    public List<mdl_Transportes> getTransportes(int id_modo_transporte) {
        return repositorio.findByIdModoTransporte(id_modo_transporte);
    }

}
