package cube.data.access.impl.search;

import cube.logics.CubeDataCalculator;
import cube.model.Cube;
import cube.model.Spot;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AreaSearchSpecificationTest {
    private static final Spot x1 = new Spot(2.0, 2.0, 2.0);
    private static final Spot x2 = new Spot(6.0, 2.0, 2.0);
    private static final Spot x3 = new Spot(2.0, 6.0, 2.0);
    private static final Spot x4 = new Spot(6.0, 6.0, 2.0);
    private static final Spot x5 = new Spot(2.0, 2.0, 6.0);
    private static final Spot x6 = new Spot(6.0, 2.0, 6.0);
    private static final Spot x7 = new Spot(2.0, 6.0, 6.0);
    private static final Spot x8 = new Spot(6.0, 6.0, 6.0);

    private static final Cube givenCube = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);
    private static final double CUBE_AREA = 54.0;


    @Test
    public void testIsSpecifiedShouldReturnTrue() {
	   CubeDataCalculator dataCalculator = Mockito.mock(CubeDataCalculator.class);
	   when(dataCalculator.calculateCubeArea(any(Cube.class))).thenReturn(CUBE_AREA);
	   AreaSearchSpecification areaSpecification = new AreaSearchSpecification(dataCalculator, 53.9,
			 54.1);
	   //when
	   boolean specified = areaSpecification.isSpecified(givenCube);
	   //then
	   Assert.assertTrue(specified);
    }

    @Test
    public void testIsSpecifiedShouldReturnFalse() {
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
