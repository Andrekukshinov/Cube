package cube.model.comporators;

import cube.logics.creator.CubeDataExtractor;
import cube.model.CoordinateName;
import cube.model.Cube;

import java.util.Comparator;
import java.util.List;

public class XCoordinateComparator implements Comparator<Cube> {
    private final CubeDataExtractor dataExtractor;

    public XCoordinateComparator() {
	   this.dataExtractor = new CubeDataExtractor();
    }

    @Override
    public int compare(Cube thisCube, Cube thatCube) {
	   Double thisCoordinate = dataExtractor.getMinCoordinate(thisCube, CoordinateName.X);
	   Double thatCoordinate = dataExtractor.getMinCoordinate(thatCube, CoordinateName.X);
	   return Double.compare(thisCoordinate, thatCoordinate);
    }
}
