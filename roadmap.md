# 🗺️ Roadmap - Safe Space

> **Projet** : Safe Space - Plateforme de Signalement et Preuve Collaborative  
> **Product Owner** : Alix VEYRAT
> **Vision** : Devenir la plateforme de référence pour la lutte contre les violences au travail  
> **Version** : 1.0  
> **Dernière mise à jour** : 30/10/2025

---

## 🎯 Vision Produit (3 ans)

**Safe Space** sera la **plateforme de référence en France** pour :
1. **Signaler** les violences au travail en toute sécurité
2. **Conserver** des preuves chiffrées avec valeur légale
3. **Qualifier** automatiquement les faits grâce à l'IA
4. **Trouver** des ressources (avocats, associations) géolocalisées
5. **Collaborer** entre victimes et témoins sans délation

**Impact visé** :
- 📈 **10 000 utilisateurs** actifs en 1 an
- 📊 **500 signalements** validés en 1 an
- 🤝 **100 témoins** ayant aidé des victimes
- ⚖️ **50 dossiers** utilisés en justice avec succès
- 🏆 **Partenariats** avec associations nationales (ex: Défenseur des droits)

---

## 📅 Timeline Globale


2025
├─ Nov-Déc : Développement MVP (Sprints 1-4)
├─ Déc-Jan : Finalisation MVP (Sprint 5)
└─ Jan 2026 : 🎉 Livraison MVP

2026
├─ Jan-Fév : Bonus (Sprints 6-8) - Sécurité avancée + MLOps
├─ Fév : Démoday - Ada Tech School
├─ Mars : Beta privée (50 testeurs)
├─ Avril : Corrections bugs + UX
├─ Mai : Beta publique (500 testeurs)
├─ Juin : Déploiement production v1.0
├─ Juil-Déc : Évolution continue (v1.1 à v1.4)

2027
├─ Jan-Juin : V2.0 - Mobile + API publique

2028
└─ V3.0 - IA avancée + Partenariats entreprises


---

## 🚀 Phase 1 : MVP (Nov 2025 - Jan 2026)

**Durée** : 10 semaines (5 sprints)  
**Dates** : 04/11/2025 → 13/01/2026  
**Objectif** : Livrer un produit fonctionnel minimum viable

---

### 🎯 Jalons Phase 1

#### Jalon 1.1 : Auth + Infrastructure ✅ Sprint 1 (17/11/2025)
- [x] Inscription/Connexion JWT
- [x] Docker Compose opérationnel
- [x] Base de données PostgreSQL
- [x] Tests unitaires > 80%

**Critères de validation** :
- ✅ Un utilisateur peut créer un compte
- ✅ Un utilisateur peut se connecter et recevoir un JWT

---

#### Jalon 1.2 : Signalements + Preuves ✅ Sprint 2 (01/12/2025)
- [x] Création signalement avec IA
- [x] Upload preuves chiffrées (victimes + témoins)
- [x] Service A (Python) opérationnel
- [x] Classification automatique

**Critères de validation** :
- ✅ Une victime peut créer un signalement qualifié par l'IA
- ✅ Upload de preuves chiffrées AES-256
- ✅ Service A classifie avec > 70% de confiance

---

#### Jalon 1.3 : Collaboration Témoins ✅ Sprint 3 (15/12/2025)
- [x] Mise à disposition preuves (témoin → victime)
- [x] Anonymat témoin garanti
- [x] Acceptation/Déclinaison preuves
- [x] Base de connaissance juridique (7+ règles)

**Critères de validation** :
- ✅ Un témoin peut proposer des preuves anonymement
- ✅ Une victime peut accepter et intégrer les preuves

---

#### Jalon 1.4 : Partage + Géolocalisation ✅ Sprint 4 (29/12/2025)
- [x] Partage dossier avec avocat
- [x] Ressources géolocalisées (PostGIS)
- [x] Carte interactive (Leaflet)
- [x] Questions IA adaptatives (WebSocket)

**Critères de validation** :
- ✅ Une victime peut partager son dossier avec un avocat
- ✅ Recherche avocats/assos dans un rayon de 10 km

---

#### Jalon 1.5 : Modération + Admin 🎉 Sprint 5 (12/01/2026)
- [x] Dashboard modérateur
- [x] Détection cas critiques
- [x] Validation signalements
- [x] Documentation complète

**Critères de validation** :
- ✅ Un modérateur peut valider des signalements
- ✅ Cas critiques détectés automatiquement (< 1h délai)
- ✅ **MVP COMPLET ET LIVRABLE**

---

### 📊 Livrables Phase 1

#### Documentation
- [x] README.md complet
- [x] PROJET.md
- [x] US.md (42 US)
- [x] BACKLOG.md
- [x] SPRINTS.md
- [x] ROADMAP.md
- [x] Swagger API Documentation

#### Technique
- [x] Service C (Spring Boot) - Backend principal
- [x] Service A (Python/FastAPI) - IA Classification
- [x] Service B (Spring WebFlux) - WebSocket temps réel
- [x] PostgreSQL + PostGIS - Base de données
- [x] Docker Compose - Déploiement
- [x] Tests unitaires + intégration (> 80% couverture)

#### Fonctionnalités
- [x] 18 User Stories critiques (🔴 Must Have)
- [x] Authentification JWT sécurisée
- [x] Coffre-fort collaboratif (victimes + témoins)
- [x] Qualification IA juridique
- [x] Géolocalisation ressources
- [x] Modération basique

---

## 🎁 Phase 2 : Bonus (Jan-Fév 2026)

**Durée** : 3 semaines (Sprints 6-8)  
**Dates** : 13/01/2026 → 03/02/2026  
**Objectif** : Ajouter features différenciatrices

---

### 🎯 Jalons Phase 2

#### Jalon 2.1 : Sécurité Avancée ✅ Sprint 6 (19/01/2026)
- [ ] Authentification 2FA (Google Authenticator)
- [ ] Horodatage certifié (RFC 3161)
- [ ] Watermarking invisible (traçabilité)
- [ ] Dashboard admin (statistiques)
- [ ] Audit logs avancés

**Critères de validation** :
- ✅ 2FA opérationnel pour tous les utilisateurs
- ✅ Horodatage certifié pour toutes les preuves
- ✅ Dashboard admin avec métriques temps réel

---

#### Jalon 2.2 : Cas Exceptionnels ✅ Sprint 7 (26/01/2026)
- [ ] Accès autorités (réquisition judiciaire)
- [ ] Signalement autorités (cas critiques)
- [ ] Gestion utilisateurs (admin)
- [ ] Export dossier complet (PDF)

**Critères de validation** :
- ✅ Protocole réquisition judiciaire opérationnel
- ✅ Signalement automatique autorités si danger imminent

---

#### Jalon 2.3 : MLOps (Apprentissage Continu) ✅ Sprint 8 (02/02/2026)
- [ ] Pipeline réentraînement modèle
- [ ] Corrections modérateurs → dataset
- [ ] A/B testing nouvelles versions
- [ ] Monitoring dérive modèle
- [ ] Dashboard métriques IA

**Critères de validation** :
- ✅ Modèle IA s'améliore automatiquement (accuracy +5% après 100 corrections)
- ✅ Monitoring dérive opérationnel

---

### 📊 Livrables Phase 2

#### Fonctionnalités
- [x] 12 User Stories 🟠 Élevées (Should Have)
- [x] 12 User Stories 🟡 Moyennes (Could Have)
- [x] Sécurité renforcée (2FA, horodatage)
- [x] IA auto-apprenante (MLOps)
- [x] Cas légaux complexes gérés

#### Technique
- [x] Pipeline CI/CD (GitHub Actions)
- [x] Monitoring (Prometheus + Grafana)
- [x] Backup automatique (quotidien)
- [x] Tests de charge (> 100 users simultanés)

---

## 🌱 Phase 3 : Beta Privée (Mars-Avril 2026)

**Durée** : 2 mois  
**Dates** : Mars-Avril 2026  
**Objectif** : Tester avec vrais utilisateurs (50 testeurs)

---

### 🎯 Jalons Phase 3

#### Jalon 3.1 : Recrutement Testeurs (Mars W1-W2)
- [ ] Partenariat avec 2 associations (ex: AVFT, Stop Harcèlement)
- [ ] Recrutement 50 testeurs (victimes + témoins + modérateurs)
- [ ] Signature NDA (confidentialité)
- [ ] Formation testeurs (2h webinaire)

**Critères de validation** :
- ✅ 50 testeurs inscrits
- ✅ 2 associations partenaires

---

#### Jalon 3.2 : Tests Utilisateurs (Mars W3-W4 + Avril)
- [ ] Déploiement beta privée (subdomain: beta.safe-space.app)
- [ ] Onboarding utilisateurs (tutoriels)
- [ ] Collecte feedback (formulaire + interviews)
- [ ] Monitoring bugs (Sentry)
- [ ] Support utilisateurs (email + chat)

**Métriques cibles** :
- 📊 **Taux d'activation** : > 80% (testeurs créent au moins 1 signalement)
- 📊 **Satisfaction** : NPS > 40
- 📊 **Bugs critiques** : < 5
- 📊 **Temps moyen parcours** : < 10 min (création signalement complet)

---

#### Jalon 3.3 : Corrections & Améliorations (Avril W3-W4)
- [ ] Corrections bugs critiques (< 48h)
- [ ] Améliorations UX/UI (selon feedback)
- [ ] Optimisation performance (< 200ms API)
- [ ] Documentation utilisateur (FAQ, guides)

**Critères de validation** :
- ✅ 0 bugs critiques
- ✅ Satisfaction > 50 NPS
- ✅ Performance optimisée

---

### 📊 Livrables Phase 3

#### Utilisateurs
- [x] 50 testeurs actifs
- [x] 20+ signalements créés
- [x] 10+ preuves partagées (témoin → victime)
- [x] 5+ dossiers partagés avec avocats

#### Feedback
- [x] Rapport feedback utilisateurs (20 pages)
- [x] Heatmaps UX (Hotjar)
- [x] Entretiens qualitatifs (10 utilisateurs)
- [x] Liste bugs prioritaires

#### Corrections
- [x] v1.0.1 : Corrections bugs
- [x] v1.0.2 : Améliorations UX
- [x] Documentation utilisateur complète

---

## 🚀 Phase 4 : Beta Publique (Mai 2026)

**Durée** : 1 mois  
**Dates** : Mai 2026  
**Objectif** : Ouvrir à 500 utilisateurs + Communication

---

### 🎯 Jalons Phase 4

#### Jalon 4.1 : Lancement Beta Publique (Mai W1)
- [ ] Déploiement production (www.safe-space.app)
- [ ] Landing page marketing
- [ ] Campagne communication (réseaux sociaux, presse)
- [ ] SEO optimisé
- [ ] Google Analytics + Mixpanel

**Critères de validation** :
- ✅ Site en ligne avec nom de domaine
- ✅ 100 inscriptions dans les 7 premiers jours

---

#### Jalon 4.2 : Croissance Utilisateurs (Mai W2-W4)
- [ ] Articles de presse (Le Monde, Libération, Mediapart)
- [ ] Partenariats associations (élargis à 5+)
- [ ] Webinaires publics (présentation plateforme)
- [ ] Publicité ciblée (Facebook, LinkedIn)

**Métriques cibles** :
- 📊 **500 utilisateurs** inscrits en 1 mois
- 📊 **100 signalements** créés
- 📊 **20 témoins** actifs
- 📊 **Taux de conversion** : 30% (visiteurs → inscrits)

---

### 📊 Livrables Phase 4

#### Marketing
- [x] Landing page professionnelle
- [x] 3 articles de presse
- [x] 5 partenariats associations
- [x] 1000 visiteurs uniques/mois

#### Produit
- [x] v1.0.3 : Stabilité production
- [x] Monitoring 24/7
- [x] Support utilisateurs (< 24h réponse)

---

## 💎 Phase 5 : Production v1.0 (Juin 2026)

**Durée** : Juin 2026  
**Objectif** : Version stable pour grand public

---

### 🎯 Jalon 5.1 : Release v1.0 🎉 (Juin 2026)

**Fonctionnalités v1.0** :
- ✅ Coffre-fort collaboratif (victimes + témoins)
- ✅ Qualification IA juridique (7+ catégories)
- ✅ Géolocalisation ressources (500+ ressources France)
- ✅ Partage dossier (avocats, autorités)
- ✅ Modération (10 modérateurs bénévoles)
- ✅ Sécurité (chiffrement, 2FA, horodatage)
- ✅ MLOps (amélioration continue IA)

**Métriques cibles v1.0** :
- 📊 **1000 utilisateurs** actifs
- 📊 **200 signalements** validés
- 📊 **50 témoins** ayant aidé
- 📊 **Uptime** : 99.5%
- 📊 **Satisfaction** : NPS > 50

---

## 🌟 Phase 6 : Évolutions v1.x (Juil-Déc 2026)

**Durée** : 6 mois  
**Objectif** : Amélioration continue basée sur usage

---

### Roadmap v1.x

#### v1.1 (Juillet 2026) - Amélioration UX
- [ ] Refonte interface utilisateur (Angular Material)
- [ ] Dark mode
- [ ] Accessibilité (WCAG 2.1 AA)
- [ ] Notifications push (web)
- [ ] Recherche avancée signalements

#### v1.2 (Août 2026) - Social & Communauté
- [ ] Forum victimes (anonyme)
- [ ] Groupes de soutien
- [ ] Chat modérateurs ↔ victimes
- [ ] Témoignages publics (anonymisés)

#### v1.3 (Sept-Oct 2026) - Reporting Avancé
- [ ] Génération rapport PDF automatique
- [ ] Export dossier complet (.zip)
- [ ] Timeline interactive incidents
- [ ] Statistiques personnelles (dashboard victime)

#### v1.4 (Nov-Déc 2026) - IA Avancée
- [ ] Analyse sentiment (détection détresse)
- [ ] Recommandations personnalisées (ressources)
- [ ] Prédiction issue procédure (ML)
- [ ] Chatbot assistance 24/7

---

## 🌍 Phase 7 : V2.0 - Mobile + API (2027)

**Durée** : 6 mois (Jan-Juin 2027)  
**Objectif** : Application mobile + Ouverture API

---

### Roadmap v2.0

#### v2.0 (Janvier-Juin 2027)
- [ ] **Application mobile native**
    - [ ] iOS (Swift)
    - [ ] Android (Kotlin)
    - [ ] Upload photo direct depuis téléphone
    - [ ] Notifications push natives
    - [ ] Géolocalisation automatique

- [ ] **API publique**
    - [ ] REST API documentée (OpenAPI)
    - [ ] Webhooks (événements)
    - [ ] SDK JavaScript/Python
    - [ ] Partenariats entreprises (intégration SIRH)

- [ ] **Expansion géographique**
    - [ ] Belgique (Néerlandais + Français)
    - [ ] Suisse (Allemand + Français + Italien)
    - [ ] Qualification juridique multi-pays

**Métriques cibles v2.0** :
- 📊 **10 000 utilisateurs** actifs
- 📊 **50% trafic mobile**
- 📊 **5 entreprises** partenaires API

---

## 🚀 Phase 8 : V3.0 - IA Avancée (2028)

**Durée** : 12 mois (2028)  
**Objectif** : Devenir référence Tech for Good

---

### Roadmap v3.0

#### v3.0 (2028)
- [ ] **IA de nouvelle génération**
    - [ ] Modèle custom (fine-tuné sur 10 000+ cas)
    - [ ] Détection précoce burnout (ML)
    - [ ] Analyse multimodale (texte + audio + vidéo)
    - [ ] Génération automatique plainte (draft juridique)

- [ ] **Partenariats entreprises**
    - [ ] Module prévention entreprises
    - [ ] Formation managers (e-learning)
    - [ ] Tableau de bord RH (anonymisé)
    - [ ] Certification "Safe Space Friendly"

- [ ] **Impact social**
    - [ ] Études scientifiques (partenariat universités)
    - [ ] Plaidoyer législatif (propositions de loi)
    - [ ] Prix Tech for Good (candidature)

**Métriques cibles v3.0** :
- 📊 **50 000 utilisateurs** actifs
- 📊 **1000 signalements/mois**
- 📊 **100 entreprises** partenaires
- 📊 **10 M€** impact économique évité (burnouts, procès)

---

## 📊 Métriques de Suivi Long Terme

### KPIs Produit

| Métrique | Année 1 | Année 2 | Année 3 |
|----------|---------|---------|---------|
| **Utilisateurs actifs** | 1 000 | 10 000 | 50 000 |
| **Signalements validés** | 200 | 2 000 | 10 000 |
| **Témoins actifs** | 50 | 500 | 2 500 |
| **Dossiers en justice** | 10 | 100 | 500 |
| **Taux de succès justice** | 60% | 70% | 80% |
| **Ressources partenaires** | 100 | 500 | 2 000 |
| **Accuracy IA** | 75% | 85% | 90% |
| **NPS (satisfaction)** | 50 | 60 | 70 |
| **Uptime** | 99% | 99.5% | 99.9% |

---

### KPIs Business (Si monétisation)

| Métrique | Année 2 | Année 3 |
|----------|---------|---------|
| **Revenus annuels** | 50 K€ | 500 K€ |
| **Partenariats entreprises** | 10 | 100 |
| **Subventions publiques** | 100 K€ | 200 K€ |
| **Modèle** | Freemium + Partenariats | SaaS Entreprises |

---

## 🎯 Facteurs Clés de Succès

### Technique
- ✅ **Sécurité** : Chiffrement robuste, conformité RGPD
- ✅ **Performance** : < 200ms API, 99.5% uptime
- ✅ **Scalabilité** : Architecture microservices
- ✅ **IA fiable** : Accuracy > 85%, amélioration continue

### Produit
- ✅ **UX/UI** : Interface intuitive, accessible
- ✅ **Mobile-first** : 50%+ trafic mobile
- ✅ **Collaboration** : Témoins engagés (30% d'actifs)
- ✅ **Ressources** : Annuaire complet (2000+ ressources)

### Business
- ✅ **Partenariats** : Associations nationales (5+)
- ✅ **Communication** : Visibilité presse (10 articles/an)
- ✅ **Impact** : Dossiers gagnés en justice (80% succès)
- ✅ **Financement** : Subventions + Partenariats (300 K€/an)

### Social
- ✅ **Confiance** : Témoignages utilisateurs positifs
- ✅ **Anonymat** : 0 fuite d'identité témoin
- ✅ **Aide réelle** : 500 victimes aidées/an
- ✅ **Prévention** : 100 entreprises sensibilisées

---

## 🚨 Risques & Mitigation

### Risques Techniques

| Risque | Impact | Probabilité | Mitigation |
|--------|--------|-------------|------------|
| Faille sécurité (chiffrement) | 🔴 Critique | Faible | Audit sécurité annuel, bug bounty |
| Fuite données | 🔴 Critique | Faible | Chiffrement end-to-end, tests intrusion |
| Panne serveur | 🟠 Élevé | Moyen | Multi-AZ deployment, backup quotidien |
| Bug IA (mauvaise qualification) | 🟡 Moyen | Moyen | Validation humaine, monitoring accuracy |

### Risques Business

| Risque | Impact | Probabilité | Mitigation |
|--------|--------|-------------|------------|
| Pas d'adoption utilisateurs | 🔴 Critique | Moyen | Beta test, marketing ciblé, partenariats |
| Concurrence (startup similaire) | 🟠 Élevé | Faible | Innovation continue, fonctionnalités uniques |
| Manque financement | 🟠 Élevé | Moyen | Diversification sources (subventions, partenariats) |
| Réglementation stricte | 🟡 Moyen | Faible | Conformité RGPD stricte, avocat conseil |

### Risques Légaux

| Risque | Impact | Probabilité | Mitigation |
|--------|--------|-------------|------------|
| Non-conformité RGPD | 🔴 Critique | Faible | DPO, audit CNIL, documentation complète |
| Poursuites (délation) | 🟠 Élevé | Faible | Témoin pas créateur signalement, CGU claires |
| Responsabilité contenu | 🟡 Moyen | Moyen | Modération, disclaimer, statut hébergeur |

---

## 📚 Ressources & Partenaires

### Partenaires Potentiels

**Associations** :
- AVFT (Association européenne contre les Violences faites aux Femmes au Travail)
- Stop Harcèlement
- Défenseur des droits
- SOS Homophobie
- SOS Racisme

**Institutionnels** :
- Ministère du Travail
- CNIL (conformité RGPD)
- Inspection du travail
- Ordres des avocats

**Entreprises** :
- OVHcloud (hébergement France)
- Qwant (respect vie privée)
- Doctolib (exemple Tech for Good)

**Financeurs** :
- BPI France (Tech for Good)
- Fondation de France
- Fondation Pierre Fabre
- Google.org

---

## 📞 Contact & Gouvernance

**Product Owner** : Alix VEYRAT
**Email** : alixveyrat@gmail.com
**LinkedIn** : https://www.linkedin.com/in/alixveyrat/

**Comité de pilotage** (futur) :
- Product Owner
- CTO (technique)
- Psychologue du travail (modération)
- Avocat spécialisé (conformité)
- Représentant association (impact)

**Rythme gouvernance** :
- Sprint Review : Toutes les 2 semaines
- Comité produit : Mensuel
- Comité stratégique : Trimestriel

---

## 🎯 Prochaines Actions

### Court Terme (0-3 mois)
- [x] Finaliser MVP (Sprint 1-5)
- [ ] Lancer formulaire collecte données IA
- [ ] Recruter 3 modérateurs bénévoles
- [ ] Préparer beta privée (Mars)

### Moyen Terme (3-6 mois)
- [ ] Beta privée (50 testeurs)
- [ ] Beta publique (500 utilisateurs)
- [ ] Partenariat 2 associations
- [ ] Article presse nationale

### Long Terme (6-12 mois)
- [ ] v1.0 production (1000 utilisateurs)
- [ ] Financement (subventions 100 K€)
- [ ] Expansion Belgique/Suisse
- [ ] Application mobile

---

**🚀 Let's make workplaces safer, together!**

---

*Document créé le 30/10/2025*  
*Version 1.0*