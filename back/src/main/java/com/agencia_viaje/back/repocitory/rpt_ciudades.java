package com.agencia_viaje.back.repocitory;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.agencia_viaje.back.model.mdl_Ciudades;

@Repository
public class rpt_ciudades implements itf_rct_ciudades{

    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_ciudades";
    
    @Override
    public List<mdl_Ciudades> getCiudades() {
        List<mdl_Ciudades> listCiudades=null;
        String query ="SELECT * FROM " +table;

        listCiudades =JdbcTemplate.query(query,
        (rs, rowNum) -> new mdl_Ciudades(
            rs.getInt("ID"),
            rs.getString("Nombre")
        )
        );
        return listCiudades;
    }
    
}
