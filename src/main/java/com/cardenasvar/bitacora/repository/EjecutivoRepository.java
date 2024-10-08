package com.cardenasvar.bitacora.repository;

import com.cardenasvar.bitacora.repository.model.EjecutivoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjecutivoRepository extends JpaRepository<EjecutivoModel, Long> {

}
