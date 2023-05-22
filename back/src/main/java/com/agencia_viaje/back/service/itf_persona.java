package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_persona;

@Service
public interface itf_persona {

    /* QUERY CON JDBC */
    public List<mdl_persona> getOperadores();
    public List<mdl_persona> getOperador(int id);
    public int saveOperador(mdl_persona request);
    /* END QUERY CON JDBC */

    /* --------------------------------------------------------------------------------------------- */

    /* QUERY CON JPA */
    public Boolean savePersonaJPA(mdl_persona request);
    /* END QUERY CON JPA */
}
