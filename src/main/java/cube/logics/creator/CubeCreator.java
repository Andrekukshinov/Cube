package cube.logics.creator;

import cube.logics.Parser;
import cube.model.Cube;
import cube.model.Spot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CubeCreator {
    private final  int firstSpot = 0;
    private final  int secondSpot = 1;
    private final  int thirdSpot = 2;
    private final  int fourthSpot = 3;
    private final  int fifthSpot = 4;
    private final  int sixthSpot = 5;
    private final  int seventhSpot = 6;
    private final  int eighthSpot = 7;
    private final Parser parser;
    private final CubeValidator cubeValidator;

    public CubeCreator(Parser parser, CubeValidator cubeValidator) {
	   this.parser = parser;
	   this.cubeValidator = cubeValidator;
    }

    public List<Optional<Cube>> createCubes(List<String> source) {
	   List<Optional<Cube>> resultCubes = new ArrayList<>();
	   for (String s : source) {
		  List<Spot> spotsForCubes = parser.parseSpotsLines(s);
		  if (cubeValidator.isValidForCube(spotsForCubes)) {
			 Cube cube = new Cube(
			 	    spotsForCubes.get(firstSpot),
				    spotsForCubes.get(secondSpot),
				    spotsForCubes.get(thirdSpot),
				    spotsForCubes.get(fourthSpot),
				    spotsForCubes.get(fifthSpot),
				    spotsForCubes.get(sixthSpot),
				    spotsForCubes.get(seventhSpot),
				    spotsForCubes.get(eighthSpot)
			 );
			 Optional<Cube> cubeOptional = Optional.of(cube);
			 resultCubes.add(cubeOptional);
		  }
	   }
	   return resultCubes;
    }
}
