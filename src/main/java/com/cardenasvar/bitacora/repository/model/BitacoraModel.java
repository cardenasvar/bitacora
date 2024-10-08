package com.cardenasvar.bitacora.repository.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Entity(name = "bitacora")
@Data
@Builder
public class BitacoraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bitacora_key_gen")
    @SequenceGenerator(name = "bitacora_key_gen", sequenceName = "bitacora_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private ContratoModel contrato;

    private LocalDateTime fecha;

    private String tabla;

    private String accion;

    private String contenido;
}
