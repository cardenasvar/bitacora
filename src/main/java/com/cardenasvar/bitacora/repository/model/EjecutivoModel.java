package com.cardenasvar.bitacora.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ejecutivo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EjecutivoModel implements ObservableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ejecutivo_key_gen")
    @SequenceGenerator(name = "ejecutivo_key_gen", sequenceName = "ejecutivo_seq", allocationSize = 1)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private ContratoModel contrato;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getTableName() {
        return "ejecutivo";
    }

    @Override
    public String toJson(){
        return "{ \"id\": " + this.id +
                ", \"nombre\": \"" + this.nombre + "\"" +
                ", \"contrato\": " + this.contrato.getId() + " }";
    }

}
