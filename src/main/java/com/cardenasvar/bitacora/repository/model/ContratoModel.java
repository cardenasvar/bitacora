package com.cardenasvar.bitacora.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "contrato")
@Data
public class ContratoModel implements ObservableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String estado;

    public boolean isVigente() {
        return this.estado.equals("Vigente");
    }

    @Override
    public String getTableName() {
        return "contrato";
    }

    @Override
    public String toJson() {
        return "";
    }
}
