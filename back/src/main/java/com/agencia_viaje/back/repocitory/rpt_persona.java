package com.agencia_viaje.back.repocitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.agencia_viaje.back.model.mdl_persona;

import java.util.ArrayList;
import java.util.List;

@Repository
public class rpt_persona implements itf_rct_persona {
    @Autowired
    private JdbcTemplate JdbcTemplate;
    String table = "agv_personas";

    @Override
    public int updatePersonajdbc(mdl_persona request) {
        try {
            String query = ""+
                "UPDATE " + table + 
                    " SET NOMBRES = ?," + 
                    " APELLIDO_PATERNO = ?," + 
                    " APELLIDO_MATERNO = ?," + 
                    " ID_DOCUMENTO = ?," + 
                    " FECHA_NACIMIENTO = ?," + 
                    " USUARIO_MODIFICA = ?," + 
                    " FECHA_MODIFICA = ?," + 
                    " IP_MODIFICA = ?";

            if(request.getCorreo() != null){
                query += ", CORREO = ?";
            }
            if(request.getNroDocumento() != null){
                query += ", NRO_DOCUMENTO = ?";
            }
            if(request.getPassword() != null){
                query += ", PASSWORD = ?";
            }

            query += " WHERE ID = ?";

            List<String> params = new ArrayList<>();

            params.add(request.getNombres());
            params.add(request.getApellidoPaterno());
            params.add(request.getApellidoMaterno());
            params.add(request.getTipoDocumento());
            params.add(request.getFechaNacimiento());
            params.add(request.getUsuarioModifica());
            params.add(request.getFechaModifica());
            params.add(request.getIpModifica());

            if(request.getCorreo() != null){
                params.add(request.getCorreo());
            }
            if(request.getNroDocumento() != null){
                params.add(request.getNroDocumento());
            }
            if(request.getPassword() != null){
                params.add(request.getPassword());
            }

            params.add(request.getId()+"");

            int registros = JdbcTemplate.update(query, params.toArray());

                
            if (registros != 0) {
                return registros;
            }

        } catch (

        Exception e) {
            return 0;
        }
        return 0;
    }

    @Override
    public boolean confirmarCorreo(String correo){
        String query = "SELECT id, id_perfil, nombres, apellido_paterno, apellido_materno FROM " + table + " WHERE correo = '" + correo +"' AND estado = 1";
        List<mdl_persona> datosPersona = null;
        datosPersona = JdbcTemplate.query(query,
            (rs, rowNum) -> new mdl_persona(
                rs.getInt("ID"),
                rs.getString("ID_PERFIL"),
                rs.getString("NOMBRES"),
                rs.getString("APELLIDO_PATERNO"),
                rs.getString("APELLIDO_MATERNO")
            )
        );

        if(datosPersona.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public boolean confirmarNroDocumento(String dni){
        String query = "SELECT id, id_perfil, nombres, apellido_paterno, apellido_materno FROM " + table + " WHERE nro_documento = '" + dni +"' AND estado = 1";
        List<mdl_persona> datosPersona = null;
        datosPersona = JdbcTemplate.query(query,
            (rs, rowNum) -> new mdl_persona(
                rs.getInt("ID"),
                rs.getString("ID_PERFIL"),
                rs.getString("NOMBRES"),
                rs.getString("APELLIDO_PATERNO"),
                rs.getString("APELLIDO_MATERNO")
            )
        );

        if(datosPersona.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public List<mdl_persona> singIn(String correo, String password) {
        String query = "SELECT id, id_perfil, nro_Documento, nombres, apellido_paterno, apellido_materno FROM " + table + " WHERE correo='" + correo +"' AND password='" + password + "' AND estado = 1";
        List<mdl_persona> datosPersona = null;
        datosPersona =JdbcTemplate.query(query,
            (rs, rowNum) -> new mdl_persona(
                rs.getInt("ID"),
                rs.getString("ID_PERFIL"),
                rs.getString("NRO_DOCUMENTO"),
                rs.getString("NOMBRES"),
                rs.getString("APELLIDO_PATERNO"),
                rs.getString("APELLIDO_MATERNO")
            )
        );
        return datosPersona;
    }

    @Override
    public boolean suspenderPersona(String id) {
        try {
            mdl_persona persona = new mdl_persona();
            String query = "UPDATE " + table + " SET estado = 0  WHERE id = ?";

            int registros = JdbcTemplate.update(query, id);
            persona.capturarIp();
            persona.capturaraFecha();
            if (registros != 0) {
                return true;
            }

        } catch (

        Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean habilitarPersona(String id) {
        try {
            String query = "UPDATE " + table + " SET estado = 1  WHERE id = ?";

            int registros = JdbcTemplate.update(query, id);
                
            if (registros != 0) {
                return true;
            }

        } catch (

        Exception e) {
            return false;
        }
        return false;
    }
}