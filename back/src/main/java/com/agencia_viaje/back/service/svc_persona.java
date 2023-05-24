package com.agencia_viaje.back.service;

import java.util.List;
import java.util.Optional;
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
    public int updatePersonajdbc(mdl_persona request) {
        return repocitory.updatePersonajdbc(request);
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
    public mdl_persona getPersonaJPA(long id) {
        Optional<mdl_persona> opt = persistence.findById(id);

        if(opt.isPresent()) {
            return opt.get();
        }else{
            return new mdl_persona();
        }
    }

    @Override
    public List<mdl_persona> getPersonasJPA() {
        return (List<mdl_persona>) persistence.findAll();
    }

    @Override
    public Boolean savePersonaJPA(mdl_persona request) {
        try {
            persistence.save(request);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updatePersonaJPA(mdl_persona request) {
        try {
            persistence.save(request);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    /* END QUERY CON JPA */
}
