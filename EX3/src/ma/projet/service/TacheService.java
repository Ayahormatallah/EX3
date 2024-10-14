
package ma.projet.service;

    

import java.util.ArrayList;
import ma.projet.classes.*;
import ma.projet.dao.IDao;

import java.util.List;
import ma.projet.classes.Projet;

public class TacheService implements IDao<Tache> {

    private IDao<Tache> tacheDao;
    private IDao<Projet> projetDao; // DAO pour l'entité Projet
 
   

    @Override
    public boolean create(Tache o) {
        return tacheDao.create(o);
    }

    @Override
    public Tache getById(int id) {
        return tacheDao.getById(id);
    }

    @Override
    public List<Tache> getAll() {
        return tacheDao.getAll();
    }
    public List<Tache> getTâchesAuDessusDe1000DH() {
        List<Tache> tâchesFiltrées = new ArrayList<>();
         
        List<Projet> projets = projetDao.getAll();
            for (Projet projet : projets) {
            for (Tache tâche : projet.getTâchesRéalisées()) {
                if (tâche.getPrix() > 1000) {
                    tâchesFiltrées.add(tâche);
                }
            }
        }return  tâchesFiltrées ;
}

    
}