
package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    List<Tache> tâchesRéalisées;
    private  List <Tache> taches;

    public Projet(String nom, Date dateDebut, Date dateFin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    // Relation ManyToOne pour indiquer qu'un projet a un seul chef de projet
    @ManyToOne
    @JoinColumn(name = "chef_id")
    private Employé chefDeProjet;

    public Projet(String nom) {
        this.nom = nom;
    }
    

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Employé getChefDeProjet() {
        return chefDeProjet;
    }

    public void setChefDeProjet(Employé chefDeProjet) {
        this.chefDeProjet = chefDeProjet;
    }
 public List<Tache> getTâchesRéalisées() {
        
        return tâchesRéalisées;
   
   
}
  public List<Tache> getTaches() {
        return taches;
    }
  public void ajouterTache(Tache tache) {
        if (tache != null) {
            taches.add(tache);
            System.out.println("Tâche ajoutée : " + tache.getNom());
        } else {
            System.out.println("Erreur : Tâche ne peut pas être nulle.");
        }
    }

    }

