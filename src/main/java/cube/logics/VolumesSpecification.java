package cube.logics;

import cube.logics.LogicsException;
import cube.logics.creator.CubeDataExtractor;
import cube.model.CoordinateName;
import cube.model.Cube;
import cube.model.VolumeRatio;

import java.util.Collections;
import java.util.List;

public class VolumesSpecification {
    private static final int COORDINATES_ZERO = 0;
    private static final double THRESHOLD_VALUE = 0.0001;

    private final CubeDataExtractor dataExtractor;

    public VolumesSpecification(CubeDataExtractor dataExtractor) {
	   this.dataExtractor = dataExtractor;
    }


    private List<Double> extractRequiredCoordinate(
		  Cube cubeToSplit, CoordinateName coordinateNameType) {
	   return dataExtractor.getCoordinates(cubeToSplit, coordinateNameType);
    }


    public VolumeRatio calculateVolumes(
		  Cube cubeToSplit, double cubeVolume,
		  CoordinateName coordinateNameType) throws LogicsException {
	   List<Double> coordinates = extractRequiredCoordinate(cubeToSplit,
			 coordinateNameType);
	   double minCoordinate = Collections.min(coordinates);
	   double maxCoordinate = Collections.max(coordinates);
	   if (minCoordinate - COORDINATES_ZERO > THRESHOLD_VALUE ||
			 maxCoordinate - COORDINATES_ZERO < THRESHOLD_VALUE) {
		  throw new LogicsException("Cube is not crossed by specified coordinate");
	   }
	   double edgeLength = maxCoordinate - minCoordinate;
	   double firstSegment = maxCoordinate - COORDINATES_ZERO;
	   double secondSegment = COORDINATES_ZERO - minCoordinate;
	   double firstSegmentRatio = firstSegment / edgeLength;
	   double secondSegmentRatio = secondSegment / edgeLength;
	   double firstVolume = cubeVolume * firstSegmentRatio;
	   double secondVolume = cubeVolume * secondSegmentRatio;
	   return new VolumeRatio(firstVolume, secondVolume);
    }
}
