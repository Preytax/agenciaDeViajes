/* package com.agencia_viaje.back.repocitory;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.agencia_viaje.back.model.mdl_Hoteles;

@Repository
public class rpt_hoteles implements itf_rct_hoteles{

    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_hoteles";

    @Override
    public List<mdl_Hoteles> getHoteles(int id_modo_ciudad1) {
        List<mdl_Hoteles> listHoteles=null;
        String query ="SELECT * FROM " +table+" WHERE id_ciudad = "+id_modo_ciudad1;

        listHoteles =JdbcTemplate.query(query,
        (rs, rowNum) -> new mdl_Hoteles(
            rs.getInt("ID"),
            rs.getInt("ID_CIUDAD"),
            rs.getString("Nombre")
        )
        );
        return listHoteles;
    }
    
}
 */