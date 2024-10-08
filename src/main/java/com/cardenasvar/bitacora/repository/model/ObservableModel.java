package com.cardenasvar.bitacora.repository.model;

public interface ObservableModel {

    Long getId();

    String getTableName();

    String toJson();
}
