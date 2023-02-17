package cat.confrerieduplaid.architrademe.kernel;

public interface CommandHandler<R, C extends Command> {
    R handle(C command);
}
