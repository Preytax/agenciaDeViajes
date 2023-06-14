package com.agencia_viaje.back.persistence;

import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_perfil;

public interface itf_pct_perfil extends CrudRepository <mdl_perfil, Long> {
    
}
