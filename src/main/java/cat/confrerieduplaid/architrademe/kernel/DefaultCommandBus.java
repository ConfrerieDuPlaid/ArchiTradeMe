package cat.confrerieduplaid.architrademe.kernel;

import java.util.Map;

final class DefaultCommandBus<C extends Command> implements CommandBus<C> {

    private final Map<Class<C>, CommandHandler> registry;

    DefaultCommandBus(Map<Class<C>, CommandHandler> registry) {
        this.registry = registry;
    }

    @Override
    public <R> R post(C command) {
        if (!command.validate()) {
            throw new ApplicationException("Command " + command.name() + " not valid");
        }

        try {
            var commandHandler = registry.get(command.getClass());
            return (R) commandHandler.handle(command);
        } catch (Exception e) {
            throw new ApplicationException(String.format("Can't execute %s", command.name()), e);
        }
    }

    @Override
    public <R> void register(Class<C> commandClass, CommandHandler<R, C> commandHandler) {
        registry.putIfAbsent(commandClass, commandHandler);
    }
}
