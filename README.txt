

********************************************************************************
********************************************************************************

                                    Introduction

********************************************************************************
********************************************************************************
La banque ProxiBanque souhaite cr�er une application permettant � ses conseillers de g�rer 
leurs clients et services � forte valeur ajout�e, comme le service de virement compte � compte.
Ce d�p�t contient le projets r�alis� lors de la formation JOBINTECH du 14/10/2019 au 23/10/2019.

Le  projet ProxiBanque v4 r�aliser avec :
 
-Front : Angular 
-Logique : Spring boot/mod�le en couche avec API REST (JAX-RS)
-Back : MySQL

Afin de cloner le d�p�t, utiliser la commande suivante :

====> git clone https://github.com/anassedy/ProxiBanKV4

********************************************************************************
********************************************************************************

            Fonctionnalit�s de l'application

********************************************************************************
********************************************************************************


####L'authentification 

Sur l'�cran authentification; le conseiller,le g�rant ou le param�trage, rentrent leurs Login et password pour acc�der � la ptalforme Proxibanque

####Cr�er conseiller

S'identifier en tant que g�rant en renseignant login et mot de passe.
Sur l'�cran liste des conseiller,cliquer sur le bouton Ajouter conseiller
Remplir le formulaire
Valider

####Modifier conseiller

Cliquer sur le bouton Modifier conseiller pour un conseiller sp�cifique pour acc�der � un formulaire d'information conseiller
Rentrer les valeurs � modifier
Cliquer sur valider
Une confirmation appara�t, puis vous �tes ramener vers la listes des conseillers
Le bouton logout dirige le g�rant vers la page de d'autentification de l'application

####Supprimer conseiller

Pour le g�rant, cliquer sur le bouton Supprimer conseiller pour un conseiller sp�cifique sur la liste des conseiller
Une confirmation appara�t

####Cr�er client

S'identifier en tant que conseiller en renseignant login et mot de passe.
La liste des clients du conseiller s'affiche, avec les actions possibles pour chaque client.(supprimer ou Editer un client)
En haut de la liste, cliquer sur le bouton Ajouter Conseiller. Remplir le formulaire et valider.
Au retour � la liste des client,celui ci est ajout� � la liste.

####Modifier client

Cliquer sur le bouton Modifier client pour un client sp�cifique pour acc�der � un formulaire d'information client
Rentrer les valeurs � modifier
Cliquer sur valider
Une confirmation appara�t, puis vous �tes ramener vers la listes des clients
Le bouton logout dirige le conseiller vers la page de d'autentification de l'application

####Supprimer client

Cliquer sur le bouton Supprimer client our un client sp�cifique sur la liste des client
Une confirmation appara�t

####Cr�er un compte

La proc�dure pour cr�er un compte courant ou un compte �pargne est similaire
Cliquer sur le bouton Cr�er compte courant ou Cr�er compte �pargne
Renseigner les champs demand�s, puis valider
Une confirmation appara�t

####Visualiser la liste des compte des clients pour un conseiller donn�

Cliquer sur le bouton Liste comptes en haut 
La liste des comptes g�rer par un conseiller appara�t


####Effectuer un virement compte � compte 

Pour un conseiller, Cliquer sur le bouton Effectuer un virement en haut, dans la page renter l'Id du client emetteur, puis l'Id du client r�c�pteur 
ensuite rentrer le montant que vous souhaitez vir�.
Une confirmation appara�t, puis vous �tes ramen� � la liste des client.

####Param�trage

L'�cran de param�trage permet de fixer des informations sp�cifiques par d�faut : 
�	Commission sur les virements 
�	Nombre maximum de clients par conseillers
�	Nombre maximum de conseillers
�	Style de graphe pour l��cran de transactions : Histogramme ou camembert

********************************************************************************
********************************************************************************

            D�ploiement de l'application

********************************************************************************
********************************************************************************
==> Partie Data-Base:
Dans le dossier server, appuier sur 'xampp-control.exe' pour d�marrer le serveur Apache sur le port 80, 443 et MySQL sur le port "selon vous", 
ensuite acc�der � l'int�rface Php My Admin, cr�e un Nouvelle BD sous le non 'proxibanquev4' puis importer le fichier 'proxibanquev4 .sql' 


==> Partie Back-end:
Sur Eclipse, importer le fichier source du projet 'ProxiBanqueV4', ensuite acc�der � la classe main 'ProxiBanqueV4Application'dans le package 'ma.jit'
et executer le projet en tant que 'spring boot app'
Si vous un port quelconque pour MySQL, modifier le sur le fichier 'application.properties' dans le dossier 'src/main/ressources'

==> Partie Front-end:
sur le dossier front-end, ouvrir le dossier 'server', puis sur la cmd lancer la commande 'json-server --watch db.json',
puis sur votre �diteur de code, dans Terminal, lancer la commande "ng serve", Cette commande va compiler et lancer votre application Proxibanque, sur le port :  http://localhost:4200/

********************************************************************************
********************************************************************************

            Conception 

********************************************************************************
********************************************************************************



Dans un premier temps, nous avons d�cartographi� l'ensemble des cas d'utilisation possibles de la banque ProxiBanque, puis on a identifi� les classes 
et les relations entre elles(vous trouvez les diagramme dans le dossier'Conception')


