package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_persona;

@Service
public interface itf_persona {

    /* QUERY CON JDBC */
    public int updatePersonajdbc(mdl_persona request);
    public boolean confirmarCorreo(String correo);
    public boolean confirmarNroDocumento(String dni);
    //public List<mdl_persona> singIn(String correo, String password);
    public boolean suspenderPersona(int id);
    public boolean habilitarPersona(int id);
    public boolean EliminatPersona(int id);
    /* END QUERY CON JDBC */

    /* --------------------------------------------------------------------------------------------- */

    /* QUERY CON JPA */
    public List<mdl_persona> singIn(String correo, String password);
    public mdl_persona getPersonaJPA(long id);
    public List<mdl_persona> findAllByIdPerfilInAndEstadoInAndUsuarioRegistra(List<String> id_perfil, List<String> estado, String usuario_registra);
    public List<mdl_persona> findAllByIdPerfilAndEstadoIn(String id_perfil, List<String> estado);
    public List<mdl_persona> getPersonasJPA();
    public Boolean savePersonaJPA(mdl_persona request);
    public Boolean updatePersonaJPA(mdl_persona request);
    /* END QUERY CON JPA */
}
