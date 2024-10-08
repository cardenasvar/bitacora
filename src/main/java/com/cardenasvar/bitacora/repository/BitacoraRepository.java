package com.cardenasvar.bitacora.repository;

import com.cardenasvar.bitacora.repository.model.BitacoraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraRepository extends JpaRepository<BitacoraModel, Long> {

}
