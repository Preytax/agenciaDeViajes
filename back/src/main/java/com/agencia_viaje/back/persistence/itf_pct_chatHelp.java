package com.agencia_viaje.back.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.agencia_viaje.back.model.mdl_ChatHelp;

public interface itf_pct_chatHelp extends CrudRepository <mdl_ChatHelp, Long>{

    //@Query("SELECT c FROM mdl_ChatHelp c GROUP BY c.numero ORDER BY c.id DESC")
    //@Query("SELECT c FROM mdl_ChatHelp c WHERE c.fecha = (SELECT MAX(ch.fecha) FROM mdl_ChatHelp ch WHERE ch.numero = c.numero) GROUP BY c.numero")
    //@Query("SELECT c.id, c.tipo, (SELECT chr.nombre FROM mdl_ChatHelp chr WHERE chr.numero = c.numero GROUP BY chr.numero) as nombre, c.numero, c.fecha, c.mensaje FROM mdl_ChatHelp c WHERE c.fecha = (SELECT MAX(ch.fecha) FROM mdl_ChatHelp ch WHERE ch.numero = c.numero) GROUP BY c.numero")
    //@Query("SELECT c.nombre FROM mdl_ChatHelp c WHERE c.fecha = (SELECT MAX(ch.fecha) FROM mdl_ChatHelp ch WHERE ch.numero = c.numero) GROUP BY c.numero")
    //@Query("SELECT t.id, t.tipo, t.nombre, t.numero, t.fecha, (SELECT msg.mensaje FROM mdl_ChatHelp msg WHERE msgORDER BY msg.id DESC) AS mensaje FROM mdl_ChatHelp t ORDER BY t.id ASC")
    @Query("SELECT new com.agencia_viaje.back.model.mdl_ChatHelp(c.id, c.id_usuario, c.tipo, ch.nombre, c.numero, c.fecha, c.mensaje) FROM mdl_ChatHelp c INNER JOIN mdl_ChatHelp ch ON ch.numero = c.numero WHERE c.fecha = (SELECT MAX(ch2.fecha) FROM mdl_ChatHelp ch2 WHERE ch2.numero = c.numero) GROUP BY c.numero")
    public List<mdl_ChatHelp> findAllGroupedByNumero();

    public List<mdl_ChatHelp> findAllByNumero(String numero);

    @Query("SELECT c FROM mdl_ChatHelp c GROUP BY c.numero")
    public List<mdl_ChatHelp> findGroupedByNumero(String numero);

    public List<mdl_ChatHelp> findById(String id);
}
