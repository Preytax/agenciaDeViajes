package com.agencia_viaje.back.service;

import java.util.List;
import com.agencia_viaje.back.model.mdl_Departamento;

public interface itf_departamento {
    // CON JPA
    public Boolean saveDepartamento(mdl_Departamento departamento);

    public List<mdl_Departamento> getDepartamentoById(int id);

    public List<mdl_Departamento> getDepartamentosByIdMultiuser(int idUsuario);

    public List<mdl_Departamento> getDepartamentosByIdMultiuserAndIdPais(int idUsuario, int id_modo_pais);
}
