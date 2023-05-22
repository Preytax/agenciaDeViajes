package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_persona;
import com.agencia_viaje.back.repocitory.itf_rct_persona;
import com.agencia_viaje.back.persistence.itf_pct_persona;

@Service
public class svc_persona implements itf_persona {

    /* QUERY CON JDBC */
    @Autowired
    itf_rct_persona repocitory;

    @Override
    public List<mdl_persona> getOperador(int id) {
        return repocitory.getOperador(id);
    }

    @Override
    public int saveOperador(mdl_persona request) {
        return repocitory.saveOperador(request);
    }

    @Override
    public List<mdl_persona> getOperadores() {
        return repocitory.getOperadores();
    }
    /* END QUERY CON JDBC */

    /*
     * -----------------------------------------------------------------------------
     * ----------------
     */

    /* QUERY CON JPA */
    @Autowired
    itf_pct_persona persistence;

    @Override
    public Boolean savePersonaJPA(mdl_persona request) {
        try {
            persistence.save(request);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    /* END QUERY CON JPA */
}
