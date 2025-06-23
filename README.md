# Projet-3

Simulation d'un bras mécanique

Ce projet vise à la simulation de la cinématique d'un bras mécanique. Il dispose d'une interface graphique avec Swift en Java.

On peut y déplacer 3 articulations ainsi qu'une pince. 

Dépendance : Java

Projet réalisé seul, sans aide extérieure. (personnes, I.A.).

![Image](https://github.com/user-attachments/assets/210d8980-9418-4d02-ac44-416eab71bdd4)

# Utilisation

## Modes

3 modes sont disponibles : 

- vitesse angulaire : contrôle des articulations via leurs vitesses angulaire.

- angle : contrôle des articulations via les angles voulus pour chaque articulation

- direction : choix des directions que doit prendre la pince, calculé par cinématique inverse.

## Changement dans le paramétrage des composants

Les articulations, le bâti et la pince sont initialisés dans le fichier physique. 

Il est possible de modifier le paramétrage des articulations déjà présentes.

On peut même en ajouter d'autres, mais le mode direction ne fonctionnera plus.

# Fonctionnement

Graphe de liaison du bras : 

![Diagramme](https://github.com/user-attachments/assets/f8d4ba4f-41c6-4e63-aca8-76396eb42998)

## Fichier

Package : Principale

  Main.java : fichier principal

Package : Physique

  ComposantBras.java : classe virtuelle dont sont issus tous les composants du bras

  Bâti.java : classe contenant la programmation du bâti

  Articulation.java : classe contenant la programmation du bras

  Pince.java : classe contenant la programmation de la pince

  Calcul.java : classe permettant les calculs nécessaires relatifs aux différents modes

Package : Interface

  Fenetre.java : classe contenant et gérant la fenêtre de l'application

  FenInterface.java : classe gérant toute la partie interface de la fenêtre

  FenSimulation.java : classe gérant toute la partie simulation de la fenêtre


## Articulation, Bâti & Pince

Chacun de ses composants est vu comme un objet issu de la classe virtuelle composantBras. La principale particularité de cette classe est la présence d'un prédécesseur. Ce prédécesseur est l'objet auquel le composant est rattaché. 

Remarque : les composants n'ont pas de collision entre eux.

Bâti : 

Le bâti est la classe la plus simple. Elle sert juste de prédécesseur pour l'articulation suivante.

Articulation :

Chaque articulation est en liaison pivot avec le composant précédent. L'articulation possède notamment une longueur, un angle minimale et maximale possible, ainsi qu'une vitesse angulaire maximale.

Chaque articulation est contrôlée par sa vitesse angulaire.

Pince : 

La pince possède un écartement déterminant l'ouverture de la pince (un écartement de 0 signifie que la pince est fermée). 

Elle possède un écartement maximal, une vitesse d'écartement maximale.

Elle est contrôlée via la vitesse de l'écartement.

## Calcul

Calcul de la cinématique inverse : 
Elle est calculée uniquement sur les 2 dernières articulations. Si la position souhaitée est impossible à atteindre, alors le bras se remet à l'horizontale.

Méthode : 

Elle est calculée à l'aide d'une fermeture cinématique projetée sur l'axe x et y. Puis, par calcul, avec notamment la loi des cosinus. On obtient les expressions des angles à obtenir. (Rq : pour s'affranchir des limites de arctan, on utilise arctan2 qui est définie de R² dans [-π, π].)
