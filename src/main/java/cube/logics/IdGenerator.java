package cube.logics;

import cube.model.observable.CubeObservable;

public class IdGenerator {
    private static long id = 0;

    public final long getId() {
        return id++;
    }
}
