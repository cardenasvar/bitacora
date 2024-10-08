package com.cardenasvar.bitacora.controller;

import com.cardenasvar.bitacora.dto.request.EjecutivoRequestDto;
import com.cardenasvar.bitacora.repository.model.EjecutivoModel;
import com.cardenasvar.bitacora.service.EjecutivoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ejecutivo")
@AllArgsConstructor
public class EjecutivoController {

    private EjecutivoService ejecutivoService;

    @PostMapping
    public ResponseEntity<EjecutivoModel> createEjecutivo(@RequestBody EjecutivoRequestDto ejecutivoRequestDto) {
        EjecutivoModel savedEjecutivo = ejecutivoService.save(ejecutivoRequestDto);
        return ResponseEntity.ok(savedEjecutivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EjecutivoModel> updateEjecutivo(
            @PathVariable Long id, @RequestBody EjecutivoRequestDto ejecutivoRequestDto) {
        EjecutivoModel updatedEjecutivo = ejecutivoService.updateEjecutivo(ejecutivoRequestDto, id);
        return ResponseEntity.ok(updatedEjecutivo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEjecutivo(@PathVariable Long id) {
        ejecutivoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EjecutivoModel>> getAllEjecutivos() {
        return ResponseEntity.ok(ejecutivoService.findAll());
    }
}
