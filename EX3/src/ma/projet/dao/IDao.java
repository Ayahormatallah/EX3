/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.dao;

import java.util.List;

public interface IDao<T> {
    boolean create(T o);         // Ajouter un objet T
    T getById(int id);           // Obtenir un objet T par son ID
    List<T> getAll();            // Obtenir tous les objets T
}

