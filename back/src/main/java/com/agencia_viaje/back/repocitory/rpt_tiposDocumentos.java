package com.agencia_viaje.back.repocitory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.agencia_viaje.back.model.mdl_tiposDocumentos;

@Repository
public class rpt_tiposDocumentos implements itf_rct_tiposDocumentos{
    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_documentos";

    @Override
    public List<mdl_tiposDocumentos> getPerfiles() {
        List<mdl_tiposDocumentos> listOpe = null;
        listOpe = JdbcTemplate.query(
            "SELECT * FROM " + table,
            (rs, rowNum) -> new mdl_tiposDocumentos(
                rs.getInt("ID"),
                rs.getString("NOMBRE")
            )
        );

        return listOpe;
    }
}
