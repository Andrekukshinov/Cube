package cube.logics;

import cube.logics.creator.CubeSpotsExtractor;
import cube.logics.specification.VolumesSpecification;
import cube.logics.specification.impl.XVolumeSpecification;
import cube.logics.specification.impl.YVolumeSpecification;
import cube.logics.specification.impl.ZVolumeSpecification;
import cube.model.CoordinatePlanes;
import cube.model.Cube;
import cube.model.Spot;
import cube.model.VolumeRatio;

import java.util.Collections;
import java.util.List;

public class CubeDataCalculator {
    private final DistancesBetweenSpotsCalculator edgeCalculator;
    private final CubeSpotsExtractor spotsExtractor;
    private static final int CUBE_SIDES_AMOUNT = 6;
    private static final int EDGE_POWER_FOR_VOLUME = 3;
    private static final int EDGE_POWER_FOR_AREA = 2;

    public CubeDataCalculator(DistancesBetweenSpotsCalculator edgeCalculator, CubeSpotsExtractor spotsExtractor) {
	   this.edgeCalculator = edgeCalculator;
	   this.spotsExtractor = spotsExtractor;
    }

    private double getCubeEdge(Cube forCalculation) {
	   List<Double> distances = edgeCalculator.getDistancesBetweenCubeSpots(forCalculation);
	   return Collections.min(distances);
    }

    public double calculateCubeVolume(Cube forCalculation) {
	   double cubeEdge = getCubeEdge(forCalculation);
	   return Math.pow(cubeEdge, EDGE_POWER_FOR_VOLUME);
    }

    public double calculateCubeArea(Cube cube) {
	   double cubeEdge = getCubeEdge(cube);


	   return (Math.pow(cubeEdge, EDGE_POWER_FOR_AREA) * CUBE_SIDES_AMOUNT);
    }

    public VolumeRatio calculateVolumeRatio(Cube cubeToSplit, CoordinatePlanes coordinatePlanesType) throws LogicsException {
	   List<Spot> extractedSpots = spotsExtractor.getCubeSpots(cubeToSplit);
	   double totalVolume = calculateCubeVolume(cubeToSplit);
	   VolumesSpecification specification;
	   switch (coordinatePlanesType) {
		  case X: specification =
				new XVolumeSpecification();
		  break;
		  case Y: specification =
				new YVolumeSpecification();
		  break;
		  case Z: specification =
				new ZVolumeSpecification();
		  break;
		  default: throw new RuntimeException();
	   }
	   return	specification.calculateVolumes(extractedSpots, totalVolume);
    }

    public boolean isZeroedCoordinatePlaced(Cube cube) {
	   List<Spot> cubeCoordinates = spotsExtractor.getCubeSpots(cube);
	   int xZeroCoordinateCounter = 0;
	   int yZeroCoordinateCounter = 0;
	   int zZeroCoordinateCounter = 0;
	   for (Spot cubeCoordinate : cubeCoordinates) {
		  if (cubeCoordinate.getXCoordinate() == 0) {
			 xZeroCoordinateCounter++;
		  }
		  if (cubeCoordinate.getYCoordinate() == 0) {
			 yZeroCoordinateCounter++;
		  }
		  if (cubeCoordinate.getZCoordinate() == 0) {
			 zZeroCoordinateCounter++;
		  }
	   }
	   return zZeroCoordinateCounter == 8 || xZeroCoordinateCounter == 8 || yZeroCoordinateCounter == 8;
    }
}
//TODO replace constants
