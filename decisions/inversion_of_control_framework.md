# Inversion Of Control Framework

## Status

Accepté

## Context

Dans le cadre de l'[architecture hexagonale](hexagonal_architecture.md) choisie, 
il est nécessaire de procéder à de l'injection de dépendance, et ainsi privilégier 
la composition à la surcharge de comportement.

## Decision

L'IoC est effectuée par le framework Spring (en dehors du domaine), 
par classe de configuration (**@Configuration**) avec des méthodes d'instanciations (**@Bean**)

Cela évite d'avoir des annotations Spring dans les couches domaine et application.

## Consequences

### Avantages :
- Évite une grande quantité de code
- Gestion optimisée des instances
- Framework Java le plus utilisé et extrêmement documenté

### Inconvénients :
- Dépendance à un framework
