package com.agencia_viaje.back.repocitory;

import java.util.List;

import com.agencia_viaje.back.model.mdl_Departamento;

public interface itf_rct_departamento {
    public List<mdl_Departamento> getDepartamento(int id_modo_pais);
}
