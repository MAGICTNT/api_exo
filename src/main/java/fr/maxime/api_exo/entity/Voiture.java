package fr.maxime.api_exo.entity;

import java.time.LocalDate;

public class Voiture {
    private int idVoiture;
    private String marqueVoiture;
    private String anneeFabrication;
    private String couleur;

    public Voiture(){}

    public Voiture(int idVoiture, String marqueVoiture, String anneeFabrication, String couleur) {
        this.idVoiture = idVoiture;
        this.marqueVoiture = marqueVoiture;
        this.anneeFabrication = anneeFabrication;
        this.couleur = couleur;
    }

    public int getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getMarqueVoiture() {
        return marqueVoiture;
    }

    public void setMarqueVoiture(String marqueVoiture) {
        this.marqueVoiture = marqueVoiture;
    }

    public String getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(String anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
