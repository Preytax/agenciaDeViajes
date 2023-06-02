package com.agencia_viaje.back.repocitory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.agencia_viaje.back.model.mdl_Actividades;

@Repository
public class rpt_actividades implements itf_rct_actividades{

    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_actividades";
    
    @Override
    public List<mdl_Actividades> getActividades() {
        List<mdl_Actividades> listActividades=null;
        String query ="SELECT * FROM " +table;

        listActividades =JdbcTemplate.query(query,
        (rs, rowNum) -> new mdl_Actividades(
            rs.getInt("ID"),
            rs.getString("Nombre")
        )
        );
        return listActividades;
    }
}
