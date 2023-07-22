package com.agencia_viaje.back.persistence;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_Hoteles;

public interface itf_pct_hotel extends CrudRepository <mdl_Hoteles, Long>{
    public mdl_Hoteles findById(int id);
    public List<mdl_Hoteles> findByIdCiudad(int id);

}
