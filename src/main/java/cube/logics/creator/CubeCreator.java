package cube.logics.creator;

import cube.data.access.impl.CubeRepository;
import cube.logics.Parser;
import cube.model.Cube;
import cube.model.Spot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class CubeCreator {
    private static final Logger LOGGER = Logger.getLogger(CubeCreator.class.getName());


    private static final int FIRST_SPOT_NUMBER = 0;
    private static final int SECOND_SPOT_NUMBER = 1;
    private static final int THIRD_SPOT_NUMBER = 2;
    private static final int FOURTH_SPOT_NUMBER = 3;
    private static final int FIFTH_SPOT_NUMBER = 4;
    private static final int SIXTH_SPOT_NUMBER = 5;
    private static final int SEVENTH_SPOT_NUMBER = 6;
    private static final int EIGHTH_SPOT_NUMBER = 7;

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
			 Cube cube = getCube(spotsForCubes);
			 Optional<Cube> cubeOptional = Optional.of(cube);
			 resultCubes.add(cubeOptional);
		  } else {
			 String msg = String.format("line %s doesnt suit", s);
			 LOGGER.warning(msg);
		  }

	   }
	   return resultCubes;
    }

    private Cube getCube(List<Spot> spotsForCubes) {
	   Spot firstSpot = spotsForCubes.get(FIRST_SPOT_NUMBER);
	   Spot secondSpot = spotsForCubes.get(SECOND_SPOT_NUMBER);
	   Spot thirdSpot = spotsForCubes.get(THIRD_SPOT_NUMBER);
	   Spot fourthSpot = spotsForCubes.get(FOURTH_SPOT_NUMBER);
	   Spot fifthSpot = spotsForCubes.get(FIFTH_SPOT_NUMBER);
	   Spot sixthSpot = spotsForCubes.get(SIXTH_SPOT_NUMBER);
	   Spot seventhSpot = spotsForCubes.get(SEVENTH_SPOT_NUMBER);
	   Spot eighthSpot = spotsForCubes.get(EIGHTH_SPOT_NUMBER);
	   return new Cube(firstSpot, secondSpot, thirdSpot, fourthSpot, fifthSpot,
			 sixthSpot, seventhSpot, eighthSpot);
    }
}
