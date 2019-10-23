

********************************************************************************
********************************************************************************

                                    Introduction

********************************************************************************
********************************************************************************
La banque ProxiBanque souhaite créer une application permettant à ses conseillers de gérer 
leurs clients et services à forte valeur ajoutée, comme le service de virement compte à compte.
Ce dépôt contient le projets réalisé lors de la formation JOBINTECH du 14/10/2019 au 23/10/2019.

Le  projet ProxiBanque v4 réaliser avec :
 
-Front : Angular 
-Logique : Spring boot/modèle en couche avec API REST (JAX-RS)
-Back : MySQL

Afin de cloner le dépôt, utiliser la commande suivante :

====> git clone https://github.com/anassedy/ProxiBanKV4

********************************************************************************
********************************************************************************

            Fonctionnalités de l'application

********************************************************************************
********************************************************************************


####L'authentification 

Sur l'écran authentification; le conseiller,le gérant ou le paramétrage, rentrent leurs Login et password pour accéder à la ptalforme Proxibanque

####Créer conseiller

S'identifier en tant que gérant en renseignant login et mot de passe.
Sur l'écran liste des conseiller,cliquer sur le bouton Ajouter conseiller
Remplir le formulaire
Valider

####Modifier conseiller

Cliquer sur le bouton Modifier conseiller pour un conseiller spécifique pour accéder à un formulaire d'information conseiller
Rentrer les valeurs à modifier
Cliquer sur valider
Une confirmation apparaît, puis vous êtes ramener vers la listes des conseillers
Le bouton logout dirige le gérant vers la page de d'autentification de l'application

####Supprimer conseiller

Pour le gérant, cliquer sur le bouton Supprimer conseiller pour un conseiller spécifique sur la liste des conseiller
Une confirmation apparaît

####Créer client

S'identifier en tant que conseiller en renseignant login et mot de passe.
La liste des clients du conseiller s'affiche, avec les actions possibles pour chaque client.(supprimer ou Editer un client)
En haut de la liste, cliquer sur le bouton Ajouter Conseiller. Remplir le formulaire et valider.
Au retour à la liste des client,celui ci est ajouté à la liste.

####Modifier client

Cliquer sur le bouton Modifier client pour un client spécifique pour accéder à un formulaire d'information client
Rentrer les valeurs à modifier
Cliquer sur valider
Une confirmation apparaît, puis vous êtes ramener vers la listes des clients
Le bouton logout dirige le conseiller vers la page de d'autentification de l'application

####Supprimer client

Cliquer sur le bouton Supprimer client our un client spécifique sur la liste des client
Une confirmation apparaît

####Créer un compte

La procédure pour créer un compte courant ou un compte épargne est similaire
Cliquer sur le bouton Créer compte courant ou Créer compte épargne
Renseigner les champs demandés, puis valider
Une confirmation apparaît

####Visualiser la liste des compte des clients pour un conseiller donné

Cliquer sur le bouton Liste comptes en haut 
La liste des comptes gérer par un conseiller apparaît


####Effectuer un virement compte à compte 

Pour un conseiller, Cliquer sur le bouton Effectuer un virement en haut, dans la page renter l'Id du client emetteur, puis l'Id du client récépteur 
ensuite rentrer le montant que vous souhaitez viré.
Une confirmation apparaît, puis vous êtes ramené à la liste des client.

####Paramétrage

L'écran de paramétrage permet de fixer des informations spécifiques par défaut : 
•	Commission sur les virements 
•	Nombre maximum de clients par conseillers
•	Nombre maximum de conseillers
•	Style de graphe pour l’écran de transactions : Histogramme ou camembert

********************************************************************************
********************************************************************************

            Déploiement de l'application

********************************************************************************
********************************************************************************
==> Partie Data-Base:
Dans le dossier server, appuier sur 'xampp-control.exe' pour démarrer le serveur Apache sur le port 80, 443 et MySQL sur le port "selon vous", 
ensuite accéder à l'intérface Php My Admin, crée un Nouvelle BD sous le non 'proxibanquev4' puis importer le fichier 'proxibanquev4 .sql' 


==> Partie Back-end:
Sur Eclipse, importer le fichier source du projet 'ProxiBanqueV4', ensuite accéder à la classe main 'ProxiBanqueV4Application'dans le package 'ma.jit'
et executer le projet en tant que 'spring boot app'
Si vous un port quelconque pour MySQL, modifier le sur le fichier 'application.properties' dans le dossier 'src/main/ressources'

==> Partie Front-end:
sur le dossier front-end, ouvrir le dossier 'server', puis sur la cmd lancer la commande 'json-server --watch db.json',
puis sur votre éditeur de code, dans Terminal, lancer la commande "ng serve", Cette commande va compiler et lancer votre application Proxibanque, sur le port :  http://localhost:4200/

********************************************************************************
********************************************************************************

            Conception 

********************************************************************************
********************************************************************************



Dans un premier temps, nous avons décartographié l'ensemble des cas d'utilisation possibles de la banque ProxiBanque, puis on a identifié les classes 
et les relations entre elles(vous trouvez les diagramme dans le dossier'Conception')


