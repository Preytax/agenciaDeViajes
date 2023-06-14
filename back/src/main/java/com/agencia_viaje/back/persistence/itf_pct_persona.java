package com.agencia_viaje.back.persistence;

import java.util.List;
//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_persona;

public interface itf_pct_persona extends CrudRepository <mdl_persona, Long> {
    //Personas por tipo de perfil, estado y usuario que registro
    public List<mdl_persona> findAllByIdPerfilInAndEstadoInAndUsuarioRegistra(List<String> id_perfil, List<String> estado, String usuario_registra);

    //Clientes por tipo de perfil y estado
    public List<mdl_persona> findAllByIdPerfilAndEstadoIn(String id_perfil, List<String> estado);

    //Cruce de tablas personas y perfiles
    //@Query("SELECT p.*, pf.nombre, md.nombre FROM agv_personas p LEFT JOIN p.agv_perfiles pf LEFT JOIN p.agv_documentos md")
    //mdl_persona findPersonasWithIdPerfilAndIdDocument(int id);
  
}
