package cube.model.observable;

import cube.model.Register;

public interface Observer {
    void update(CubeObservable cube);
}
