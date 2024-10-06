package com.Fiap.OdontoCare.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteDTO {

    private Long id;

    @NotBlank
    @Size(max = 30)
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    @Size(max = 14)
    private String cpf;

    @NotNull
    private Long carteirinha;

    @NotBlank
    @Size(max = 20)
    private String telefone;

    @NotBlank
    @Email(message = "Email inválido")
    private String email;

    @NotBlank
    @Size(max = 200)
    private String endereco;
}
