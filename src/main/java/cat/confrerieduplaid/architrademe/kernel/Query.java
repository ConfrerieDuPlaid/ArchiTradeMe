package cat.confrerieduplaid.architrademe.kernel;

public interface Query {
    default String name() {
        return this.getClass().getSimpleName();
    }

    default boolean validate() {
        return true;
    }
}
