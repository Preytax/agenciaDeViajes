package com.agencia_viaje.back.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.preference.Preference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
/* import org.springframework.web.bind.annotation.RequestBody; */
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ctl_mercadoPagoSand {
    private static final Logger LOGGER = LoggerFactory.getLogger(ctl_mercadoPagoSand.class);

    // Agrega credenciales
    @PostMapping(value = "/crear-preferencia", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> preferencia() {
        try {
            MercadoPagoConfig.setAccessToken("TEST-3777880882668910-070602-e0162cbed7f4fc97342d92f2b5f49973-145441956");

            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                .id("145441956")
                .title("Games")
                .description("PS5")
                .pictureUrl("")
                .categoryId("games")
                .quantity(2)
                .currencyId("PE")
                .unitPrice(new BigDecimal("4000"))
                .build();

            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);

            PreferenceRequest preferenceRequest = PreferenceRequest.builder().items(items).build();
            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);

            LOGGER.info("Preferencia creada: {}", preference);

            return ResponseEntity.ok("Preferencia creada");
        } catch (Exception e) {
            LOGGER.error("Error al crear la preferencia: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error al crear la preferencia");
        }
    }
}
