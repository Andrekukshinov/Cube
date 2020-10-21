package cube.data.access.impl;

import cube.data.access.api.CoordinateSearchSpecification;
import cube.logics.creator.CubeDataExtractor;
import cube.model.CoordinateName;
import cube.model.Cube;

import java.util.List;

public class YCoordinateSearchSpecification extends CoordinateSearchSpecification {
    private final CubeDataExtractor dataExtractor;

    //package access for testing
    YCoordinateSearchSpecification(CubeDataExtractor dataExtractor, double xCoordinate) {
	   super(xCoordinate);
	   this.dataExtractor = dataExtractor;
    }

    public YCoordinateSearchSpecification(double xCoordinate) {
	   super(xCoordinate);
	   dataExtractor = new CubeDataExtractor();
    }

    @Override
    protected List<Double> getRequiredCoordinates(Cube cube) {
	   return dataExtractor.getCoordinates(cube, CoordinateName.Y);
    }
}

