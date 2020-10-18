package cube.logics.creator;


import cube.logics.Parser;
import cube.model.Cube;
import cube.model.Spot;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

public class CubeCreatorTest {
    private final Spot x1 = new Spot(2.0, 2.0, 2.0);
    private final Spot x2 = new Spot(6.0, 2.0, 2.0);
    private final Spot x3 = new Spot(2.0, 6.0, 2.0);
    private final Spot x4 = new Spot(6.0, 6.0, 2.0);
    private final Spot x5 = new Spot(2.0, 2.0, 6.0);
    private final Spot x6 = new Spot(6.0, 2.0, 6.0);
    private final Spot x7 = new Spot(2.0, 6.0, 6.0);
    private final Spot x8 = new Spot(6.0, 6.0, 6.0);

    public final String validCoordinates = "2.0 2.0 2.0    6.0 2.0 2.0    2.0 6.0 2.0    6.0 6.0 2.0    2.0 2.0 6.0    6.0 2.0 6.0    2.0 6.0 6.0    6.0 6.0 6.0";
    public final String invalidCoordinates = "2456.0 2.0 2.0    6.0 2.0 2.0    2.0 6.0 2.0    6.0 6.0 2.0    2.0 2.0 6.0    6.0 2.0 6.0    2.0 6.0 6.0    6.0 6.0 6.0";

    public final List<Spot> spots = Arrays
		  .asList(x1, x2, x3, x4, x5, x6, x7, x8);

    public final Cube expected = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);


    @Test
    public void testCreateCubesShouldCreateCubes() {
	   Parser parser = Mockito.mock(Parser.class);
	   CubeValidator validator = Mockito.mock(CubeValidator.class);
	   given(parser.parseSpotsLines(anyString())).willReturn(spots);
	   given(validator.isValidForCube(any(List.class))).willReturn(true);
	   CubeCreator cubeCreator = new CubeCreator(parser, validator);
	   //when
	   List<Optional<Cube>> result = cubeCreator
			 .createCubes(Collections.singletonList(validCoordinates));
	   //then
	   Optional<Cube> optionalCube = result.get(0);
	   Assert.assertEquals(expected, optionalCube.get());

    }

    @Test(expected = IndexOutOfBoundsException.class) //then
    public void testCreateCubesShouldThrowNullPointerException() {
	   Parser parser = Mockito.mock(Parser.class);
	   CubeValidator validator = Mockito.mock(CubeValidator.class);
	   given(parser.parseSpotsLines(validCoordinates)).willReturn(spots);
	   given(validator.isValidForCube(spots)).willReturn(true);
	   CubeCreator cubeCreator = new CubeCreator(parser, validator);
	   //when
	   List<Optional<Cube>> result = cubeCreator
			 .createCubes(Collections.singletonList(invalidCoordinates));
	   Optional<Cube> optionalCube = result.get(0);
	   optionalCube.get();

    }
}
