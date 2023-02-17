package cat.confrerieduplaid.architrademe.kernel;

public interface QueryHandler<R, Q extends Query> {
    R handle(Q query);
}
