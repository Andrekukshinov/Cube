package cube.model.comporators;

import cube.logics.CubeDataCalculator;
import cube.logics.DistancesBetweenSpotsProvider;
import cube.logics.creator.CubeDataExtractor;
import cube.model.Cube;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Cube> {
    private final CubeDataCalculator dataCalculator;

    public PerimeterComparator() {
	   CubeDataExtractor dataExtractor = new CubeDataExtractor();
	   DistancesBetweenSpotsProvider distancesProvider = new DistancesBetweenSpotsProvider();
	   this.dataCalculator = new CubeDataCalculator(distancesProvider, dataExtractor);
    }

    @Override
    public int compare(Cube thisCube, Cube thatCube) {
	   double perimeter1 = dataCalculator.calculateCubePerimeter(thisCube);
	   double perimeter2 = dataCalculator.calculateCubePerimeter(thatCube);
	   return Double.compare(perimeter1, perimeter2);
    }
}
