package cat.confrerieduplaid.architrademe.kernel;

import java.util.Map;

final class DefaultEventPublisher<E extends Event> implements EventPublisher<E> {
    private final Map<Class<E>, EventHandler<E>> register;

    DefaultEventPublisher(Map<Class<E>, EventHandler<E>> register) {
        this.register = register;
    }

    @Override
    public void publish(E event) {
        var eventHandler = register.get(event.getClass());
        if (eventHandler == null) {
            throw new ApplicationException(String.format("No handler for the event %s", event.name()));
        }
        eventHandler.handle(event);
    }

    @Override
    public void register(Class eventClass, EventHandler handler) {
        register.put(eventClass, handler);
    }
}
