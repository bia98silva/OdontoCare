package com.Fiap.OdontoCare.Controller;

import com.Fiap.OdontoCare.Entity.Dentista;
import com.Fiap.OdontoCare.Service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Fiap.OdontoCare.DTO.DentistaDTO;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @GetMapping
    public List<Dentista> getAllDentistas() {
        return dentistaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> getDentistaById(@PathVariable Long id) {
        return dentistaService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dentista> createDentista(@Valid @RequestBody DentistaDTO dentistaDTO) {
        Dentista savedDentista = dentistaService.save(dentistaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDentista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dentista> updateDentista(@PathVariable Long id, @Valid @RequestBody DentistaDTO dentistaDTO) {
        dentistaDTO.setIdDentista(id);
        Dentista updatedDentista = dentistaService.update(dentistaDTO);
        return ResponseEntity.ok(updatedDentista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDentista(@PathVariable Long id) {
        dentistaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
