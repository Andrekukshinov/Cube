package cube.model.observable;


import cube.logics.CubeDataCalculator;
import cube.model.Cube;
import cube.model.Register;
import cube.model.Spot;
import org.junit.Assert;
 import org.testng.annotations.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CubeObserverTest {
    private static final double CUBE_VOLUME = 27.0;
    private static final double CUBE_AREA = 54.0;
    private static final double CUBE_PERIMETER = 36.0;

    @Test(dataProviderClass = CubeObservableTest.class, dataProvider = "cubeObservableProvider")
    public void testUpdateShouldPutRegisterDataOfSpecifiedCube(CubeObservable givenCube) {
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
