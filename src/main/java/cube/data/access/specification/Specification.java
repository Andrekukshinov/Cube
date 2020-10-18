package cube.data.access.specification;

import cube.model.Cube;

public interface Specification<T> {
    boolean isSpecified(T t);
}
