package cat.confrerieduplaid.architrademe.kernel;

public interface EventHandler<E extends Event> {
    void handle(E event);
}
