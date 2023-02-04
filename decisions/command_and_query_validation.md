# Command And Query Validation

## Status

Proposed

## Context

On utilise des commandes et des query, avant l'arrivé dans la couche application,
nous voulons appliquer une validation (syntaxique, non métier) de la donnée,
notament la non nullité de propriétés.

## Decision

Nous avons crée une méthode validate() dans les command et les query
par défaut, une query est valide par défaut.

La méthode renvoie un booléen.

## Consequences

### Avantages :
- la méthode peut être appelée systematiquement si la query passe dans une file.

### Inconvénients :
- met de la logique dans les query et les commandes qui sont censé être des DTO
