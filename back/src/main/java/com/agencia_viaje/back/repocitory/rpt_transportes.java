package com.agencia_viaje.back.repocitory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.agencia_viaje.back.model.mdl_Transportes;

@Repository
public class rpt_transportes implements itf_rct_transportes{

    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_transportes";
    
    @Override
    public List<mdl_Transportes> getTransportes() {
        List<mdl_Transportes> listTransportes=null;
        String query ="SELECT * FROM " +table;

        listTransportes =JdbcTemplate.query(query,
        (rs, rowNum) -> new mdl_Transportes(
            rs.getInt("ID"),
            rs.getInt("ID_MODO_TRANSPORTE"),
            rs.getString("Nombre")
        )
        );
        return listTransportes;
    }
    
}
