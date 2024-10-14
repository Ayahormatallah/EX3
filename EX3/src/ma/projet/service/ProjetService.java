package ma.projet.service;

import ma.projet.classes.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.dao.IDao;


public class ProjetService implements IDao<Projet> {
    private List<Projet> projets = new ArrayList<>(); // Liste pour stocker les projets

    @Override
    public boolean create(Projet projet) {
        return projets.add(projet); // Ajoute un projet à la liste
    }

    @Override
    public Projet getById(int id) {
        for (Projet projet : projets) {
            if (projet.getId() == id) {
                return projet; // Retourne le projet si trouvé
            }
        }
        return null; // Retourne null si le projet n'est pas trouvé
    }

    @Override
    public List<Projet> getAll() {
        return new ArrayList<>(projets); // Retourne une copie de la liste des projets
    }

    // Méthode pour afficher la liste des tâches réalisées dans un projet
    public void afficherTâchesRéalisées(Projet projet) {
        System.out.println("Projet : " + projet.getId() + ", Nom : " + projet.getNom() + 
                           ", Date début : " + projet.getDateDebut());
        System.out.println("Liste des tâches :");
        System.out.println("Num | Nom | Date Début Réelle | Date Fin Réelle");
        for (Tache tâche : projet.getTâchesRéalisées()) {
            System.out.println(tâche.getId() + " | " + tâche.getNom() + " | " +
                               tâche.getDateDebut() + " | " + tâche.getDateFin());
        }
    }

    // Méthode pour afficher les tâches dont le prix est supérieur à 1000 DH
    public List<Tache> getTâchesAuDessusDe1000DH() {
        List<Tache> tâchesFiltrées = new ArrayList<>();
        for (Projet projet : projets) {
            for (Tache tâche : projet.getTâchesRéalisées()) {
                if (tâche.getPrix() > 1000) {
                    tâchesFiltrées.add(tâche);
                }
            }
        }
        return tâchesFiltrées; // Retourne la liste des tâches filtrées
    }

    // Méthode pour afficher les tâches réalisées entre deux dates
    public List<Tache> getTâchesRéaliséesEntreDates(Date dateDébut, Date dateFin) {
        List<Tache> tâchesFiltrées = new ArrayList<>();
        for (Projet projet : projets) {
            for (Tache tâche : projet.getTâchesRéalisées()) {
                if (tâche.getDateDebut().compareTo(dateDébut) >= 0 &&
                        0 > tâche.getDateFin().compareTo(dateFin)) {
                    tâchesFiltrées.add(tâche);
                }
            }
        }
        return tâchesFiltrées; // Retourne la liste des tâches filtrées
    }
     public List<Tache> getTachesPlanifiees(int projetId) {
        // Récupérer le projet par son ID
        Projet projet = getById(projetId);
        
        if (projet == null) {
            System.out.println("Projet introuvable");
            return null;
        }
        
        List<Tache> tachesPlanifiees = new ArrayList<>();
        
        // Parcourir les tâches du projet et récupérer les tâches planifiées
        for (Tache tache : projet.getTaches()) {
            if (tache.getDateFin() == null) {  // La tâche est planifiée si sa date de fin est encore nulle (non terminée)
                tachesPlanifiees.add(tache);
            }
        }
        
        // Afficher les tâches planifiées
        if (tachesPlanifiees.isEmpty()) {
            System.out.println("Aucune tâche planifiée pour ce projet.");
        } else {
            System.out.println("Liste des tâches planifiées pour le projet : " + projet.getNom());
            for (Tache tache : tachesPlanifiees) {
                System.out.println("Tâche: " + tache.getNom() + " | Date début prévue: " + tache.getDateDebut());
            }
        }
          return tachesPlanifiees;
}}