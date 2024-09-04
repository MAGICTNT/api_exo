package fr.maxime.api_exo.service;

import fr.maxime.api_exo.entity.Voiture;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Service {
    private List<Voiture> voitureList;

    public Service() {
        voitureList = new ArrayList<>();
        voitureList.add(new Voiture(0, "marque 1", "11/12/2024", "rouge"));
        voitureList.add(new Voiture(1, "marque 2", "11/12/2024", "vert"));
        voitureList.add(new Voiture(2, "marque 3", "11/12/2024", "jaune"));
        voitureList.add(new Voiture(3, "marque 4", "11/12/2024", "orange"));
        voitureList.add(new Voiture(4, "marque 5", "11/12/2024", "bleu"));
        voitureList.add(new Voiture(5, "marque 6", "11/12/2024", "noir"));
    }

    public List<Voiture> getVoitureList() {
        return voitureList;
    }

    public void setVoitureList(List<Voiture> voitureList) {
        this.voitureList = voitureList;
    }

    public Voiture getVoitureById(int idVoiture) {
        return voitureList.stream()
                .filter(voiture -> voiture.getIdVoiture() == idVoiture)
                .findFirst()
                .orElse(null);
    }

    public Voiture addVoiture(Voiture voiture) {
        voitureList.add(voiture);
        return voiture;
    }

    public Voiture updateVoiture(int idVoiture, Voiture updatedVoiture) {
        Voiture voiture = getVoitureById(idVoiture);
        if (voiture != null) {
            voiture.setMarqueVoiture(updatedVoiture.getMarqueVoiture());
            voiture.setAnneeFabrication(updatedVoiture.getAnneeFabrication());
            voiture.setCouleur(updatedVoiture.getCouleur());
        }
        return voiture;
    }

    public void removeVoiture(int idVoiture) {
        voitureList.removeIf(voiture -> voiture.getIdVoiture() == idVoiture);
    }
}
