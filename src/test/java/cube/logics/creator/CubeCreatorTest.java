package cube.logics.creator;


import cube.logics.Parser;
import cube.model.Cube;
import cube.model.Spot;
import org.junit.Assert;
import org.mockito.Mockito;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

public class CubeCreatorTest {
    public final String validCoordinates = "2.0 2.0 2.0    6.0 2.0 2.0    2.0 6.0 2.0    6.0 6.0 2.0    2.0 2.0 6.0    6.0 2.0 6.0    2.0 6.0 6.0    6.0 6.0 6.0";
    public final String invalidCoordinates = "2456.0 2.0 2.0    6.0 2.0 2.0    2.0 6.0 2.0    6.0 6.0 2.0    2.0 2.0 6.0    6.0 2.0 6.0    2.0 6.0 6.0    6.0 6.0 6.0";

    @DataProvider(name = "spotsProvider")
    public static Object[][] spotsProvider(Method method) {
	   Object[][] result;
	   Spot x1 = new Spot(2.0, 2.0, 2.0);
	   Spot x2 = new Spot(6.0, 2.0, 2.0);
	   Spot x3 = new Spot(2.0, 6.0, 2.0);
	   Spot x4 = new Spot(6.0, 6.0, 2.0);
	   Spot x5 = new Spot(2.0, 2.0, 6.0);
	   Spot x6 = new Spot(6.0, 2.0, 6.0);
	   Spot x7 = new Spot(2.0, 6.0, 6.0);
	   Spot x8 = new Spot(6.0, 6.0, 6.0);
	   List<Spot> spots = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, x8);

	   Cube expected = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);

	   String methodName = method.getName();
	   if (methodName.equalsIgnoreCase("testCreateCubesShouldCreateCubes")) {
		  result = new Object[1][2];
		  result[0][0] = spots;
		  result[0][1] = expected;
		  return result;
	   } else if (methodName
			 .equalsIgnoreCase("testCreateCubesShouldThrowNullPointerException")) {
		  result = new Object[1][1];
		  result[0][0] = spots;
		  return result;
	   } else {
		  result = new Object[1][2];
		  result[0][0] = spots;
		  result[0][1] = x1;
		  return result;
	   }
    }

    @Test(dataProvider = "spotsProvider")
    public void testCreateCubesShouldCreateCubes(List<Spot> spots, Cube expected) {
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

    @Test(expectedExceptions = IndexOutOfBoundsException.class, dataProvider = "spotsProvider")//then
    public void testCreateCubesShouldThrowNullPointerException(List<Spot> spots) {
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
