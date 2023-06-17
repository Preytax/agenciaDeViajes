package com.agencia_viaje.back.persistence;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_Departamento;

public interface itf_pct_departamento extends CrudRepository <mdl_Departamento, Long>{
    public List<mdl_Departamento> findById(int id);
    public List<mdl_Departamento> findAllByIdMultiuser(int idUsuario);
    public List<mdl_Departamento> findAllByIdMultiuserAndIdPais(int idUsuario, int idPais);
}
