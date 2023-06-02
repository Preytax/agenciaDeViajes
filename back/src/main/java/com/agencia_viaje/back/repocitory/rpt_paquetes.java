package com.agencia_viaje.back.repocitory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.agencia_viaje.back.model.mdl_Paquetes;

@Repository
public class rpt_paquetes implements itf_rct_paquetes{

    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_paquetes";

    @Override
    public List<mdl_Paquetes> getPaquetes() {
        List<mdl_Paquetes> listPaq = null;
        String query = "SELECT * FROM " + table;

        listPaq =JdbcTemplate.query(query,
            (rs, rowNum) -> new mdl_Paquetes(
                rs.getInt("ID"),
                rs.getInt("ID_USUARIO"),
                rs.getInt("ID_PAIS"),
                rs.getInt("ID_DEPARTAMENTO"),
                rs.getInt("ID_CIUDAD"),
                rs.getInt("ID_ACTIVIDADES"),
                rs.getInt("ID_HOTELES"),
                rs.getInt("ID_MODO_TRANSPORTE"),
                rs.getInt("ID_TRANSPORTE"),
                rs.getString("FECHA_INICIO"),
                rs.getString("FECHA_FINAL")
            )
        );
        return listPaq;
    }

    @Override
    public int savePaquete(mdl_Paquetes request) {
        try {
            int registros = JdbcTemplate.update(
                "INSERT INTO " + table
                        + " (id_usuario,id_pais,id_departamento,id_ciudad,id_actividades,id_hoteles,id_modo_transporte,id_transporte,fecha_inicio,fecha_final) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                request.getIdusuario(),request.getIdpais(), request.getIddepartamento(), request.getIdciudad(), request.getIdactividades(), request.getIdhotel(), request.getIdmodotransporte(),request.getIdtransporte(),request.getFechaInicio(),request.getFechaFinal());

            if (registros != 0) {
                return registros;
            }
            
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }
    
}
