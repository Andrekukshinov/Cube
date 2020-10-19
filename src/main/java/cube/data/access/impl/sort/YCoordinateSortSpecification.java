package cube.data.access.impl.sort;

import cube.data.access.api.SortSpecification;
import cube.model.Cube;
import cube.model.comporators.XCoordinateComparator;
import cube.model.comporators.YCoordinateComparator;

import java.util.Comparator;

public class YCoordinateSortSpecification implements SortSpecification<Cube> {
    @Override
    public Comparator<Cube> getComparator() {
	   return new YCoordinateComparator();
    }
}
