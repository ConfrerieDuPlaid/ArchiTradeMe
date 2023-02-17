package cat.confrerieduplaid.architrademe.kernel;

public interface CommandBus<C extends Command> {
    <R> R post(C command);

    <R> void register(Class<C> commandClass, CommandHandler<R, C> commandHandler);
}