package com.cardenasvar.bitacora.service;

import com.cardenasvar.bitacora.dto.request.EjecutivoRequestDto;
import com.cardenasvar.bitacora.repository.ContratoRepository;
import com.cardenasvar.bitacora.repository.EjecutivoRepository;
import com.cardenasvar.bitacora.repository.model.ContratoModel;
import com.cardenasvar.bitacora.repository.model.EjecutivoModel;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
@Slf4j
public class EjecutivoService {

    @Autowired
    private EjecutivoRepository ejecutivoRepository;

    @Autowired
    private ContratoRepository contratoRepository;

    public EjecutivoModel save(EjecutivoRequestDto ejecutivoRequestDto) {
        log.info("Entrando en save, ejecutivoRequestDto: {}", ejecutivoRequestDto);

        ContratoModel contratoModel = contratoRepository.findById(ejecutivoRequestDto.getIdContrato())
                .orElseThrow(() -> new EntityNotFoundException("Contrato no encontrado"));
        EjecutivoModel ejecutivo = EjecutivoModel.builder()
                .contrato(contratoModel)
                .nombre(ejecutivoRequestDto.getNombre())
                .build();
        return ejecutivoRepository.save(ejecutivo);
    }

    public void delete(Long id) {
        log.info("Entrando en deleteEjecutivo, id: {}", id);
        EjecutivoModel ejecutivo = ejecutivoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ejecutivo no encontrado"));
        ejecutivoRepository.delete(ejecutivo);
    }

    public EjecutivoModel updateEjecutivo(EjecutivoRequestDto ejecutivoRequestDto, Long idEjecutivo) {
        log.info("Entrando en updateEjecutivo, ejecutivoRequestDto: {}, idEjecutivo: {}", ejecutivoRequestDto, idEjecutivo);
        ContratoModel contratoModel = contratoRepository.findById(ejecutivoRequestDto.getIdContrato())
                .orElseThrow(() -> new EntityNotFoundException("Contrato no encontrado"));
        EjecutivoModel ejecutivo = EjecutivoModel.builder()
                .id(idEjecutivo)
                .contrato(contratoModel)
                .nombre(ejecutivoRequestDto.getNombre())
                .build();
        return ejecutivoRepository.save(ejecutivo);
    }

    public List<EjecutivoModel> findAll() {
        return ejecutivoRepository.findAll();
    }
}
