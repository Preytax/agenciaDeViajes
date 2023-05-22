package com.agencia_viaje.back.repocitory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.agencia_viaje.back.model.mdl_persona;

@Repository
public class rpt_persona implements itf_rct_persona {
    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_personas";

    @Override
    public List<mdl_persona> getOperador(int id) {
        List<mdl_persona> listOpe = null;
        listOpe = JdbcTemplate.query("SELECT * FROM " + table + " WHERE id = " + id,
                (rs, rowNum) -> new mdl_persona(
                        rs.getInt("ID"),
                        rs.getString("ID_PERFIL"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDO_PATERNO"),
                        rs.getString("APELLIDO_MATERNO"),
                        rs.getString("ID_DOCUMENTO"),
                        rs.getString("NRO_DOCUMENTO"),
                        rs.getString("CORREO"),
                        rs.getString("PASSWORD"),
                        rs.getString("ESTADO"),
                        rs.getInt("USUARIO_REGISTRA"),
                        rs.getString("FECHA_NACIMIENTO"),
                        rs.getString("FECHA_REGISTRA"),
                        rs.getString("IP_REGISTRA")));

        return listOpe;
    }

    @Override
    public List<mdl_persona> getOperadores() {
        List<mdl_persona> listOpe = null;
        String query = "" +
                "SELECT " +
                table + ".id, " +
                "perf.nombre AS id_perfil, " +
                table + ".nombres, " +
                table + ".apellido_paterno, " +
                table + ".apellido_materno, " +
                "docu.nombre as tipo_documento, " +
                table + ".nro_documento, " +
                table + ".correo, " +
                table + ".password, " +
                /*
                 * "CASE " + table + ".estado "+
                 * "WHEN 0 THEN 'Deshabilitado' "+
                 * "WHEN 1 THEN 'Habilitado' "+
                 * "WHEN 2 THEN 'Elimiando' "+
                 * "END AS estado, " +
                 */table + ".estado, " +
                table + ".fecha_nacimiento, " +
                table + ".usuario_registra, " +
                table + ".fecha_registra, " +
                table + ".ip_registra " +

                "FROM " +
                table +

                " LEFT JOIN agv_documentos AS docu ON " +
                "   docu.id = " + table + ".id_documento" +

                " LEFT JOIN agv_perfiles AS perf ON " +
                "   perf.id = " + table + ".id_perfil" +

                "";

        listOpe = JdbcTemplate.query(
                query,
                (rs, rowNum) -> new mdl_persona(
                        rs.getInt("ID"),
                        rs.getString("ID_PERFIL"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDO_PATERNO"),
                        rs.getString("APELLIDO_MATERNO"),
                        rs.getString("TIPO_DOCUMENTO"),
                        rs.getString("NRO_DOCUMENTO"),
                        rs.getString("CORREO"),
                        rs.getString("PASSWORD"),
                        rs.getString("ESTADO"),
                        rs.getInt("USUARIO_REGISTRA"),
                        rs.getString("FECHA_NACIMIENTO"),
                        rs.getString("FECHA_REGISTRA"),
                        rs.getString("IP_REGISTRA")));

        return listOpe;
    }

    @Override
    public int saveOperador(mdl_persona request) {
        try {
            int registros = JdbcTemplate.update(
                    "INSERT INTO " + table
                            + " (ID_PERFIL, NOMBRES, APELLIDO_PATERNO, APELLIDO_MATERNO, ID_DOCUMENTO, NRO_DOCUMENTO, FECHA_NACIMIENTO, CORREO, PASSWORD, USUARIO_REGISTRA, IP_REGISTRA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    request.getIdPerfil(), request.getNombres(), request.getApellidoPaterno(),
                    request.getApellidoMaterno(), request.getTipoDocumento(),
                    request.getNroDocumento(), request.getFechaNacimiento(), request.getCorreo(), request.getPassword(),
                    /* request.getUsuarioRegistra() */1, request.getIp());

            if (registros != 0) {
                return registros;
            }

        } catch (

        Exception e) {
            return 0;
        }
        return 0;
    }
}