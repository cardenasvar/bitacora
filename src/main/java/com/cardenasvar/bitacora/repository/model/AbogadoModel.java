package com.cardenasvar.bitacora.repository.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "abogado")
@Data
public class AbogadoModel implements ObservableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abogado_key_gen")
    @SequenceGenerator(name = "abogado_key_gen", sequenceName = "abogado_seq", allocationSize = 1)
    private Long id;

    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private ContratoModel contrato;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getTableName() {
        return "abogado";
    }

    @Override
    public String toJson(){
        return "{ \"id\": " + this.id +
                ", \"nombre\": \"" + this.nombre + "\"" +
                ", \"apellido\": \"" + this.nombre + "\"" +
                ", \"contrato\": " + this.contrato.toJson() + " }";
    }

}
