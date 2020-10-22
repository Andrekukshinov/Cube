package cube.logics;

import cube.model.Spot;

import java.util.ArrayList;
import java.util.List;

public strictfp class DistancesBetweenSpotsProvider {

    public List<Double> calculateDistances(
		  List<Spot> spots, Spot calculateFrom, int spotNumberToSkip) {
	   List<Double> distances = new ArrayList<>();
	   for (int runner = 0; runner < spots.size(); ++runner) {
		  if (runner == spotNumberToSkip) {
			 continue;
		  }
		  Double distanceBetweenSpots = getDistanceBetweenSpots(spots, calculateFrom,
				runner);
		  distances.add(distanceBetweenSpots);
	   }
	   return distances;
    }

    private Double getDistanceBetweenSpots(
		  List<Spot> spots, Spot calculateFrom, int runner) {
	   Spot currentSpot = spots.get(runner);
	   double currentXCoordinate = currentSpot.getXCoordinate();
	   double currentYCoordinate = currentSpot.getYCoordinate();
	   double currentZCoordinate = currentSpot.getZCoordinate();
	   double ethalonXCoordinate = calculateFrom.getXCoordinate();
	   double ethalonYCoordinate = calculateFrom.getYCoordinate();
	   double ethalonZCoordinate = calculateFrom.getZCoordinate();
	   double xSquaredDistance = Math.pow((currentXCoordinate - ethalonXCoordinate), 2);
	   double ySquaredDistance = Math.pow((currentYCoordinate - ethalonYCoordinate), 2);
	   double zSquaredDistance = Math.pow((currentZCoordinate - ethalonZCoordinate), 2);
	   return Math.sqrt(xSquaredDistance + ySquaredDistance + zSquaredDistance);
    }
}
