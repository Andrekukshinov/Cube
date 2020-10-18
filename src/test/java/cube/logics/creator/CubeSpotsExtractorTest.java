package cube.logics.creator;


import cube.model.Cube;
import cube.model.Spot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CubeSpotsExtractorTest {
    private final Spot x1 = new Spot(2.0, 2.0, 2.0);
    private final Spot x2 = new Spot(6.0, 2.0, 2.0);
    private final Spot x3 = new Spot(2.0, 6.0, 2.0);
    private final Spot x4 = new Spot(6.0, 6.0, 2.0);
    private final Spot x5 = new Spot(2.0, 2.0, 6.0);
    private final Spot x6 = new Spot(6.0, 2.0, 6.0);
    private final Spot x7 = new Spot(2.0, 6.0, 6.0);
    private final Spot x8 = new Spot(6.0, 6.0, 6.0);

    private final List<Spot> expected = Arrays
		  .asList(x1, x2, x3, x4, x5, x6, x7, x8);
    private final Cube givenCube = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);


    @Test
    public void testGetCubeSpotsShouldExtractCubeSpots() {
	   CubeDataExtractor spotsExtractor = new CubeDataExtractor();
	   //when
	   List<Spot> extractedCubeSpots = spotsExtractor.getCubeSpots(givenCube);
	   //then
	   Assert.assertEquals(expected, extractedCubeSpots);
    }

}
