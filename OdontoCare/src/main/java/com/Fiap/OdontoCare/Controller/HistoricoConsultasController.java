package com.Fiap.OdontoCare.Controller;

import com.Fiap.OdontoCare.DTO.HistoricoConsultasDTO;
import com.Fiap.OdontoCare.Entity.HistoricoConsultas;
import com.Fiap.OdontoCare.Service.HistoricoConsultasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/historico-consultas")
public class HistoricoConsultasController {

    @Autowired
    private HistoricoConsultasService historicoConsultasService;

    @GetMapping
    public List<HistoricoConsultas> getAllHistoricoConsultas() {
        return historicoConsultasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoConsultas> getHistoricoConsultaById(@PathVariable Long id) {
        return historicoConsultasService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistoricoConsultas> createHistoricoConsulta(@Valid @RequestBody HistoricoConsultasDTO historicoConsultaDTO) {
        HistoricoConsultas savedHistoricoConsulta = historicoConsultasService.save(historicoConsultaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHistoricoConsulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoConsultas> updateHistoricoConsulta(@PathVariable Long id, @Valid @RequestBody HistoricoConsultasDTO historicoConsultaDTO) {
        historicoConsultaDTO.setId(id);
        HistoricoConsultas updatedHistoricoConsulta = historicoConsultasService.save(historicoConsultaDTO);
        return ResponseEntity.ok(updatedHistoricoConsulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoricoConsulta(@PathVariable Long id) {
        historicoConsultasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
