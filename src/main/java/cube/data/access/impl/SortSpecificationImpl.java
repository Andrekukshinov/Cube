package cube.data.access.impl;

import cube.data.access.SortType;
import cube.data.access.api.SortSpecification;
import cube.model.Cube;
import cube.model.comporators.*;

import java.util.Comparator;

public class SortSpecificationImpl implements SortSpecification<Cube> {
    private final SortType type;

    public SortSpecificationImpl(SortType type) {
	   this.type = type;
    }

    @Override
    public Comparator<Cube> getComparator() {
	   switch (type) {
		  case AREA:
		      return new AreaComparator();
		  case VOLUME:
		      return new VolumeComparator();
		  case PERIMETER:
		      return new PerimeterComparator();
		  case X:
		      return new XCoordinateComparator();
		  case Y:
		      return new YCoordinateComparator();
		  case Z:
		      return new ZCoordinateComparator();
		  default:
		      throw new IllegalArgumentException("No such sort type!");
	   }
    }
}
