/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;


import ma.projet.classes.Employétache;
import ma.projet.dao.IDao;

import java.util.List;

public class EmployétacheService implements IDao<Employétache> {

    private IDao<Employétache> employeTacheDao; // DAO pour l'entité EmployeTache

    public EmployétacheService(IDao<Employétache> employétacheDao) {
        this.employeTacheDao = employeTacheDao;
    }

    @Override
    public boolean create(Employétache o) {
        return employeTacheDao.create(o);
    }

    @Override
    public Employétache getById(int id) {
        return employeTacheDao.getById(id);
    }

    @Override
    public List<Employétache> getAll() {
        return employeTacheDao.getAll();
    }

    // Ajoutez d'autres méthodes spécifiques si nécessair
}


