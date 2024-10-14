
package ma.projet.test;
import java.util.List;
import ma.projet.classes.*;
import ma.projet.service.*;
import java.util.Date;
import ma.projet.util.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        // Création de quelques projets et tâches7
        HibernateUtil.getSessionFactory().openSession();
        Projet projet1 = new Projet("Gestion de projet");
       
        
        Date date3 = new Date(2024/01/10);
        Date date4 = new Date(2024/03/12);
        Tache tache1 = new Tache("Conception", new Date(2024/01/12), new Date(2024/01/12));
        Tache tache2 = new Tache("Développement", date3, date4);

        projet1.ajouterTache(tache1);
        projet1.ajouterTache(tache2);

        // Test de la classe Projet
        System.out.println("Test de la classe Projet :");
        System.out.println("Projet : " + projet1.getNom());
        System.out.println("Date de début : " + projet1.getDateDebut());
        System.out.println("Tâches :");
        for (Tache tache : projet1.getTaches()) {
            System.out.println("Tâche: " + tache.getNom() + " | Prix: " + tache.getPrix());
        }
        System.out.println();

        // Création des services
        TacheService tacheService = new TacheService();
        EmployéService employeService = new EmployéService();

        // Test de la classe TacheService
        System.out.println("Test de la classe TacheService :");
        tacheService.create(tache1);
        tacheService.create(tache2);

        List<Tache> tachesFiltrees = tacheService.getTâchesAuDessusDe1000DH();
        System.out.println("Tâches avec prix > 1000 DH :");
        for (Tache tache : tachesFiltrees) {
            System.out.println("Tâche: " + tache.getNom() + " | Prix: " + tache.getPrix());
        }
        System.out.println();

        // Test de la classe EmployeService
        System.out.println("Test de la classe EmployeService :");
        Employé employe1 = new Employé(1, "Aya", "jean", "0123456789");
        Employé employe2 = new Employé(2, "Bob", "Martin", "25876543210");

        employeService.create(employe1);
        employeService.create(employe2);

        List<Employé> employes = employeService.getAll();
        System.out.println("Liste des employés :");
        for (Employé employe : employes) {
            System.out.println("Employé: " + employe.getNom() + " " + employe.getPrenom());
        }
    }
}
