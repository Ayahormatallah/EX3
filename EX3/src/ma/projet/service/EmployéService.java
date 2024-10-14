package ma.projet.service;

import ma.projet.classes.Employé;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;

import java.util.ArrayList;
import java.util.List;
import ma.projet.dao.IDao;

public class EmployéService implements IDao<Employé> {
    private List<Employé> employés = new ArrayList<>(); // Liste pour stocker les employés

    @Override
    public boolean create(Employé employé) {
        return employés.add(employé); // Ajoute un employé à la liste
    }

    @Override
    public Employé getById(int id) {
        for (Employé employé : employés) {
            if (employé.getId() == id) {
                return employé; // Retourne l'employé si trouvé
            }
        }
        return null; // Retourne null si l'employé n'est pas trouvé
    }

    @Override
    public List<Employé> getAll() {
        return new ArrayList<>(employés); // Retourne une copie de la liste des employés
    }

    // Méthode pour afficher la liste des tâches réalisées par un employé
    public List<Tache> getTâchesRéalisées(Employé employé) {
        return (List<Tache>) employé.getTaches(); // Supposant que les tâches sont définies dans l'objet Employé
    }

    // Méthode pour afficher la liste des projets gérés par un employé
    public List<Projet> getProjetsGérés(Employé employé) {
        return (List<Projet>) employé.getProjet(); // Supposant que les projets sont définis dans l'objet Employé
    }

    // Méthode pour afficher les tâches réalisées par un employé
    public void afficherTâchesRéalisées(Employé employé) {
        System.out.println("Tâches réalisées par " + employé.getNom() + " " + employé.getPrenom() + ":");
        for (Tache tache : employé.getTaches()) {
            System.out.println("Num: " + tache.getId() + ", Nom: " + tache.getNom() +
                ", Date Début Réelle: " + tache.getDateDebut() +
                ", Date Fin Réelle: " + tache.getDateFin());
        }
    }

    // Méthode pour afficher les projets gérés par un employé
    public void afficherProjetsGérés(Employé employé) {
        System.out.println("Projets gérés par " + employé.getNom() + " " + employé.getPrenom() + ":");
        for (Projet projet : employé.getProjet()) {
            System.out.println( "Nom: " + projet.getNom());
        }
    }
}
