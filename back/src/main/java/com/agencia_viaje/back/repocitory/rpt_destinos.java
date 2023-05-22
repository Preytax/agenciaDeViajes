package com.agencia_viaje.back.repocitory;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agencia_viaje.back.model.mdl_Destinos;

@Repository
public class rpt_destinos implements itf_rct_destinos{

    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_destinos";

    @Override
    public List<mdl_Destinos> getDestinos() {
        List<mdl_Destinos> listDestinos=null;
        String query ="SELECT * FROM " +table;

        listDestinos =JdbcTemplate.query(query,
        (rs, rowNum) -> new mdl_Destinos(
            rs.getInt("ID"),
            rs.getInt("ID_PAISES"),
            rs.getString("Nombre")
        )
        );
        return listDestinos;
    }
    
}
