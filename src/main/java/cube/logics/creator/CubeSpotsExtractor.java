package cube.logics.creator;

import cube.model.Cube;
import cube.model.Spot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CubeSpotsExtractor {
    public List<Spot> getCubeSpots(Cube cube) {
	   List<Spot> cubeCoordinates = new ArrayList<>();
	   cubeCoordinates.add(cube.getFirstSpot());
	   cubeCoordinates.add(cube.getSecondSpot());
	   cubeCoordinates.add(cube.getThirdSpot());
	   cubeCoordinates.add(cube.getFourthSpot());
	   cubeCoordinates.add(cube.getFifthSpot());
	   cubeCoordinates.add(cube.getSixthSpot());
	   cubeCoordinates.add(cube.getSeventhSpot());
	   cubeCoordinates.add(cube.getEighthSpot());
	   return cubeCoordinates;
    }
}
