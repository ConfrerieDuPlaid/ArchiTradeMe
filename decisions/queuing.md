# Queuing

## Status


## Context

L'exposition (controllers REST) a des dépendances directes 
vers la couche application (services).


## Decision

Pour éviter une dépendance directe des controllers vers les services, 
une file permet de découpler l'exposition et l'application.
Les commandes et les queries sont envoyés à la file, et c'est elle qui possède
la connaissance du destinataire du message.
C'est par configuration que les destinataires (handlers) sont déclarés.

La première implémentation est un MessageBus qui appelle les services directement.
Une implementation Kafka ou RabbitMQ peut être mise en place à la place.

## Consequences

### Avantages :
- Découplage entre les couches exposition et application
- Permet d'effectuer des traitements systématiques sur les messages (validation, log)
- Possibilité de traitements synchrones ou asynchrones selon l'implémentation
- Historisation des messages

### Inconvénients :
- Lecture du flow d'exécution laborieuse
