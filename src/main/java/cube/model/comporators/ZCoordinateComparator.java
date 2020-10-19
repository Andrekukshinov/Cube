package cube.model.comporators;

import cube.logics.creator.CubeDataExtractor;
import cube.model.CoordinateName;
import cube.model.Cube;

import java.util.Comparator;

public class ZCoordinateComparator implements Comparator<Cube> {
    private final CubeDataExtractor dataExtractor;

    public ZCoordinateComparator() {
	   this.dataExtractor = new CubeDataExtractor();
    }

    @Override
    public int compare(Cube thisCube, Cube thatCube) {
	   Double thisCoordinate = dataExtractor.getMinCoordinate(thisCube, CoordinateName.Z);
	   Double thatCoordinate = dataExtractor.getMinCoordinate(thatCube, CoordinateName.Z);
	   return Double.compare(thisCoordinate, thatCoordinate);
    }
}
