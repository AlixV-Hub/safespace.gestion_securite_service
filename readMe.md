# 🛡️ Safe Space - Backend

> **Plateforme de Signalement et Preuve Collaborative contre les Violences au Travail**

Backend Spring Boot pour Safe Space - Système sécurisé permettant aux victimes et témoins de signaler, qualifier juridiquement (via IA) et conserver des preuves chiffrées des violences au travail.

---

## 📋 Table des Matières

- [Vue d'ensemble](#-vue-densemble)
- [Architecture](#-architecture)
- [Technologies](#-technologies)
- [Démarrage Rapide](#-démarrage-rapide)
- [Configuration](#️-configuration)
- [API Documentation](#-api-documentation)
- [Base de Données](#️-base-de-données)
- [Sécurité](#-sécurité)
- [Tests](#-tests)
- [Déploiement](#-déploiement)
- [Roadmap](#️-roadmap)
- [Contribution](#-contribution)
- [License](#-license)

---

## 🎯 Vue d'ensemble

**Safe Space** est une plateforme Tech for Good qui révolutionne la lutte contre les violences au travail grâce à **3 piliers** :

### 1️⃣ Coffre-Fort Collaboratif Sécurisé
- 🔐 **Victimes** : Stockent leurs preuves chiffrées (AES-256)
- 👁️ **Témoins** : Conservent des preuves qu'ils proposent aux victimes (sans délation)
- 🤝 **Mise à disposition** : Témoins → Victimes (anonymat garanti)
- ⏰ **Horodatage certifié** : Valeur légale (RFC 3161)

### 2️⃣ Qualification Juridique Automatique par IA
- 🤖 **Formulaire intelligent** : Questions adaptatives en temps réel (WebSocket)
- ⚖️ **Classification automatique** : Harcèlement moral, sexuel, discrimination, etc.
- 📜 **Articles de loi** : Code du travail, Code pénal
- 📊 **Confiance** : Score de précision (ex: 87%)

### 3️⃣ Réseau de Ressources Géolocalisées
- 🗺️ **Recherche spatiale** : Avocats, associations, syndicats (PostGIS)
- 📍 **Rayon paramétrable** : 5, 10, 20 km
- 🔍 **Filtres avancés** : Spécialités, langues, gratuit/payant

---

## 🏗️ Architecture

### Microservices (3 services)

```
┌─────────────────────────────────────────────────────────┐
│                   FRONTEND (Angular 17)                 │
│  • Interface responsive                                 │
│  • WebSocket (temps réel)                               │
│  • Carte interactive (Leaflet + PostGIS)                │
└────────────────┬────────────────────────────────────────┘
                 │
        ┌────────┴────────────────────┐
        │                             │
┌───────▼────────┐          ┌─────────▼─────────┐
│  SERVICE C     │          │    SERVICE B      │
│ (Spring Boot)  │◄────────►│ (Spring WebFlux)  │
│                │          │                   │
│ • Auth JWT     │          │ • WebSocket       │
│ • CRUD         │          │ • Questions IA    │
│ • Coffre-fort  │          │   temps réel      │
│ • Géoloc       │          └───────────────────┘
│ • PostgreSQL   │                    │
└───────┬────────┘          ┌─────────▼─────────┐
        │                   │    SERVICE A      │
        └──────────────────►│ (Python/FastAPI)  │
                            │                   │
                            │ • Classification  │
                            │ • NLP (spaCy)     │
                            │ • MLOps          │
                            └───────────────────┘
```

---

## 💻 Technologies

### Service C (Backend Principal)
- Spring Boot 3.4.0
- Java 21
- Spring Security + JWT
- Spring Data JPA (Hibernate)
- PostgreSQL 16 + PostGIS
- Docker

### Service A (IA)
- Python 3.11+
- FastAPI
- spaCy (NLP)
- scikit-learn

### Service B (Temps Réel)
- Spring WebFlux
- WebSocket (STOMP)
- Reactor

---

## 🚀 Démarrage Rapide

### Prérequis

- Docker & Docker Compose
- Java 21 (pour dev local)
- PostgreSQL 16 (pour dev local)

### Installation

```bash
# Cloner le repository
git clone https://github.com/ton-username/safe-space-backend.git
cd safe-space-backend

# Copier .env.example → .env
cp .env.example .env

# Éditer .env (mots de passe, clés)
nano .env

# Lancer avec Docker Compose
docker-compose up -d

# Vérifier logs
docker-compose logs -f safe-space-backend
```

### Accès

- **API Backend** : http://localhost:8080
- **Swagger UI** : http://localhost:8080/swagger-ui.html
- **PostgreSQL** : localhost:5432 (DB: safe_space_db)

---

## ⚙️ Configuration

### Profils Spring

1. **dev** - Développement local
2. **test** - Tests automatisés
3. **prod** - Production

### Variables d'Environnement

```bash
# Base de données
DB_HOST=localhost
DB_PORT=5432
DB_NAME=safe_space_db
DB_USER=safespace_user
DB_PASSWORD=VotreMotDePasseSecurise123!

# JWT
JWT_SECRET=VotreCleSecrete256BitsMinimum
JWT_ACCESS_TOKEN_EXPIRATION=900000
JWT_REFRESH_TOKEN_EXPIRATION=604800000

# Chiffrement
ENCRYPTION_MASTER_KEY=VotreMasterKey256Bits
```

---

## 📚 API Documentation

### Swagger UI

**Dev** : http://localhost:8080/swagger-ui.html

### Endpoints Principaux

#### 🔐 Authentification
```
POST   /api/auth/register        # Inscription
POST   /api/auth/login           # Connexion → JWT
POST   /api/auth/refresh         # Refresh token
POST   /api/auth/logout          # Déconnexion
```

#### 📝 Signalements
```
POST   /api/signalements         # Créer signalement
GET    /api/signalements         # Liste signalements
GET    /api/signalements/{id}    # Détails
POST   /api/signalements/{id}/submit  # Soumettre
```

#### 📦 Preuves
```
POST   /api/evidences/upload     # Upload preuve
GET    /api/evidences            # Liste preuves
GET    /api/evidences/{id}/download  # Télécharger
```

#### 🤝 Mise à Disposition
```
POST   /api/evidence-offers/create     # Proposer preuve
GET    /api/evidence-offers/for-me     # Voir preuves dispo
POST   /api/evidence-offers/{id}/accept  # Accepter
```

#### 🗺️ Ressources
```
GET    /api/ressources/search    # Recherche géolocalisée
```

---

## 🗄️ Base de Données

### Tables Principales

- `users` - Utilisateurs
- `signalements` - Signalements (victimes)
- `evidences` - Preuves chiffrées
- `evidence_offers` - Propositions témoins
- `evidence_shares` - Partages avocats/RH
- `ressources` - Ressources géolocalisées
- `qualification_rules` - Règles IA

### Extensions PostgreSQL

```sql
CREATE EXTENSION IF NOT EXISTS pgcrypto;  -- Chiffrement
CREATE EXTENSION IF NOT EXISTS postgis;   -- Géolocalisation
```

---

## 🔐 Sécurité

### Authentification
- JWT (Access: 15min, Refresh: 7 jours)
- BCrypt (cost 12)
- 2FA (optionnel)

### Chiffrement
- Fichiers : AES-256-GCM
- Données BDD : pgcrypto
- TLS 1.3 (production)

### RBAC
- `VICTIM` - Victimes
- `WITNESS` - Témoins
- `MODERATOR` - Modérateurs
- `ADMIN` - Administrateurs

### RGPD
- ✅ Anonymisation
- ✅ Consentement explicite
- ✅ Durée conservation limitée
- ✅ Droits utilisateurs
- ✅ Audit logs

---

## 🧪 Tests

```bash
# Tous les tests
./mvnw test

# Coverage (> 80%)
./mvnw jacoco:report
```

---

## 🚀 Déploiement

### Docker Compose
```bash
docker-compose up -d
```

### Production (Heroku)
```bash
heroku create safe-space-backend
heroku addons:create heroku-postgresql
git push heroku main
```

---

## 🗺️ Roadmap

### ✅ MVP (Nov 2025 - Jan 2026)
- [x] Auth JWT
- [x] Signalements + Preuves
- [x] Témoins → Victimes
- [x] IA Classification
- [x] Géolocalisation
- [x] Docker

### 🎁 Bonus (Jan-Fév 2026)
- [ ] 2FA
- [ ] Horodatage certifié
- [ ] MLOps
- [ ] CI/CD

Voir [ROADMAP.md](./ROADMAP.md) pour détails.

---

## 📖 Documentation

- [**PROJET_PITCH.md**](./PROJET.md) - Pitch complet
- [**USER_STORIES.md**](./US.md) - 42 User Stories
- [**BACKLOG_PRODUIT.md**](./BACKLOG.md) - Product Backlog
- [**SPRINTS_PLANNING.md**](./SPRINTS.md) - Planning sprints
- [**ROADMAP.md**](./ROADMAP.md) - Vision 3 ans


---

## 🤝 Contribution

1. Fork le repository
2. Crée une branche : `git checkout -b feature/ma-feature`
3. Commit : `git commit -m "feat: Ma feature"`
4. Push : `git push origin feature/ma-feature`
5. Pull Request

---

## 📜 License

MIT License - Copyright (c) 2025 Alix VEYRAT

---

## 📞 Contact

**Auteur** : Alix VEYRAT  
**Email** : alixveyrat@gmail.com
**LinkedIn** : https://www.linkedin.com/in/alixveyrat/
**GitHub** : https://github.com/AlixV-Hub

---

## 🙏 Remerciements

- Anthropic Claude
- Spring Boot Team
- PostgreSQL Community
- Associations d'aide aux victimes
- Toustes les participant.e.s
- Ma fille
- Mes amies pour leur soutien sans faille
- Mon futur époux
- Ada Tech School


---

**🚀 Ensemble, rendons les lieux de travail plus sûrs !**

---

*Dernière mise à jour : 30/10/2025*  
*Version : 1.0*