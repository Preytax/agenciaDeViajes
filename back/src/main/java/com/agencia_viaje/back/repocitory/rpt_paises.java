package com.agencia_viaje.back.repocitory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.agencia_viaje.back.model.mdl_Paises;

@Repository
public class rpt_paises implements itf_rct_paises{

    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_paises";
    
    @Override
    public List<mdl_Paises> getPaises() {
        List<mdl_Paises> listPaises=null;
        String query ="SELECT * FROM " +table;

        listPaises =JdbcTemplate.query(query,
        (rs, rowNum) -> new mdl_Paises(
            rs.getInt("ID"),
            rs.getInt("ID_Departamento"),
            rs.getString("Nombre")
        )
        );
        return listPaises;
    }
    
}
