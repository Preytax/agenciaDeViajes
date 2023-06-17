package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_Departamento;
import com.agencia_viaje.back.persistence.itf_pct_departamento;

@Service

public class svc_Departamentos implements itf_departamento {
    @Autowired
    itf_pct_departamento repositorio;
    
    @Override
    public Boolean saveDepartamento(mdl_Departamento departamento) {
        try {
            repositorio.save(departamento);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<mdl_Departamento> getDepartamentosbyidusuario(int idUsuario){
        return repositorio.findAllByIdUsuario(idUsuario);
    }

    @Override
    public List<mdl_Departamento> getDepartamentosbyidusuariobyidpais(int idUsuario, int id_modo_pais){
        return repositorio.findAllByIdUsuarioAndIdPais(idUsuario, id_modo_pais);
    }
}
