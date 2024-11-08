package com.Fiap.OdontoCare.Service;

import com.Fiap.OdontoCare.DTO.ConsultaDTO;
import com.Fiap.OdontoCare.Entity.Consulta;
import com.Fiap.OdontoCare.Entity.Paciente;
import com.Fiap.OdontoCare.Entity.Dentista;
import com.Fiap.OdontoCare.Exception.ResourceNotFoundException;
import com.Fiap.OdontoCare.Repository.ConsultaRepository;
import com.Fiap.OdontoCare.Repository.PacienteRepository;
import com.Fiap.OdontoCare.Repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DentistaRepository dentistaRepository;

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> findById(Long id) {
        return Optional.ofNullable(consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id)));
    }

    public Consulta save(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta();
        consulta.setDataConsulta(consultaDTO.getDataConsulta());
        consulta.setStatus(consultaDTO.getStatus());
        consulta.setDetalhes(consultaDTO.getDetalhes());

        // Buscar paciente
        Paciente paciente = pacienteRepository.findById(consultaDTO.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + consultaDTO.getPacienteId()));
        consulta.setPaciente(paciente);

        // Buscar dentista
        Dentista dentista = dentistaRepository.findById(consultaDTO.getDentistaId())
                .orElseThrow(() -> new ResourceNotFoundException("Dentista não encontrado com ID: " + consultaDTO.getDentistaId()));
        consulta.setDentista(dentista); // Supondo que você tenha um método setDentista na classe Consulta

        return consultaRepository.save(consulta);
    }

    public Consulta update(ConsultaDTO consultaDTO) {
        Consulta consulta = consultaRepository.findById(consultaDTO.getIdConsulta())
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + consultaDTO.getIdConsulta()));

        consulta.setDataConsulta(consultaDTO.getDataConsulta());
        consulta.setStatus(consultaDTO.getStatus());
        consulta.setDetalhes(consultaDTO.getDetalhes());

        if (consultaDTO.getPacienteId() != null) {
            Paciente paciente = pacienteRepository.findById(consultaDTO.getPacienteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + consultaDTO.getPacienteId()));
            consulta.setPaciente(paciente);
        }

        if (consultaDTO.getDentistaId() != null) {
            Dentista dentista = dentistaRepository.findById(consultaDTO.getDentistaId())
                    .orElseThrow(() -> new ResourceNotFoundException("Dentista não encontrado com ID: " + consultaDTO.getDentistaId()));
            consulta.setDentista(dentista); // Atualizando o dentista
        }

        return consultaRepository.save(consulta);
    }

    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }
}
