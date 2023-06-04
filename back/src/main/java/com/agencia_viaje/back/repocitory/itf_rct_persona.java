package com.agencia_viaje.back.repocitory;

import java.util.List;
import com.agencia_viaje.back.model.mdl_persona;

public interface itf_rct_persona {
    public int updatePersonajdbc(mdl_persona request);
    public boolean confirmarCorreo(String correo);
    public boolean confirmarNroDocumento(String dni);
    public List<mdl_persona> singIn(String correo, String password);
    public boolean suspenderPersona(String id);
    public boolean habilitarPersona(String id);
}
