package cat.confrerieduplaid.architrademe.kernel;

import java.util.Map;

final class DefaultQueryBus<Q extends Query> implements QueryBus<Q> {

    private final Map<Class<Q>, QueryHandler> registry;

    DefaultQueryBus(Map<Class<Q>, QueryHandler> registry) {
        this.registry = registry;
    }

    @Override
    public <R> R post(Q query) {
        if (!query.validate()) {
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
