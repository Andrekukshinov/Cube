package cube.logics.creator;


import cube.model.CoordinateName;
import cube.model.Cube;
import cube.model.Spot;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class CubeDataExtractorTest {


    @DataProvider(name = "coordinatesProvider")
    public static Object[][] getData(Method methodName) {
	   Object[][] result;
	   double minValue = 2.0;
	   double maxValue = 6.0;
	   Spot x1 = new Spot(minValue, minValue, minValue);
	   Spot x2 = new Spot(maxValue, minValue, minValue);
	   Spot x3 = new Spot(minValue, maxValue, minValue);
	   Spot x4 = new Spot(maxValue, maxValue, minValue);
	   Spot x5 = new Spot(minValue, minValue, maxValue);
	   Spot x6 = new Spot(maxValue, minValue, maxValue);
	   Spot x7 = new Spot(minValue, maxValue, maxValue);
	   Spot x8 = new Spot(maxValue, maxValue, maxValue);

	   List<Double> xCoordinates = Arrays
			 .asList(minValue, maxValue, minValue, maxValue, minValue, maxValue,
				    minValue, maxValue);
	   List<Double> yCoordinates = Arrays
			 .asList(minValue, minValue, maxValue, maxValue, minValue, minValue,
				    maxValue, maxValue);
	   List<Double> zCoordinates = Arrays
			 .asList(minValue, minValue, minValue, minValue, maxValue, maxValue,
				    maxValue, maxValue);


	   List<Spot> expected = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, x8);
	   Cube givenCube = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);
	   if (methodName.getName()
			 .equalsIgnoreCase("testGetCoordinateShouldExtractCoordinates")) {
		  result = new Object[3][3];
		  result[0][0] = givenCube;
		  result[0][1] = xCoordinates;
		  result[0][2] = CoordinateName.X;

		  result[1][0] = givenCube;
		  result[1][1] = yCoordinates;
		  result[1][2] = CoordinateName.Y;

		  result[2][0] = givenCube;
		  result[2][1] = zCoordinates;
		  result[2][2] = CoordinateName.Z;

		  return result;
	   } else if (methodName.getName()
			 .equalsIgnoreCase("testGetCubeSpotsShouldExtractCubeSpots")) {
		  result = new Object[1][2];
		  result[0][0] = givenCube;
		  result[0][1] = expected;
		  return result;
	   } else {
		  result = new Object[3][3];
		  result[0][0] = givenCube;
		  result[0][1] = minValue;
		  result[0][2] = CoordinateName.X;

		  result[1][0] = givenCube;
		  result[1][1] = minValue;
		  result[1][2] = CoordinateName.Y;

		  result[2][0] = givenCube;
		  result[2][1] = minValue;
		  result[2][2] = CoordinateName.Z;
		  return result;
	   }
    }


    @Test(dataProvider = "coordinatesProvider")
    public void testGetCubeSpotsShouldExtractCubeSpots(
		  Cube givenCube, List<Spot> expected) {
	   CubeDataExtractor spotsExtractor = new CubeDataExtractor();
	   //when
	   List<Spot> extractedCubeSpots = spotsExtractor.getCubeSpots(givenCube);
	   //then
	   Assert.assertEquals(expected, extractedCubeSpots);
    }

    @Test(dataProvider = "coordinatesProvider")
    public void testGetCoordinateShouldExtractCoordinates(
		  Cube givenCube, List<Double> xCoordinates, CoordinateName coordinate) {
	   CubeDataExtractor dataExtractor = new CubeDataExtractor();
	   //when
	   List<Double> resultCoordinates = dataExtractor
			 .getCoordinates(givenCube, coordinate);
	   //then
	   Assert.assertEquals(xCoordinates, resultCoordinates);
    }

    @Test(dataProvider = "coordinatesProvider")
    public void testGetMinCoordinate(
		  Cube cube, Double expectedCoordinate, CoordinateName name) {
	   CubeDataExtractor dataExtractor = new CubeDataExtractor();
	   //when
	   Double resultCoordinates = dataExtractor.getMinCoordinate(cube, name);
	   //then
	   Assert.assertEquals(expectedCoordinate, resultCoordinates);
    }

}
