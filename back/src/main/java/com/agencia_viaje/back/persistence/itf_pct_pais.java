package com.agencia_viaje.back.persistence;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_Paises;

public interface itf_pct_pais extends CrudRepository <mdl_Paises, Long>{

    public List<mdl_Paises> findAllByIdMultiuser(int idMultiuser);
    public List<mdl_Paises> findById(int id);
}
