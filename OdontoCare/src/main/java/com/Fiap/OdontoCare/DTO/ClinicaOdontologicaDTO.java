package com.Fiap.OdontoCare.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClinicaOdontologicaDTO {

    private String nome;
    private String endereco;
    private String telefone;
    private GeolocalizacaoDTO geolocalizacao;
}
