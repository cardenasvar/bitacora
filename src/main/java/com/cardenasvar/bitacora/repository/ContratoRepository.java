package com.cardenasvar.bitacora.repository;

import com.cardenasvar.bitacora.repository.model.ContratoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<ContratoModel, Long> {

}
