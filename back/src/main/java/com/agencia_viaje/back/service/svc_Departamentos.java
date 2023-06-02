package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_Departamento;
import com.agencia_viaje.back.repocitory.itf_rct_departamento;

@Service

public class svc_Departamentos implements itf_rct_departamento {
    @Autowired
    itf_rct_departamento repositorio;
    @Override
    public List<mdl_Departamento> getDepartamento(){
        return repositorio.getDepartamento();
    }
}
