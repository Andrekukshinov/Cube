package cube.logics.specification;

import cube.logics.LogicsException;
import cube.model.Spot;
import cube.model.VolumeRatio;

import java.util.Collections;
import java.util.List;

public abstract class VolumesSpecification {
    protected abstract List<Double> extractRequiredCoordinate(List<Spot> spots);

    public VolumeRatio calculateVolumes(List<Spot> spots, double cubeVolume) throws LogicsException {
	   List<Double> coordinates = extractRequiredCoordinate(spots);
	   double minCoordinate = Collections.min(coordinates);
	   double maxCoordinate = Collections.max(coordinates);
	   if (minCoordinate > 0 || maxCoordinate < 0) {
	       throw new LogicsException("Cube is not crossed by specified coordinate");
	   }
	   double edgeLength = maxCoordinate - minCoordinate;
	   double firstSegment = maxCoordinate - 0;
	   double secondSegment = 0 - minCoordinate;
	   double firstSegmentRatio = firstSegment / edgeLength;
	   double secondSegmentRatio = secondSegment / edgeLength;
	   double firstVolume = cubeVolume * firstSegmentRatio;
	   double secondVolume = cubeVolume * secondSegmentRatio;
	   return new VolumeRatio(firstVolume, secondVolume);
    }
}
