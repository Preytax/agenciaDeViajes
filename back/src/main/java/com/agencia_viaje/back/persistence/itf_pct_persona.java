package com.agencia_viaje.back.persistence;

import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_persona;

public interface itf_pct_persona extends CrudRepository <mdl_persona, Long> {
   
}
