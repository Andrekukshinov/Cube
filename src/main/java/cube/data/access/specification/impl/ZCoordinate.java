package cube.data.access.specification.impl;

import cube.data.access.specification.CoordinateSpecification;
import cube.logics.creator.CubeDataExtractor;
import cube.model.CoordinateName;
import cube.model.Cube;

import java.util.List;

public class ZCoordinate extends CoordinateSpecification {
    private final CubeDataExtractor dataExtractor;

    //package access for testing
    ZCoordinate(CubeDataExtractor dataExtractor, double xCoordinate) {
	   super(xCoordinate);
	   this.dataExtractor = dataExtractor;
    }

    public ZCoordinate(double xCoordinate) {
	   super(xCoordinate);
	   dataExtractor = new CubeDataExtractor();
    }

    @Override
    protected List<Double> getRequiredCoordinates(Cube cube) {
	   return dataExtractor.getCoordinates(cube, CoordinateName.X);
    }
}

