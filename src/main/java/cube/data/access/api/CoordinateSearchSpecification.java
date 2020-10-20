package cube.data.access.api;

import cube.data.access.api.SearchSpecification;
import cube.logics.creator.CubeValidator;
import cube.model.Cube;

import java.util.List;
import java.util.logging.Logger;

public abstract class CoordinateSearchSpecification implements SearchSpecification<Cube> {


    private final double xCoordinate;

    public CoordinateSearchSpecification(double xCoordinate) {
	   this.xCoordinate = xCoordinate;
    }

    @Override
    public boolean isSpecified(Cube cube) {
	   List<Double> coordinates = getRequiredCoordinates(cube);
	   boolean result = false;
	   for (Double coordinate : coordinates) {
		  if (Math.abs(coordinate - xCoordinate) < 0.0001) {
			 result = true;
		  }
	   }
	   return result;
    }

    protected abstract List<Double> getRequiredCoordinates(Cube cube);
}
