package cube.data.access.specification.impl;

import cube.data.access.specification.Specification;
import cube.logics.CubeDataCalculator;
import cube.logics.DistancesBetweenSpotsProvider;
import cube.logics.creator.CubeDataExtractor;
import cube.model.Cube;

public class AreaSpecification implements Specification<Cube> {
    private static final double THRESHOLD_VALUE = 0.001;

    private final CubeDataCalculator dataCalculator;
    private final double leftBorder;
    private final double rightBorder;

    //    package access for testing
    AreaSpecification(
		  CubeDataCalculator dataCalculator, double leftBorder, double rightBorder) {
	   this.dataCalculator = dataCalculator;
	   this.leftBorder = leftBorder;
	   this.rightBorder = rightBorder;
    }

    public AreaSpecification(double leftBorder, double rightBorder) {
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
