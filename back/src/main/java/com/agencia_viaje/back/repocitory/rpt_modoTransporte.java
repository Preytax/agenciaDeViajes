package com.agencia_viaje.back.repocitory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.agencia_viaje.back.model.mdl_ModoTransporte;

@Repository
public class rpt_modoTransporte implements itf_rct_modotransporte {
    
    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_modo_transportes";

    @Override
    public List<mdl_ModoTransporte> getTipoTransporte() {
        List<mdl_ModoTransporte> listTipoTransportes = null;
        String query = "SELECTO * FROM " + table;

        listTipoTransportes = JdbcTemplate.query(query,
                (rs, rowNum) -> new mdl_ModoTransporte(
                    rs.getInt("ID"),
                    rs.getString("Nombre")
                )
                );
        return listTipoTransportes;
    }
}
