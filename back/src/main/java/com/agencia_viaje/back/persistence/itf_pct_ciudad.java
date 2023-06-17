package com.agencia_viaje.back.persistence;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_Ciudades;

public interface itf_pct_ciudad extends CrudRepository <mdl_Ciudades, Long>{
    public List<mdl_Ciudades> findAllByIdUsuario(int idUsuario);
    public List<mdl_Ciudades> findAllByIdUsuarioAndIdDepartamento(int idUsuario, int idDepartamento);
}
