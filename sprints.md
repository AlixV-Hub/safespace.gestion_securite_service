# 🗓️ Sprints Planning - Safe Space

> **Projet** : Safe Space - Plateforme de Signalement et Preuve Collaborative  
> **Scrum Master** : Alix VEYRAT 
> **Version** : 1.0  
> **Dernière mise à jour** : 30/10/2025

---

## 📅 Calendrier Global

**Début projet** : 04/11/2025 (Semaine 45)  
**Fin MVP** : 13/01/2026 (Semaine 2 - 2026)  
**Durée MVP** : 10 semaines (5 sprints de 2 semaines)

**Fin Projet Complet (avec bonus)** : 03/02/2026  
**Durée totale** : 13 semaines

---

## 🎯 Vue d'ensemble Sprints

| Sprint | Dates | Objectif | Points | Status |
|--------|-------|----------|--------|--------|
| **Sprint 0** | 30/10 - 03/11 | Collecte données IA (formulaire) | - | 🟢 En cours |
| **Sprint 1** | 04/11 - 17/11 | Fondations + Auth JWT | 18 | ⏳ À venir |
| **Sprint 2** | 18/11 - 01/12 | Signalements + Preuves | 29 | ⏳ À venir |
| **Sprint 3** | 02/12 - 15/12 | Témoins → Victimes | 31 | ⏳ À venir |
| **Sprint 4** | 16/12 - 29/12 | Partage + Géoloc | 35 | ⏳ À venir |
| **Sprint 5** | 30/12 - 12/01 | Modération + Admin | 28 | ⏳ À venir |
| **🎉 MVP** | **13/01/2026** | **Livrable complet** | **141** | **🎯** |
| **Sprint 6** | 13/01 - 19/01 | Sécurité Avancée (bonus) | 19 | 🎁 Optionnel |
| **Sprint 7** | 20/01 - 26/01 | Cas Exceptionnels (bonus) | 21 | 🎁 Optionnel |
| **Sprint 8** | 27/01 - 02/02 | MLOps (bonus) | 5 | 🎁 Optionnel |

---

## 🏃 Sprint 0 : Collecte Données IA (30/10 - 03/11)

### 🎯 Objectif Sprint

**Lancer le formulaire de collecte de données** pour entraîner l'IA à qualifier les témoignages.

**Pourquoi ?** Pour avoir un dataset d'entraînement quand on implémentera MLOps (Sprint 8).

---

### 📋 Tasks

| Task | Description | Temps | Owner | Status |
|------|-------------|-------|-------|--------|
| T0.1 | Rédiger pitch formulaire (PITCH_FORMULAIRE.md) | 1h | AV    | ✅ Fait |
| T0.2 | Créer formulaire Google Forms RGPD | 2h | AV    | ⏳ À faire |
| T0.3 | Page d'accueil formulaire (landing page) | 3h | AV    | ⏳ À faire |
| T0.4 | Diffusion formulaire (réseaux sociaux, email) | 1h | AV    | ⏳ À faire |
| T0.5 | Setup Google Sheets pour collecter réponses | 0.5h | AV    | ⏳ À faire |

**Total** : 7.5h (1 semaine en parallèle du projet)

---

### ✅ Definition of Done Sprint 0

- [x] Formulaire Google Forms créé avec :
    - [x] Consentement RGPD explicite
    - [x] Anonymisation assurée
    - [x] Questions de qualification
- [x] Page d'accueil publiée (GitHub Pages ou simple HTML)
- [x] Formulaire diffusé (minimum 3 canaux)
- [x] Objectif : 50 réponses d'ici fin MVP (13/01)

---

### 📊 Livrables Sprint 0

1. **PITCH_FORMULAIRE.md** ✅
2. **FORMULAIRE_COLLECTE.md** ✅
3. Formulaire Google Forms en ligne
4. Landing page formulaire
5. Premier lot de 10-20 réponses

---

## 🏃 Sprint 1 : Fondations + Auth JWT (04/11 - 17/11)

### 🎯 Objectif Sprint

**Mettre en place l'infrastructure technique** et l'**authentification sécurisée** (JWT).

**Sprint Goal** : Un utilisateur peut créer un compte et se connecter.

---

### 📋 User Stories

| US | Titre | Points | Priority |
|----|-------|--------|----------|
| US-1.1 | Inscription Victime | 5 | 🔴 Must |
| US-1.2 | Inscription Témoin | 2 | 🔴 Must |
| US-1.3 | Connexion JWT | 5 | 🔴 Must |
| US-1.4 | Refresh Token | 3 | 🔴 Must |

**Velocity prévue** : 18 points

---

### 📋 Tasks Détaillées

#### 🗄️ Base de données (Day 1)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T1.1 | Créer table `users` (SQL) | 1h | ⏳ |
| T1.2 | Créer table `refresh_tokens` (SQL) | 0.5h | ⏳ |
| T1.3 | Seed data : Admin user | 0.5h | ⏳ |



#### 🏗️ Entités JPA (Day 1-2)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T1.4 | Entité User.java | 2h | ⏳ |
| T1.5 | Entité RefreshToken.java | 1h | ⏳ |
| T1.6 | Repository UserRepository | 0.5h | ⏳ |
| T1.7 | Repository RefreshTokenRepository | 0.5h | ⏳ |




---

#### 🔐 Sécurité JWT (Day 3-5)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T1.8 | JwtTokenProvider.java | 3h | ⏳ |
| T1.9 | JwtAuthenticationFilter.java | 2h | ⏳ |
| T1.10 | SecurityConfig.java | 2h | ⏳ |
| T1.11 | UserService.java (register, login) | 3h | ⏳ |
| T1.12 | AuthController.java | 2h | ⏳ |
| T1.13 | DTOs (RegisterRequest, LoginRequest, AuthResponse) | 1h | ⏳ |


---

#### 🧪 Tests (Day 6-7)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T1.14 | Tests UserService | 2h | ⏳ |
| T1.15 | Tests AuthController (integration) | 2h | ⏳ |
| T1.16 | Tests JWT (valid/invalid tokens) | 1h | ⏳ |

**Objectif couverture** : > 80%

---

#### 📄 Documentation (Day 7)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T1.17 | Swagger API Auth endpoints | 1h | ⏳ |
| T1.18 | README : Section Auth | 0.5h | ⏳ |

---

### ✅ Definition of Done Sprint 1

- [x] Table `users` créée en BDD
- [x] Un utilisateur peut s'inscrire (POST /api/auth/register)
- [x] Un utilisateur peut se connecter (POST /api/auth/login) → Reçoit JWT
- [x] Le JWT est validé sur endpoints protégés
- [x] Le refresh token fonctionne (POST /api/auth/refresh)
- [x] Tests unitaires : > 80% couverture
- [x] Tests d'intégration : Auth flow complet
- [x] Swagger documentation à jour
- [x] Code review fait
- [x] Déploiement Docker Compose OK

---

### 📊 Sprint Review (17/11)

**Démo** :
1. Inscription utilisateur (Postman)
2. Connexion → Récupération JWT
3. Appel endpoint protégé avec JWT
4. Refresh token

**Validation Product Owner** : ✅ / ❌

---

### 🔄 Sprint Retrospective (17/11)

**Ce qui a bien fonctionné** :
- ...

**Ce qui peut être amélioré** :
- ...

**Actions pour Sprint 2** :
- ...

---

## 🏃 Sprint 2 : Signalements + Coffre-Fort (18/11 - 01/12)

### 🎯 Objectif Sprint

**Implémenter la création de signalements** avec qualification IA et **upload de preuves chiffrées**.

**Sprint Goal** : Une victime peut créer un signalement qualifié par l'IA et uploader des preuves sécurisées.

---

### 📋 User Stories

| US | Titre | Points | Priority |
|----|-------|--------|----------|
| US-2.1 | Création Signalement avec IA | 8 | 🔴 Must |
| US-2.3 | Qualification Juridique Auto | 5 | 🟠 Should |
| US-2.7 | Soumettre Signalement | 3 | 🔴 Must |
| US-3.1 | Upload Preuve Victime | 8 | 🔴 Must |
| US-3.2 | Upload Preuve Témoin | 3 | 🔴 Must |
| US-3.8 | Download Preuve | 5 | 🔴 Must |
| US-3.10 | Avertissement Légal Audio/Vidéo | 3 | 🟠 Should |

**Velocity prévue** : 29 points

---

### 📋 Tasks Détaillées

#### 🗄️ Base de données (Day 1)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T2.1 | Table `signalements` | 1h | ⏳ |
| T2.2 | Table `evidences` | 1h | ⏳ |
| T2.3 | Extension pgcrypto (chiffrement) | 0.5h | ⏳ |


---

#### 🏗️ Entités JPA (Day 1-2)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T2.4 | Entité Signalement.java | 2h | ⏳ |
| T2.5 | Entité Evidence.java | 2h | ⏳ |
| T2.6 | Repositories | 1h | ⏳ |

---

#### 🔐 Service Chiffrement (Day 2-3)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T2.7 | EncryptionService.java (AES-256) | 4h | ⏳ |
| T2.8 | Tests chiffrement/déchiffrement | 1h | ⏳ |


---

#### 📂 Service Upload (Day 3-4)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T2.9 | EvidenceService.java (upload) | 4h | ⏳ |
| T2.10 | FileStorageService.java | 2h | ⏳ |
| T2.11 | EvidenceController.java | 2h | ⏳ |


---

#### 🤖 Service A - Classification IA (Day 4-6)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T2.12 | Setup Service A (Python/FastAPI) | 2h | ⏳ |
| T2.13 | Endpoint POST /api/ai/classify | 4h | ⏳ |
| T2.14 | NLP basique (keywords extraction) | 3h | ⏳ |
| T2.15 | Table qualification_rules (seed data) | 2h | ⏳ |
| T2.16 | Client HTTP Service C → Service A | 2h | ⏳ |


---

#### 🧪 Tests (Day 7-8)

| Task | Description | Temps | Status |
|------|-------------|-------|--------|
| T2.17 | Tests EvidenceService | 2h | ⏳ |
| T2.18 | Tests chiffrement E2E | 2h | ⏳ |
| T2.19 | Tests Service A (Python) | 2h | ⏳ |
| T2.20 | Tests intégration upload | 2h | ⏳ |

---

### ✅ Definition of Done Sprint 2

- [x] Une victime peut créer un signalement (description)
- [x] Service A classifie automatiquement (catégorie + confiance)
- [x] Qualification juridique affichée (article de loi)
- [x] Une victime peut uploader une preuve (screenshot, PDF, audio, vidéo)
- [x] Un témoin peut uploader une preuve
- [x] Fichiers chiffrés AES-256
- [x] Popup avertissement si audio/vidéo
- [x] Une victime peut télécharger ses preuves
- [x] Tests : > 80% couverture
- [x] Service A opérationnel (Docker)
- [x] Docker Compose : Service C + Service A + PostgreSQL

---

## 🏃 Sprint 3 : Témoins → Victimes (02/12 - 15/12)

### 🎯 Objectif Sprint

**Permettre aux témoins de proposer leurs preuves** aux victimes, tout en restant anonymes.

**Sprint Goal** : Un témoin peut mettre des preuves à disposition d'une victime qui peut les accepter.

---

### 📋 User Stories

| US | Titre | Points | Priority |
|----|-------|--------|----------|
| US-2.4 | Voir Preuves Disponibles | 5 | 🔴 Must |
| US-2.5 | Accepter Preuve Témoin | 5 | 🔴 Must |
| US-2.6 | Décliner Preuve Témoin | 2 | 🟡 Could |
| US-2.8 | Modifier Signalement (DRAFT) | 3 | 🟡 Could |
| US-3.3 | Caractérisation Preuve IA | 5 | 🟠 Should |
| US-3.4 | Mise à Disposition | 8 | 🔴 Must |
| US-3.5 | Générer Code Partage | 3 | 🟠 Should |
| US-3.6 | Utiliser Code Partage | 5 | 🟠 Should |
| US-6.1 | Classification IA (améliorations) | 13 | 🔴 Must |
| US-6.3 | Base Connaissance Juridique | 8 | 🟠 Should |

**Velocity prévue** : 31 points

---

### 📋 Tasks Détaillées

*(Détails similaires aux sprints précédents : tables BDD, entités JPA, services, controllers, tests)*

**Highlights** :
- Table `evidence_offers`
- Service EvidenceOfferService
- Système de codes partage (6 chiffres)
- Anonymisation témoin
- Enrichissement Service A (règles de qualification)

---

### ✅ Definition of Done Sprint 3

- [x] Un témoin peut proposer une preuve à une victime
- [x] Témoin reste anonyme vis-à-vis de la victime
- [x] Victime reçoit notification
- [x] Victime voit liste preuves disponibles
- [x] Victime peut accepter → copie dans son dossier
- [x] Victime peut décliner
- [x] Système code partage fonctionne
- [x] IA caractérise chaque preuve
- [x] Base de connaissance avec 7+ règles juridiques
- [x] Tests E2E parcours témoin complet

---

## 🏃 Sprint 4 : Partage + Géolocalisation (16/12 - 29/12)

### 🎯 Objectif Sprint

**Partage dossier avec avocat** + **Ressources géolocalisées** (avocats, associations).

**Sprint Goal** : Une victime peut partager son dossier et trouver des ressources près d'elle.

---

### 📋 User Stories (35 points)

- US-2.2 : Questions IA Adaptatives (WebSocket)
- US-4.1 : Partager avec Avocat
- US-4.3 : Révoquer Accès
- US-5.1 : Recherche Avocats
- US-5.2 : Recherche Associations
- US-5.5 : Carte Interactive
- US-6.2 : Questions Adaptatives (Service A)

**Highlights** :
- Service B (Spring WebFlux + WebSocket)
- Extension PostGIS
- Table `ressources` avec coordonnées
- Table `evidence_shares`
- Intégration Leaflet (front-end)

---

## 🏃 Sprint 5 : Modération + Admin (30/12 - 12/01)

### 🎯 Objectif Sprint

**Dashboard modérateur** + **Détection cas critiques** + **Administration**.

**Sprint Goal** : Les modérateurs peuvent valider signalements et détecter urgences.

---

### 📋 User Stories (28 points)

- US-7.1 : Dashboard Modérateur
- US-7.2 : Valider Signalement
- US-7.3 : Détection Cas Critique
- US-5.3 : Ajouter Ressource
- US-5.4 : Valider Ressource
- US-4.4 : Historique Accès
- + Nettoyage, tests finaux, documentation

**🎉 FIN MVP - 13/01/2026**

---

## 🎁 Sprint 6-8 : Bonus (Optionnels)

### Sprint 6 : Sécurité Avancée (19 points)
- 2FA
- Horodatage certifié
- Dashboard admin
- Audit logs

### Sprint 7 : Cas Exceptionnels (21 points)
- Accès autorités
- Signalement autorités
- Gestion users admin

### Sprint 8 : MLOps (5 points)
- Pipeline réentraînement
- A/B testing
- Monitoring dérive

---

## 📊 Cérémonies Scrum

### 🗓️ Daily Scrum (Quotidien - 15min)

**Format** :
1. Qu'ai-je fait hier ?
2. Que vais-je faire aujourd'hui ?
3. Y a-t-il des obstacles ?

**Outil** : Notion 

---

### 🎯 Sprint Planning (Début de sprint - 2h)

**Agenda** :
1. Review backlog produit
2. Sélection US (selon velocity)
3. Découpage en tasks
4. Estimation (poker planning)
5. Engagement équipe sur sprint goal

---

### 📊 Sprint Review (Fin de sprint - 1h)

**Agenda** :
1. Démo fonctionnalités terminées (DoD respectée)
2. Feedback Product Owner
3. Mise à jour backlog si nécessaire

---

### 🔄 Sprint Retrospective (Fin de sprint - 1h)

**Format** : Start / Stop / Continue

**Questions** :
- Qu'est-ce qui a bien fonctionné ?
- Qu'est-ce qui peut être amélioré ?
- Actions concrètes pour prochain sprint ?

---

### 🔍 Backlog Refinement (Mi-sprint - 1h)

**Agenda** :
1. Affinage US futures (critères d'acceptation)
2. Découpage US trop grosses (> 8 points)
3. Re-priorisation si nécessaire
4. Ajout détails techniques

---

## 📈 Outils de Suivi

### Tableau Kanban notion

```
┌──────────┬──────────┬──────────┬──────────┐
│ To Do    │ In Prog  │ Review   │ Done     │
├──────────┼──────────┼──────────┼──────────┤
│ US-1.1   │ US-1.3   │          │ US-1.2   │
│ US-1.4   │          │          │          │
│ T1.1     │ T1.8     │ T1.7     │ T1.4     │
│ T1.2     │          │          │ T1.5     │
└──────────┴──────────┴──────────┴──────────┘
```

**Outil** : notion 

---

### Burndown Chart (Exemple Sprint 1)

```
Points restants
  ↑
 18│ ●
   │  ╲
 15│   ●
   │    ╲
 12│     ╲
   │      ●
  9│       ╲
   │        ●
  6│         ╲
   │          ●
  3│           ╲
   │            ●
  0│_____________●____→ Jours
     1  2  3  4  5  6  7  8  9 10
```

---

## ✅ Checklist Sprint (Template)

### Début de Sprint
- [ ] Sprint Planning fait
- [ ] US sélectionnées et comprises
- [ ] Tasks créées et estimées
- [ ] Sprint Goal défini
- [ ] Obstacles identifiés

### Pendant Sprint
- [ ] Daily Scrum quotidien
- [ ] Tasks mises à jour (To Do → In Progress → Done)
- [ ] Tests écrits en même temps que code
- [ ] Code review fait par pair
- [ ] Documentation à jour

### Fin de Sprint
- [ ] Tous critères DoD validés
- [ ] Sprint Review fait (démo)
- [ ] Sprint Retrospective fait
- [ ] Backlog Refinement fait
- [ ] Velocity calculée
- [ ] Actions d'amélioration notées

---

## 📞 Contact & Support

**Scrum Master** : Alix VEYRAT
**Email** : alixveyrat@gmail.com
**Discord** : #alix_nantes

**Urgences** : Si blocage > 4h, escalade au Scrum Master

---

*Document créé le 30/10/2025*  
*Version 1.0*