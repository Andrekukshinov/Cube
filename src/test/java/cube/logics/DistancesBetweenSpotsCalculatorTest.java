package cube.logics;


import cube.logics.creator.CubeSpotsExtractor;
import cube.model.Cube;
import cube.model.Spot;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

public class DistancesBetweenSpotsCalculatorTest {
    private final Spot x1 = new Spot(2.0, 2.0, 2.0);
    private final Spot x2 = new Spot(6.0, 2.0, 2.0);
    private final Spot x3 = new Spot(2.0, 6.0, 2.0);
    private final Spot x4 = new Spot(6.0, 6.0, 2.0);
    private final Spot x5 = new Spot(2.0, 2.0, 6.0);
    private final Spot x6 = new Spot(6.0, 2.0, 6.0);
    private final Spot x7 = new Spot(2.0, 6.0, 6.0);
    private final Spot x8 = new Spot(6.0, 6.0, 6.0);

    private final double cubeEdgeDistance = 4.0;
    private final double sideDiagonalDistance = 5.656854249492381;
    private final double cubeDiagonalDistance = 6.928203230275509;
    private final Cube cube = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);
    private final List<Double> distancesToCompare = Arrays.asList(cubeEdgeDistance, cubeEdgeDistance, sideDiagonalDistance, cubeEdgeDistance, sideDiagonalDistance, sideDiagonalDistance, cubeDiagonalDistance);
    private final List<Spot> spotsToValidate = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, x8);

    @Test
    public void testGetDistancesFromGivenSpot() {
	   CubeSpotsExtractor spotsExtractor = Mockito.mock(CubeSpotsExtractor.class);
	   given(spotsExtractor.getCubeSpots(cube)).willReturn(Arrays.asList(cube.getFirstSpot(), cube.getSecondSpot(), cube.getThirdSpot(), cube.getFourthSpot(), cube.getFifthSpot(), cube.getSixthSpot(), cube.getSeventhSpot(), cube.getEighthSpot()));
	   DistancesBetweenSpotsCalculator calculator = new DistancesBetweenSpotsCalculator(spotsExtractor);
	   List<Spot> forValidation = spotsToValidate;
	   List<Double> expected = distancesToCompare;
	   //when
	   List<Double> result = calculator.getDistancesFromGivenSpot(forValidation, 0);
	   //then
	   Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetDistancesBetweenCubeSpots() {
	   CubeSpotsExtractor spotsExtractor = Mockito.mock(CubeSpotsExtractor.class);
	   given(spotsExtractor.getCubeSpots(cube)).willReturn(Arrays.asList(cube.getFirstSpot(), cube.getSecondSpot(), cube.getThirdSpot(), cube.getFourthSpot(), cube.getFifthSpot(), cube.getSixthSpot(), cube.getSeventhSpot(), cube.getEighthSpot()));
	   DistancesBetweenSpotsCalculator calculator = new DistancesBetweenSpotsCalculator(spotsExtractor);
	   List<Double> expected = distancesToCompare;
	   //when
	   List<Double> result = calculator.getDistancesBetweenCubeSpots(cube);
	   //then
	   Assert.assertEquals(expected, result);
    }
}
