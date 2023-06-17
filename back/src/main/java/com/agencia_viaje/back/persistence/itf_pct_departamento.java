package com.agencia_viaje.back.persistence;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_Departamento;

public interface itf_pct_departamento extends CrudRepository <mdl_Departamento, Long>{
    public List<mdl_Departamento> findAllByIdUsuario(int idUsuario);
    public List<mdl_Departamento> findAllByIdUsuarioAndIdPais(int idUsuario, int idPais);
}
