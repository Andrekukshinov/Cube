package cube.data.access.api;

import java.util.Comparator;

public interface SortSpecification<T> {
    Comparator<T> getComparator();
}
