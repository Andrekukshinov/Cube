package cube.model.observable;


import cube.logics.CubeDataCalculator;
import cube.model.Cube;
import cube.model.Register;
import cube.model.Spot;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CubeObserverTest {
    private static final Spot x1 = new Spot(2.0, 2.0, 2.0);
    private static final Spot x2 = new Spot(6.0, 2.0, 2.0);
    private static final Spot x3 = new Spot(2.0, 6.0, 2.0);
    private static final Spot x4 = new Spot(6.0, 6.0, 2.0);
    private static final Spot x5 = new Spot(2.0, 2.0, 6.0);
    private static final Spot x6 = new Spot(6.0, 2.0, 6.0);
    private static final Spot x7 = new Spot(2.0, 6.0, 6.0);
    private static final Spot x8 = new Spot(6.0, 6.0, 6.0);

    private static final CubeObservable givenCube = new CubeObservable(x1, x2, x3, x4, x5,
		  x6, x7, x8, 1);

    private static final double CUBE_VOLUME = 27.0;
    private static final double CUBE_AREA = 54.0;
    private static final double CUBE_PERIMETER = 36.0;

    @Test
    public void testUpdateShouldPutRegisterDataOfSpecifiedCube() {
	   CubeDataCalculator dataCalculator = Mockito.mock(CubeDataCalculator.class);
	   CubeObserver observer = new CubeObserver(dataCalculator);
	   when(dataCalculator.calculateCubeVolume(any(Cube.class))).thenReturn(CUBE_VOLUME);
	   when(dataCalculator.calculateCubeArea(any(Cube.class))).thenReturn(CUBE_AREA);
	   when(dataCalculator.calculateCubePerimeter(any(Cube.class)))
			 .thenReturn(CUBE_PERIMETER);
	   Register expected = new Register(CUBE_AREA, CUBE_VOLUME, CUBE_PERIMETER);
	   //when
	   observer.update(givenCube);
	   //then
	   Register compareWith = observer.getTestedObject(givenCube.getId());
	   Assert.assertEquals(expected, compareWith);
    }

}
