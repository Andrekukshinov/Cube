package cube.model.observable;

import cube.logics.CubeDataCalculator;
import cube.logics.DistancesBetweenSpotsProvider;
import cube.logics.creator.CubeDataExtractor;
import cube.model.Register;

import java.util.HashMap;
import java.util.Map;

public class CubeObserver implements Observer {
    private static CubeObserver instance;
    private final CubeDataCalculator calculator;
    private final Map<Long, Register> cubeDataMap = new HashMap<>();

    private CubeObserver() {
	   DistancesBetweenSpotsProvider distancesCalculator = new DistancesBetweenSpotsProvider();
	   CubeDataExtractor spotsExtractor = new CubeDataExtractor();
	   this.calculator = new CubeDataCalculator(distancesCalculator, spotsExtractor);
    }

    //for testing
    CubeObserver(CubeDataCalculator calculator) {
	   this.calculator = calculator;
    }

    public static CubeObserver getInstance() {
	   if (instance == null) {
		  instance = new CubeObserver();
	   }
	   return instance;
    }

    @Override
    public void update(CubeObservable cube) {
	   double area = calculator.calculateCubeArea(cube);
	   double volume = calculator.calculateCubeVolume(cube);
	   double perimeter = calculator.calculateCubePerimeter(cube);
	   Register register = new Register(area, volume, perimeter);
	   cubeDataMap.put(cube.getId(), register);
    }

    //for testing
    Register getTestedObject(long id) {
	   return cubeDataMap.get(id);
    }
}
