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

- direction : choix des directions que doit prendre la pince, calculé par cinématique inverse. [EN COURS]

## Changement dans le paramétrage des composants

Les articulations, le bâti et la pince sont initialisés dans le fichier physique.

Il est possible de modifier le paramétrage des articulations déjà présentes.

On peut même en ajouter d'autres, mais le mode direction ne fonctionnera plus.

# Fonctionnement

Graphe de liaison du bras : 

![Diagramme](https://github.com/user-attachments/assets/f8d4ba4f-41c6-4e63-aca8-76396eb42998)

## Articulation, Bâtie & Pince

Chacun de ses composants est vu comme un objet issu de la classe virtuelle composantBras. La principale particularité de cette classe est la présence d'un prédécesseur. Ce prédécesseur est l'objet auquel le composant est rattaché. 

Remarque : les composants n'ont pas de collision entre eux.

Bâtie : 

Le bâtie est la classe la plus simple. Elle sert juste de prédécesseur pour l'articulation suivante.

Articulation :

Chaque articulation est en liaison pivot avec le composant précédent. L'articulation possède notamment une longueur, un angle minimale et maximale possible, ainsi qu'une vitesse angulaire maximale.

Chaque articulation est contrôlée par sa vitesse angulaire.

Pince : 

La pince possède un écartement déterminant l'ouverture de la pince (un écartement de 0 signifie que la pince est fermée). 

Elle possède un écartement maximal, une vitesse d'écartement maximale.

Elle est contrôlée via la vitesse de l'écartement.

## Calcul

[EN COURS]



