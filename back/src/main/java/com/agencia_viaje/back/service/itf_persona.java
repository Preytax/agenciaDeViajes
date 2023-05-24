package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_persona;

@Service
public interface itf_persona {

    /* QUERY CON JDBC */
    public int updatePersonajdbc(mdl_persona request);
    /* END QUERY CON JDBC */

    /* --------------------------------------------------------------------------------------------- */

    /* QUERY CON JPA */
    public mdl_persona getPersonaJPA(long id);
    public List<mdl_persona> getPersonasJPA();
    public Boolean savePersonaJPA(mdl_persona request);
    public Boolean updatePersonaJPA(mdl_persona request);
    /* END QUERY CON JPA */
}
