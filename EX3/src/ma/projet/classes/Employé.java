

package ma.projet.classes;
import javax.persistence.*;
import java.util.List;
import ma.projet.classes.Employétache;
@Entity
@Table(name = "employe")
public class Employé {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "employe")
    private List<Employétache> employeTaches;

    @OneToOne(mappedBy = "chefDeProjet")
    private Projet projet;  // Relation 1:1 avec Projet

    // Constructeurs
    public Employé() {}

    public Employé(int id, String nom, String prenom, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Employétache> getEmployeTaches() {
        return employeTaches;
    }

    public void setEmployeTaches(List<Employétache> employeTaches) {
        this.employeTaches = employeTaches;
    }

    public List<Projet> getProjet() {
        return (List<Projet>) projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    

    

    public Iterable<Tache> getTaches() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
