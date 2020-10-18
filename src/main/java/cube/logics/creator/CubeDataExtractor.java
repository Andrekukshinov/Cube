package cube.logics.creator;

import cube.model.CoordinateName;
import cube.model.Cube;
import cube.model.Spot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CubeDataExtractor {
    public List<Spot> getCubeSpots(Cube cube) {
	   List<Spot> cubeCoordinates = new ArrayList<>();
	   Spot firstSpot = cube.getFirstSpot();
	   Spot secondSpot = cube.getSecondSpot();
	   Spot thirdSpot = cube.getThirdSpot();
	   Spot fourthSpot = cube.getFourthSpot();
	   Spot fifthSpot = cube.getFifthSpot();
	   Spot sixthSpot = cube.getSixthSpot();
	   Spot seventhSpot = cube.getSeventhSpot();
	   Spot eighthSpot = cube.getEighthSpot();
	   Collections.addAll(cubeCoordinates, firstSpot, secondSpot, thirdSpot, fourthSpot,
			 fifthSpot, sixthSpot, seventhSpot, eighthSpot);
	   return cubeCoordinates;
    }

    public double getMinCoordinate(Cube cube, CoordinateName name) {
	   List<Double> coordinates = getCoordinates(cube, name);
	   return Collections.min(coordinates);
    }

    public List<Double> getCoordinates(Cube cube, CoordinateName name) {
	   List<Double> xCoordinates = new ArrayList<>();
	   for (Spot spot : getCubeSpots(cube)) {
		  double coordinate;
		  coordinate = getSpecifiedCoordinate(name, spot);
		  xCoordinates.add(coordinate);
	   }
	   return xCoordinates;
    }

    private double getSpecifiedCoordinate(CoordinateName name, Spot spot) {
	   double coordinate;
	   switch (name) {
		  case X:
			 coordinate = spot.getXCoordinate();
			 break;
		  case Y:
			 coordinate = spot.getYCoordinate();
			 break;
		  case Z:
			 coordinate = spot.getZCoordinate();
			 break;
		  default:
			 String stringCoordinate = name.toString();
			 String massage = String
				    .format("Coordinate %s not found.", stringCoordinate);
			 throw new IllegalArgumentException(massage);
	   }
	   return coordinate;
    }

}





