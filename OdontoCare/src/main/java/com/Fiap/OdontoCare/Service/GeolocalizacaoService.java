package com.Fiap.OdontoCare.Service;

import com.Fiap.OdontoCare.DTO.GeolocalizacaoDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class GeolocalizacaoService {

    private static final String NOMINATIM_URL = "https://nominatim.openstreetmap.org/search?format=json&q=";

    public Optional<GeolocalizacaoDTO> getCoordinates(String address) {
        String url = NOMINATIM_URL + address.replace(" ", "+");

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response);

            if (jsonNode.isArray() && jsonNode.size() > 0) {
                JsonNode firstResult = jsonNode.get(0);
                double latitude = firstResult.get("lat").asDouble();
                double longitude = firstResult.get("lon").asDouble();
                return Optional.of(new GeolocalizacaoDTO(latitude, longitude));
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return Optional.empty(); 
    }
}
