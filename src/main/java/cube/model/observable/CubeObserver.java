package cube.model.observable;

import cube.logics.CubeDataCalculator;
import cube.logics.DistancesBetweenSpotsProvider;
import cube.logics.creator.CubeDataExtractor;
import cube.model.Register;

import java.util.HashMap;
import java.util.Map;

public class CubeObserver implements Observer {
    private final CubeDataCalculator calculator;
    private static CubeObserver instance;
    private Map<Long, Register> cubeDataMap = new HashMap<>();

    private CubeObserver(CubeDataCalculator calculator) {
	   this.calculator = calculator;
    }

    public static CubeObserver getInstance() {
	   if (instance == null) {
		  DistancesBetweenSpotsProvider distancesCalculator = new DistancesBetweenSpotsProvider();
		  CubeDataExtractor spotsExtractor = new CubeDataExtractor();
		  CubeDataCalculator dataCalculator = new CubeDataCalculator(
				distancesCalculator, spotsExtractor);
		  instance = new CubeObserver(dataCalculator);
	   }
	   return instance;
    }

    @Override
    public void update(CubeObservable cube) {
	   for (int runner = 0; runner < cubeDataMap.size(); ++runner) {
		  double area = calculator.calculateCubeArea(cube);
		  double volume = calculator.calculateCubeVolume(cube);
		  double perimeter = calculator.calculateCubePerimeter(cube);
		  Register register = new Register(area, volume, perimeter);
		  cubeDataMap.put(cube.getId(), register);
	   }
    }
}
