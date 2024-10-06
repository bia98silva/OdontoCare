package com.Fiap.OdontoCare.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Table(name = "Paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Paciente")
    private Long id;
    @Column(name = "Nome", nullable = false, length = 30)
    private String nome;
    @Column(name = "Data_Nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "CPF", unique = true, nullable = false, length = 14)
    private String cpf;
    @Column(name = "Carteirinha", unique = true, nullable = false)
    private Long carteirinha;
    @Column(name = "Telefone", nullable = false, length = 20)
    private String telefone;
    @Column(name = "Endereco", nullable = false, length = 200)
    private String endereco;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consultas;

    public void setEmail(@NotBlank @Email(message = "Email inválido") String email) {
    }
}

