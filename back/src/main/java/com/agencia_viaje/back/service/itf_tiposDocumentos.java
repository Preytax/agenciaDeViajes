package com.agencia_viaje.back.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.agencia_viaje.back.model.mdl_tiposDocumentos;

@Service
public interface itf_tiposDocumentos {
    public List<mdl_tiposDocumentos> getPerfiles();
}
