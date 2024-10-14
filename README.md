Cette application permet de gérer les projets et d'imputer le temps passé sur les tâches réalisées par les employés afin de calculer le coût global des projets pour un bureau d'études. L'application intègre des fonctionnalités de gestion des projets, des tâches, des employés et de leurs contributions à différents projets.

Structure du Projet
Le projet est organisé en plusieurs packages qui séparent les différentes couches de l'application :

ma.projet.classes : Contient les classes entités représentant les employés, les projets, les tâches, et les relations entre eux.
ma.projet.config : Contient le fichier de configuration Hibernate pour la connexion à la base de données.
ma.projet.dao : Définit l'interface générique IDao pour les opérations CRUD (Create, Read, Update, Delete).
ma.projet.service : Implémente les services métier pour manipuler les entités et fournir les fonctionnalités de gestion des projets.
ma.projet.util : Contient des utilitaires, y compris la classe HibernateUtil pour la gestion des sessions Hibernate.
Fonctionnalités
A. Couche persistance (3 points)
Développement des classes entités dans le package ma.projet.classes. Les entités représentent les concepts de Projet, Tâche, Employé, et EmployeTache, avec les annotations nécessaires pour la persistance des données via Hibernate.
Création du fichier de configuration Hibernate hibernate.cfg.xml dans le package ma.projet.config. Ce fichier contient les informations de configuration pour la base de données MySQL.
Création de la classe HibernateUtil dans le package ma.projet.util pour gérer les sessions Hibernate, en facilitant la création et la fermeture des sessions.
