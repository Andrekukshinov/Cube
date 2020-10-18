package cube.logics.creator;

import cube.logics.DistancesBetweenSpotsProvider;
import cube.model.Spot;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class CubeValidator {
    private static final Logger LOGGER = Logger.getLogger(CubeValidator.class.getName());

    private static final double THRESHOLD_VALUE = 0.0001;

    private static final int CUBE_SPOTS_AMOUNT = 8;
    private static final int EDGE_COUNTER = 3;
    private static final int CUBE_DIAGONAL_COUNTER = 1;
    private static final int SIDE_DIAGONAL_COUNTER = 3;
    private static final int UNDEFINED_CUBE_SEGMENTS_AMOUNT = 0;
    private static final int FIRST_POINT = 0;


    private final DistancesBetweenSpotsProvider edgeCalculator;

    public CubeValidator(DistancesBetweenSpotsProvider edgeCalculator) {
	   this.edgeCalculator = edgeCalculator;
    }

    private List<Double> getDistancesBetweenSpots(
		  List<Spot> spots, int spotNumberCalculateFrom) {
	   return getDistancesFromGivenSpot(spots, spotNumberCalculateFrom);
    }
    private List<Double> getDistancesFromGivenSpot(
		  List<Spot> spots, int spotNumberCalculateFrom) {
	   Spot calculateFrom = spots.get(spotNumberCalculateFrom);
	   return edgeCalculator.calculateDistances(spots, calculateFrom, spotNumberCalculateFrom);
    }

    private double getDiagonal(
		  List<Double> distances, double minDistance, double maxDistance) {
	   double diagonal = 0;
	   int runner = 0;
	   while (runner < distances.size()) {
		  if (Math.abs(distances.get(runner) - minDistance) > THRESHOLD_VALUE && Math
				.abs(distances.get(runner) - maxDistance) > THRESHOLD_VALUE) {
			 diagonal = distances.get(runner);
			 break;
		  }
		  runner++;
	   }
	   return diagonal;
    }

    private boolean validateCube(List<Double> distances) {
	   double minDistance = Collections.min(distances);
	   double maxDistance = Collections.max(distances);
	   double diagonal = getDiagonal(distances, minDistance, maxDistance);
	   int minDistanceCounter = UNDEFINED_CUBE_SEGMENTS_AMOUNT;
	   int maxDistanceCounter = UNDEFINED_CUBE_SEGMENTS_AMOUNT;
	   int diagonalCounter = UNDEFINED_CUBE_SEGMENTS_AMOUNT;
	   for (Double distance : distances) {
		  if (Math.abs(minDistance - distance) < THRESHOLD_VALUE) {
			 minDistanceCounter++;
		  } else if (Math.abs(maxDistance - distance) < THRESHOLD_VALUE) {
			 maxDistanceCounter++;
		  } else if (Math.abs(diagonal - distance) < THRESHOLD_VALUE) {
			 diagonalCounter++;
		  }
	   }

	   return minDistanceCounter == EDGE_COUNTER &&
			 maxDistanceCounter == CUBE_DIAGONAL_COUNTER &&
			 diagonalCounter == SIDE_DIAGONAL_COUNTER;
    }

    public boolean isValidForCube(List<Spot> spots) {

	   if (spots.size() != CUBE_SPOTS_AMOUNT) {
		  String stringSpots = spots.toString();
		  LOGGER.warning(String.format("Invalid spots %s", stringSpots));
		  return false;
	   }
	   List<Double> distancesFromFirstSpot = getDistancesBetweenSpots(spots,
			 FIRST_POINT);

	   List<Double> distancesFromSecondPoint = getDistancesBetweenSpots(spots,
			 CUBE_SPOTS_AMOUNT - 1);

	   return validateCube(distancesFromFirstSpot) && validateCube(
			 distancesFromSecondPoint);
    }
}
