package com.agencia_viaje.back.repocitory;

import java.util.List;
import com.agencia_viaje.back.model.mdl_persona;

public interface itf_rct_persona {
    public int updatePersonajdbc(mdl_persona request);
    public List<mdl_persona> singIn(String correo, String password);
}
