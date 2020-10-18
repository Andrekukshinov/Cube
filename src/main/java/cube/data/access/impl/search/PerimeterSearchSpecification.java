package cube.data.access.impl.search;

import cube.data.access.api.SearchSpecification;
import cube.logics.CubeDataCalculator;
import cube.logics.DistancesBetweenSpotsProvider;
import cube.logics.creator.CubeDataExtractor;
import cube.model.Cube;

public class PerimeterSearchSpecification implements SearchSpecification<Cube> {
    private static final double THRESHOLD_VALUE = 0.001;

    private final CubeDataCalculator dataCalculator;
    private final double leftBorder;
    private final double rightBorder;

    //    package access for testing
    PerimeterSearchSpecification(
		  CubeDataCalculator dataCalculator, double leftBorder, double rightBorder) {
	   this.dataCalculator = dataCalculator;
	   this.leftBorder = leftBorder;
	   this.rightBorder = rightBorder;
    }

    public PerimeterSearchSpecification(double leftBorder, double rightBorder) {
	   this.leftBorder = leftBorder;
	   this.rightBorder = rightBorder;
	   CubeDataExtractor dataExtractor = new CubeDataExtractor();
	   DistancesBetweenSpotsProvider distancesProvider = new DistancesBetweenSpotsProvider();
	   dataCalculator = new CubeDataCalculator(distancesProvider, dataExtractor);
    }

    @Override
    public boolean isSpecified(Cube cube) {
	   double perimeter = dataCalculator.calculateCubePerimeter(cube);
	   return perimeter - leftBorder > THRESHOLD_VALUE && rightBorder - perimeter > THRESHOLD_VALUE;
    }
}
