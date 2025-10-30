# 📋 Product Backlog - Safe Space

> **Projet** : Safe Space - Plateforme de Signalement et Preuve Collaborative  
> **Product Owner** : Alix VEYRAT
> **Version** : 1.0  
> **Dernière mise à jour** : 30/10/2025

---

## 🎯 Vision Produit

**Safe Space** est une plateforme sécurisée qui permet aux **victimes** de violences au travail de signaler les faits et conserver des preuves chiffrées, et aux **témoins** de mettre leurs preuves à disposition sans faire de délation. Une **IA** qualifie automatiquement les faits juridiquement et oriente vers des ressources géolocalisées.

---

## 📊 Indicateurs de Réussite (Definition of Done Projet)

### Critères MVP (Minimum Viable Product)

- [x] ✅ Un utilisateur peut créer un compte (victime ou témoin)
- [x] ✅ Un utilisateur peut se connecter (JWT)
- [x] ✅ Une victime peut créer un signalement
- [x] ✅ L'IA qualifie automatiquement le signalement (catégorie + article loi)
- [x] ✅ Une victime peut uploader des preuves chiffrées
- [x] ✅ Un témoin peut uploader des preuves
- [x] ✅ Un témoin peut mettre ses preuves à disposition d'une victime
- [x] ✅ Une victime peut accepter/décliner les preuves proposées
- [x] ✅ Une victime peut télécharger ses preuves
- [x] ✅ Une victime peut partager son dossier avec un avocat
- [x] ✅ Les ressources (avocats, assos) sont géolocalisées (PostGIS)
- [x] ✅ Déploiement Docker Compose fonctionnel
- [x] ✅ Documentation complète (README, pitches, US)

---

## 🔢 Priorisation (MoSCoW)

### **Must Have** (MVP - Sprint 1 à 5) 🔴

Fonctionnalités critiques sans lesquelles le produit ne fonctionne pas.

### **Should Have** (Important - Sprint 6-7) 🟠

Fonctionnalités importantes qui améliorent significativement l'expérience.

### **Could Have** (Nice to have - Sprint 8+) 🟡

Fonctionnalités bonus qui différencient le produit.

### **Won't Have (This Time)** (Hors scope) ⚪

Fonctionnalités reportées à une version future.

---

## 📦 Backlog Priorisé (Par Sprint)

---

## 🚀 Sprint 1 : Fondations (2 semaines)

**Objectif** : Infrastructure technique + Authentification

**Points** : 18 points  
**Dates** : Semaine 1-2

### User Stories

| ID | US | Priorité | Points | Status |
|----|----|----|--------|--------|
| US-1.1 | Inscription Victime | 🔴 Must | 5 | ⏳ To Do |
| US-1.2 | Inscription Témoin | 🔴 Must | 2 | ⏳ To Do |
| US-1.3 | Connexion JWT | 🔴 Must | 5 | ⏳ To Do |
| US-1.4 | Refresh Token | 🔴 Must | 3 | ⏳ To Do |

### Tasks Techniques (non US)

- [x] ✅ Configuration Spring Boot (fait)
- [x] ✅ Docker Compose PostgreSQL (fait)
- [x] ✅ Structure projet (fait)
- [ ] ⏳ Entités JPA (User, Role)
- [ ] ⏳ Repository + Service User
- [ ] ⏳ JWT Token Provider
- [ ] ⏳ Security Config (JWT Filter)
- [ ] ⏳ Tests unitaires Auth

**Definition of Done Sprint 1** :
- ✅ Un utilisateur peut s'inscrire (victime ou témoin)
- ✅ Un utilisateur peut se connecter et recevoir un JWT
- ✅ Le JWT est validé à chaque requête protégée
- ✅ Le refresh token fonctionne
- ✅ Tests unitaires passent (> 80% couverture)
- ✅ Documentation API (Swagger)

---

## 🚀 Sprint 2 : Signalements + Coffre-Fort Basique (2 semaines)

**Objectif** : Création signalement + Upload preuves chiffrées

**Points** : 29 points  
**Dates** : Semaine 3-4

### User Stories

| ID | US | Priorité | Points | Status |
|----|----|----|--------|--------|
| US-2.1 | Création Signalement avec IA | 🔴 Must | 8 | ⏳ To Do |
| US-2.3 | Qualification Juridique Auto | 🟠 Should | 5 | ⏳ To Do |
| US-2.7 | Soumettre Signalement | 🔴 Must | 3 | ⏳ To Do |
| US-3.1 | Upload Preuve Victime | 🔴 Must | 8 | ⏳ To Do |
| US-3.2 | Upload Preuve Témoin | 🔴 Must | 3 | ⏳ To Do |
| US-3.10 | Avertissement Légal Audio/Vidéo | 🟠 Should | 3 | ⏳ To Do |

### Tasks Techniques

- [ ] ⏳ Entités JPA (Signalement, Evidence)
- [ ] ⏳ Service Chiffrement (AES-256)
- [ ] ⏳ Service Upload Fichiers
- [ ] ⏳ Service A (Python) - Endpoint classification basique
- [ ] ⏳ Client HTTP Service C → Service A
- [ ] ⏳ Stockage local fichiers chiffrés
- [ ] ⏳ Tests intégration upload

**Definition of Done Sprint 2** :
- ✅ Une victime peut créer un signalement (description)
- ✅ L'IA (Service A) classifie automatiquement (harcèlement, discrimination, etc.)
- ✅ La qualification juridique s'affiche (article de loi)
- ✅ Une victime peut uploader une preuve (screenshot, PDF)
- ✅ Un témoin peut uploader une preuve
- ✅ Les fichiers sont chiffrés AES-256
- ✅ Popup avertissement si audio/vidéo
- ✅ Tests d'intégration passent

---

## 🚀 Sprint 3 : Mise à Disposition Témoins (2 semaines)

**Objectif** : Témoins peuvent proposer preuves aux victimes

**Points** : 31 points  
**Dates** : Semaine 5-6

### User Stories

| ID | US | Priorité | Points | Status |
|----|----|----|--------|--------|
| US-2.4 | Voir Preuves Disponibles (Témoins) | 🔴 Must | 5 | ⏳ To Do |
| US-2.5 | Accepter Preuve Témoin | 🔴 Must | 5 | ⏳ To Do |
| US-2.6 | Décliner Preuve Témoin | 🟡 Could | 2 | ⏳ To Do |
| US-2.8 | Modifier Signalement (DRAFT) | 🟡 Could | 3 | ⏳ To Do |
| US-3.3 | Caractérisation Preuve avec IA | 🟠 Should | 5 | ⏳ To Do |
| US-3.4 | Mettre Preuve à Disposition | 🔴 Must | 8 | ⏳ To Do |
| US-3.7 | Anonymat Témoin | 🔴 Must | 2 | ⏳ To Do |
| US-6.1 | Classification IA (Service A) | 🔴 Must | 13 | ⏳ To Do |

### Tasks Techniques

- [ ] ⏳ Entité JPA EvidenceOffer
- [ ] ⏳ Service EvidenceOfferService
- [ ] ⏳ API REST /api/evidence-offers
- [ ] ⏳ Notification système (email basique)
- [ ] ⏳ Service A : NLP extraction keywords (spaCy)
- [ ] ⏳ Service A : Base qualification_rules en BDD
- [ ] ⏳ Tests E2E parcours témoin

**Definition of Done Sprint 3** :
- ✅ Un témoin peut proposer une preuve à une victime
- ✅ L'identité du témoin reste anonyme
- ✅ La victime reçoit une notification
- ✅ La victime voit la liste des preuves proposées
- ✅ La victime peut accepter → preuve copiée dans son dossier
- ✅ La victime peut décliner
- ✅ L'IA caractérise chaque preuve (catégorie)
- ✅ Tests E2E parcours complet témoin→victime

---

## 🚀 Sprint 4 : Partage Dossier + Géolocalisation (2 semaines)

**Objectif** : Partage avec avocat + Ressources géolocalisées

**Points** : 35 points  
**Dates** : Semaine 7-8

### User Stories

| ID | US | Priorité | Points | Status |
|----|----|----|--------|--------|
| US-2.2 | Questions IA Adaptatives (WebSocket) | 🟠 Should | 8 | ⏳ To Do |
| US-3.5 | Générer Code Partage | 🟠 Should | 3 | ⏳ To Do |
| US-3.6 | Utiliser Code Partage (Victime) | 🟠 Should | 5 | ⏳ To Do |
| US-4.1 | Partager avec Avocat | 🔴 Must | 8 | ⏳ To Do |
| US-4.3 | Révoquer Accès | 🟠 Should | 3 | ⏳ To Do |
| US-5.1 | Rechercher Avocat Spécialisé | 🟠 Should | 8 | ⏳ To Do |
| US-5.2 | Rechercher Associations | 🟠 Should | 3 | ⏳ To Do |
| US-5.5 | Carte Interactive (Leaflet) | 🟠 Should | 8 | ⏳ To Do |
| US-6.2 | Génération Questions Adaptatives | 🟠 Should | 8 | ⏳ To Do |

### Tasks Techniques

- [ ] ⏳ Entités JPA (EvidenceShare, Ressource)
- [ ] ⏳ Extension PostGIS PostgreSQL
- [ ] ⏳ Service Géolocalisation (ST_DWithin)
- [ ] ⏳ Service B (Spring WebFlux) - WebSocket
- [ ] ⏳ Service A : Endpoint /api/ai/next-questions
- [ ] ⏳ Client WebSocket Angular
- [ ] ⏳ Intégration Leaflet (carte)
- [ ] ⏳ Système partage avec token JWT temporaire

**Definition of Done Sprint 4** :
- ✅ Une victime peut partager son dossier avec un avocat (email)
- ✅ L'avocat reçoit un lien d'accès avec token temporaire (30 jours)
- ✅ L'avocat peut consulter et télécharger les preuves
- ✅ La victime peut révoquer l'accès
- ✅ Recherche avocats/assos par géolocalisation (rayon 10km)
- ✅ Carte interactive affiche les ressources
- ✅ L'IA pose des questions en temps réel (WebSocket)
- ✅ Tests intégration PostGIS

---

## 🚀 Sprint 5 : Modération + Administration (2 semaines)

**Objectif** : Validation signalements + Détection cas critiques

**Points** : 28 points  
**Dates** : Semaine 9-10

### User Stories

| ID | US | Priorité | Points | Status |
|----|----|----|--------|--------|
| US-1.5 | Déconnexion | 🟡 Could | 2 | ⏳ To Do |
| US-1.7 | Profil Utilisateur | 🟡 Could | 3 | ⏳ To Do |
| US-1.8 | Suppression Compte | 🟡 Could | 5 | ⏳ To Do |
| US-2.9 | Historique Signalement | 🟡 Could | 3 | ⏳ To Do |
| US-3.11 | Suppression Preuve | 🟡 Could | 3 | ⏳ To Do |
| US-4.2 | Partager avec RH (Consentement) | 🟡 Could | 8 | ⏳ To Do |
| US-4.4 | Historique Accès Preuves | 🟠 Should | 5 | ⏳ To Do |
| US-5.3 | Ajouter Ressource (Modérateur) | 🟡 Could | 5 | ⏳ To Do |
| US-5.4 | Valider Ressource (Admin) | 🟡 Could | 3 | ⏳ To Do |
| US-7.1 | Dashboard Modérateur | 🟡 Could | 5 | ⏳ To Do |
| US-7.2 | Valider Signalement | 🟡 Could | 3 | ⏳ To Do |
| US-7.3 | Détection Cas Critique | 🔴 Must | 5 | ⏳ To Do |

### Tasks Techniques

- [ ] ⏳ RBAC avancé (ROLE_MODERATOR)
- [ ] ⏳ Dashboard modérateur (Angular)
- [ ] ⏳ Service détection cas critiques (mots-clés)
- [ ] ⏳ Notification email modérateurs
- [ ] ⏳ Gestion consentement RH (signature électronique)
- [ ] ⏳ Audit logs avancés

**Definition of Done Sprint 5** :
- ✅ Un modérateur peut voir les signalements en attente
- ✅ Un modérateur peut valider/corriger un signalement
- ✅ Les cas critiques sont détectés automatiquement (mots-clés)
- ✅ Notification immédiate si cas critique
- ✅ Une victime peut voir l'historique d'accès à ses preuves
- ✅ Une victime peut partager avec RH (consentement explicite)
- ✅ Tests RBAC complets

---

## 🎁 BONUS : Sprint 6-8 (Si temps restant)

### Sprint 6 : Sécurité Avancée (1 semaine)

**Points** : 19 points

| ID | US | Points | Status |
|----|----|--------|--------|
| US-1.6 | Activation 2FA | 8 | ⏳ To Do |
| US-3.9 | Horodatage Certifié (RFC 3161) | 8 | ⏳ To Do |
| US-6.4 | Suggestions Temps Réel (WebSocket) | 8 | ⏳ To Do |
| US-8.1 | Dashboard Admin (Stats) | 8 | ⏳ To Do |
| US-8.2 | Logs d'Audit | 5 | ⏳ To Do |

**Objectif** : Renforcer sécurité et monitoring

---

### Sprint 7 : Cas Exceptionnels (1 semaine)

**Points** : 21 points

| ID | US | Points | Status |
|----|----|--------|--------|
| US-4.5 | Accès Autorités (Réquisition) | 13 | ⏳ To Do |
| US-7.4 | Signaler Autorités | 8 | ⏳ To Do |
| US-8.3 | Gestion Utilisateurs (Admin) | 5 | ⏳ To Do |

**Objectif** : Gestion cas légaux complexes

---

### Sprint 8 : MLOps (Apprentissage Continu) (1 semaine)

**Points** : 5 points

| ID | US | Points | Status |
|----|----|--------|--------|
| US-6.5 | Historique Qualifications (MLOps) | 5 | ⏳ To Do |

**Tasks MLOps** :
- [ ] Pipeline réentraînement (corrections modérateurs)
- [ ] A/B testing nouvelles versions modèle
- [ ] Monitoring dérive modèle
- [ ] Dashboard métriques IA

**Objectif** : Amélioration continue IA

---

## 📊 Vue d'ensemble Sprints

| Sprint | Objectif | Points | Durée | Status |
|--------|----------|--------|-------|--------|
| Sprint 1 | Fondations + Auth | 18 | 2 sem | ⏳ |
| Sprint 2 | Signalements + Preuves | 29 | 2 sem | ⏳ |
| Sprint 3 | Témoins → Victimes | 31 | 2 sem | ⏳ |
| Sprint 4 | Partage + Géoloc | 35 | 2 sem | ⏳ |
| Sprint 5 | Modération + Admin | 28 | 2 sem | ⏳ |
| **MVP COMPLET** | **Total MVP** | **141** | **10 sem** | **⏳** |
| Sprint 6 (Bonus) | Sécurité Avancée | 19 | 1 sem | 🎁 |
| Sprint 7 (Bonus) | Cas Exceptionnels | 21 | 1 sem | 🎁 |
| Sprint 8 (Bonus) | MLOps | 5 | 1 sem | 🎁 |
| **TOTAL PROJET** | **Complet** | **186** | **13 sem** | **🎯** |

---

## 📈 Métriques de Suivi

### Velocity Sprint (Objectif)

**Sprint 1-5 (MVP)** : ~28 points/sprint  
**Sprint 6-8 (Bonus)** : ~15 points/sprint

### Burndown Chart

À mettre à jour après chaque sprint :

```
Points restants
  ↑
200│                   ○ Début
   │                 ╱
150│               ╱
   │             ╱
100│           ╱
   │         ╱
 50│       ╱
   │     ╱
  0│___╱________________→ Temps (sprints)
     1  2  3  4  5  6
```

---

## 🚫 Won't Have (Hors Scope Actuel)

Fonctionnalités intéressantes mais reportées :

### Reporting Avancé
- [ ] Génération rapport PDF automatique
- [ ] Export dossier complet (.zip)
- [ ] Timeline interactive incidents

### Social/Communauté
- [ ] Forum victimes (anonyme)
- [ ] Chat entre victimes
- [ ] Groupes de soutien

### IA Avancée
- [ ] Analyse sentiment (détection détresse)
- [ ] Prédiction issue procédure
- [ ] Recommandations personnalisées

### Mobile
- [ ] Application mobile native (iOS/Android)
- [ ] Upload photo direct depuis téléphone
- [ ] Notifications push

### Intégrations
- [ ] Intégration Slack/Teams (alertes)
- [ ] API publique (pour partenaires)
- [ ] Webhook pour systèmes externes

---

## 🔄 Processus de Mise à Jour Backlog

### Sprint Planning (Début de sprint)

1. **Sélection US** : Équipe choisit US du backlog selon velocity
2. **Découpage tasks** : US → tasks techniques (< 4h)
3. **Estimation** : Poker planning (Fibonacci)
4. **Engagement** : Équipe s'engage sur sprint goal

### Daily Scrum (Quotidien)

- Mise à jour status tasks (To Do → In Progress → Done)
- Blockers signalés immédiatement

### Sprint Review (Fin de sprint)

- Démo fonctionnalités terminées
- Validation Product Owner (DoD respectée)
- Feedback utilisateurs (si testeurs dispo)

### Sprint Retrospective (Fin de sprint)

- Ce qui a bien fonctionné
- Ce qui peut être amélioré
- Actions d'amélioration pour sprint suivant

### Backlog Refinement (Mi-sprint)

- Affinage US futures
- Ajout détails critères d'acceptation
- Re-priorisation si nécessaire

---

## 📞 Rôles & Responsabilités

**Product Owner** : Alix VEYRAT
- Priorise backlog
- Définit critères d'acceptation
- Valide DoD

**Scrum Master** : Alix VEYRAT (auto-organisation)
- Facilite cérémonies Scrum
- Supprime obstacles
- Protège l'équipe

**Dev Team** : Alix VEYRAT + Claude (assistance)
- Développe fonctionnalités
- Estime complexité
- Auto-organisation

---

## 📚 Références

- [User Stories détaillées](./US.md)
- [Sprints Planning](./SPRINTS.md)
- [Roadmap projet](./ROADMAP.md)
- [Pitch projet](./PROJET.md)

---

*Document créé le 30/10/2025*  
*Version 1.0*