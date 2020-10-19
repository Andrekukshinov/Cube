package cube.model.observable;

import cube.model.Spot;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

public class CubeObservableTest {

   @DataProvider(name = "cubeObservableProvider")
    public static Object[][] cubeObservableProvider() {
	    Spot x1 = new Spot(2.0, 2.0, 2.0);
	    Spot x2 = new Spot(6.0, 2.0, 2.0);
	    Spot x3 = new Spot(2.0, 6.0, 2.0);
	    Spot x4 = new Spot(6.0, 6.0, 2.0);
	    Spot x5 = new Spot(2.0, 2.0, 6.0);
	    Spot x6 = new Spot(6.0, 2.0, 6.0);
	    Spot x7 = new Spot(2.0, 6.0, 6.0);
	    Spot x8 = new Spot(6.0, 6.0, 6.0);
	    CubeObservable forCalculation = new CubeObservable(x1, x2, x3,
			 x4, x5, x6, x7, x8);
	    return new Object[][]{{forCalculation}};
    }

    private static final Spot zeroX8 = new Spot(0.0, 6.0, 6.0);

    @Test(dataProvider = "cubeObservableProvider")
    public void testAddObserver(CubeObservable observable) {
	   CubeObserver observer = Mockito.mock(CubeObserver.class);
	   List<Observer> expected = Collections.singletonList(observer);
	   //when
	   observable.addObserver(observer);
	   //then
	   List<Observer> result = observable.getObserves();
	   Assert.assertEquals(expected, result);
	   verify(observer, Mockito.times(1)).update(observable);
    }

    @Test(dataProvider = "cubeObservableProvider")
    public void testRemoveObserver(CubeObservable observable) {

	   CubeObserver observer = Mockito.mock(CubeObserver.class);
	   List<Observer> expected = Collections.singletonList(observer);
	   observable.addObserver(observer);
	   observable.addObserver(observer);
	   //when
	   observable.removeObserver(observer);
	   //then
	   List<Observer> result = observable.getObserves();
	   Assert.assertEquals(expected, result);
    }

    @Test(dataProvider = "cubeObservableProvider")
    public void testNotifyAllShouldNotifyObserversOnUpdatingTheObject(CubeObservable observable) {
	   CubeObserver observer = Mockito.mock(CubeObserver.class);
	   observable.addObserver(observer);
	   //when
	   observable.setFirstSpot(zeroX8);
	   //then
	   verify(observer, Mockito.times(2)).update(observable);
    }

    @Test(dataProvider = "cubeObservableProvider")
    public void testNotifyAllShouldNotNotifyObservers(CubeObservable observable) {
	   CubeObserver observer = Mockito.mock(CubeObserver.class);
	   observable.addObserver(observer);
	   observable.removeObserver(observer);
	   //when
	   observable.setFirstSpot(zeroX8);
	   //then
	   verify(observer, Mockito.times(1)).update(observable);
    }

}
