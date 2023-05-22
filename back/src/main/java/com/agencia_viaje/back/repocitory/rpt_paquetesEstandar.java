package com.agencia_viaje.back.repocitory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.agencia_viaje.back.model.mdl_crearPaquetesEstandar;

@Repository
public class rpt_paquetesEstandar implements itf_rct_paquetesEstandar{

    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_paquetes";

    @Override
    public List<mdl_crearPaquetesEstandar> getPaquetes() {
        List<mdl_crearPaquetesEstandar> listPaqPers = null;
        String query = "SELECT * FROM " + table;

        listPaqPers =JdbcTemplate.query(query,
            (rs, rowNum) -> new mdl_crearPaquetesEstandar(
                rs.getInt("ID"),
                rs.getInt("ID_MODO"),
                rs.getInt("ID_DESTINO"),
                rs.getInt("ID_CRONOGRAMA"),
                rs.getInt("ID_HOTEL"),
                rs.getInt("ID_TRANSPORTE"),
                rs.getInt("ID_USUARIO"),
                rs.getInt("ESTADO"),
                rs.getInt("USUARIO_REGISTRA"),
                rs.getInt("USUARIO_MODIFICA"),
                rs.getInt("USUARIO_ELIMINA"),
                rs.getDate("FECHA_REGISTRA"),
                rs.getDate("FECHA_MODIFICA"),
                rs.getDate("FECHA_ELIMINA"),
                rs.getString("IP_REGISTRA"),
                rs.getString("IP_MODIFICA"),
                rs.getString("IP_ELIMINA")
            )
        );

        return listPaqPers;
    }

    @Override
    public int savePaquete(mdl_crearPaquetesEstandar request) {
        try {
            int registros = JdbcTemplate.update(
                "INSERT INTO " + table
                        + " (id_modo,id_destino,id_cronograma,id_hotel,id_transporte,id_usuario,estado,usuario_registra,fecha_registra,ip_registra) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                request.getIdDestino(), request.getIdHotel(), request.getIdCronograma(), request.getIdTransporte(), request.getIdModo());

            if (registros != 0) {
                return registros;
            }
            
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }
    
}
