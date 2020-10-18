package cube.data.access.specification;

import cube.data.access.specification.Specification;
import cube.logics.CubeDataCalculator;
import cube.logics.DistancesBetweenSpotsProvider;
import cube.logics.creator.CubeDataExtractor;
import cube.model.Cube;

import java.util.List;

public abstract class CoordinateSpecification implements Specification<Cube> {
    private final double xCoordinate;

    public CoordinateSpecification( double xCoordinate) {
	   this.xCoordinate = xCoordinate;
    }

    @Override
    public boolean isSpecified(Cube cube) {
	   List<Double> xCoordinates = getRequiredCoordinates(cube);
	   boolean result = false;
	   for (Double coordinate : xCoordinates) {
		  if (coordinate - xCoordinate < 0.0001) {
			 result = true;
		  }
	   }
	   return result;
    }

    protected abstract List<Double> getRequiredCoordinates(Cube cube);
}
