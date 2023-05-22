package com.agencia_viaje.back.repocitory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.agencia_viaje.back.model.mdl_perfil;

@Repository
public class rpt_perfil implements itf_rct_perfil{
    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_perfiles";

    @Override
    public List<mdl_perfil> getPerfiles() {
        List<mdl_perfil> listOpe = null;
        listOpe = JdbcTemplate.query(
            "SELECT * FROM " + table,
            (rs, rowNum) -> new mdl_perfil(
                rs.getInt("ID"),
                rs.getString("NOMBRE")
            )
        );

        return listOpe;
    }
}
