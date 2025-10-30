# 📝 User Stories - Safe Space

> **Projet** : Safe Space - Plateforme de Signalement et Preuve Collaborative  
> **Version** : 1.0  
> **Date** : 30/10/2025

---

## 📊 Vue d'ensemble

**Total User Stories** : 42  
**Epics** : 8  
**Priorités** :
- 🔴 Critique : 18 US
- 🟠 Élevé : 12 US
- 🟡 Moyen : 9 US
- 🟢 Faible : 3 US

---

## 📖 Légende

| Symbole | Signification |
|---------|---------------|
| 🔴 | Critique (MVP obligatoire) |
| 🟠 | Élevé (Important pour UX) |
| 🟡 | Moyen (Nice to have) |
| 🟢 | Faible (Bonus) |

**Estimation** : Points de complexité (Fibonacci)
- 1 point = 1-2h
- 2 points = 3-4h
- 3 points = 1 jour
- 5 points = 2-3 jours
- 8 points = 1 semaine
- 13 points = 2 semaines

---

## 🎯 Epic 1 : Gestion des Utilisateurs

### US-1.1 : Inscription Victime 🔴

**En tant que** Victime  
**Je veux** créer un compte (anonyme ou identifié)  
**Pour** signaler en sécurité sans m'exposer

**Critères d'acceptation** :
- [ ] Formulaire inscription avec email + mot de passe
- [ ] Option "Compte anonyme" (génère pseudonyme automatique)
- [ ] Validation email (si non anonyme)
- [ ] Mot de passe sécurisé (min 12 caractères, BCrypt)
- [ ] Checkbox RGPD (consentement traitement données)
- [ ] Choix rôle : "Je suis victime" / "Je suis témoin" / "Les deux"

**Estimation** : 5 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 1

---

### US-1.2 : Inscription Témoin 🔴

**En tant que** Témoin  
**Je veux** créer un compte  
**Pour** aider une victime sans m'exposer

**Critères d'acceptation** :
- [ ] Même formulaire que US-1.1
- [ ] Rôle par défaut : WITNESS
- [ ] Option "Rester anonyme vis-à-vis des victimes" (cochée par défaut)
- [ ] Message explicatif : "Vos preuves peuvent aider, sans délation"

**Estimation** : 2 points (réutilise US-1.1)  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 1

---

### US-1.3 : Connexion JWT 🔴

**En tant que** Utilisateur  
**Je veux** me connecter avec email/mot de passe  
**Pour** accéder à mon coffre-fort et mes signalements

**Critères d'acceptation** :
- [ ] Endpoint POST /api/auth/login
- [ ] Génération JWT (access token + refresh token)
- [ ] Access token : durée 15 minutes
- [ ] Refresh token : durée 7 jours
- [ ] Stockage refresh token en HttpOnly cookie
- [ ] Réponse : { "accessToken": "...", "user": {...} }
- [ ] Gestion erreurs (401 si mauvais credentials)

**Estimation** : 5 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 1

---

### US-1.4 : Refresh Token 🔴

**En tant que** Utilisateur  
**Je veux** renouveler mon token automatiquement  
**Pour** rester connecté sans ressaisir mot de passe

**Critères d'acceptation** :
- [ ] Endpoint POST /api/auth/refresh
- [ ] Lecture refresh token depuis cookie
- [ ] Génération nouveau access token
- [ ] Rotation refresh token (nouveau généré à chaque appel)
- [ ] Invalidation ancien refresh token
- [ ] Réponse 401 si refresh token invalide/expiré

**Estimation** : 3 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 1

---

### US-1.5 : Déconnexion 🟡

**En tant que** Utilisateur  
**Je veux** me déconnecter  
**Pour** sécuriser mon compte sur appareil partagé

**Critères d'acceptation** :
- [ ] Endpoint POST /api/auth/logout
- [ ] Invalidation refresh token en BDD
- [ ] Suppression cookie HttpOnly
- [ ] Réponse 200 OK

**Estimation** : 2 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 2

---

### US-1.6 : Activation 2FA 🟡

**En tant que** Utilisateur  
**Je veux** activer l'authentification à deux facteurs  
**Pour** renforcer la sécurité de mon compte

**Critères d'acceptation** :
- [ ] Endpoint POST /api/auth/2fa/enable
- [ ] Génération QR Code (Google Authenticator, Authy)
- [ ] Validation code à 6 chiffres
- [ ] Stockage secret 2FA chiffré en BDD
- [ ] Flag two_factor_enabled = true

**Estimation** : 8 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 6 (bonus)

---

### US-1.7 : Profil Utilisateur 🟡

**En tant que** Utilisateur  
**Je veux** voir et modifier mon profil  
**Pour** mettre à jour mes informations

**Critères d'acceptation** :
- [ ] Endpoint GET /api/users/me (infos utilisateur connecté)
- [ ] Endpoint PUT /api/users/me (update profil)
- [ ] Champs modifiables : pseudonym, phone (chiffré)
- [ ] Champs non modifiables : email, role
- [ ] Changement email : nécessite validation (séparé)
- [ ] Changement mot de passe : endpoint dédié (séparé)

**Estimation** : 3 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 3

---

### US-1.8 : Suppression Compte 🟡

**En tant que** Utilisateur  
**Je veux** supprimer mon compte  
**Pour** exercer mon droit à l'oubli (RGPD)

**Critères d'acceptation** :
- [ ] Endpoint DELETE /api/users/me
- [ ] Confirmation obligatoire (saisie mot de passe)
- [ ] Suppression cascades :
    - [ ] Signalements (si victime)
    - [ ] Preuves (coffre-fort)
    - [ ] Evidence_offers (si témoin)
- [ ] Anonymisation données dans audit_logs (pas suppression)
- [ ] Envoi email confirmation suppression

**Estimation** : 5 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 5

---

## 🎯 Epic 2 : Signalements (Victimes uniquement)

### US-2.1 : Création Signalement avec IA 🔴

**En tant que** Victime  
**Je veux** créer un signalement avec l'aide de l'IA  
**Pour** qualifier correctement les faits juridiquement

**Critères d'acceptation** :
- [ ] Endpoint POST /api/signalements
- [ ] Champs obligatoires : description, first_incident_date
- [ ] Appel Service A (IA) pour classification automatique
- [ ] Stockage : ai_category, ai_confidence, ai_legal_qualification
- [ ] Chiffrement description en BDD (pgcrypto)
- [ ] Statut initial : DRAFT
- [ ] Réponse : signalement créé + qualification IA

**Estimation** : 8 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 2

---

### US-2.2 : Formulaire Intelligent (Questions IA) 🟠

**En tant que** Victime  
**Je veux** que l'IA me pose des questions guidées  
**Pour** compléter mon témoignage efficacement

**Critères d'acceptation** :
- [ ] WebSocket /api/qualify/stream
- [ ] Service B appelle Service A pour questions adaptatives
- [ ] Questions envoyées en temps réel selon texte tapé
- [ ] Format question : { id, text, type, weight }
- [ ] Types supportés : yes_no, text, multiple_choice
- [ ] Réponses stockées : signalement.user_answers (JSONB)

**Estimation** : 8 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 4

---

### US-2.3 : Qualification Juridique Auto 🟠

**En tant que** Victime  
**Je veux** obtenir une qualification juridique automatique  
**Pour** comprendre la nature juridique des faits

**Critères d'acceptation** :
- [ ] Affichage qualification après soumission signalement
- [ ] Format :
    - [ ] Catégorie principale (ex: "Harcèlement moral")
    - [ ] Article de loi (ex: "Article L1152-1 Code du travail")
    - [ ] Texte complet de l'article
    - [ ] Confiance IA (ex: 89%)
    - [ ] Sous-catégories (ex: ["isolement", "surcharge"])
- [ ] Badge de gravité : LOW/MEDIUM/HIGH/CRITICAL
- [ ] Possibilité de corriger si IA s'est trompée

**Estimation** : 5 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 2

---

### US-2.4 : Voir Preuves Disponibles (Témoins) 🔴

**En tant que** Victime  
**Je veux** voir les preuves mises à disposition par des témoins  
**Pour** compléter mon dossier

**Critères d'acceptation** :
- [ ] Endpoint GET /api/evidence-offers/for-me
- [ ] Affichage liste preuves PENDING
- [ ] Informations visibles :
    - [ ] "Témoin anonyme" (pas d'identité)
    - [ ] Type preuve (screenshot, audio, document)
    - [ ] Date incident
    - [ ] Description (chiffrée, déchiffrée pour victime)
    - [ ] Catégorie IA suggérée
- [ ] Actions : Accepter / Décliner / Voir détails
- [ ] Notification badge (nombre preuves en attente)

**Estimation** : 5 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 3

---

### US-2.5 : Accepter Preuve Témoin 🔴

**En tant que** Victime  
**Je veux** accepter une preuve proposée par un témoin  
**Pour** l'ajouter à mon dossier

**Critères d'acceptation** :
- [ ] Endpoint POST /api/evidence-offers/{id}/accept
- [ ] Vérification : offer.victim_id = user.id
- [ ] Copie preuve dans coffre-fort victime :
    - [ ] Nouvelle entrée evidences (owner = victime)
    - [ ] Lien signalement_id
    - [ ] Conservation origin = "WITNESS_OFFER"
- [ ] Update evidence_offer.status = ACCEPTED
- [ ] Notification témoin (optionnel, anonyme) : "Votre preuve a été acceptée"

**Estimation** : 5 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 3

---

### US-2.6 : Décliner Preuve Témoin 🟡

**En tant que** Victime  
**Je veux** décliner une preuve proposée  
**Pour** garder le contrôle de mon dossier

**Critères d'acceptation** :
- [ ] Endpoint POST /api/evidence-offers/{id}/decline
- [ ] Update evidence_offer.status = DECLINED
- [ ] Preuve reste dans coffre-fort témoin (pas supprimée)
- [ ] Notification témoin : "Preuve déclinée"

**Estimation** : 2 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 3

---

### US-2.7 : Soumettre Signalement 🔴

**En tant que** Victime  
**Je veux** soumettre mon signalement (DRAFT → SUBMITTED)  
**Pour** qu'il soit examiné

**Critères d'acceptation** :
- [ ] Endpoint POST /api/signalements/{id}/submit
- [ ] Vérification champs obligatoires remplis
- [ ] Update status = SUBMITTED
- [ ] Horodatage submitted_at
- [ ] Si is_critical = true → Notification modérateurs

**Estimation** : 3 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 2

---

### US-2.8 : Modifier Signalement (DRAFT) 🟡

**En tant que** Victime  
**Je veux** modifier mon signalement tant qu'il est en DRAFT  
**Pour** corriger/compléter les informations

**Critères d'acceptation** :
- [ ] Endpoint PUT /api/signalements/{id}
- [ ] Autorisation seulement si status = DRAFT
- [ ] Re-qualification IA si description modifiée
- [ ] Champs modifiables : description, dates, lieu, entreprise

**Estimation** : 3 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 3

---

### US-2.9 : Voir Historique Signalement 🟡

**En tant que** Victime  
**Je veux** voir l'historique de mon signalement  
**Pour** suivre son évolution (DRAFT → SUBMITTED → VALIDATED)

**Critères d'acceptation** :
- [ ] Endpoint GET /api/signalements/{id}/history
- [ ] Timeline affichant :
    - [ ] Date création (DRAFT)
    - [ ] Date soumission (SUBMITTED)
    - [ ] Date validation (VALIDATED si applicable)
    - [ ] Changements statut
- [ ] Affichage front-end : Timeline verticale

**Estimation** : 3 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 5

---

## 🎯 Epic 3 : Coffre-Fort (Victimes + Témoins)

### US-3.1 : Upload Preuve (Victime) 🔴

**En tant que** Victime  
**Je veux** uploader mes preuves (screenshots, documents, etc.)  
**Pour** les conserver de manière sécurisée

**Critères d'acceptation** :
- [ ] Endpoint POST /api/evidences/upload (multipart/form-data)
- [ ] Types acceptés : image/*, application/pdf, .docx, .txt
- [ ] Taille max : 50 MB
- [ ] Chiffrement AES-256 avant stockage
- [ ] Génération file_hash (SHA-256)
- [ ] Stockage local : /storage/evidences/{user_id}/{evidence_id}.enc
- [ ] Métadonnées BDD : file_name, file_type, file_size, incident_date
- [ ] owner_type = VICTIM
- [ ] Lien optionnel signalement_id

**Estimation** : 8 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 2

---

### US-3.2 : Upload Preuve (Témoin) 🔴

**En tant que** Témoin  
**Je veux** uploader des preuves d'une agression dont je suis témoin  
**Pour** les mettre à disposition d'une victime

**Critères d'acceptation** :
- [ ] Même endpoint que US-3.1
- [ ] owner_type = WITNESS
- [ ] PAS de lien signalement_id (témoin ne crée pas signalement)
- [ ] Champ description obligatoire : "Décrivez ce que vous avez vu"
- [ ] Classification IA automatique (catégorie suggérée)

**Estimation** : 3 points (réutilise US-3.1)  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 2

---

### US-3.3 : Caractérisation Preuve avec IA 🟠

**En tant que** Témoin ou Victime  
**Je veux** que l'IA caractérise ma preuve  
**Pour** la qualifier juridiquement

**Critères d'acceptation** :
- [ ] Après upload, appel Service A avec description
- [ ] IA retourne : category, tags, confidence
- [ ] Stockage en BDD : evidences.category, evidences.tags
- [ ] Affichage à l'utilisateur : "Cette preuve correspond à : Harcèlement moral"

**Estimation** : 5 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 3

---

### US-3.4 : Mettre Preuve à Disposition (Témoin → Victime) 🔴

**En tant que** Témoin  
**Je veux** mettre mes preuves à disposition d'une victime  
**Pour** l'aider sans faire de délation

**Critères d'acceptation** :
- [ ] Endpoint POST /api/evidence-offers/create
- [ ] Body : { evidence_id, victim_email, message (optionnel) }
- [ ] Recherche victime par email (si inscrite)
- [ ] Si victime pas inscrite : génération share_code (6 chiffres)
- [ ] witness_is_anonymous = true (par défaut)
- [ ] Notification victime (si inscrite)
- [ ] Témoin peut partager code à victime hors plateforme

**Estimation** : 8 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 3

---

### US-3.5 : Générer Code Partage 🟠

**En tant que** Témoin  
**Je veux** générer un code de partage  
**Pour** le donner discrètement à une victime

**Critères d'acceptation** :
- [ ] Option dans US-3.4 : "Générer code au lieu de chercher victime"
- [ ] Code format : SAFE-XXXX (4 chiffres)
- [ ] Expiration : 30 jours
- [ ] Affichage : "Partagez ce code avec la victime : SAFE-8472"
- [ ] Victime peut utiliser code pour récupérer preuve

**Estimation** : 3 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 3

---

### US-3.6 : Utiliser Code Partage (Victime) 🟠

**En tant que** Victime  
**Je veux** entrer un code de partage reçu d'un témoin  
**Pour** accéder aux preuves proposées

**Critères d'acceptation** :
- [ ] Endpoint POST /api/evidence-offers/claim-code
- [ ] Body : { share_code: "SAFE-8472" }
- [ ] Vérification code valide et non expiré
- [ ] Association offer à victim_id
- [ ] Affichage preuve dans "Preuves disponibles"
- [ ] Victime peut accepter/décliner

**Estimation** : 5 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 3

---

### US-3.7 : Anonymat Témoin 🔴

**En tant que** Témoin  
**Je veux** rester anonyme vis-à-vis de la victime  
**Pour** me protéger des représailles

**Critères d'acceptation** :
- [ ] witness_is_anonymous = true par défaut
- [ ] Victime voit "Témoin anonyme" (pas d'email, pas de nom)
- [ ] Aucune information identifiante dans evidence_offer
- [ ] Même si victime accepte, témoin reste anonyme
- [ ] Option pour témoin : "Révéler mon identité" (optionnel, US future)

**Estimation** : 2 points (géré dans US-3.4)  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 3

---

### US-3.8 : Download Preuve 🔴

**En tant que** Victime  
**Je veux** télécharger mes preuves  
**Pour** les utiliser hors plateforme

**Critères d'acceptation** :
- [ ] Endpoint GET /api/evidences/{id}/download
- [ ] Vérification : user.id = evidence.owner_id OU preuve partagée avec user
- [ ] Déchiffrement à la volée
- [ ] Headers : Content-Disposition, Content-Type
- [ ] Log accès dans evidence_access_logs
- [ ] Rate limiting : 10 downloads/heure/user

**Estimation** : 5 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 2

---

### US-3.9 : Horodatage Certifié 🟡

**En tant que** Utilisateur  
**Je veux** un horodatage certifié de mes preuves  
**Pour** prouver qu'elles existaient à une date donnée

**Critères d'acceptation** :
- [ ] Lors upload : Appel serveur timestamping (RFC 3161)
- [ ] Génération timestamp_token
- [ ] Stockage en BDD : evidences.timestamp_token
- [ ] Affichage à l'utilisateur : "Preuve certifiée le 30/10/2025 à 14:32"
- [ ] Option download timestamp (fichier .tsr)

**Estimation** : 8 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 6 (bonus)

---

### US-3.10 : Avertissement Légal Audio/Vidéo 🟠

**En tant que** Utilisateur  
**Je veux** être averti des risques légaux avant upload audio/vidéo  
**Pour** éviter des problèmes juridiques

**Critères d'acceptation** :
- [ ] Détection type fichier : audio/* ou video/*
- [ ] Popup modale obligatoire :
    - [ ] Titre : "⚠️ Avertissement Légal"
    - [ ] Message : Article 226-1 Code pénal, risques encourus
    - [ ] Checkbox : "J'ai compris et j'accepte les risques"
    - [ ] Boutons : "Annuler" / "Continuer"
- [ ] Si annule → Pas d'upload
- [ ] Si accepte → legal_warning_accepted = true en BDD

**Estimation** : 3 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 2

---

### US-3.11 : Suppression Preuve 🟡

**En tant que** Utilisateur  
**Je veux** supprimer une preuve de mon coffre-fort  
**Pour** nettoyer mon espace

**Critères d'acceptation** :
- [ ] Endpoint DELETE /api/evidences/{id}
- [ ] Vérification propriété
- [ ] Confirmation obligatoire (popup)
- [ ] Suppression fichier chiffré (storage)
- [ ] Suppression métadonnées BDD
- [ ] Si preuve dans evidence_offer → Invalidation offer
- [ ] Log suppression (audit)

**Estimation** : 3 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 5

---

## 🎯 Epic 4 : Partage Dossier (Victimes → Avocats/RH/Autorités)

### US-4.1 : Partager avec Avocat 🔴

**En tant que** Victime  
**Je veux** partager mon dossier complet avec mon avocat  
**Pour** qu'il puisse me défendre

**Critères d'acceptation** :
- [ ] Endpoint POST /api/evidence-shares/share-with-lawyer
- [ ] Body : { evidence_ids[], lawyer_email, lawyer_name, duration_days }
- [ ] Génération token JWT temporaire (pour avocat)
- [ ] Envoi email avocat avec lien d'accès
- [ ] Lien format : https://safe-space.com/shared/{token}
- [ ] Expiration : duration_days (défaut 30 jours)
- [ ] Avocat peut view + download
- [ ] Log tous les accès

**Estimation** : 8 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 4

---

### US-4.2 : Partager avec RH (Consentement Explicite) 🟡

**En tant que** Victime  
**Je veux** partager avec RH de mon entreprise  
**Pour** tenter résolution interne

**Critères d'acceptation** :
- [ ] Popup modale consentement explicite :
    - [ ] Texte : "En partageant avec RH, vous acceptez..."
    - [ ] Checkbox : "J'autorise le partage"
    - [ ] Signature électronique (nom + date)
- [ ] Stockage consent_text, consent_signature_hash
- [ ] RH peut seulement VIEW (pas download)
- [ ] can_download = false, can_view_only = true
- [ ] Révocable à tout moment

**Estimation** : 8 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 5 (bonus)

---

### US-4.3 : Révoquer Accès 🟠

**En tant que** Victime  
**Je veux** révoquer un accès partagé (sauf autorités)  
**Pour** garder le contrôle

**Critères d'acceptation** :
- [ ] Endpoint POST /api/evidence-shares/{id}/revoke
- [ ] Update revoked_at = NOW()
- [ ] Invalidation token JWT
- [ ] Si shared_with_type = AUTHORITY → Erreur "Impossible de révoquer autorités"
- [ ] Notification destinataire : "Accès révoqué"

**Estimation** : 3 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 4

---

### US-4.4 : Historique Accès 🟠

**En tant que** Victime  
**Je veux** voir qui a accédé à mes preuves  
**Pour** contrôler l'utilisation de mes données

**Critères d'acceptation** :
- [ ] Endpoint GET /api/evidences/{id}/access-logs
- [ ] Affichage tableau :
    - [ ] Date/heure
    - [ ] Qui (email avocat/RH ou "Autorités")
    - [ ] Action (VIEW, DOWNLOAD)
    - [ ] IP (optionnel)
- [ ] Pagination (20 logs/page)
- [ ] Filtre par date

**Estimation** : 5 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 5

---

### US-4.5 : Accès Autorités (Réquisition) 🟡

**En tant que** Autorité (Police, Justice)  
**Je veux** accéder à des preuves sur réquisition judiciaire  
**Pour** mener mon enquête

**Critères d'acceptation** :
- [ ] Endpoint POST /api/evidence-shares/authority-access
- [ ] Upload document réquisition (PDF)
- [ ] Vérification identité autorité (certificat électronique)
- [ ] Accès permanent (pas d'expiration)
- [ ] Notification victime automatique (RGPD)
- [ ] Log renforcé (réquisition_reference, document_path)

**Estimation** : 13 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 7 (bonus)

---

## 🎯 Epic 5 : Ressources Géolocalisées

### US-5.1 : Rechercher Avocat Spécialisé 🟠

**En tant que** Victime ou Témoin  
**Je veux** trouver un avocat spécialisé près de chez moi  
**Pour** obtenir de l'aide juridique

**Critères d'acceptation** :
- [ ] Endpoint GET /api/ressources/search
- [ ] Paramètres : type=LAWYER, lat, lon, radius (km)
- [ ] Requête PostGIS (ST_DWithin)
- [ ] Filtres :
    - [ ] Spécialités (harassment, discrimination, sexual_harassment)
    - [ ] Gratuit / Aide juridictionnelle
    - [ ] Langues parlées
- [ ] Résultat : Liste ressources triées par distance
- [ ] Format : { name, address, distance_km, phone, email, website }

**Estimation** : 8 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 4

---

### US-5.2 : Rechercher Associations 🟠

**En tant que** Victime ou Témoin  
**Je veux** voir les associations d'aide aux victimes  
**Pour** être accompagné(e)

**Critères d'acceptation** :
- [ ] Même endpoint que US-5.1
- [ ] Paramètre : type=ASSOCIATION
- [ ] Affichage carte interactive (Leaflet)
- [ ] Marqueurs cliquables (popup infos)

**Estimation** : 3 points (réutilise US-5.1)  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 4

---

### US-5.3 : Ajouter Ressource (Modérateur) 🟡

**En tant que** Modérateur  
**Je veux** ajouter une nouvelle ressource (avocat, asso, etc.)  
**Pour** enrichir l'annuaire

**Critères d'acceptation** :
- [ ] Endpoint POST /api/ressources (ROLE_MODERATOR)
- [ ] Formulaire complet : nom, type, adresse, coordonnées, spécialités
- [ ] Géocodage automatique (adresse → lat/lon) via API (Nominatim)
- [ ] Statut initial : PENDING
- [ ] Validation par admin nécessaire avant publication

**Estimation** : 5 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 5

---

### US-5.4 : Valider Ressource (Admin) 🟡

**En tant que** Admin  
**Je veux** valider les ressources en attente  
**Pour** garantir leur fiabilité

**Critères d'acceptation** :
- [ ] Endpoint GET /api/ressources/pending (ROLE_ADMIN)
- [ ] Liste ressources avec status = PENDING
- [ ] Actions : Approuver / Rejeter
- [ ] Si approuvé : status = VALIDATED, validated_by = admin_id
- [ ] Si rejeté : Suppression

**Estimation** : 3 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 5

---

### US-5.5 : Carte Interactive 🟠

**En tant que** Utilisateur  
**Je veux** voir les ressources sur une carte  
**Pour** visualiser facilement la proximité

**Critères d'acceptation** :
- [ ] Intégration Leaflet + OpenStreetMap
- [ ] Marqueurs colorés par type (🔵 avocat, 🟢 asso, 🟡 syndicat, 🔴 psy)
- [ ] Popup au clic : Nom, adresse, distance, bouton "Contacter"
- [ ] Géolocalisation utilisateur (avec permission)
- [ ] Cercle rayon de recherche visible

**Estimation** : 8 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 4

---

## 🎯 Epic 6 : Qualification IA (Service A)

### US-6.1 : Classification Automatique 🔴

**En tant que** Service C  
**Je veux** appeler Service A pour classifier un témoignage  
**Pour** obtenir une qualification juridique

**Critères d'acceptation** :
- [ ] Endpoint POST /api/ai/classify (Service A - Python)
- [ ] Body : { text: "...", user_answers: {...} }
- [ ] Algorithme classification :
    - [ ] Extraction keywords (NLP - spaCy)
    - [ ] Calcul scores par règle
    - [ ] Sélection meilleure catégorie
    - [ ] Si confiance < 70% → Appel LLM
- [ ] Réponse : { category, confidence, legal_code, legal_text, sub_categories, severity }
- [ ] Temps réponse : < 2s

**Estimation** : 13 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 3

---

### US-6.2 : Génération Questions Adaptatives 🟠

**En tant que** Service B  
**Je veux** obtenir les prochaines questions à poser  
**Pour** guider l'utilisateur

**Critères d'acceptation** :
- [ ] Endpoint POST /api/ai/next-questions (Service A)
- [ ] Body : { text, previous_answers }
- [ ] Analyse : Détection catégorie probable
- [ ] Récupération questions depuis qualification_rules
- [ ] Tri par poids (weight)
- [ ] Retour top 3 questions non posées
- [ ] Format : [{ id, text, type, weight }]

**Estimation** : 8 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 4

---

### US-6.3 : Base de Connaissance Juridique 🟠

**En tant que** Admin IA  
**Je veux** gérer les règles de qualification  
**Pour** améliorer la précision

**Critères d'acceptation** :
- [ ] Table qualification_rules pré-remplie :
    - [ ] Harcèlement moral
    - [ ] Harcèlement sexuel
    - [ ] Discrimination raciste
    - [ ] Discrimination sexiste
    - [ ] Discrimination homophobe
    - [ ] Agissements sexistes
    - [ ] Conditions travail dangereuses
- [ ] Chaque règle : criteria, questions, keywords, legal_text
- [ ] Endpoint CRUD /api/ai/rules (ROLE_ADMIN)

**Estimation** : 8 points  
**Priorité** : 🟠 Élevé  
**Sprint** : Sprint 3

---

### US-6.4 : Suggestions Temps Réel (WebSocket) 🟡

**En tant que** Utilisateur  
**Je veux** voir des suggestions IA pendant que je tape  
**Pour** m'aider à structurer mon témoignage

**Critères d'acceptation** :
- [ ] WebSocket /api/qualify/stream (Service B)
- [ ] Debounce 500ms
- [ ] Appel Service A avec texte partiel
- [ ] Retour : catégories probables, mots-clés détectés
- [ ] Affichage badges temps réel : "IA détecte : Harcèlement moral"

**Estimation** : 8 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 6 (bonus)

---

### US-6.5 : Historique Qualifications (MLOps) 🟢

**En tant que** Data Scientist  
**Je veux** stocker les qualifications validées/corrigées  
**Pour** réentraîner le modèle

**Critères d'acceptation** :
- [ ] Table qualification_history
- [ ] Insertion après validation modérateur
- [ ] Champs : ai_category, validated_category, correction_reason
- [ ] Export CSV pour réentraînement
- [ ] Endpoint GET /api/ai/training-data (ROLE_ADMIN)

**Estimation** : 5 points  
**Priorité** : 🟢 Faible  
**Sprint** : Sprint 8 (bonus MLOps)

---

## 🎯 Epic 7 : Modération

### US-7.1 : Dashboard Modérateur 🟡

**En tant que** Modérateur  
**Je veux** voir les signalements en attente  
**Pour** les examiner

**Critères d'acceptation** :
- [ ] Endpoint GET /api/signalements/pending (ROLE_MODERATOR)
- [ ] Liste signalements status = SUBMITTED
- [ ] Tri par priorité (CRITICAL en premier)
- [ ] Affichage : titre, date, catégorie IA, confiance
- [ ] Actions : Voir détails / Valider / Rejeter

**Estimation** : 5 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 5

---

### US-7.2 : Valider Signalement 🟡

**En tant que** Modérateur  
**Je veux** valider un signalement  
**Pour** confirmer sa légitimité

**Critères d'acceptation** :
- [ ] Endpoint POST /api/signalements/{id}/validate (ROLE_MODERATOR)
- [ ] Update status = VALIDATED
- [ ] Horodatage reviewed_at, reviewed_by
- [ ] Option : Corriger catégorie IA si erreur
- [ ] Si correction → Stockage dans qualification_history (MLOps)

**Estimation** : 3 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 5

---

### US-7.3 : Détecter Cas Critique 🔴

**En tant que** Système  
**Je veux** détecter automatiquement les cas critiques  
**Pour** alerter rapidement

**Critères d'acceptation** :
- [ ] Détection mots-clés : ["viol", "violence physique", "menace de mort", "suicide"]
- [ ] Si détecté → is_critical = true
- [ ] Notification immédiate modérateurs (email + push)
- [ ] Badge URGENT dans dashboard
- [ ] Délai traitement : < 1h

**Estimation** : 5 points  
**Priorité** : 🔴 Critique  
**Sprint** : Sprint 5

---

### US-7.4 : Signaler Autorités 🟡

**En tant que** Modérateur  
**Je veux** signaler un cas critique aux autorités  
**Pour** respecter l'obligation légale (Article 434-3)

**Critères d'acceptation** :
- [ ] Bouton "Signaler autorités" (cas critiques uniquement)
- [ ] Génération rapport PDF :
    - [ ] Résumé signalement (anonymisé)
    - [ ] Catégorie juridique
    - [ ] Preuves disponibles (liste)
    - [ ] Urgence
- [ ] Envoi email autorité compétente
- [ ] Update authorities_notified = true
- [ ] Notification victime (RGPD)

**Estimation** : 8 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 7 (bonus)

---

## 🎯 Epic 8 : Administration & Monitoring

### US-8.1 : Dashboard Admin 🟡

**En tant que** Admin  
**Je veux** voir des statistiques globales  
**Pour** monitorer la plateforme

**Critères d'acceptation** :
- [ ] Endpoint GET /api/admin/stats (ROLE_ADMIN)
- [ ] Métriques :
    - [ ] Nombre users (par rôle)
    - [ ] Nombre signalements (par statut)
    - [ ] Nombre preuves (par type)
    - [ ] Nombre evidence_offers (PENDING, ACCEPTED)
    - [ ] Accuracy IA (si MLOps activé)
- [ ] Graphiques : Charts.js ou Recharts
- [ ] Période : 7 jours, 30 jours, tout

**Estimation** : 8 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 6 (bonus)

---

### US-8.2 : Logs d'Audit 🟡

**En tant que** Admin  
**Je veux** consulter les logs d'audit  
**Pour** tracer les actions sensibles

**Critères d'acceptation** :
- [ ] Endpoint GET /api/admin/audit-logs (ROLE_ADMIN)
- [ ] Logs : Toutes actions sur evidences, shares, signalements
- [ ] Filtres : user, action, date range
- [ ] Export CSV
- [ ] Conservation : 5 ans

**Estimation** : 5 points  
**Priorité** : 🟡 Moyen  
**Sprint** : Sprint 6 (bonus)

---

### US-8.3 : Gestion Utilisateurs (Admin) 🟢

**En tant que** Admin  
**Je veux** gérer les comptes utilisateurs  
**Pour** résoudre problèmes support

**Critères d'acceptation** :
- [ ] Endpoint GET /api/admin/users (ROLE_ADMIN)
- [ ] Liste tous users avec rôles
- [ ] Actions :
    - [ ] Verrouiller compte (account_locked = true)
    - [ ] Déverrouiller
    - [ ] Changer rôle (MODERATOR <-> USER)
    - [ ] Supprimer compte (cascade)
- [ ] Recherche par email

**Estimation** : 5 points  
**Priorité** : 🟢 Faible  
**Sprint** : Sprint 7 (bonus)

---

## 📊 Récapitulatif par Priorité

### 🔴 Critiques (MVP) : 18 US

| Epic | US | Titre | Points |
|------|----|----|--------|
| 1 | 1.1 | Inscription Victime | 5 |
| 1 | 1.2 | Inscription Témoin | 2 |
| 1 | 1.3 | Connexion JWT | 5 |
| 1 | 1.4 | Refresh Token | 3 |
| 2 | 2.1 | Création Signalement IA | 8 |
| 2 | 2.4 | Voir Preuves Disponibles | 5 |
| 2 | 2.5 | Accepter Preuve Témoin | 5 |
| 2 | 2.7 | Soumettre Signalement | 3 |
| 3 | 3.1 | Upload Preuve Victime | 8 |
| 3 | 3.2 | Upload Preuve Témoin | 3 |
| 3 | 3.4 | Mise à Disposition | 8 |
| 3 | 3.7 | Anonymat Témoin | 2 |
| 3 | 3.8 | Download Preuve | 5 |
| 4 | 4.1 | Partage Avocat | 8 |
| 6 | 6.1 | Classification IA | 13 |
| 7 | 7.3 | Détection Cas Critique | 5 |

**Total Critiques : 88 points**

---

### 🟠 Élevées : 12 US

| Epic | US | Titre | Points |
|------|----|----|--------|
| 2 | 2.2 | Questions IA Adaptatives | 8 |
| 2 | 2.3 | Qualification Juridique | 5 |
| 3 | 3.3 | Caractérisation Preuve IA | 5 |
| 3 | 3.5 | Générer Code Partage | 3 |
| 3 | 3.6 | Utiliser Code Partage | 5 |
| 3 | 3.10 | Avertissement Légal Audio | 3 |
| 4 | 4.3 | Révoquer Accès | 3 |
| 4 | 4.4 | Historique Accès | 5 |
| 5 | 5.1 | Recherche Avocat | 8 |
| 5 | 5.2 | Recherche Associations | 3 |
| 5 | 5.5 | Carte Interactive | 8 |
| 6 | 6.2 | Questions Adaptatives | 8 |
| 6 | 6.3 | Base Connaissance | 8 |

**Total Élevées : 72 points**

---

### 🟡 Moyennes : 9 US

**Total : 50 points**

### 🟢 Faibles : 3 US

**Total : 15 points**

---

## 📈 Total Général

**Total US** : 42  
**Total Points** : 225 points  
**Estimation temps** : ~225 heures (≈ 30 jours de travail)

---

*Document créé le 30/10/2025*  
*Version 1.0*