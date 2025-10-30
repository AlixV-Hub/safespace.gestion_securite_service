# 🛡️ Safe Space - Plateforme de Signalement et Preuve Collaborative

> **Projet personnel académique dans le cadre d'un passage du RNCP6 Concepteur développeur d'application** 
> Architecture microservices avec IA pour la lutte contre les violences au travail

---

## 📊 Informations Projet

**Nom du projet** : Safe Space  
**Tagline** : *"Ensemble contre les violences au travail"*  
**Type** : Plateforme web (Full-Stack Java/Angular) + IA (Python)  
**Domaine** : Justice sociale, Tech for Good, Droit du travail  
**Architecture** : Microservices (3 services)  
**Technologies** : Spring Boot, Angular, Python/FastAPI, PostgreSQL/PostGIS, Docker

---

## 🎯 Contexte & Problématique

### Le Problème

En France, les violences au travail restent largement sous-déclarées :

**Chiffres clés** :
- 🔴 **30% des salariés** déclarent avoir subi du harcèlement moral (Baromètre Technologia, 2023)
- 🔴 **1 femme sur 3** a subi du harcèlement sexuel au travail (Défenseur des droits, 2023)
- 🔴 **Seulement 5%** des victimes portent plainte
- 🔴 **80% des témoins** n'osent pas s'impliquer par peur de représailles

### Les Obstacles

**Pour les victimes** :
1. ❌ Ne savent pas **qualifier juridiquement** les faits (harcèlement ? discrimination ?)
2. ❌ Manquent de **preuves** pour étayer leur dossier
3. ❌ Ne savent **pas vers qui se tourner** (avocat ? syndicat ? associations ?)
4. ❌ **Peur** de ne pas être crues, peur des représailles

**Pour les témoins** :
1. ❌ Veulent aider mais craignent les **représailles**
2. ❌ Ne veulent pas faire de **délation** (signaler à la place de la victime)
3. ❌ Possèdent des **preuves** (emails, screenshots, enregistrements) mais ne savent pas quoi en faire

**Résultat** : Les agresseurs restent impunis, les victimes souffrent en silence.

---

## 💡 La Solution : Safe Space

### Vision

**Safe Space** est une plateforme sécurisée en **3 axes** pour accompagner victimes et témoins de violences au travail.

---

## 🏗️ Architecture en 3 Piliers

### 1️⃣ **Coffre-Fort Collaboratif Sécurisé**

**Fonctionnalités** :
- 🔐 **Victimes** : Stockent leurs preuves de manière chiffrée (end-to-end encryption)
- 👁️ **Témoins** : Conservent des preuves d'agressions dont ils sont témoins
- 🤝 **Mise à disposition** : Les témoins proposent leurs preuves aux victimes (sans délation forcée)
- ⏰ **Horodatage certifié** : Preuve légale que le document existait à une date donnée
- 🔗 **Partage contrôlé** : Avec avocat, RH (consentement), autorités (réquisition)

**Types de preuves acceptées** :
- 📸 Screenshots (messages, emails, Slack)
- 📄 Documents (contrats, courriers RH, évaluations)
- 🎤 Enregistrements audio (avec avertissement légal)
- 📹 Vidéos (avec avertissement légal)
- 📝 Notes horodatées (journal de bord)

**Sécurité** :
- ✅ Chiffrement AES-256
- ✅ Clés uniques par fichier (KMS)
- ✅ Horodatage RFC 3161 ou blockchain
- ✅ Audit logs complets
- ✅ Watermarking invisible (traçabilité)

---

### 2️⃣ **Qualification Juridique Automatique par IA**

**Problème résolu** : Les victimes et témoins ne savent pas nommer juridiquement ce qu'ils subissent.

**Solution IA** :

**Formulaire Intelligent Adaptatif** :
1. 📝 L'utilisateur décrit les faits en texte libre
2. 🤖 L'IA détecte des mots-clés et suggère des catégories en temps réel
3. ❓ L'IA pose des questions ciblées (WebSocket - temps réel)
4. ⚖️ L'IA qualifie automatiquement :
    - Catégorie (harcèlement moral, sexuel, discrimination, etc.)
    - Article de loi applicable (Code du travail, Code pénal)
    - Niveau de gravité
5. 📍 L'IA oriente vers les bonnes ressources (avocat spécialisé, asso, etc.)

**Catégories gérées** :
- Harcèlement moral (Article L1152-1)
- Harcèlement sexuel (Article L1153-1)
- Agissements sexistes (Article L1142-2-1)
- Discrimination (racisme, homophobie, sexisme) (Article L1132-1)
- Conditions de travail dangereuses (Article L4121-1)

**Base de connaissance juridique** :
- Règles de qualification (critères, questions, mots-clés)
- Exemples types (cas positifs, négatifs, borderline)
- Textes de loi complets
- Jurisprudence (optionnel)

**Technologies IA** :
- NLP (spaCy, Transformers) pour extraction de features
- Modèle de classification (fine-tuné sur données juridiques)
- LLM (GPT-4, Claude, Mistral) pour cas complexes
- MLOps : Amélioration continue via corrections des modérateurs

---

### 3️⃣ **Réseau de Ressources Géolocalisées**

**Problème résolu** : Les victimes ne savent pas vers qui se tourner.

**Solution** :

**Annuaire géolocalisé** :
- 🗺️ **Avocats** spécialisés droit du travail (harcèlement, discrimination)
- 🤝 **Associations** d'aide aux victimes
- 🏢 **Syndicats**
- 🧠 **Psychologues** du travail
- 🏥 **Médecins** du travail

**Fonctionnalités** :
- Recherche par rayon (PostGIS - géolocalisation spatiale)
- Filtres (gratuit, aide juridictionnelle, langues parlées, spécialités)
- Notation/avis (optionnel, modéré)
- Contact direct depuis la plateforme

**Validation** :
- Ressources validées par modérateurs (vérification légitimité)
- Partenariats avec associations reconnues

---

## 👥 Personas & Parcours Utilisateurs

### Persona 1 : Léa, 28 ans - **Victime de harcèlement moral**

**Situation** :  
Léa subit du harcèlement moral de son manager depuis 6 mois : remarques humiliantes en réunion, surcharge de travail impossible, isolement des collègues. Elle a des screenshots de messages Slack, mais ne sait pas si ça constitue légalement du harcèlement.

**Parcours sur Safe Space** :

1. **Inscription** (anonyme ou identifiée - son choix)
2. **Upload preuves** dans son coffre-fort personnel
    - 15 screenshots de messages Slack humiliants
    - 3 emails de son manager avec surcharge injustifiée
    - Notes horodatées de chaque incident
3. **Formulaire de qualification IA** :
    - Léa décrit : *"Mon manager me critique devant tout le monde, me donne trop de travail, et mes collègues ne me parlent plus"*
    - IA détecte : Mots-clés = ["critique", "travail", "isolement"]
    - IA pose questions :
        - ✅ "Ces comportements sont-ils répétés ?" → Oui
        - ✅ "Vos conditions de travail se sont-elles dégradées ?" → Oui
        - ✅ "Êtes-vous isolée de vos collègues ?" → Oui
    - **IA qualifie** : **Harcèlement moral (Article L1152-1 Code du travail)** - Confiance 89%
4. **Notification** : *"Témoin anonyme a mis des preuves à disposition"*
    - Marc (collègue) a uploadé des enregistrements audio de réunions
    - Léa **accepte** les preuves de Marc dans son dossier
5. **Recherche ressources** :
    - Géolocalisation : "Avocats droit du travail à moins de 10 km"
    - Résultat : 3 avocats spécialisés harcèlement
6. **Partage avec avocat** :
    - Léa partage son dossier complet (signalement + preuves) avec Me Dupont
    - Accès temporaire (30 jours), révocable
7. **Suivi** : Léa peut consulter l'historique d'accès à ses preuves

**Résultat** : Léa a un dossier solide, qualifié juridiquement, avec preuves horodatées et témoin.

---

### Persona 2 : Marc, 35 ans - **Témoin**

**Situation** :  
Marc assiste régulièrement à des scènes où son manager humilie Léa en réunion. Il a pris des notes et fait des enregistrements audio (réunions publiques). Il veut aider Léa, mais a peur de représailles s'il la contacte directement ou s'il fait un signalement officiel.

**Parcours sur Safe Space** :

1. **Inscription** (rôle : Témoin)
2. **Upload preuves** dans son coffre-fort :
    - 5 notes horodatées décrivant les incidents
    - 2 enregistrements audio de réunions (avec avertissement légal accepté)
3. **Qualification IA** :
    - Marc décrit : *"J'ai vu mon manager critiquer Léa devant tout le monde, la surcharger de tâches"*
    - IA qualifie : **Harcèlement moral** (témoin)
4. **Mise à disposition** :
    - Option A : Marc recherche "Léa D." dans l'entreprise et propose ses preuves
    - Option B : Marc génère un **code de partage** (ex: `SAFE-8472`) qu'il donne discrètement à Léa
5. **Anonymat** : Léa voit "*Témoin anonyme*" - l'identité de Marc reste masquée
6. **Pas de délation** : Marc ne peut PAS créer de signalement à la place de Léa

**Résultat** : Marc aide Léa tout en restant protégé. Les preuves sont conservées en sécurité.

---

### Persona 3 : Sophie, 45 ans - **Modératrice**

**Rôle** :  
Psychologue du travail bénévole, Sophie valide les ressources et détecte les cas critiques.

**Actions** :
1. **Validation ressources** : Vérifie que les avocats/associations sont légitimes
2. **Détection cas critiques** : Si danger imminent (violence physique, menaces), alerte autorités
3. **Accompagnement exceptionnel** : Aide dans les cas où l'IA ne suffit pas (très rare)

**Note** : La majorité du travail est fait par l'IA. Sophie intervient uniquement pour validation et urgences.

---

## 🎯 Valeur Ajoutée & Innovation

### Innovation #1 : Coffre-Fort Collaboratif Témoin/Victime

**Unique sur le marché** :
- Permet aux témoins de stocker des preuves **sans faire de délation**
- La victime garde le **contrôle total** (accepter/refuser)
- Anonymat du témoin garanti

**Différenciation** :
- Plateformes existantes (gouvernementales) : Seulement signalement victime
- Safe Space : **Collaboration** victime + témoins

---

### Innovation #2 : Qualification Juridique Automatique

**Unique sur le marché** :
- Formulaire intelligent avec questions adaptatives en temps réel
- Qualification automatique avec articles de loi
- Base de connaissance juridique intégrée

**Différenciation** :
- Plateformes existantes : Formulaires statiques, aucune aide à la qualification
- Safe Space : **IA guide** l'utilisateur pour qualifier correctement

---

### Innovation #3 : Horodatage Certifié

**Valeur légale** :
- Preuve que le document existait à une date précise
- Empêche de contester l'authenticité temporelle
- Technologies : RFC 3161 ou ancrage blockchain

---

## 🏗️ Architecture Technique

### Vue d'ensemble
```
┌────────────────────────────────────────────────────┐
│           FRONTEND (Angular 17)                    │
│  • Interface utilisateur responsive                │
│  • Formulaire intelligent (WebSocket)              │
│  • Carte interactive (Leaflet + PostGIS)           │
│  • Dashboard victime/témoin/modérateur             │
└──────────────────┬─────────────────────────────────┘
                   │
        ┌──────────┴────────────────────┐
        │                               │
┌───────▼──────────┐          ┌─────────▼────────────┐
│   SERVICE C      │          │    SERVICE B         │
│  (Spring Boot)   │◄────────►│  (Spring WebFlux)    │
│                  │          │                      │
│ • Auth JWT       │          │ • WebSocket temps    │
│ • CRUD           │          │   réel               │
│ • Coffre-fort    │          │ • Assistance         │
│ • Géolocalisation│          │   rédaction IA       │
│ • RBAC           │          │ • Questions          │
│ • PostgreSQL     │          │   adaptatives        │
└───────┬──────────┘          └──────────────────────┘
        │                               │
        │                     ┌─────────▼────────────┐
        │                     │    SERVICE A         │
        └────────────────────►│  (Python/FastAPI)    │
                              │                      │
                              │ • Classification IA  │
                              │ • NLP (spaCy)        │
                              │ • Qualification      │
                              │   juridique          │
                              │ • MLOps (optionnel)  │
                              └──────────────────────┘
```

---

### Service C (Spring Boot) - **Cœur du système**

**Responsabilités** :
- Gestion utilisateurs (User, Role)
- Authentification JWT + Spring Security
- CRUD Signalements (victimes uniquement)
- **Coffre-fort numérique** (upload, chiffrement, partage)
- Mise à disposition preuves (témoin → victime)
- Ressources géolocalisées (PostGIS)
- RBAC (Role-Based Access Control)

**Stack** :
- Spring Boot 3.5.7
- Spring Security + JWT
- Spring Data JPA (Hibernate)
- PostgreSQL 16 + PostGIS
- Docker

---

### Service B (Spring WebFlux) - **Temps réel**

**Responsabilités** :
- WebSocket (connexion persistante avec front-end)
- Assistance rédaction en temps réel
- Questions adaptatives (appel Service A)
- Streaming des suggestions IA

**Stack** :
- Spring WebFlux (reactive)
- WebSocket (STOMP)
- RxJava / Reactor

---

### Service A (Python/FastAPI) - **IA**

**Responsabilités** :
- Classification automatique des témoignages
- Extraction de features (NLP)
- Génération de questions adaptatives
- Qualification juridique
- MLOps (réentraînement continu - Bonus)

**Stack** :
- Python 3.11+
- FastAPI
- spaCy (NLP)
- Transformers (Hugging Face)
- scikit-learn
- PostgreSQL (règles de qualification)

---

## 🔐 Conformité RGPD & Sécurité

### RGPD

**Données sensibles** (Article 9 RGPD) :
- Témoignages de violences révèlent santé, orientations, opinions

**Base légale** :
- ✅ **Consentement explicite** (Article 9.2.a)
- ✅ **Défense de droits en justice** (Article 9.2.f)

**Mesures RGPD** :
1. ✅ **Minimisation** : Pas de nom/prénom/IP dans preuves
2. ✅ **Anonymisation** : Suppression entités nommées (NER)
3. ✅ **Chiffrement** : AES-256 end-to-end
4. ✅ **Durée conservation** : 6 ans max (prescription pénale)
5. ✅ **Droits utilisateurs** : Accès, rectification, suppression
6. ✅ **Audit logs** : Tous les accès tracés
7. ✅ **Registre des traitements** : Documenté

**Avertissements légaux** :
- ⚠️ Enregistrements audio/vidéo sans consentement = illégal (Article 226-1 Code pénal)
- ⚠️ Popup obligatoire avant upload audio/vidéo

---

### Sécurité

**Authentification** :
- JWT avec refresh tokens
- BCrypt pour mots de passe
- 2FA (optionnel)

**Chiffrement** :
- **Au repos** : pgcrypto (PostgreSQL)
- **En transit** : TLS 1.3
- **Fichiers** : AES-256 avec clés uniques (KMS)

**Protection accès** :
- RBAC strict
- Rate limiting (10 downloads/heure)
- Détection activité suspecte (géolocalisation, volume)
- Watermarking invisible (traçabilité fuites)

**Audit** :
- Logs complets (qui, quoi, quand, où)
- Conservation 5 ans
- Conformité ISO 27001 (objectif)

---

## 📊 Modèle de Données (Simplifié)

### Tables principales
```
users
├─ id, email, password_hash, role, pseudonym
├─ is_anonymous, two_factor_enabled

signalements (victimes uniquement)
├─ victim_id, description_encrypted
├─ ai_category, ai_confidence, legal_code
├─ status (DRAFT, SUBMITTED, VALIDATED)

evidences (victimes + témoins)
├─ owner_id, owner_type (VICTIM/WITNESS)
├─ file_path_encrypted, file_hash
├─ timestamp_token, encryption_key_id
├─ category, tags

evidence_offers (témoins → victimes)
├─ witness_id (anonyme), victim_id
├─ evidence_id, share_code
├─ status (PENDING, ACCEPTED, DECLINED)

evidence_shares (victimes → avocats/RH/autorités)
├─ shared_by, shared_with_type
├─ expires_at, can_download
├─ consent_given (si RH)

ressources (géolocalisées)
├─ name, type, coordinates (PostGIS)
├─ specialties, is_free
├─ validated_by, status

qualification_rules (base de connaissance IA)
├─ category, legal_code, legal_text
├─ criteria (JSON), questions (JSON)
├─ keywords, severity
```

---

## 🚀 Roadmap & Jalons

### Phase 1 : MVP (8 semaines) - ✅ Livrable

**Objectif** : Système fonctionnel avec features essentielles

**Livrables** :
- ✅ Auth JWT (User, Role)
- ✅ Upload preuves (victime + témoin) - chiffrement basique
- ✅ Mise à disposition (témoin → victime)
- ✅ Formulaire qualification IA basique
- ✅ Ressources géolocalisées (PostGIS)
- ✅ Docker Compose
- ✅ Documentation



---

### Phase 2 : Sécurité Avancée (3 semaines) - 🎁 Bonus

**Objectif** : Renforcer sécurité et conformité

**Livrables** :
- Horodatage certifié (RFC 3161)
- Watermarking invisible
- 2FA
- Audit logs avancés
- Détection activité suspecte

---

### Phase 3 : IA Avancée (3 semaines) - 🎁 Bonus

**Objectif** : Améliorer qualification IA

**Livrables** :
- Intégration LLM (GPT-4, Claude, Mistral)
- Questions adaptatives temps réel (WebSocket)
- Base de connaissance enrichie (50+ règles)
- Dashboard métriques IA

---

### Phase 4 : MLOps (2 semaines) - 🎁 Bonus

**Objectif** : Apprentissage continu

**Livrables** :
- Pipeline MLOps (corrections modérateurs)
- Réentraînement automatique
- A/B testing nouvelles versions
- Monitoring dérive modèle

---

### Phase 5 : Déploiement (1 semaine) - 🎁 Bonus

**Objectif** : Mise en production

**Livrables** :
- Déploiement cloud (AWS/Azure/Heroku)
- CI/CD (GitHub Actions)
- Monitoring (Prometheus, Grafana)
- Backup automatique

---

## 📈 Métriques de Succès

### Indicateurs techniques

- ✅ Disponibilité : 99.5% (uptime)
- ✅ Temps réponse API : < 200ms (95e percentile)
- ✅ Chiffrement : 100% des preuves
- ✅ Tests : Couverture > 80%

### Indicateurs métier si déploiement

- 📊 Nombre signalements créés
- 📊 Taux témoins contributeurs
- 📊 Taux acceptation preuves témoins
- 📊 Précision IA (accuracy > 85%)
- 📊 Satisfaction utilisateurs (NPS > 50)

---

## 🎓 Aspects Académiques

### Compétences démontrées

**Architecture** :
- ✅ Microservices
- ✅ Communication inter-services (REST, WebSocket)
- ✅ Patterns (Repository, Service, DTO)

**Back-end** :
- ✅ Spring Boot (Security, Data JPA, WebFlux)
- ✅ JWT + RBAC
- ✅ PostgreSQL + PostGIS
- ✅ Python + FastAPI

**Front-end** :
- ✅ Angular (Components, Services, RxJS)
- ✅ WebSocket (temps réel)
- ✅ Leaflet (cartographie)

**DevOps** :
- ✅ Docker + Docker Compose
- ✅ CI/CD (GitHub Actions)
- ✅ Monitoring

**IA/ML** :
- ✅ NLP (classification de texte)
- ✅ Fine-tuning modèles
- ✅ MLOps (optionnel)

**Soft Skills** :
- ✅ Gestion projet (Scrum, sprints)
- ✅ Documentation technique
- ✅ Respect RGPD
- ✅ Réflexion éthique

---

## 💼 Positionnement Professionnel

**Compétences techniques valorisées** :
- Architecture microservices (scalabilité)
- Sécurité (chiffrement, JWT, RBAC)
- IA/ML (classification, NLP)
- DevOps (Docker, CI/CD)
- Full-stack (Java + Angular)

**Soft skills valorisés** :
- Vision produit (problème réel résolu)
- Gestion projet (backlog, sprints)
- Réflexion éthique (RGPD, protection victimes)
- Documentation (README, pitches, US)

**Différenciation** :
- Projet à **impact social** (Tech for Good)
- **Innovation** (coffre-fort collaboratif unique)
- **Complexité technique** (3 services, IA, géolocalisation, chiffrement)

---

## 📞 Contact & Liens

**Auteur** : [Alix VEYRAT]  
**Email** : [alixveyrat@gmail.com]  
**LinkedIn** : [https://www.linkedin.com/in/alixveyrat/]  
**GitHub** : [https://github.com/AlixV-Hub/safespace.gestion_securite_servicegithub.com/ton-username/safe-space-backend]

**Ressources** :
- [Documentation technique](./README.md)
- [User Stories](./USER_STORIES.md)
- [Backlog Produit](./BACKLOG_PRODUIT.md)
- [Sprints Planning](./SPRINTS_PLANNING.md)
- [Roadmap](./ROADMAP.md)

---

## 🙏 Remerciements

- **Anthropic Claude** - Assistance au développement
- **Spring Boot Team** - Framework
- **PostgreSQL Community** - Base de données
- **Associations d'aide aux victimes** - Inspiration et contexte

---

**Made with ❤️ for a safer workplace**

---

*Document créé le 30/10/2025*  
*Version 1.0*