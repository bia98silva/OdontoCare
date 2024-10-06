package com.Fiap.OdontoCare.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Dentista")
    private Long idDentista;
    @Column(name = "Nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "CRO", unique = true, nullable = false, length = 20)
    private String cro;
    @Column(name = "Especialidade", nullable = false, length = 50)
    private String especialidade;
    @Column(name = "Telefone", nullable = false, length = 20)
    private String telefone;
    @Column(name = "Email")
    private String email;

    @OneToMany(mappedBy = "dentista", cascade = CascadeType.ALL)
    private List<Consulta> consultas;
}
