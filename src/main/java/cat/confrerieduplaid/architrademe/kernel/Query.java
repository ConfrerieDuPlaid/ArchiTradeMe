package cat.confrerieduplaid.architrademe.kernel;

public interface Query {
    default boolean validate() {
        return true;
    }
}
