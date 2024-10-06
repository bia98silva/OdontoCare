package com.Fiap.OdontoCare.Service;

import com.Fiap.OdontoCare.DTO.PacienteDTO;
import com.Fiap.OdontoCare.Entity.Paciente;
import com.Fiap.OdontoCare.Exception.ResourceNotFoundException;
import com.Fiap.OdontoCare.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(Long id) {
        return Optional.ofNullable(pacienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + id)));
    }

    public Paciente save(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.getNome());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setCarteirinha(pacienteDTO.getCarteirinha());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setEndereco(pacienteDTO.getEndereco());
        return pacienteRepository.save(paciente);
    }

    public Paciente update(PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteRepository.findById(pacienteDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + pacienteDTO.getId()));
        paciente.setNome(pacienteDTO.getNome());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setCarteirinha(pacienteDTO.getCarteirinha());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setEndereco(pacienteDTO.getEndereco());
        return pacienteRepository.save(paciente);
    }

    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }
}
