/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tache")
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(name = "prix")
    private double prix;

    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet; // Relation 1:n avec Projet

    @OneToMany(mappedBy = "tache", cascade = CascadeType.ALL)
    private List<Employétache> employeTaches; // Relation n:n avec Employe via EmployeTache

    // Constructeurs
    public Tache() {}

    public Tache( String nom, Date dateDebut, Date dateFin ) {
        
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<Employétache> getEmployeTaches() {
        return employeTaches;
    }

    public void setEmployeTaches(List<Employétache> employeTaches) {
        this.employeTaches = employeTaches;
    }

  

     
}
