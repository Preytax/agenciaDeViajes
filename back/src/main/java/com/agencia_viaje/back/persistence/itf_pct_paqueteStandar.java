package com.agencia_viaje.back.persistence;

/* import java.util.List; */
import org.springframework.data.jpa.repository.JpaRepository;
/* import org.springframework.data.jpa.repository.Query; */
import com.agencia_viaje.back.model.mdl_Paquetes;

public interface itf_pct_paqueteStandar extends JpaRepository<mdl_Paquetes, Long> {

    /* @Query(value = "SELECT p FROM mdl_Paquetes p WHERE " +
            "p.id_pais = :idPais AND " +
            "p.id_ciudad = :idCiudad AND " +
            "p.fecha_inicio <= :fechaInicio AND " +
            "p.fecha_final >= :fechaFinal")
    public List<mdl_Paquetes> findByFiltros(String idPais, String idCiudad,  String fechaInicio, String fechaFinal); */
}