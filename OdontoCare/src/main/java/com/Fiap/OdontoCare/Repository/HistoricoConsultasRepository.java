package com.Fiap.OdontoCare.Repository;

import com.Fiap.OdontoCare.Entity.HistoricoConsultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoConsultasRepository extends JpaRepository<HistoricoConsultas, Long> {
}
