package com.cardenasvar.bitacora.repository;

import com.cardenasvar.bitacora.repository.model.AbogadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbogadoRepository extends JpaRepository<AbogadoModel, Long> {

}
