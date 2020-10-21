package cube.data.access.api;


import cube.data.access.impl.XCoordinateSearchSpecification;
import cube.data.access.impl.YCoordinateSearchSpecification;
import cube.data.access.impl.ZCoordinateSearchSpecification;
import cube.model.Cube;
import cube.model.Spot;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CoordinateSearchSpecificationTest {

    private static final double INVALID_COORDINATE = 0.0;
    private static final double COORDINATE = 2.0;

    @DataProvider(name = "cubeProvider")
    public static Object[][] cubeProvider() {
	    Spot x1 = new Spot(2.0, 2.0, 2.0);
	    Spot x2 = new Spot(6.0, 2.0, 2.0);
	    Spot x3 = new Spot(2.0, 6.0, 2.0);
	    Spot x4 = new Spot(6.0, 6.0, 2.0);
	    Spot x5 = new Spot(2.0, 2.0, 6.0);
	    Spot x6 = new Spot(6.0, 2.0, 6.0);
	    Spot x7 = new Spot(2.0, 6.0, 6.0);
	    Spot x8 = new Spot(6.0, 6.0, 6.0);
	   Cube givenCube = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);
	   return new Object[][]{{givenCube}};
    }


    @Test(dataProvider = "cubeProvider")
    public void testIsSpecifiedByXCoordinateShouldReturnTrue(Cube givenCube) {
	   CoordinateSearchSpecification searchSpecification = new XCoordinateSearchSpecification(
			 COORDINATE);
	   //when
	   boolean result = searchSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertTrue(result);
    }

    @Test(dataProvider = "cubeProvider")
    public void testIsSpecifiedByYCoordinateShouldReturnTrue(Cube givenCube) {
	   CoordinateSearchSpecification searchSpecification = new YCoordinateSearchSpecification(
			 COORDINATE);
	   //when
	   boolean result = searchSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertTrue(result);
    }

    @Test(dataProvider = "cubeProvider")
    public void testIsSpecifiedByZCoordinateShouldReturnTrue(Cube givenCube) {
	   CoordinateSearchSpecification searchSpecification = new ZCoordinateSearchSpecification(
			 COORDINATE);
	   //when
	   boolean result = searchSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertTrue(result);
    }

    @Test(dataProvider = "cubeProvider")
    public void testIsSpecifiedByXCoordinateShouldReturnFalse(Cube givenCube) {
	   CoordinateSearchSpecification searchSpecification = new XCoordinateSearchSpecification(
			 INVALID_COORDINATE);
	   //when
	   boolean result = searchSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertFalse(result);
    }

    @Test(dataProvider = "cubeProvider")
    public void testIsSpecifiedByYCoordinateShouldReturnFalse(Cube givenCube) {
	   CoordinateSearchSpecification searchSpecification = new YCoordinateSearchSpecification(
			 INVALID_COORDINATE);
	   //when
	   boolean result = searchSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertFalse(result);
    }

    @Test(dataProvider = "cubeProvider")
    public void testIsSpecifiedByZCoordinateShouldReturnFalse(Cube givenCube) {
	   CoordinateSearchSpecification searchSpecification = new ZCoordinateSearchSpecification(
			 INVALID_COORDINATE);
	   //when
	   boolean result = searchSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertFalse(result);
    }
}
