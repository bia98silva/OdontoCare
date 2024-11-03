package com.Fiap.OdontoCare.Repository;

import com.Fiap.OdontoCare.Entity.ClinicaOdontologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaOdontologicaRepository extends JpaRepository<ClinicaOdontologica, Long> {
}
