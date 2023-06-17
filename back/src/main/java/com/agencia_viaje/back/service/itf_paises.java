package com.agencia_viaje.back.service;

import java.util.List;
import com.agencia_viaje.back.model.mdl_Paises;

public interface itf_paises {
    //CON JPA
    public Boolean savePais(mdl_Paises pais);
    public List<mdl_Paises> getPaises(String id_usuario);
    public List<mdl_Paises> getPaisesById(int id);
}
