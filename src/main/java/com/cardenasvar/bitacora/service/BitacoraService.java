package com.cardenasvar.bitacora.service;

import com.cardenasvar.bitacora.repository.BitacoraRepository;
import com.cardenasvar.bitacora.repository.model.BitacoraModel;
import com.cardenasvar.bitacora.repository.model.ContratoModel;
import com.cardenasvar.bitacora.repository.model.ObservableModel;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BitacoraService {

    private final BitacoraRepository bitacoraRepository;

    public void registrarCambio(ObservableModel model, ContratoModel contratoModel, String accion) {
        BitacoraModel bitacoraModel = BitacoraModel.builder()
                .contrato(contratoModel)
                .fecha(LocalDateTime.now())
                .tabla(model.getTableName())
                .contenido(model.toJson())
                .accion(accion) // "MODIFICAR" o "ELIMINAR"
                .build();
        bitacoraRepository.save(bitacoraModel);
    }
}
