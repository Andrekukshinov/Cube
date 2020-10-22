package cube.data.access.impl;


import cube.data.access.api.CoordinateSearchSpecificationTest;
import cube.data.access.impl.PerimeterSearchSpecification;
import cube.logics.CubeDataCalculator;
import cube.model.Cube;
import org.junit.Assert;
 import org.testng.annotations.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PerimeterSearchSpecificationTest {

    private static final double CUBE_PERIMETER = 36.0;


    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testIsSpecifiedShouldReturnTrue(Cube givenCube) {
	   CubeDataCalculator dataCalculator = Mockito.mock(CubeDataCalculator.class);
	   when(dataCalculator.calculateCubePerimeter(any(Cube.class)))
			 .thenReturn(CUBE_PERIMETER);
	   PerimeterSearchSpecification perimeterSpecification = new PerimeterSearchSpecification(
			 dataCalculator, 35.9, 36.1);
	   //when
	   boolean specified = perimeterSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertTrue(specified);
    }

    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testIsSpecifiedShouldReturnFalse(Cube givenCube) {
	   CubeDataCalculator dataCalculator = Mockito.mock(CubeDataCalculator.class);
	   when(dataCalculator.calculateCubePerimeter(any(Cube.class)))
			 .thenReturn(CUBE_PERIMETER);
	   PerimeterSearchSpecification perimeterSpecification = new PerimeterSearchSpecification(
			 dataCalculator, 35.9, 26.1);
	   //when
	   boolean specified = perimeterSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertFalse(specified);
    }
}
