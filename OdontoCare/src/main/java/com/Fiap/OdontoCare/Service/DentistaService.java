package com.Fiap.OdontoCare.Service;

import com.Fiap.OdontoCare.DTO.DentistaDTO;
import com.Fiap.OdontoCare.Entity.Dentista;
import com.Fiap.OdontoCare.Exception.ResourceNotFoundException;
import com.Fiap.OdontoCare.Repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository dentistaRepository;

    public List<Dentista> findAll() {
        return dentistaRepository.findAll();
    }

    public Optional<Dentista> findById(Long id) {
        return Optional.ofNullable(dentistaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dentista não encontrado com ID: " + id)));
    }

    public Dentista save(DentistaDTO dentistaDTO) {
        Dentista dentista = new Dentista();
        dentista.setIdDentista(dentistaDTO.getIdDentista()); // Definindo o ID do dentista se necessário
        dentista.setNome(dentistaDTO.getNome());
        dentista.setCro(dentistaDTO.getCro()); // Inclua o mapeamento do CRO
        dentista.setEspecialidade(dentistaDTO.getEspecialidade());
        dentista.setTelefone(dentistaDTO.getTelefone());
        dentista.setEmail(dentistaDTO.getEmail());
        // Se você tiver um relacionamento com consultas, você também deve mapeá-lo aqui
        return dentistaRepository.save(dentista);
    }

    public Dentista update(DentistaDTO dentistaDTO) {
        Dentista dentista = dentistaRepository.findById(dentistaDTO.getIdDentista())
                .orElseThrow(() -> new ResourceNotFoundException("Dentista não encontrado com ID: " + dentistaDTO.getIdDentista()));
        dentista.setNome(dentistaDTO.getNome());
        dentista.setCro(dentistaDTO.getCro()); // Inclua o mapeamento do CRO
        dentista.setEspecialidade(dentistaDTO.getEspecialidade());
        dentista.setTelefone(dentistaDTO.getTelefone());
        dentista.setEmail(dentistaDTO.getEmail());
        return dentistaRepository.save(dentista);
    }

    public void deleteById(Long id) {
        dentistaRepository.deleteById(id);
    }
}
