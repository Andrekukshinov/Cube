package cube.model.comporators;

import cube.logics.CubeDataCalculator;
import cube.logics.DistancesBetweenSpotsProvider;
import cube.logics.creator.CubeDataExtractor;
import cube.model.Cube;

import java.util.Comparator;

public class AreaComparator implements Comparator<Cube> {
    private final CubeDataCalculator dataCalculator;

    public AreaComparator() {
	   CubeDataExtractor dataExtractor = new CubeDataExtractor();
	   DistancesBetweenSpotsProvider distancesProvider = new DistancesBetweenSpotsProvider();
	   this.dataCalculator = new CubeDataCalculator(distancesProvider, dataExtractor);
    }

    @Override
    public int compare(Cube thisCube, Cube thatCube) {
	   double area1 = dataCalculator.calculateCubeArea(thisCube);
	   double area2 = dataCalculator.calculateCubeArea(thatCube);
	   return Double.compare(area1, area2);
    }

}
