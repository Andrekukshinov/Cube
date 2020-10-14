package cube.logics;

import cube.logics.creator.CubeSpotsExtractor;
import cube.model.Cube;
import cube.model.Spot;

import java.util.ArrayList;
import java.util.List;

public strictfp class DistancesBetweenSpotsCalculator {
    private final CubeSpotsExtractor spotsExtractor;

    private final int defaultSpotNumberToCalculateFrom = 0;

    public DistancesBetweenSpotsCalculator(CubeSpotsExtractor spotsExtractor) {
	   this.spotsExtractor = spotsExtractor;
    }

    private List<Double> calculateDistances(List<Spot> spots, Spot calculateFrom, int spotNumberToSkip) {
	   List<Double> distances = new ArrayList<>();
	   for (int runner = 0; runner < spots.size(); ++runner) {
		  if(runner == spotNumberToSkip){
			 continue;
		  }
		  Double distanceBetweenSpots =
				Math.sqrt(Math.pow((spots.get(runner).getXCoordinate() - calculateFrom.getXCoordinate()),2)
					   + Math.pow((spots.get(runner).getYCoordinate() - calculateFrom.getYCoordinate()),2)
					   + Math.pow((spots.get(runner).getZCoordinate() - calculateFrom.getZCoordinate()),2));
		  distances.add(distanceBetweenSpots);
	   }
	   return distances;
    }


    public List<Double> getDistancesFromGivenSpot(List<Spot> spots, int spotNumberCalculateFrom) {
	   Spot calculateFrom = spots.get( spotNumberCalculateFrom);
	   return calculateDistances(spots, calculateFrom, spotNumberCalculateFrom);
    }
    public List<Double> getDistancesBetweenCubeSpots(Cube cube) {
	   List<Spot> spots = spotsExtractor.getCubeSpots(cube);
	   Spot calculateFrom = spots.get(defaultSpotNumberToCalculateFrom);
	   return calculateDistances(spots, calculateFrom, defaultSpotNumberToCalculateFrom);
    }

}
