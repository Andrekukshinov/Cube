package cube.logics;

import cube.logics.creator.CubeDataExtractor;
import cube.model.CoordinateName;
import cube.model.Cube;
import cube.model.Spot;
import cube.model.VolumeRatio;

import java.util.Collections;
import java.util.List;

public class CubeDataCalculator {
    private static final int CUBE_SIDES_AMOUNT = 6;
    private static final int EDGE_POWER_FOR_VOLUME = 3;
    private static final int EDGE_POWER_FOR_AREA = 2;
    private static final int CUBE_SPOTS_COORDINATE_AMOUNT = 8;
    private static final int COORDINATE_ZERO = 0;
    private static final int DEFAULT_ZERO_COORDINATE_COUNTER = 0;
    private static final int CUBE_EDGES_AMOUNT = 12;


    private final DistancesBetweenSpotsProvider distancesProvider;
    private final CubeDataExtractor dataExtractor;

    public CubeDataCalculator(
		  DistancesBetweenSpotsProvider distancesProvider,
		  CubeDataExtractor dataExtractor) {
	   this.distancesProvider = distancesProvider;
	   this.dataExtractor = dataExtractor;
    }

    private double getCubeEdge(Cube forCalculation) {
	   List<Spot> cubeSpots = dataExtractor.getCubeSpots(forCalculation);
	   List<Double> distances = getDistancesBetweenCubeSpots(cubeSpots);
	   return Collections.min(distances);
    }

    private List<Double> getDistancesBetweenCubeSpots(List<Spot> spotsFromCube) {
	   int  defaultSpotNumberToCalculateFrom = 0;
	   Spot calculateFrom = spotsFromCube.get(defaultSpotNumberToCalculateFrom);
	   return distancesProvider.calculateDistances(spotsFromCube, calculateFrom,
			 defaultSpotNumberToCalculateFrom);
    }

    public double calculateCubeVolume(Cube forCalculation) {
	   double cubeEdge = getCubeEdge(forCalculation);
	   return Math.pow(cubeEdge, EDGE_POWER_FOR_VOLUME);
    }

    public double calculateCubePerimeter(Cube forCalculation) {
	   double cubeEdge = getCubeEdge(forCalculation);
	   return cubeEdge * CUBE_EDGES_AMOUNT;
    }

    public double calculateCubeArea(Cube cube) {
	   double cubeEdge = getCubeEdge(cube);
	   return (Math.pow(cubeEdge, EDGE_POWER_FOR_AREA) * CUBE_SIDES_AMOUNT);
    }

    public VolumeRatio calculateVolumeRatio(
		  Cube cubeToSplit, CoordinateName coordinateNameType)
		  throws LogicsException {
	   double totalVolume = calculateCubeVolume(cubeToSplit);
	   VolumesSpecification specification = new VolumesSpecification(dataExtractor);

	   return specification.calculateVolumes(cubeToSplit, totalVolume, coordinateNameType);
    }

    public boolean isZeroedCoordinatePlaced(Cube cube) {
	   List<Spot> cubeCoordinates = dataExtractor.getCubeSpots(cube);
	   int xZeroCoordinateCounter = DEFAULT_ZERO_COORDINATE_COUNTER;
	   int yZeroCoordinateCounter = DEFAULT_ZERO_COORDINATE_COUNTER;
	   int zZeroCoordinateCounter = DEFAULT_ZERO_COORDINATE_COUNTER;
	   for (Spot cubeCoordinate : cubeCoordinates) {
		  if (cubeCoordinate.getXCoordinate() == COORDINATE_ZERO) {
			 xZeroCoordinateCounter++;
		  }
		  if (cubeCoordinate.getYCoordinate() == COORDINATE_ZERO) {
			 yZeroCoordinateCounter++;
		  }
		  if (cubeCoordinate.getZCoordinate() == COORDINATE_ZERO) {
			 zZeroCoordinateCounter++;
		  }
	   }
	   return zZeroCoordinateCounter == CUBE_SPOTS_COORDINATE_AMOUNT || xZeroCoordinateCounter == CUBE_SPOTS_COORDINATE_AMOUNT || yZeroCoordinateCounter == CUBE_SPOTS_COORDINATE_AMOUNT;
    }
}
