package com.cardenasvar.bitacora.repository;

import com.cardenasvar.bitacora.repository.model.ContactoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<ContactoModel, Long> {

}
