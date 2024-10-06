package com.Fiap.OdontoCare.Service;

import com.Fiap.OdontoCare.DTO.HistoricoConsultasDTO;
import com.Fiap.OdontoCare.Entity.HistoricoConsultas;
import com.Fiap.OdontoCare.Exception.ResourceNotFoundException;
import com.Fiap.OdontoCare.Repository.HistoricoConsultasRepository;
import com.Fiap.OdontoCare.Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoConsultasService {

    @Autowired
    private HistoricoConsultasRepository historicoConsultasRepository;

    @Autowired
    private ConsultaRepository consultaRepository; // Para buscar a consulta

    public List<HistoricoConsultas> findAll() {
        return historicoConsultasRepository.findAll();
    }

    public Optional<HistoricoConsultas> findById(Long id) {
        return Optional.ofNullable(historicoConsultasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Histórico de consultas não encontrado com ID: " + id)));
    }

    public HistoricoConsultas save(HistoricoConsultasDTO historicoConsultaDTO) {
        HistoricoConsultas historicoConsulta = new HistoricoConsultas();
        historicoConsulta.setConsulta(consultaRepository.findById(historicoConsultaDTO.getConsultaId())
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada.")));
        historicoConsulta.setDataAtendimento(historicoConsultaDTO.getDataAtendimento());
        historicoConsulta.setMotivoConsulta(historicoConsultaDTO.getMotivoConsulta());
        historicoConsulta.setObservacoes(historicoConsultaDTO.getObservacoes());
        return historicoConsultasRepository.save(historicoConsulta);
    }

    public void deleteById(Long id) {
        historicoConsultasRepository.deleteById(id);
    }
}
