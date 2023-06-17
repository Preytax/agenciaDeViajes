package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_Paises;
import com.agencia_viaje.back.persistence.itf_pct_pais;

@Service
public class svc_Paises implements itf_paises {

    @Autowired
    itf_pct_pais persistence;

    @Override
    public Boolean savePais(mdl_Paises pais) {
        try {
            persistence.save(pais);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<mdl_Paises> getPaisesById(int id){
        return persistence.findById(id);
    }

    @Override
    public List<mdl_Paises> getPaises(int idMultiuser) {
        return persistence.findAllByIdMultiuser(idMultiuser);
    }
}
