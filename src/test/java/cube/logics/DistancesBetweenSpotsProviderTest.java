package cube.logics;


import cube.model.Spot;
import org.junit.Assert;
 import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DistancesBetweenSpotsProviderTest {
    private static final Spot x1 = new Spot(2.0, 2.0, 2.0);
    private static final Spot x2 = new Spot(6.0, 2.0, 2.0);
    private static final Spot x3 = new Spot(2.0, 6.0, 2.0);
    private static final Spot x4 = new Spot(6.0, 6.0, 2.0);
    private static final Spot x5 = new Spot(2.0, 2.0, 6.0);
    private static final Spot x6 = new Spot(6.0, 2.0, 6.0);
    private static final Spot x7 = new Spot(2.0, 6.0, 6.0);
    private static final Spot x8 = new Spot(6.0, 6.0, 6.0);

    private static final double CUBE_EDGE_DISTANCE = 4.0;
    private static final double SIDE_DIAGONAL_DISTANCE = 5.656854249492381;
    private static final double CUBE_DIAGONAL_DISTANCE = 6.928203230275509;

    private static final List<Double> distancesToCompare = Arrays
		  .asList(CUBE_EDGE_DISTANCE, CUBE_EDGE_DISTANCE, SIDE_DIAGONAL_DISTANCE,
				CUBE_EDGE_DISTANCE, SIDE_DIAGONAL_DISTANCE, SIDE_DIAGONAL_DISTANCE,
				CUBE_DIAGONAL_DISTANCE);
    private static final List<Spot> spotsToValidate = Arrays
		  .asList(x1, x2, x3, x4, x5, x6, x7, x8);

    @Test
    public void testCalculateDistancesShouldReturnDistancesFromGivenSpot() {
	   DistancesBetweenSpotsProvider distancesProvider = new DistancesBetweenSpotsProvider();
	   //when
        List<Double> resultDistances = distancesProvider
                .calculateDistances(spotsToValidate, x1, 0);
        //then
        Assert.assertEquals(distancesToCompare, resultDistances);
    }

}
