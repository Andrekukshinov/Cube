package cube.data.access.impl.sort;

import cube.data.access.api.SortSpecification;
import cube.model.Cube;

import java.util.Comparator;

public class AreaSortSpecification implements SortSpecification<Cube> {
    @Override
    public Comparator<Cube> getComparator() {
	   return new cube.model.comporators.AreaComparator();
    }
}
