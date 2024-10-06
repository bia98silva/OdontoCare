package com.Fiap.OdontoCare.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class HistoricoConsultasDTO {

    private Long id;

    @NotNull(message = "A consulta não pode ser nula.")
    private Long consultaId;

    @NotNull(message = "A data de atendimento não pode ser nula.")
    private LocalDateTime dataAtendimento;

    @NotBlank(message = "O motivo da consulta não pode estar vazio.")
    @Size(max = 300, message = "O motivo da consulta deve ter no máximo 300 caracteres.")
    private String motivoConsulta;

    @Size(max = 300, message = "As observações devem ter no máximo 300 caracteres.")
    private String observacoes;


}
