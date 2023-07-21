package com.agencia_viaje.back.persistence;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_Transportes;

public interface itf_pct_transporte extends CrudRepository <mdl_Transportes, Long>{

    public List<mdl_Transportes> findAllByIdMultiuser(int idMultiuser);
    public List<mdl_Transportes> findById(int id);
    public List<mdl_Transportes> findByIdModoTransporte(int id);
}
