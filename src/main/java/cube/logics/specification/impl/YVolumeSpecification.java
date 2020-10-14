package cube.logics.specification.impl;

import cube.logics.specification.VolumesSpecification;
import cube.model.Spot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class YVolumeSpecification extends VolumesSpecification {
    @Override
    protected List<Double> extractRequiredCoordinate(List<Spot> spots) {
	   List<Double> yCoordinates = new ArrayList<>();
	   for (Spot spot : spots) {
		  yCoordinates.add(spot.getYCoordinate());
	   }
	   return yCoordinates;
    }
}
