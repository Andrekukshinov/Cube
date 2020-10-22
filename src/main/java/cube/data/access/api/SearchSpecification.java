package cube.data.access.api;

import cube.model.Cube;

public interface SearchSpecification<T> {
    boolean isSpecified(T t);
}
