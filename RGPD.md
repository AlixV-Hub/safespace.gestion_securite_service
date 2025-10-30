# ANNEXE 2 : POLITIQUE DE CONFIDENTIALITÉ

**Safe Space - Plateforme de signalement et preuve collaborative**

**Date d'entrée en vigueur** : 30 octobre 2025  
**Dernière mise à jour** : 30 octobre 2025  
**Version** : 1.0

---

## 📋 SOMMAIRE

1. [Introduction](#1-introduction)
2. [Qui sommes-nous ?](#2-qui-sommes-nous)
3. [Quelles données collectons-nous ?](#3-quelles-données-collectons-nous)
4. [Pourquoi collectons-nous vos données ?](#4-pourquoi-collectons-nous-vos-données)
5. [Comment utilisons-nous vos données ?](#5-comment-utilisons-nous-vos-données)
6. [Qui a accès à vos données ?](#6-qui-a-accès-à-vos-données)
7. [Comment protégeons-nous vos données ?](#7-comment-protégeons-nous-vos-données)
8. [Combien de temps conservons-nous vos données ?](#8-combien-de-temps-conservons-nous-vos-données)
9. [Quels sont vos droits ?](#9-quels-sont-vos-droits)
10. [Cookies et technologies similaires](#10-cookies-et-technologies-similaires)
11. [Modifications de cette politique](#11-modifications-de-cette-politique)
12. [Contact](#12-contact)

---

## 1. INTRODUCTION

Bienvenue sur **Safe Space**, une plateforme dédiée à la lutte contre les violences au travail.

**Votre vie privée est notre priorité absolue.** Nous comprenons la sensibilité des situations que vous vivez et nous nous engageons à protéger vos données personnelles avec le plus haut niveau de sécurité.

Cette Politique de Confidentialité vous explique :
- ✅ Quelles données nous collectons
- ✅ Pourquoi nous les collectons
- ✅ Comment nous les protégeons
- ✅ Quels sont vos droits

**Nous respectons le Règlement Général sur la Protection des Données (RGPD)** et nous vous garantissons un contrôle total sur vos informations personnelles.

---

## 2. QUI SOMMES-NOUS ?

### Responsable de traitement
**Safe Space** est exploité par :
- **Nom** : Alix VEYRAT
- **Adresse** : Nantes
- **Email** : alixveyrat@gmail.com
- **Téléphone** : 

### Délégué à la Protection des Données (DPO)
Pour toute question relative à la protection de vos données :
- **Email DPO** : rgpd@safespace.fr [à créer]
- **Formulaire de contact** : [URL]

---

## 3. QUELLES DONNÉES COLLECTONS-NOUS ?

### 3.1. Données de compte

#### Pour les comptes identifiés
- **Email** : Pour vous connecter et recevoir des notifications importantes
- **Mot de passe** : Chiffré avec BCrypt (nous ne connaissons jamais votre mot de passe en clair)
- **Pseudonyme** : Généré automatiquement (ex: "Victime_A7X2K9") pour protéger votre identité
- **Rôle** : Victime, Témoin, Modérateur ou Administrateur
- **Date de création** : Pour gérer la durée de conservation

#### Pour les comptes anonymes
- **Pseudonyme uniquement** : Aucun email ni donnée personnelle
- **Mot de passe chiffré** : Pour sécuriser votre accès

### 3.2. Données des signalements (victimes uniquement)

- **Description textuelle** : Votre récit des faits (chiffré de bout en bout)
- **Qualification juridique** : Catégorie détectée par notre IA (harcèlement, discrimination, etc.)
- **Article de loi suggéré** : Code du travail, Code pénal
- **Score de confiance** : Précision de l'analyse IA (ex: 87%)

⚠️ **Données sensibles** (Article 9 RGPD) :
Vos signalements peuvent contenir des informations sur votre :
- Santé (burn-out, anxiété, dépression)
- Vie sexuelle (harcèlement sexuel)
- Opinions (discrimination syndicale/politique)
- Origine ethnique (discrimination raciste)
- Orientation sexuelle (discrimination homophobe)

**Nous traitons ces données uniquement avec votre consentement explicite.**

### 3.3. Données des preuves (victimes et témoins)

- **Fichiers** : Documents, photos, vidéos, enregistrements audio (chiffrés)
- **Métadonnées** : Nom du fichier (hashé), date d'upload, taille
- **Hash SHA-256** : Pour garantir l'intégrité du fichier
- **Horodatage certifié** : Pour prouver que le fichier existait à une date donnée (optionnel)

### 3.4. Données de géolocalisation (optionnel)

- **Coordonnées GPS** : Pour vous suggérer des ressources locales (avocats, associations)
- **Ville** : Si vous refusez la géolocalisation automatique
- **Rayon de recherche** : 5, 10 ou 20 km

**Important** : Vos coordonnées GPS ne sont jamais stockées, elles sont utilisées uniquement pour la recherche en temps réel.

### 3.5. Logs d'audit

- **Adresse IP** : Hashée (SHA-256) pour détecter les activités suspectes
- **Date/Heure** : De vos actions (connexion, upload, téléchargement)
- **Type d'action** : Pour garantir la sécurité du système

---

## 4. POURQUOI COLLECTONS-NOUS VOS DONNÉES ?

Nous collectons vos données pour les finalités suivantes :

### 4.1. Fournir le service
- ✅ **Créer et gérer votre compte** : Pour vous permettre d'accéder à la plateforme
- ✅ **Stocker vos signalements et preuves** : De manière sécurisée et chiffrée
- ✅ **Analyser juridiquement vos signalements** : Via notre IA pour vous orienter

### 4.2. Vous aider
- ✅ **Suggérer des ressources locales** : Avocats, associations, syndicats près de chez vous
- ✅ **Faciliter le partage de preuves** : Entre témoins et victimes, avec votre consentement

### 4.3. Garantir la sécurité
- ✅ **Détecter les activités suspectes** : Tentatives de piratage, téléchargements massifs
- ✅ **Tracer les accès aux preuves** : Pour identifier les fuites éventuelles

### 4.4. Améliorer le service
- ✅ **Réentraîner l'IA** : Avec des signalements anonymisés (uniquement avec votre consentement)
- ✅ **Corriger les erreurs de qualification** : Grâce aux modérateurs

---

## 5. COMMENT UTILISONS-NOUS VOS DONNÉES ?

### 5.1. Anonymisation automatique

**Avant toute analyse par l'IA**, nous supprimons automatiquement :
- ❌ Les noms et prénoms → Remplacés par "PERSONNE_A", "PERSONNE_B"
- ❌ Les lieux précis → Remplacés par "LIEU_X"
- ❌ Les noms d'entreprises → Remplacés par "ENTREPRISE_Y"

**Exemple** :
```
Texte original : "Mon manager Jean Dupont m'a insulté devant toute l'équipe chez Acme Corp."
Texte anonymisé : "Mon manager PERSONNE_A m'a insulté devant toute l'équipe chez ENTREPRISE_Y."
```

⚠️ **Limite** : L'anonymisation n'est pas parfaite. Évitez de mentionner des détails trop spécifiques (ex: "mon chef qui a un tatouage de dragon sur le bras gauche").

### 5.2. Chiffrement de bout en bout

- 🔐 **Tous vos signalements et preuves sont chiffrés** avec AES-256-GCM
- 🔐 **Clés uniques par fichier** : Stockées dans un système de gestion de clés sécurisé (KMS)
- 🔐 **Nous ne pouvons pas lire vos données** sans votre autorisation explicite

### 5.3. Partage de données

**Nous ne partageons JAMAIS vos données sans votre consentement explicite.**

Les seules exceptions sont :
- ⚖️ **Réquisition judiciaire** : Si un tribunal nous oblige légalement à fournir des données
- 🚨 **Danger imminent** : Si nous détectons un risque de violence imminente (harcèlement grave, menaces de mort)

---

## 6. QUI A ACCÈS À VOS DONNÉES ?

### 6.1. Accès internes

#### Vos données de compte
- ✅ **Vous** : Accès complet à vos données
- ✅ **Administrateurs système** : Uniquement en cas de support technique (avec logs d'audit)

#### Vos signalements et preuves
- ✅ **Vous** : Propriétaire exclusif
- ✅ **Destinataires que vous choisissez** : Avocat, RH, témoin (avec lien sécurisé)
- ⚠️ **Administrateurs** : Uniquement si l'IA détecte un contenu dangereux (ex: menaces de violence)

### 6.2. Accès externes

**Aucun accès externe** sauf :
- ⚖️ **Avocat de votre choix** : Si vous partagez vos preuves via lien sécurisé
- 🏢 **RH de votre entreprise** : Uniquement si vous acceptez une médiation interne
- 👮 **Autorités judiciaires** : Sur réquisition légale uniquement

### 6.3. Sous-traitants

- **Hébergeur** : OVH - Localisation : France/UE


**Tous nos sous-traitants sont liés par des contrats RGPD stricts.**

---

## 7. COMMENT PROTÉGEONS-NOUS VOS DONNÉES ?

### 7.1. Chiffrement

- 🔐 **Au repos** : AES-256-GCM pour tous les fichiers et signalements
- 🔐 **En transit** : TLS 1.3 pour toutes les communications (HTTPS)
- 🔐 **Mots de passe** : Hashés avec BCrypt (cost factor 12)

### 7.2. Authentification

- 🔑 **JWT** : Tokens d'accès (15 minutes) et de rafraîchissement (7 jours)
- 🔑 **Double authentification (2FA)** : Optionnelle via Google Authenticator, Authy (recommandée)
- 🔑 **Protection contre le brute force** : 5 tentatives maximum / 15 minutes

### 7.3. Contrôle d'accès

- 🛡️ **Rôles stricts** : Chaque utilisateur n'a accès qu'aux données nécessaires (RBAC)
- 🛡️ **Rate limiting** : 10 téléchargements/heure maximum
- 🛡️ **Détection d'activité suspecte** : Blocage automatique si téléchargements massifs

### 7.4. Audit et traçabilité

- 📜 **Logs complets** : Qui a accédé à quoi, quand et depuis quelle IP (hashée)
- 📜 **Watermarking invisible** : Chaque téléchargement de preuve est marqué pour tracer les fuites
- 📜 **Conservation des logs** : 5 ans (obligation légale)

### 7.5. Sauvegardes

- 💾 **Quotidiennes** : Sauvegardes incrémentielles chiffrées
- 💾 **Hebdomadaires** : Sauvegardes complètes chiffrées
- 💾 **Localisation** : Serveur dédié sécurisé (hors du serveur principal)
- 💾 **Rotation** : Suppression après 30 jours

---

## 8. COMBIEN DE TEMPS CONSERVONS-NOUS VOS DONNÉES ?

### 8.1. Données de compte
- ⏰ **Compte actif** : Tant que vous ne demandez pas la suppression
- ⏰ **Inactivité prolongée** : Suppression automatique après 3 ans d'inactivité (notification 3 mois avant)
- ⏰ **Après suppression volontaire** :
    - Suppression immédiate des données d'authentification
    - Conservation des logs d'audit pendant 5 ans (obligation légale)

### 8.2. Signalements et preuves
- ⏰ **Actifs** : Tant que vous ne demandez pas la suppression
- ⏰ **Après clôture du dossier judiciaire** : Jusqu'à 6 ans (prescription pénale pour harcèlement)
- ⏰ **Suppression volontaire** : Immédiate et irréversible (avec confirmation)

### 8.3. Logs d'audit
- ⏰ **Conservation** : 5 ans (obligation légale - Article L. 213-1 Code de la consommation)

### 8.4. Géolocalisation
- ⏰ **Coordonnées GPS** : Jamais stockées (calcul en temps réel uniquement)
- ⏰ **Ville saisie manuellement** : 1 an (préférence utilisateur)

---

## 9. QUELS SONT VOS DROITS ?

Conformément au RGPD, vous disposez des droits suivants :

### 9.1. Droit d'accès (Article 15)
Vous pouvez demander une copie de toutes vos données personnelles.

**Comment ?** Rendez-vous dans **Mon Compte > Exporter mes données** ou envoyez un email à rgpd@safespace.fr

### 9.2. Droit de rectification (Article 16)
Vous pouvez corriger vos données personnelles inexactes.

**Comment ?** Rendez-vous dans **Mon Compte > Modifier mes informations**

### 9.3. Droit à l'effacement / "Droit à l'oubli" (Article 17)
Vous pouvez demander la suppression de toutes vos données.

**Comment ?** Rendez-vous dans **Mon Compte > Supprimer mon compte**

⚠️ **Important** :
- La suppression est **irréversible**
- Les logs d'audit sont conservés 5 ans (obligation légale)
- Les preuves partagées avec un avocat restent accessibles par ce dernier

### 9.4. Droit à la limitation (Article 18)
Vous pouvez demander à geler temporairement votre compte sans le supprimer.

**Comment ?** Rendez-vous dans **Mon Compte > Geler mon compte**

### 9.5. Droit à la portabilité (Article 20)
Vous pouvez récupérer vos données dans un format structuré (JSON).

**Comment ?** Rendez-vous dans **Mon Compte > Exporter mes données**

### 9.6. Droit d'opposition (Article 21)
Vous pouvez refuser :
- ❌ L'analyse par IA de vos signalements
- ❌ L'utilisation de vos données pour améliorer le service (réentraînement IA)
- ❌ La géolocalisation automatique

**Comment ?** Rendez-vous dans **Mon Compte > Préférences de confidentialité**

### 9.7. Droit à l'intervention humaine (Article 22)
Si vous contestez une qualification juridique faite par l'IA, vous pouvez demander une révision par un modérateur humain.

**Comment ?** Cliquez sur **"Demander une révision humaine"** dans votre signalement

### 9.8. Droit de réclamation
Si vous estimez que vos droits ne sont pas respectés, vous pouvez déposer une plainte auprès de la CNIL :
- **Site** : https://www.cnil.fr/fr/plaintes
- **Adresse** : CNIL, 3 Place de Fontenoy, TSA 80715, 75334 PARIS CEDEX 07

---

## 10. COOKIES ET TECHNOLOGIES SIMILAIRES

### 10.1. Cookies utilisés

Nous utilisons uniquement des **cookies strictement nécessaires** au fonctionnement de la plateforme :

| Cookie | Finalité | Durée | Type |
|--------|----------|-------|------|
| `access_token` | Authentification (JWT) | 15 minutes | Essentiel |
| `refresh_token` | Renouvellement session | 7 jours | Essentiel |
| `session_id` | Gestion de session | Session | Essentiel |

**Aucun cookie publicitaire ou de tracking n'est utilisé.**

### 10.2. Vos choix
Vous pouvez désactiver les cookies dans les paramètres de votre navigateur, mais cela empêchera le bon fonctionnement de la plateforme.

---

## 11. MODIFICATIONS DE CETTE POLITIQUE

Nous pouvons modifier cette Politique de Confidentialité pour refléter les évolutions de la réglementation ou de nos pratiques.

**En cas de modification importante** :
- 📧 Vous recevrez un email de notification (si compte non-anonyme)
- 🔔 Une notification apparaîtra sur la plateforme
- ⏰ Vous aurez 30 jours pour accepter ou refuser les nouvelles conditions

**Historique des versions** :
| Date | Version | Modifications |
|------|---------|---------------|
| 30/10/2025 | 1.0 | Version initiale |

---

## 12. CONTACT

### Pour toute question sur vos données personnelles
- **Email DPO** : rgpd@safespace.fr
- **Formulaire** : [URL du formulaire de contact]
- **Délai de réponse** : 1 mois maximum (Article 12.3 RGPD)

### Pour une réclamation
- **CNIL** : https://www.cnil.fr/fr/plaintes
- **Adresse** : CNIL, 3 Place de Fontenoy, TSA 80715, 75334 PARIS CEDEX 07

---

## 🛡️ NOTRE ENGAGEMENT

**Chez Safe Space, votre vie privée est sacrée.**

Nous nous engageons à :
- ✅ Ne jamais vendre vos données
- ✅ Ne jamais partager vos données sans votre consentement
- ✅ Protéger vos données avec le plus haut niveau de sécurité
- ✅ Respecter tous vos droits RGPD
- ✅ Être transparents sur nos pratiques

**Si vous avez le moindre doute, contactez-nous : rgpd@safespace.fr**

---

**Merci de faire confiance à Safe Space pour vous accompagner dans votre démarche.**

---

*Dernière mise à jour : 30 octobre 2025*  
*Version 1.0*