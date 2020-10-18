package cube.data.access.specification.impl;

import cube.data.access.specification.Specification;
import cube.logics.CubeDataCalculator;
import cube.logics.DistancesBetweenSpotsProvider;
import cube.logics.creator.CubeDataExtractor;
import cube.model.Cube;

public class VolumeSpecification implements Specification<Cube> {

    private static final double THRESHOLD_VALUE = 0.001;

    private final CubeDataCalculator dataCalculator;
    private final double leftBorder;
    private final double rightBorder;

    //    package access for testing
    VolumeSpecification(
		  CubeDataCalculator dataCalculator, double leftBorder, double rightBorder) {
	   this.dataCalculator = dataCalculator;
	   this.leftBorder = leftBorder;
	   this.rightBorder = rightBorder;
    }

    public VolumeSpecification(double leftBorder, double rightBorder) {
	   this.leftBorder = leftBorder;
	   this.rightBorder = rightBorder;
	   CubeDataExtractor dataExtractor = new CubeDataExtractor();
	   DistancesBetweenSpotsProvider distancesProvider = new DistancesBetweenSpotsProvider();
	   dataCalculator = new CubeDataCalculator(distancesProvider, dataExtractor);
    }

    @Override
    public boolean isSpecified(Cube cube) {
	   double volume = dataCalculator.calculateCubeVolume(cube);
	   return volume - leftBorder > THRESHOLD_VALUE && rightBorder - volume > THRESHOLD_VALUE;
    }
}
