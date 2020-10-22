package cube.model.comporators;

import cube.logics.CubeDataCalculator;
import cube.logics.DistancesBetweenSpotsProvider;
import cube.logics.creator.CubeDataExtractor;
import cube.model.Cube;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Cube> {
    private final CubeDataCalculator dataCalculator;

    public VolumeComparator() {
	   CubeDataExtractor dataExtractor = new CubeDataExtractor();
	   DistancesBetweenSpotsProvider distancesProvider = new DistancesBetweenSpotsProvider();
	   this.dataCalculator = new CubeDataCalculator(distancesProvider, dataExtractor);
    }

    @Override
    public int compare(Cube thisCube, Cube thatCube) {
	   double volume1 = dataCalculator.calculateCubeVolume(thisCube);
	   double volume2 = dataCalculator.calculateCubeVolume(thatCube);
	   return Double.compare(volume1, volume2);
    }
}
