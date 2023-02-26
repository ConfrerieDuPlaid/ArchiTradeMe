package cat.confrerieduplaid.architrademe.kernel;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public final class DefaultEventPublisher<E extends Event> implements EventPublisher<E> {
    private final Map<Class<E>, EventHandler<E>> register;

    public DefaultEventPublisher(Map<Class<E>, EventHandler<E>> register) {
        this.register = register;
    }

    @Override
    public void publish(E event) {
        var eventHandler = register.get(event.getClass());
        if (eventHandler == null) {
            log.warn("No handler found for event {}", event.getClass().getSimpleName());
        } else {
            eventHandler.handle(event);
        }

    }

    @Override
    public void register(Class eventClass, EventHandler handler) {
        register.put(eventClass, handler);
    }
}
