# 🛡️ Safe Space - Backend Gestion Sécurité

> **Projet personnel dans le cadre académique du RNCP6 Concepteur développeur d'applications** - Plateforme sécurisée d'assistance à la rédaction de signalements et de mise en relation avec des ressources locales.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue.svg)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Compose-2496ED.svg)](https://www.docker.com/)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)

---

## 🎯 Vision du Projet

Safe Space est une plateforme de **signalement sécurisé** qui permet aux utilisateurs de :
- Rédiger des signalements anonymisés avec assistance IA
- Trouver des ressources locales géolocalisées
- Bénéficier d'une modération pour garantir la qualité des ressources

**Ce repository** contient le **Service C** : l'API Gateway et le cœur de la sécurité du système (authentification, autorisation, gestion des ressources).

---

## 🏗️ Architecture Microservices
```
┌─────────────────┐
│   Frontend      │
│   (Angular)     │
└────────┬────────┘
         │
    ┌────┴─────────────────────┐
    │                          │
┌───▼──────────┐      ┌────────▼────────┐
│  Service B   │      │   Service C     │ ◄── CE REPO
│  (WebFlux)   │      │ (Spring Boot)   │
│  Temps Réel  │      │ Auth & Gateway  │
└──────────────┘      └────────┬────────┘
                               │
                      ┌────────▼────────┐
                      │  PostgreSQL/    │
                      │  PostGIS        │
                      └─────────────────┘
                               │
                      ┌────────▼────────┐
                      │   Service A     │
                      │  (Python/IA)    │
                      │  Classification │
                      └─────────────────┘
```

---

## 🔐 Service C - Responsabilités

Ce service est le **cœur du système** et gère :

| Fonctionnalité | Description |
|----------------|-------------|
| 🔑 **Authentification** | JWT + Spring Security (BCrypt) |
| 👥 **Gestion des Rôles** | RBAC (Utilisateur, Modérateur) |
| 📝 **Gestion des Ressources** | CRUD + Workflow de modération (PENDING → APPROVED) |
| 🗺️ **Géolocalisation** | Recherche par rayon (PostGIS) |
| 📊 **Monitoring** | Spring Boot Actuator |

---

## 🚀 Technologies

### Backend
- **Spring Boot 3.5.7** - Framework principal
- **Spring Security** - Authentification JWT + RBAC
- **Spring Data JPA** - ORM Hibernate
- **PostgreSQL 16** - Base de données relationnelle
- **PostGIS** - Extension géospatiale (à venir)
- **Lombok** - Réduction du boilerplate

### DevOps
- **Docker & Docker Compose** - Conteneurisation
- **Maven** - Build automation

### Monitoring
- **Spring Boot Actuator** - Health checks & metrics

---

## 📋 User Stories Implémentées

| ID | Rôle | Fonctionnalité | Statut |
|----|------|----------------|--------|
| C.1 | Utilisateur | Inscription (mot de passe BCrypt) | 🔄 En cours |
| C.2 | Utilisateur | Connexion (JWT) | 🔄 En cours |
| C.3 | Utilisateur | Créer une ressource (statut PENDING) | 📅 Planifié |
| C.4 | Modérateur | Valider une ressource (PENDING → APPROVED) | 📅 Planifié |
| C.5 | Utilisateur | Recherche géolocalisée (rayon 10km) | 📅 Planifié |

---

## 🏃 Démarrage Rapide

### Prérequis

- **Docker & Docker Compose** installés
- **Java 17** (pour développement local)
- **Maven** (inclus via wrapper)

---

### 🐳 Option 1 : Avec Docker (Recommandé)

Lance l'environnement complet (PostgreSQL + Application) :
```bash
# Clone le repository
git clone https://github.com/TON_USERNAME/safe-space-backend.git
cd safe-space-backend

# Lance tous les services
docker-compose up --build

# L'API sera disponible sur http://localhost:8080
```

---

### 💻 Option 2 : Développement Local

Lance uniquement PostgreSQL avec Docker, et l'application en local pour le hot reload :
```bash
# 1. Lance la base de données
docker-compose up postgres_db -d

# 2. Lance l'application Spring Boot
cd gestion-securite-service
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

# L'API sera disponible sur http://localhost:8080
```

---

## 🔧 Configuration

### Profils disponibles

| Profil | Environnement | DDL Auto | Logs | Usage |
|--------|---------------|----------|------|-------|
| **dev** | Développement local | `update` | DEBUG | Hot reload, PostgreSQL sur localhost |
| **test** | Tests automatisés | `create-drop` | WARN | Base recréée à chaque test |
| **prod** | Production (Docker) | `validate` | INFO | Sécurisé, pas de modification BDD |

### Variables d'environnement

Pour personnaliser la configuration en production, créez un fichier `.env` :
```bash
# Copier le template
cp .env.example .env

# Éditer avec vos valeurs
SPRING_PROFILE=prod
DB_USER=votreuser
DB_PASSWORD=votremotdepasse
```

---

## 📊 Endpoints Disponibles

### Actuator (Monitoring)

| Endpoint | Description | Accès |
|----------|-------------|-------|
| `GET /actuator/health` | État de l'application | Public |
| `GET /actuator/info` | Informations système | Public |
| `GET /actuator/metrics` | Métriques (CPU, RAM) | Public |

### API (À venir)

| Endpoint | Méthode | Description | Auth |
|----------|---------|-------------|------|
| `/api/auth/register` | POST | Inscription | ❌ |
| `/api/auth/login` | POST | Connexion (JWT) | ❌ |
| `/api/ressources` | GET | Liste des ressources | ✅ |
| `/api/ressources` | POST | Créer une ressource | ✅ |
| `/api/ressources/{id}/approve` | PUT | Valider (MODERATEUR) | ✅ |
| `/api/ressources/search` | GET | Recherche géolocalisée | ✅ |

---

## 🧪 Tests
```bash
# Lancer tous les tests
./mvnw test

# Lancer les tests avec rapport de couverture
./mvnw verify
```

---

## 📁 Structure du Projet
```
safe-space-backend/
├── docker-compose.yml              # Orchestration Docker
├── .env.example                    # Template configuration
├── .gitignore                      # Fichiers ignorés par Git
├── README.md                       # Ce fichier
│
└── gestion-securite-service/       # Service C (Spring Boot)
    ├── src/
    │   ├── main/
    │   │   ├── java/com/safespace/gestion_securite_service/
    │   │   │   ├── GestionSecuriteServiceApplication.java
    │   │   │   ├── config/
    │   │   │   │   └── SecurityConfigDev.java
    │   │   │   ├── controller/     # À venir
    │   │   │   ├── service/        # À venir
    │   │   │   ├── repository/     # À venir
    │   │   │   ├── model/          # À venir
    │   │   │   └── dto/            # À venir
    │   │   └── resources/
    │   │       └── application.yml
    │   └── test/
    ├── Dockerfile
    └── pom.xml
```

---

## 🔒 Sécurité

### Bonnes Pratiques Implémentées

- ✅ **Mots de passe chiffrés** avec BCrypt
- ✅ **JWT** pour l'authentification stateless
- ✅ **RBAC** (Role-Based Access Control)
- ✅ **CORS** configuré
- ✅ **Variables d'environnement** pour les secrets
- ✅ `.gitignore` pour ne pas commiter `.env`
- ✅ **Utilisateur non-root** dans Docker

### Spring Security

- **Profil dev** : Sécurité désactivée pour faciliter le développement
- **Profil prod** : JWT + authentification complète

---

## 🌍 Roadmap

### Phase 1 : Setup & Authentification ✅
- [x] Configuration Spring Boot
- [x] Docker Compose
- [x] PostgreSQL
- [x] Actuator
- [ ] Entités JPA (User, Role)
- [ ] API Auth (Register, Login)

### Phase 2 : Gestion des Ressources 🔄
- [ ] Entité Ressource + Repository
- [ ] CRUD Ressources
- [ ] Workflow de modération
- [ ] Tests unitaires

### Phase 3 : Géolocalisation 📅
- [ ] Intégration PostGIS
- [ ] Recherche par rayon
- [ ] Calcul de distance

### Phase 4 : Intégration IA 📅
- [ ] Communication avec Service A (Python)
- [ ] Classification des signalements
- [ ] Recommandations

---

## 👥 Auteur

Alix VEYRAT - Projet personnel  
📧 alixveyrat@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/alixveyrat/) 

---

## 📄 Licence

Ce projet est réalisé dans le cadre d'un projet académique.

---

## 🙏 Remerciements

- **Spring Boot Team** pour le framework
- **Anthropic** pour l'assistance IA
- **PostgreSQL Community** pour la base de données
- **Docker** pour la conteneurisation

---

## 📞 Support

Pour toute question ou problème :
1. Consulter la [documentation Spring Boot](https://docs.spring.io/spring-boot/)
2. Vérifier les [issues GitHub](https://github.com/TON_USERNAME/safe-space-backend/issues)
3. Contacter l'auteur

---

**Made with ❤️ and ☕ for a safer space**