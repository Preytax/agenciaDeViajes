package com.agencia_viaje.back.persistence;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_Ciudades;

public interface itf_pct_ciudad extends CrudRepository <mdl_Ciudades, Long>{
    public List<mdl_Ciudades> findById(int id);
    public List<mdl_Ciudades> findAllByIdMultiuser(int idMultiuser);
    public List<mdl_Ciudades> findAllByIdMultiuserAndIdDepartamento(int idMultiuser, int idDepartamento);
}
