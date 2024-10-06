package com.Fiap.OdontoCare.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "HistoricoConsulta")
public class HistoricoConsultas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Historico")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Consulta", nullable = false)
    private Consulta consulta;

    @Column(name = "Data_Atendimento", nullable = false)
    private LocalDateTime dataAtendimento;

    @Column(name = "Motivo_Consulta", nullable = false, length = 300)
    private String motivoConsulta;

    @Column(name = "Observacoes", length = 300)
    private String observacoes;
}
