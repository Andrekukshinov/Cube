package cube.logics.specification.impl;

import cube.logics.specification.VolumesSpecification;
import cube.model.Spot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class XVolumeSpecification extends VolumesSpecification {
    @Override
    protected List<Double> extractRequiredCoordinate(List<Spot> spots) {
        List<Double> xCoordinates = new ArrayList<>();
	   for (Spot spot : spots) {
		  xCoordinates.add(spot.getXCoordinate());
	   }
	   return xCoordinates;
    }
}
