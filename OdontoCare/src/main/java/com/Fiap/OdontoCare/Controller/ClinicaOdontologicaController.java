package com.Fiap.OdontoCare.Controller;

import com.Fiap.OdontoCare.DTO.ClinicaOdontologicaDTO;
import com.Fiap.OdontoCare.DTO.GeolocalizacaoDTO;
import com.Fiap.OdontoCare.Entity.ClinicaOdontologica;
import com.Fiap.OdontoCare.Exception.ResourceNotFoundException;
import com.Fiap.OdontoCare.Repository.ClinicaOdontologicaRepository;
import com.Fiap.OdontoCare.Service.GeolocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/clinicas")
public class ClinicaOdontologicaController {

    @Autowired
    private ClinicaOdontologicaRepository clinicaOdontologicaRepository;

    @Autowired
    private GeolocalizacaoService geolocalizacaoService;

    @GetMapping("/proximas/{endereco}")
    public CollectionModel<EntityModel<ClinicaOdontologica>> getClinicasProximas(@PathVariable String endereco) {
        Optional<GeolocalizacaoDTO> coordenadas = geolocalizacaoService.getCoordinates(endereco);

        if (coordenadas.isEmpty()) {
            return CollectionModel.empty();
        }

        double latitude = coordenadas.get().getLatitude();
        double longitude = coordenadas.get().getLongitude();

        List<EntityModel<ClinicaOdontologica>> clinicas = clinicaOdontologicaRepository.findAll().stream()
                .filter(clinica -> isNearby(clinica, latitude, longitude))
                .map(clinica -> {
                    EntityModel<ClinicaOdontologica> model = EntityModel.of(clinica);
                    model.add(linkTo(methodOn(ClinicaOdontologicaController.class).getClinica(clinica.getId())).withSelfRel());
                    return model;
                })
                .collect(Collectors.toList());

        return CollectionModel.of(clinicas, linkTo(methodOn(ClinicaOdontologicaController.class).getAllClinicas()).withSelfRel());
    }

    private boolean isNearby(ClinicaOdontologica clinica, double lat, double lon) {
        double clinicaLat = clinica.getLatitude();
        double clinicaLon = clinica.getLongitude();
        double distance = Math.sqrt(Math.pow((clinicaLat - lat), 2) + Math.pow((clinicaLon - lon), 2));
        return distance < 0.1;
    }

    @GetMapping("/{id}")
    public EntityModel<ClinicaOdontologica> getClinica(@PathVariable Long id) {
        ClinicaOdontologica clinica = clinicaOdontologicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clínica não encontrada"));

        return EntityModel.of(clinica,
                linkTo(methodOn(ClinicaOdontologicaController.class).getClinica(id)).withSelfRel(),
                linkTo(methodOn(ClinicaOdontologicaController.class).getAllClinicas()).withRel("todas-clinicas"));
    }

    @GetMapping
    public CollectionModel<EntityModel<ClinicaOdontologica>> getAllClinicas() {
        List<EntityModel<ClinicaOdontologica>> clinicas = clinicaOdontologicaRepository.findAll().stream()
                .map(clinica -> EntityModel.of(clinica,
                        linkTo(methodOn(ClinicaOdontologicaController.class).getClinica(clinica.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(clinicas, linkTo(methodOn(ClinicaOdontologicaController.class).getAllClinicas()).withSelfRel());
    }

    @PostMapping
    public ResponseEntity<?> createClinica(@RequestBody ClinicaOdontologicaDTO clinicaDTO) {
        ClinicaOdontologica clinica = new ClinicaOdontologica();
        clinica.setNome(clinicaDTO.getNome());
        clinica.setEndereco(clinicaDTO.getEndereco());
        clinica.setTelefone(clinicaDTO.getTelefone());

        if (clinicaDTO.getGeolocalizacao() != null) {
            clinica.setLatitude(clinicaDTO.getGeolocalizacao().getLatitude());
            clinica.setLongitude(clinicaDTO.getGeolocalizacao().getLongitude());
        }

        ClinicaOdontologica savedClinica = clinicaOdontologicaRepository.save(clinica);
        EntityModel<ClinicaOdontologica> model = EntityModel.of(savedClinica,
                linkTo(methodOn(ClinicaOdontologicaController.class).getClinica(savedClinica.getId())).withSelfRel(),
                linkTo(methodOn(ClinicaOdontologicaController.class).getAllClinicas()).withRel("todas-clinicas"));

        return ResponseEntity
                .created(URI.create(model.getRequiredLink(IanaLinkRelations.SELF).toUri().toString()))
                .body(model);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createClinicasBatch(@RequestBody List<ClinicaOdontologicaDTO> clinicasDTO) {
        List<ClinicaOdontologica> clinicas = clinicasDTO.stream().map(clinicaDTO -> {
            ClinicaOdontologica clinica = new ClinicaOdontologica();
            clinica.setNome(clinicaDTO.getNome());
            clinica.setEndereco(clinicaDTO.getEndereco());
            clinica.setTelefone(clinicaDTO.getTelefone());

            if (clinicaDTO.getGeolocalizacao() != null) {
                clinica.setLatitude(clinicaDTO.getGeolocalizacao().getLatitude());
                clinica.setLongitude(clinicaDTO.getGeolocalizacao().getLongitude());
            }
            return clinica;
        }).collect(Collectors.toList());

        List<ClinicaOdontologica> savedClinicas = clinicaOdontologicaRepository.saveAll(clinicas);

        List<EntityModel<ClinicaOdontologica>> models = savedClinicas.stream()
                .map(savedClinica -> EntityModel.of(savedClinica,
                        linkTo(methodOn(ClinicaOdontologicaController.class).getClinica(savedClinica.getId())).withSelfRel(),
                        linkTo(methodOn(ClinicaOdontologicaController.class).getAllClinicas()).withRel("todas-clinicas")))
                .collect(Collectors.toList());

        return ResponseEntity
                .created(URI.create(linkTo(methodOn(ClinicaOdontologicaController.class).getAllClinicas()).toUri().toString()))
                .body(CollectionModel.of(models));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClinica(@PathVariable Long id, @RequestBody ClinicaOdontologicaDTO clinicaDTO) {
        ClinicaOdontologica clinica = clinicaOdontologicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clínica não encontrada"));


        clinica.setNome(clinicaDTO.getNome());
        clinica.setEndereco(clinicaDTO.getEndereco());
        clinica.setTelefone(clinicaDTO.getTelefone());

        if (clinicaDTO.getGeolocalizacao() != null) {
            clinica.setLatitude(clinicaDTO.getGeolocalizacao().getLatitude());
            clinica.setLongitude(clinicaDTO.getGeolocalizacao().getLongitude());
        }

        ClinicaOdontologica updatedClinica = clinicaOdontologicaRepository.save(clinica);
        EntityModel<ClinicaOdontologica> model = EntityModel.of(updatedClinica,
                linkTo(methodOn(ClinicaOdontologicaController.class).getClinica(updatedClinica.getId())).withSelfRel(),
                linkTo(methodOn(ClinicaOdontologicaController.class).getAllClinicas()).withRel("todas-clinicas"));

        return ResponseEntity.ok(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClinica(@PathVariable Long id) {
        if (!clinicaOdontologicaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Clínica não encontrada");
        }
        clinicaOdontologicaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
