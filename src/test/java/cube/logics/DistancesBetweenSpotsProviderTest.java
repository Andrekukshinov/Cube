package cube.logics;


import cube.logics.creator.CubeCreatorTest;
import cube.model.Spot;
import org.junit.Assert;
 import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DistancesBetweenSpotsProviderTest {

    private static final double CUBE_EDGE_DISTANCE = 4.0;
    private static final double SIDE_DIAGONAL_DISTANCE = 5.656854249492381;
    private static final double CUBE_DIAGONAL_DISTANCE = 6.928203230275509;

    private static final List<Double> distancesToCompare = Arrays
		  .asList(CUBE_EDGE_DISTANCE, CUBE_EDGE_DISTANCE, SIDE_DIAGONAL_DISTANCE,
				CUBE_EDGE_DISTANCE, SIDE_DIAGONAL_DISTANCE, SIDE_DIAGONAL_DISTANCE,
				CUBE_DIAGONAL_DISTANCE);

    @Test(dataProvider = "spotsProvider", dataProviderClass = CubeCreatorTest.class)
    public void testCalculateDistancesShouldReturnDistancesFromGivenSpot(List<Spot> spotsToValidate, Spot x1) {
	   DistancesBetweenSpotsProvider distancesProvider = new DistancesBetweenSpotsProvider();
	   //when
        List<Double> resultDistances = distancesProvider
                .calculateDistances(spotsToValidate, x1, 0);
        //then
        Assert.assertEquals(distancesToCompare, resultDistances);
    }

}
