package com.agencia_viaje.back.repocitory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.agencia_viaje.back.model.mdl_Departamento;

@Repository
public class rpt_departamento implements itf_rct_departamento {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    String table = "agv_departamentos";

    @Override
    public List<mdl_Departamento> getDepartamento(int id_modo_pais){
        List<mdl_Departamento> listDepartamento=null;
        String query ="SELECT * FROM " + table +" where id_pais = "+id_modo_pais;

        listDepartamento = jdbcTemplate.query(query,
        (rs, rowNum)-> new mdl_Departamento(
           rs.getInt("ID"), 
           rs.getInt("ID_PAIS"),
           rs.getString("NOMBRE")
        )
        );
        return listDepartamento;
    }
}
