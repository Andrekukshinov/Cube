package cube.data.access.specification.impl;

import cube.data.access.specification.CoordinateSpecification;
import cube.logics.creator.CubeDataExtractor;
import cube.model.CoordinateName;
import cube.model.Cube;

import java.util.List;

public class YCoordinate extends CoordinateSpecification {
    private final CubeDataExtractor dataExtractor;

    //package access for testing
    YCoordinate(CubeDataExtractor dataExtractor, double xCoordinate) {
	   super(xCoordinate);
	   this.dataExtractor = dataExtractor;
    }

    public YCoordinate(double xCoordinate) {
	   super(xCoordinate);
	   dataExtractor = new CubeDataExtractor();
    }

    @Override
    protected List<Double> getRequiredCoordinates(Cube cube) {
	   return dataExtractor.getCoordinates(cube, CoordinateName.Y);
    }
}

