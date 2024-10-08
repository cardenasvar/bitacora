package com.cardenasvar.bitacora.aspect;

import com.cardenasvar.bitacora.dto.request.EjecutivoRequestDto;
import com.cardenasvar.bitacora.repository.EjecutivoRepository;
import com.cardenasvar.bitacora.repository.model.*;
import com.cardenasvar.bitacora.service.BitacoraService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class BitacoraAspect {

    private final BitacoraService bitacoraService;

    private final EjecutivoRepository ejecutivoRepository;

    @Before("execution(* com.cardenasvar.bitacora.service.EjecutivoService.delete*(..)) && args(id)")
    public void registrarEliminacionEjecutivo(Long id) {
        log.info("Entrando en Bitacora, registrarEliminacionEjecutivo");
        EjecutivoModel antiguoEjecutivoModel = ejecutivoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EjecutivoModel no encontrado"));

        ContratoModel contrato = antiguoEjecutivoModel.getContrato();
        if (contrato != null && contrato.isVigente()) {
            bitacoraService.registrarCambio(antiguoEjecutivoModel, contrato, "ELIMINAR");
        }
    }

    @Pointcut("execution(* com.cardenasvar.bitacora.service.EjecutivoService.updateEjecutivo(..)) && args(ejecutivoRequestDto, idEjecutivo)")
    public void updateEjecutivoOperation(EjecutivoRequestDto ejecutivoRequestDto, Long idEjecutivo) {
    }

    @Before("updateEjecutivoOperation(ejecutivoRequestDto, idEjecutivo)")
    public void registrarEstadoAntiguoEjecutivo(EjecutivoRequestDto ejecutivoRequestDto, Long idEjecutivo) {
        log.info("Entrando en Bitacora, registrarEstadoAntiguoEjecutivo");
        EjecutivoModel antiguoEjecutivoModel = ejecutivoRepository.findById(idEjecutivo)
                .orElseThrow(() -> new EntityNotFoundException("EjecutivoModel no encontrado"));

        ContratoModel contrato = antiguoEjecutivoModel.getContrato();
        if (contrato != null && contrato.isVigente()) {
            bitacoraService.registrarCambio(antiguoEjecutivoModel, contrato, "MODIFICAR");
        }
    }

}
