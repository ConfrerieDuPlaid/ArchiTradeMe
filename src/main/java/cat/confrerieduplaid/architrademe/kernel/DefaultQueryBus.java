package cat.confrerieduplaid.architrademe.kernel;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
final class DefaultQueryBus<Q extends Query> implements QueryBus<Q> {

    private final Map<Class<Q>, QueryHandler> registry;

    DefaultQueryBus(Map<Class<Q>, QueryHandler> registry) {
        this.registry = registry;
    }

    @Override
    public <R> R post(Q query) {
        if (!query.validate()) {
            log.error(query.toString());
            throw new ApplicationException("Command " + query.name() + " not valid");
        }

        try {
            var commandHandler = registry.get(query.getClass());
            return (R) commandHandler.handle(query);
        } catch (Exception e) {
            throw new ApplicationException(String.format("Can't execute %s", query.name()), e);
        }
    }

    @Override
    public <R> void register(Class<Q> queryClass, QueryHandler<R, Q> queryHandler) {
        registry.putIfAbsent(queryClass, queryHandler);
    }
}
