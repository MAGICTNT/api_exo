package fr.maxime.api_exo.service;

import fr.maxime.api_exo.entity.Voiture;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class VoitureService {
    private final Service service;

    @Inject
    public VoitureService(Service service) {
        this.service = service;
    }

    public Voiture save(int id, String marque, String anneeFabrication, String couleur) {
        Voiture voiture = new Voiture(id, marque, anneeFabrication, couleur);
        service.addVoiture(voiture);
        return voiture;
    }

    public Voiture update(int id, String marque, String anneeFabrication, String couleur) {
        Voiture updatedVoiture = new Voiture(id, marque, anneeFabrication, couleur);
        service.updateVoiture(id, updatedVoiture);
        return updatedVoiture;
    }

    public Voiture getById(int id) {
        return service.getVoitureById(id);
    }

    public List<Voiture> getAll() {
        return service.getVoitureList();
    }

    public void deleteById(int id) {
        service.removeVoiture(id);
    }
}
