# 🚚 FleetFlow

## Description

FleetFlow est une API REST développée avec Spring Boot permettant la gestion complète d'une plateforme de transport et de logistique.

L'application permet de gérer les clients, chauffeurs, véhicules, livraisons et utilisateurs tout en garantissant la sécurité des accès grâce à JWT et Spring Security.

Le projet a été conçu selon une architecture MVC en respectant les bonnes pratiques de développement backend (DTO, MapStruct, SOLID, Clean Code).

---

##  Fonctionnalités

### Gestion des Clients
- Ajouter un client
- Modifier un client
- Supprimer un client
- Consulter un client
- Lister les clients

### Gestion des Chauffeurs
- Ajouter un chauffeur
- Modifier un chauffeur
- Supprimer un chauffeur
- Consulter un chauffeur
- Lister les chauffeurs

### Gestion des Véhicules
- Ajouter un véhicule
- Modifier un véhicule
- Supprimer un véhicule
- Consulter un véhicule
- Lister les véhicules
- Rechercher par statut

### Gestion des Livraisons
- Créer une livraison
- Modifier une livraison
- Supprimer une livraison
- Consulter une livraison
- Lister les livraisons
- Affecter une livraison à un chauffeur
- Rechercher par client
- Rechercher par chauffeur
- Rechercher par statut

### Gestion des Utilisateurs
- Inscription utilisateur
- Authentification
- Gestion des rôles

---

## 🔐 Sécurité

Le projet utilise :

- Spring Security
- JWT (JSON Web Token)
- Authentification Stateless
- Contrôle d'accès basé sur les rôles (RBAC)

### Rôles

#### ADMIN
- Gestion complète du système
- Gestion des utilisateurs
- Gestion des chauffeurs
- Gestion des véhicules
- Gestion des livraisons
- Gestion des clients

#### MANAGER
- Gestion des clients
- Gestion des livraisons
- Consultation des véhicules
- Consultation des chauffeurs

#### CHAUFFEUR
- Consultation de ses livraisons
- Mise à jour du statut des livraisons

---

## 📄 Pagination et Tri

Pagination implémentée avec Spring Data JPA :

```http
GET /api/clients?page=0&size=10&sort=name,asc
```