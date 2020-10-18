package cube.data.access;

import cube.data.access.specification.Specification;

import java.util.List;

public interface Repository<T> {
    void add(T t);

    void remove(T t);

    void update(T toBeUpdated, int index);

    List<T> query(Specification<T> specification);

}
