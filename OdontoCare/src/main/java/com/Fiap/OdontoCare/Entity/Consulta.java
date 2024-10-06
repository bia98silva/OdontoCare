package com.Fiap.OdontoCare.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Entity
@Table(name = "Consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Consulta")
    private Long idConsulta;
    @Column(name = "Data_Consulta", nullable = false)
    private LocalDateTime dataConsulta;
    @Column(name = "Status", nullable = false, length = 50)
    private String status;
    @Column(name = "Detalhes", length = 255)
    private String detalhes;

    @ManyToOne
    @JoinColumn(name = "ID_Paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "ID_Dentista", nullable = false)
    private Dentista dentista;


}
