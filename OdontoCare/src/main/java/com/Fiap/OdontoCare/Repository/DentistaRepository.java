package com.Fiap.OdontoCare.Repository;

import com.Fiap.OdontoCare.Entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {
}
