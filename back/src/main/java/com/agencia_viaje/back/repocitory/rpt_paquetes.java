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
        String query = ""+
            "SELECT " + 
                table + ".id, "+
                table + ".id_modo, "+
                table + ".id_usuario, "+
                table + ".id_departamento, "+
                table + ".actividades, "+
                table + ".id_hoteles, "+
                table + ".id_modo_transporte, "+
                table + ".id_transporte, "+
                table + ".fecha_inicio, "+
                table + ".fecha_final, "+
                table + ".monto "+
                /* " agv_paises.nombre AS pais, "+
                " agv_ciudades.nombre AS ciudad "+ */
            
            " FROM " + table +
            
            /* " INNER JOIN agv_paises ON " +
                " agv_paises.id = " + table + ".id_pais" +

            " INNER JOIN agv_ciudades ON " +
                " agv_ciudades.id = " + table + ".id_ciudad " + */
                
            " WHERE " + table + ".estado = 1";


        listPaq =JdbcTemplate.query(query,
            (rs, rowNum) -> new mdl_Paquetes(
                rs.getInt("ID"),
                rs.getInt("ID_MODO"),
                rs.getInt("ID_USUARIO"),
                /* rs.getString("PAIS"), */
                rs.getInt("ID_DEPARTAMENTO"),
                /* rs.getString("CIUDAD"), */
                rs.getInt("ID_HOTELES"),
                rs.getInt("ID_MODO_TRANSPORTE"),
                rs.getInt("ID_TRANSPORTE"),
                rs.getString("FECHA_INICIO"),
                rs.getString("FECHA_FINAL"),
                rs.getInt("MONTO"),
                rs.getString("ACTIVIDADES")
            )
        );
        return listPaq;
    }

    @Override
    public int savePaquete(mdl_Paquetes request) {
        try {
            
            int registros = JdbcTemplate.update(
                "INSERT INTO " + table
                        + " (id_usuario,id_modo,id_pais,id_departamento,id_ciudad,id_hoteles,id_modo_transporte,id_transporte,fecha_inicio,fecha_final,monto,actividades) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
               request.getIdusuario(),request.getIdmodo()/* ,request.getIdpais() */, request.getIddepartamento()/*, request.getIdciudad() */, request.getActividades(), request.getIdhotel(), request.getIdmodotransporte(),request.getIdtransporte(),request.getFechaInicio(),request.getFechaFinal(),request.getMonto());

            if (registros != 0) {
                return registros;
            }
            
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

    @Override
    public List<mdl_Paquetes> getPaquetesByFiltros(String idCiudadPartida, String idCiudadDestino) {
        List<mdl_Paquetes> listPaq = null;
        
        String query = ""+
            "SELECT " + 
                table + ".id, "+
                table + ".id_modo, "+
                table + ".id_usuario, "+
                table + ".id_departamento, "+
                table + ".actividades, "+
                table + ".id_hoteles, "+
                table + ".id_modo_transporte, "+
                table + ".id_transporte, "+
                table + ".fecha_inicio, "+
                table + ".fecha_final, "+
                table + ".monto "+
                /* " agv_paises.nombre AS pais, "+
                " agv_ciudades.nombre AS ciudad "+ */
            
            " FROM " + table +
            
            /* " INNER JOIN agv_paises ON " +
                " agv_paises.id = " + table + ".id_pais" +

            " INNER JOIN agv_ciudades ON " +
                " agv_ciudades.id = " + table + ".id_ciudad " + */
                
            " WHERE " + 
                table + ".estado = 1 ";

            if(!idCiudadPartida.equals("0")){
                query += " AND "+table + ".id_ciudad_partida = '"+idCiudadPartida+"'";
            }

            if(!idCiudadDestino.equals("0")){
                query += " AND "+table + ".id_ciudad_destino = '"+idCiudadDestino+"'";
            }

        listPaq =JdbcTemplate.query(query,
            (rs, rowNum) -> new mdl_Paquetes(
                rs.getInt("ID"),
                rs.getInt("ID_MODO"),
                rs.getInt("ID_USUARIO"),
                /* rs.getString("PAIS"), */
                rs.getInt("ID_DEPARTAMENTO"),
                /* rs.getString("CIUDAD"), */
                rs.getInt("ID_HOTELES"),
                rs.getInt("ID_MODO_TRANSPORTE"),
                rs.getInt("ID_TRANSPORTE"),
                rs.getString("FECHA_INICIO"),
                rs.getString("FECHA_FINAL"),
                rs.getInt("MONTO"),
                rs.getString("ACTIVIDADES")
            )
        );
        return listPaq;
    }
    
}
