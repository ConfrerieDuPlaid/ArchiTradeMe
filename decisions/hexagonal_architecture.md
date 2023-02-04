# Hexagonal Architechture

## Status

Accepté

## Context

Nous avons une application dont le metier est relativement complexe et sujet à évoluer.
Les fonctionnalités attendues sont assez vague, ainsi que les règles de gestion.
Les fonctionnalités présentement attendues sont :
- Inscription de consultants
- Recherche de consultant
- Facturation des prestations

Nous avons besoin d'isoler les domaines pour qu'ils puissent évoluer indépendamment, 
pour répondre à une exigence de Time To Market, répondre au besoin du marché et
évoluer rapidement en même temps que lui.

## Decision

L'architecture hexagonale permet d'isoler les domaines et les faire évoluer indépendamment.
Une structure Port / Adapter classique permet d'avoir les intentions métier clairement
lisibles (application > port > in).

## Consequences

### Avantages :
- Les intentions metier sont criants dans la structure : ports in
- Les règles métier sont clairement localisées et facilement modifiables
- Le domaine est agnostique de l'infrastructure. Le projet étant en constante évolution, 
un changement d'infrastructure n'aura pas d'impact sur les domaines.

### Inconvénients :
- De nombreuses classes
- Début lent à cause la quantité de code à produire
