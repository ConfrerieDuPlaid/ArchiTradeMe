package cat.confrerieduplaid.architrademe.kernel;

import java.util.HashMap;

public final class BusFactory {

    private BusFactory() {
        throw new AssertionError();
    }

    public static CommandBus defaultCommandBus() {
        return new DefaultCommandBus(new HashMap<>());
    }

    public static QueryBus defaultQueryBus() {
        return new DefaultQueryBus(new HashMap<>());
    }

    public static EventPublisher defaultEventHandler() {
        return new DefaultEventPublisher(new HashMap<>());
    }
}
