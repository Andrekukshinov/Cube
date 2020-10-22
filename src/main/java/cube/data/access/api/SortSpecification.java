package cube.data.access.api;

import cube.data.access.SortType;

import java.util.Comparator;

public interface SortSpecification<T> {
    Comparator<T> getComparator();
}
