package cube.logics;


import cube.logics.creator.CubeSpotsExtractor;
import cube.model.CoordinatePlanes;
import cube.model.Cube;
import cube.model.Spot;
import cube.model.VolumeRatio;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class CubeDataCalculatorTest {
    private final Spot x1 = new Spot(2.0, 2.0, 2.0);
    private final Spot x2 = new Spot(6.0, 2.0, 2.0);
    private final Spot x3 = new Spot(2.0, 6.0, 2.0);
    private final Spot x4 = new Spot(6.0, 6.0, 2.0);
    private final Spot x5 = new Spot(2.0, 2.0, 6.0);
    private final Spot x6 = new Spot(6.0, 2.0, 6.0);
    private final Spot x7 = new Spot(2.0, 6.0, 6.0);
    private final Spot x8 = new Spot(6.0, 6.0, 6.0);

    private final Spot firstSpot = new Spot(-2.0, -2.0, -2.0);
    private final Spot secondSpot = new Spot(1.0, -2.0, -2.0);
    private final Spot thirdSpot = new Spot(1.0, 1.0, -2.0);
    private final Spot fourthSpot = new Spot(-2.0, 1.0, -2.0);
    private final Spot fifthSpot = new Spot(-2.0, -2.0, 1.0);
    private final Spot sixthSpot = new Spot(1.0, -2.0, 1.0);
    private final Spot seventhSpot = new Spot(1.0, 1.0, 1.0);
    private final Spot eighthSpot = new Spot(-2.0, 1.0, 1.0);
    
    private final double cubeEdgeDistanceForValid = 4.0;
    private final double sideDiagonalDistanceForValid = 5.656854249492381;
    private final double cubeDiagonalDistanceForValid = 6.928203230275509;
    private final List<Spot> expected = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, x8);

    @Test
    public void testCalculateCubeVolumeShouldReturnCorrectCubeVolume() {
	   CubeSpotsExtractor spotsExtractor = Mockito.mock(CubeSpotsExtractor.class);
	   DistancesBetweenSpotsCalculator distancesBetweenSpotsCalculator = Mockito.mock(DistancesBetweenSpotsCalculator.class);
	   Cube givenCube = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);
	   List<Double> distances = Arrays.asList(cubeEdgeDistanceForValid, cubeEdgeDistanceForValid, sideDiagonalDistanceForValid, cubeEdgeDistanceForValid, sideDiagonalDistanceForValid, sideDiagonalDistanceForValid, cubeDiagonalDistanceForValid);
	   when(distancesBetweenSpotsCalculator.getDistancesBetweenCubeSpots(givenCube)).thenReturn(distances);
	   CubeDataCalculator dataCalculator = new CubeDataCalculator(distancesBetweenSpotsCalculator, spotsExtractor);
	   //when
	   double calculatedVolume = dataCalculator.calculateCubeVolume(givenCube);
	   //then
	   Assert.assertTrue(Math.abs(Math.pow(4.0, 3) - calculatedVolume) < 0.0001);

    }
    @Test
    public void testCalculateCubeAreaShouldReturnCorrectCubeArea() {
	   CubeSpotsExtractor spotsExtractor = Mockito.mock(CubeSpotsExtractor.class);
	   DistancesBetweenSpotsCalculator distancesBetweenSpotsCalculator = Mockito.mock(DistancesBetweenSpotsCalculator.class);
	   Cube givenCube = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);
	   List<Double> distances = Arrays.asList(cubeEdgeDistanceForValid, cubeEdgeDistanceForValid, sideDiagonalDistanceForValid, cubeEdgeDistanceForValid, sideDiagonalDistanceForValid, sideDiagonalDistanceForValid, cubeDiagonalDistanceForValid);
	   when(distancesBetweenSpotsCalculator.getDistancesBetweenCubeSpots(givenCube)).thenReturn(distances);
	   CubeDataCalculator dataCalculator = new CubeDataCalculator(distancesBetweenSpotsCalculator, spotsExtractor);
	   //when
	   double calculatedVolume = dataCalculator.calculateCubeArea(givenCube);
	   //then
	   Assert.assertTrue((Math.abs(Math.pow(4.0, 2) * 6) - calculatedVolume) < 0.0001);

    }
    @Test
    public void testIsZeroedCoordinatePlacedShouldReturnFalse() {
	   CubeSpotsExtractor spotsExtractor = Mockito.mock(CubeSpotsExtractor.class);
	   DistancesBetweenSpotsCalculator distancesBetweenSpotsCalculator = Mockito.mock(DistancesBetweenSpotsCalculator.class);
	   Cube givenCube = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);
	   given(spotsExtractor.getCubeSpots(givenCube)).willReturn(expected);
	   CubeDataCalculator dataCalculator = new CubeDataCalculator(distancesBetweenSpotsCalculator, spotsExtractor);
	   //when
	   boolean isZeroPlaced = dataCalculator.isZeroedCoordinatePlaced(givenCube);
	   //then
	   Assert.assertFalse(isZeroPlaced);
    }
    @Test
    public void testIsZeroedCoordinatePlacedShouldReturnTrue() {
	   CubeSpotsExtractor spotsExtractor = Mockito.mock(CubeSpotsExtractor.class);
	   DistancesBetweenSpotsCalculator distancesBetweenSpotsCalculator = Mockito.mock(DistancesBetweenSpotsCalculator.class);
	   Spot zeroX1 = new Spot(0.0, 2.0, 2.0);
	   Spot zeroX2 = new Spot(0.0, 2.0, 2.0);
	   Spot zeroX3 = new Spot(0.0, 6.0, 2.0);
	   Spot zeroX4 = new Spot(0.0, 6.0, 2.0);
	   Spot zeroX5 = new Spot(0.0, 2.0, 6.0);
	   Spot zeroX6 = new Spot(0.0, 2.0, 6.0);
	   Spot zeroX7 = new Spot(0.0, 6.0, 6.0);
	   Spot zeroX8 = new Spot(0.0, 6.0, 6.0);
	   Cube givenCube = new Cube(zeroX1, zeroX2, zeroX3, zeroX4, zeroX5, zeroX6, zeroX7, zeroX8);
	   List<Spot> spots = Arrays.asList(zeroX1, zeroX2, zeroX3, zeroX4, zeroX5, zeroX6, zeroX7, zeroX8);
	   given(spotsExtractor.getCubeSpots(givenCube)).willReturn(spots);
	   CubeDataCalculator dataCalculator = new CubeDataCalculator(distancesBetweenSpotsCalculator, spotsExtractor);
	   //when
	   boolean isZeroPlaced = dataCalculator.isZeroedCoordinatePlaced(givenCube);
	   //then
	   Assert.assertTrue(isZeroPlaced);
    }
    @Test
    public void testCalculateVolumeRatioShouldReturnVolumeRatio() throws LogicsException {
	   DistancesBetweenSpotsCalculator distancesBetweenSpotsCalculator = Mockito.mock(DistancesBetweenSpotsCalculator.class);
	   CubeSpotsExtractor spotsExtractor = Mockito.mock(CubeSpotsExtractor.class);
	   List<Spot> extractedSpots = Arrays.asList(firstSpot, secondSpot, thirdSpot, fourthSpot, fifthSpot, sixthSpot, seventhSpot, eighthSpot);
	   Cube forCalculation = new Cube(firstSpot, secondSpot, thirdSpot, fourthSpot, fifthSpot, sixthSpot, seventhSpot, eighthSpot);
	   when(spotsExtractor.getCubeSpots(forCalculation)).thenReturn(extractedSpots);
	   when(distancesBetweenSpotsCalculator.getDistancesBetweenCubeSpots(forCalculation)).thenReturn(Arrays.asList(3.0));
	   CubeDataCalculator cubeDataCalculator = new CubeDataCalculator(distancesBetweenSpotsCalculator, spotsExtractor);
	   VolumeRatio expected = new VolumeRatio(9, 18);
	   //when
	   VolumeRatio result = cubeDataCalculator.calculateVolumeRatio(forCalculation, CoordinatePlanes.X);
	   //then
	   Assert.assertEquals(expected, result);
    }
    @Test(expected = LogicsException.class)//then
    public void testCalculateVolumeRatioShouldThrowLogicsException() throws LogicsException {
	   DistancesBetweenSpotsCalculator distancesBetweenSpotsCalculator = Mockito.mock(DistancesBetweenSpotsCalculator.class);
	   CubeSpotsExtractor spotsExtractor = Mockito.mock(CubeSpotsExtractor.class);
	   Cube forCalculation = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);
	   List<Spot> extractedSpots = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, x8);
	   when(spotsExtractor.getCubeSpots(forCalculation)).thenReturn(extractedSpots);
	   when(distancesBetweenSpotsCalculator.getDistancesBetweenCubeSpots(forCalculation)).thenReturn(Arrays.asList(3.0));
	   CubeDataCalculator cubeDataCalculator = new CubeDataCalculator(distancesBetweenSpotsCalculator, spotsExtractor);
	   //when
	   VolumeRatio result = cubeDataCalculator.calculateVolumeRatio(forCalculation, CoordinatePlanes.X);
    }
}
