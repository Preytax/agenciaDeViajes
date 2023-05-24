package com.agencia_viaje.back.repocitory;

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
    public int updatePersonajdbc(mdl_persona request) {
        try {
            String query = ""+
                "UPDATE " + table + 
                    " SET NOMBRES = ?," + 
                    " APELLIDO_PATERNO = ?," + 
                    " APELLIDO_MATERNO = ?," + 
                    " ID_DOCUMENTO = ?," + 
                    " NRO_DOCUMENTO = ?," + 
                    " FECHA_NACIMIENTO = ?," + 
                    " CORREO = ?," + 
                    " USUARIO_MODIFICA = ?," + 
                    " FECHA_MODIFICA = ?," + 
                    " IP_MODIFICA = ?";

            if(request.getPassword() != null){
                query += ", PASSWORD = ?";
            }

            query += " WHERE ID = ?";

            int registros = JdbcTemplate.update(query,request.getNombres(),request.getApellidoPaterno(),request.getApellidoMaterno(),request.getTipoDocumento(),
                request.getNroDocumento(),request.getFechaNacimiento(),request.getCorreo(),request.getUsuarioModifica(),request.getFechaModifica(),
                request.getIpModifica(),request.getPassword(),request.getId());

                
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