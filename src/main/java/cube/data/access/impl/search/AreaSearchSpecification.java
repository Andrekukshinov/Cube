package cube.data.access.impl.search;

import cube.data.access.api.SearchSpecification;
import cube.logics.CubeDataCalculator;
import cube.logics.DistancesBetweenSpotsProvider;
import cube.logics.creator.CubeDataExtractor;
import cube.model.Cube;

public class AreaSearchSpecification implements SearchSpecification<Cube> {
    private static final double THRESHOLD_VALUE = 0.001;

    private final CubeDataCalculator dataCalculator;
    private final double leftBorder;
    private final double rightBorder;

    //    package access for testing
    AreaSearchSpecification(
		  CubeDataCalculator dataCalculator, double leftBorder, double rightBorder) {
	   this.dataCalculator = dataCalculator;
	   this.leftBorder = leftBorder;
	   this.rightBorder = rightBorder;
    }

    public AreaSearchSpecification(double leftBorder, double rightBorder) {
	   this.leftBorder = leftBorder;
	   this.rightBorder = rightBorder;
	   CubeDataExtractor dataExtractor = new CubeDataExtractor();
	   DistancesBetweenSpotsProvider distancesProvider = new DistancesBetweenSpotsProvider();
	   dataCalculator = new CubeDataCalculator(distancesProvider, dataExtractor);
    }

    @Override
    public boolean isSpecified(Cube cube) {
	   double area = dataCalculator.calculateCubeArea(cube);
	   return area - leftBorder > THRESHOLD_VALUE && rightBorder - area > THRESHOLD_VALUE;
    }
}
