package cube.data.access.api;

import cube.data.access.api.SearchSpecification;
import cube.data.access.api.SortSpecification;

import java.util.List;

public interface Repository<T> {
    void add(T t);

    void remove(T t);

    void update(T toBeUpdated, int index);

    List<T> query(SearchSpecification<T> searchSpecification);

    List<T> sort( SortSpecification<T> sortSpecification);

}
