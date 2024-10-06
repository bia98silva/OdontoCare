package com.Fiap.OdontoCare.Controller;

import com.Fiap.OdontoCare.DTO.PacienteDTO;
import com.Fiap.OdontoCare.Entity.Paciente;
import com.Fiap.OdontoCare.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        return pacienteService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@Valid @RequestBody PacienteDTO pacienteDTO) {
        Paciente savedPaciente = pacienteService.save(pacienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @Valid @RequestBody PacienteDTO pacienteDTO) {
        pacienteDTO.setId(id);
        Paciente updatedPaciente = pacienteService.update(pacienteDTO);
        return ResponseEntity.ok(updatedPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
