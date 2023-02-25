package cat.confrerieduplaid.architrademe.kernel;

public interface EventPublisher<E extends Event> {
    void publish(E event);

    void register(Class<E> eventClass, EventHandler<E> eventHandler);
}