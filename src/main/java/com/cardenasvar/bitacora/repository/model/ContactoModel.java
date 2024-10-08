package com.cardenasvar.bitacora.repository.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "contacto")
@Data
public class ContactoModel implements ObservableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacto_key_gen")
    @SequenceGenerator(name = "contacto_key_gen", sequenceName = "contacto_seq", allocationSize = 1)
    private Long id;

    private String nombre;
    private String apellido;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private ContratoModel contrato;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getTableName() {
        return "contacto";
    }

    @Override
    public String toJson(){
        return "{ \"id\": " + this.id +
                ", \"nombre\": \"" + this.nombre + "\"" +
                ", \"apellido\": \"" + this.apellido + "\"" +
                ", \"tipo\": \"" + this.tipo + "\"" +
                ", \"contrato\": " + this.contrato.getId() + " }";
    }

}
