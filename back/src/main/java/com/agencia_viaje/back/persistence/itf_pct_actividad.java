package com.agencia_viaje.back.persistence;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_Actividades;

public interface itf_pct_actividad extends CrudRepository <mdl_Actividades, Long>{
    public List<mdl_Actividades> findById(int id);
    public List<mdl_Actividades> findAllByIdMultiuser(int idMultiuser);
    public List<mdl_Actividades> findAllByIdMultiuserAndIdCiudad(int idMultiuser, int idCiudad);
}
