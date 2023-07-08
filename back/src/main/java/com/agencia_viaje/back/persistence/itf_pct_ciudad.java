package com.agencia_viaje.back.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_Ciudades;

public interface itf_pct_ciudad extends CrudRepository <mdl_Ciudades, Long>{
    public List<mdl_Ciudades> findById(int id);
    public List<mdl_Ciudades> findAllByIdMultiuser(int idMultiuser);
    public List<mdl_Ciudades> findAllByIdMultiuserAndIdDepartamento(int idMultiuser, int idDepartamento);

    @Query(value = "SELECT agv_ciudades.* FROM agv_ciudades " +
            "INNER JOIN agv_departamentos ON agv_departamentos.id = agv_ciudades.id_departamento " +
            "INNER JOIN agv_paises ON agv_paises.id = agv_departamentos.id_pais " +
            "WHERE agv_paises.id = :paisId", nativeQuery = true)
    public List<mdl_Ciudades> findAllByIdPais(int paisId);
}
