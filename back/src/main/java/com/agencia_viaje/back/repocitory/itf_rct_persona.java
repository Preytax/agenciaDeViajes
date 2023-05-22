package com.agencia_viaje.back.repocitory;

import java.util.List;
import com.agencia_viaje.back.model.mdl_persona;

public interface itf_rct_persona {
    public List<mdl_persona> getOperadores();

    public List<mdl_persona> getOperador(int id);

    public int saveOperador(mdl_persona request);
}
