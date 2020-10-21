package cube.data.access.impl;

import cube.data.access.api.CoordinateSearchSpecificationTest;
import cube.data.access.impl.AreaSearchSpecification;
import cube.logics.CubeDataCalculator;
import cube.model.Cube;
import org.junit.Assert;
 import org.testng.annotations.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AreaSearchSpecificationTest {
    private static final double CUBE_AREA = 54.0;


    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testIsSpecifiedShouldReturnTrue(Cube givenCube) {
	   CubeDataCalculator dataCalculator = Mockito.mock(CubeDataCalculator.class);
	   when(dataCalculator.calculateCubeArea(any(Cube.class))).thenReturn(CUBE_AREA);
	   AreaSearchSpecification areaSpecification = new AreaSearchSpecification(dataCalculator, 53.9,
			 54.1);
	   //when
	   boolean specified = areaSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertTrue(specified);
    }

    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testIsSpecifiedShouldReturnFalse(Cube givenCube) {
	   CubeDataCalculator dataCalculator = Mockito.mock(CubeDataCalculator.class);
	   when(dataCalculator.calculateCubeArea(any(Cube.class))).thenReturn(CUBE_AREA);
	   AreaSearchSpecification areaSpecification = new AreaSearchSpecification(dataCalculator, 93.9,
			 54.1);
	   //when
	   boolean specified = areaSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertFalse(specified);
    }
}
