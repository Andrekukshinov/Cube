package cube.data.access.impl.search;

import cube.data.access.api.CoordinateSearchSpecificationTest;
import cube.logics.CubeDataCalculator;
import cube.model.Cube;
import cube.model.Spot;
import org.junit.Assert;
 import org.testng.annotations.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class VolumeSearchSpecificationTest {
    private static final double CUBE_VOLUME = 27;


    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testIsSpecifiedShouldReturnTrue(Cube givenCube) {
	   CubeDataCalculator dataCalculator = Mockito.mock(CubeDataCalculator.class);
	   when(dataCalculator.calculateCubeVolume(any(Cube.class))).thenReturn(CUBE_VOLUME);
	   VolumeSearchSpecification areaSpecification = new VolumeSearchSpecification(dataCalculator,
			 26.9, 27.1);
	   //when
	   boolean specified = areaSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertTrue(specified);
    }

    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testIsSpecifiedShouldReturnFalse(Cube givenCube) {
	   CubeDataCalculator dataCalculator = Mockito.mock(CubeDataCalculator.class);
	   when(dataCalculator.calculateCubeVolume(any(Cube.class))).thenReturn(CUBE_VOLUME);
	   VolumeSearchSpecification areaSpecification = new VolumeSearchSpecification(dataCalculator,
			 36.9, 37.1);
	   //when
	   boolean specified = areaSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertFalse(specified);
    }
}
