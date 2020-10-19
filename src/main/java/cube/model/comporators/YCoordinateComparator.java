package cube.model.comporators;

import cube.logics.creator.CubeDataExtractor;
import cube.model.CoordinateName;
import cube.model.Cube;

import java.util.Comparator;

public class YCoordinateComparator implements Comparator<Cube> {
    private final CubeDataExtractor dataExtractor;

    public YCoordinateComparator() {
	   this.dataExtractor = new CubeDataExtractor();
    }

    @Override
    public int compare(Cube thisCube, Cube thatCube) {
	   Double thisCoordinate = dataExtractor.getMinCoordinate(thisCube, CoordinateName.Y);
	   Double thatCoordinate = dataExtractor.getMinCoordinate(thatCube, CoordinateName.Y);
	   return Double.compare(thisCoordinate, thatCoordinate);
    }
}
