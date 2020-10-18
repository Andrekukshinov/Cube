package cube.data.access.impl.sort;

import cube.data.access.api.SortSpecification;
import cube.model.Cube;
import cube.model.comporators.PerimeterComparator;

import java.util.Comparator;

public class PerimeterSortSpecification implements SortSpecification<Cube> {
    @Override
    public Comparator<Cube> getComparator() {
	   return new PerimeterComparator();
    }
}
