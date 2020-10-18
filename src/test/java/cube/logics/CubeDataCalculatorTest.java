package cube.logics;


import cube.logics.creator.CubeDataExtractor;
import cube.model.CoordinateName;
import cube.model.Cube;
import cube.model.Spot;
import cube.model.VolumeRatio;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class CubeDataCalculatorTest {
    private static final Spot x1 = new Spot(2.0, 2.0, 2.0);
    private static final Spot x2 = new Spot(6.0, 2.0, 2.0);
    private static final Spot x3 = new Spot(2.0, 6.0, 2.0);
    private static final Spot x4 = new Spot(6.0, 6.0, 2.0);
    private static final Spot x5 = new Spot(2.0, 2.0, 6.0);
    private static final Spot x6 = new Spot(6.0, 2.0, 6.0);
    private static final Spot x7 = new Spot(2.0, 6.0, 6.0);
    private static final Spot x8 = new Spot(6.0, 6.0, 6.0);

    private static final Spot firstSpot = new Spot(-2.0, -2.0, -2.0);
    private static final Spot secondSpot = new Spot(1.0, -2.0, -2.0);
    private static final Spot thirdSpot = new Spot(1.0, 1.0, -2.0);
    private static final Spot fourthSpot = new Spot(-2.0, 1.0, -2.0);
    private static final Spot fifthSpot = new Spot(-2.0, -2.0, 1.0);
    private static final Spot sixthSpot = new Spot(1.0, -2.0, 1.0);
    private static final Spot seventhSpot = new Spot(1.0, 1.0, 1.0);
    private static final Spot eighthSpot = new Spot(-2.0, 1.0, 1.0);

    private static final Spot zeroX1 = new Spot(0.0, 2.0, 2.0);
    private static final Spot zeroX2 = new Spot(0.0, 2.0, 2.0);
    private static final Spot zeroX3 = new Spot(0.0, 6.0, 2.0);
    private static final Spot zeroX4 = new Spot(0.0, 6.0, 2.0);
    private static final Spot zeroX5 = new Spot(0.0, 2.0, 6.0);
    private static final Spot zeroX6 = new Spot(0.0, 2.0, 6.0);
    private static final Spot zeroX7 = new Spot(0.0, 6.0, 6.0);
    private static final Spot zeroX8 = new Spot(0.0, 6.0, 6.0);

    private static final List<Spot> spots = Arrays
		  .asList(zeroX1, zeroX2, zeroX3, zeroX4, zeroX5, zeroX6, zeroX7, zeroX8);
    private static final List<Spot> expected = Arrays
		  .asList(x1, x2, x3, x4, x5, x6, x7, x8);

    private static final Cube givenCube = new Cube(x1, x2, x3, x4, x5, x6, x7, x8);

    private static final double CUBE_EDGE_DISTANCE_FOR_VALID = 4.0;
    private static final double SIDE_DIAGONAL_DISTANCE_FOR_VALID = 5.656854249492381;
    private static final double CUBE_DIAGONAL_DISTANCE_FOR_VALID = 6.928203230275509;
    private static final double THRESHOLD_VALUE = 0.0001;

    private static final List<Double> DISTANCES = Arrays
		  .asList(CUBE_EDGE_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
				SIDE_DIAGONAL_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
				SIDE_DIAGONAL_DISTANCE_FOR_VALID, SIDE_DIAGONAL_DISTANCE_FOR_VALID,
				CUBE_DIAGONAL_DISTANCE_FOR_VALID);

    private static final int FIRST_VOLUME = 9;
    private static final int SECOND_VOLUME = 18;


    @Test
    public void testCalculateCubeVolumeShouldReturnCorrectCubeVolume() {
	   CubeDataExtractor spotsExtractor = Mockito.mock(CubeDataExtractor.class);
	   DistancesBetweenSpotsProvider distancesBetweenSpotsProvider = Mockito
			 .mock(DistancesBetweenSpotsProvider.class);

	   when(spotsExtractor.getCubeSpots(any(Cube.class))).thenReturn(expected);

	   when(distancesBetweenSpotsProvider
			 .calculateDistances(any(List.class), any(Spot.class), anyInt()))
			 .thenReturn(Arrays.asList(3.0));

	   CubeDataCalculator dataCalculator = new CubeDataCalculator(
			 distancesBetweenSpotsProvider, spotsExtractor);
	   //when
	   double calculatedVolume = dataCalculator.calculateCubeVolume(givenCube);
	   //then
	   Assert.assertTrue(
			 Math.abs(Math.pow(3.0, 3) - calculatedVolume) < THRESHOLD_VALUE);

    }

    @Test
    public void testCalculateCubePerimeterShouldReturnCorrectCubeVolume() {
	   CubeDataExtractor spotsExtractor = Mockito.mock(CubeDataExtractor.class);
	   DistancesBetweenSpotsProvider distancesBetweenSpotsProvider = Mockito
			 .mock(DistancesBetweenSpotsProvider.class);

	   when(spotsExtractor.getCubeSpots(any(Cube.class))).thenReturn(expected);

	   when(distancesBetweenSpotsProvider.calculateDistances(any(List.class), any(Spot.class), anyInt()))
			 .thenReturn(Arrays.asList(3.0));
	   CubeDataCalculator dataCalculator = new CubeDataCalculator(
			 distancesBetweenSpotsProvider, spotsExtractor);
	   //when
	   double perim = dataCalculator.calculateCubePerimeter(givenCube);
	   //then
	   Assert.assertTrue(Math.abs(3.0 * 4 * 3 - perim) < THRESHOLD_VALUE);

    }

    @Test
    public void testCalculateCubeAreaShouldReturnCorrectCubeArea() {
	   CubeDataExtractor spotsExtractor = Mockito.mock(CubeDataExtractor.class);
	   DistancesBetweenSpotsProvider distancesBetweenSpotsProvider = Mockito
			 .mock(DistancesBetweenSpotsProvider.class);

	   List<Double> distances = Arrays
			 .asList(CUBE_EDGE_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
				    SIDE_DIAGONAL_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
				    SIDE_DIAGONAL_DISTANCE_FOR_VALID,
				    SIDE_DIAGONAL_DISTANCE_FOR_VALID,
				    CUBE_DIAGONAL_DISTANCE_FOR_VALID);

	   when(spotsExtractor.getCubeSpots(any(Cube.class))).thenReturn(expected);

	   when(distancesBetweenSpotsProvider
			 .calculateDistances(any(List.class), any(Spot.class), anyInt()))
			 .thenReturn(Arrays.asList(3.0));

	   CubeDataCalculator dataCalculator = new CubeDataCalculator(
			 distancesBetweenSpotsProvider, spotsExtractor);
	   //when
	   double calculatedVolume = dataCalculator.calculateCubeArea(givenCube);
	   //then
	   Assert.assertTrue(
			 (Math.abs(Math.pow(3.0, 2) * 6) - calculatedVolume) < THRESHOLD_VALUE);

    }

    @Test
    public void testIsZeroedCoordinatePlacedShouldReturnFalse() {
	   CubeDataExtractor spotsExtractor = Mockito.mock(CubeDataExtractor.class);

	   DistancesBetweenSpotsProvider distancesBetweenSpotsProvider = Mockito
			 .mock(DistancesBetweenSpotsProvider.class);

	   given(spotsExtractor.getCubeSpots(any(Cube.class))).willReturn(expected);

	   CubeDataCalculator dataCalculator = new CubeDataCalculator(
			 distancesBetweenSpotsProvider, spotsExtractor);
	   //when
	   boolean isZeroPlaced = dataCalculator.isZeroedCoordinatePlaced(givenCube);
	   //then
	   Assert.assertFalse(isZeroPlaced);
    }

    @Test
    public void testIsZeroedCoordinatePlacedShouldReturnTrue() {
	   CubeDataExtractor spotsExtractor = Mockito.mock(CubeDataExtractor.class);

	   DistancesBetweenSpotsProvider distancesBetweenSpotsProvider = Mockito
			 .mock(DistancesBetweenSpotsProvider.class);

	   given(spotsExtractor.getCubeSpots(any(Cube.class))).willReturn(spots);

	   CubeDataCalculator dataCalculator = new CubeDataCalculator(
			 distancesBetweenSpotsProvider, spotsExtractor);
	   //when
	   boolean isZeroPlaced = dataCalculator.isZeroedCoordinatePlaced(givenCube);
	   //then
	   Assert.assertTrue(isZeroPlaced);
    }

    @Test
    public void testCalculateVolumeRatioShouldReturnVolumeRatio() throws LogicsException {
	   DistancesBetweenSpotsProvider distancesBetweenSpotsProvider = Mockito
			 .mock(DistancesBetweenSpotsProvider.class);
	   CubeDataExtractor spotsExtractor = Mockito.mock(CubeDataExtractor.class);
	   List<Spot> extractedSpots = Arrays
			 .asList(firstSpot, secondSpot, thirdSpot, fourthSpot, fifthSpot,
				    sixthSpot, seventhSpot, eighthSpot);
	   Cube forCalculation = new Cube(firstSpot, secondSpot, thirdSpot, fourthSpot,
			 fifthSpot, sixthSpot, seventhSpot, eighthSpot);
	   double fifthXCoordinate = fifthSpot.getXCoordinate();
	   double secondXCoordinate = secondSpot.getXCoordinate();
	   double thirdXCoordinate = thirdSpot.getXCoordinate();
	   double fourthXCoordinate = fourthSpot.getXCoordinate();
	   double firstXCoordinate = firstSpot.getXCoordinate();
	   double sixthXCoordinate = sixthSpot.getXCoordinate();
	   double seventhXCoordinate = seventhSpot.getXCoordinate();
	   List<Double> spotCoordinates = Arrays
			 .asList(firstXCoordinate, secondXCoordinate, thirdXCoordinate,
				    fourthXCoordinate, fifthXCoordinate, sixthXCoordinate,
				    seventhXCoordinate);
	   when(spotsExtractor.getCubeSpots(any(Cube.class))).thenReturn(extractedSpots);
	   when(spotsExtractor.getCoordinates(any(Cube.class), any()))
			 .thenReturn(spotCoordinates);
	   when(distancesBetweenSpotsProvider
			 .calculateDistances(any(List.class), any(Spot.class), anyInt()))
			 .thenReturn(Arrays.asList(3.0));
	   CubeDataCalculator cubeDataCalculator = new CubeDataCalculator(
			 distancesBetweenSpotsProvider, spotsExtractor);
	   VolumeRatio expected = new VolumeRatio(FIRST_VOLUME, SECOND_VOLUME);
	   //when
	   VolumeRatio result = cubeDataCalculator
			 .calculateVolumeRatio(forCalculation, CoordinateName.X);
	   //then
	   Assert.assertEquals(expected, result);
    }

    @Test(expected = LogicsException.class)//then
    public void testCalculateVolumeRatioShouldThrowLogicsException() throws LogicsException {
	   DistancesBetweenSpotsProvider distancesBetweenSpotsProvider = Mockito
			 .mock(DistancesBetweenSpotsProvider.class);
	   CubeDataExtractor spotsExtractor = Mockito.mock(CubeDataExtractor.class);

	   when(spotsExtractor.getCubeSpots(givenCube)).thenReturn(expected);
	   when(spotsExtractor.getCoordinates(any(Cube.class), any())).thenReturn(DISTANCES);
	   when(distancesBetweenSpotsProvider
			 .calculateDistances(any(List.class), any(Spot.class), anyInt()))
			 .thenReturn(DISTANCES);

	   CubeDataCalculator cubeDataCalculator = new CubeDataCalculator(
			 distancesBetweenSpotsProvider, spotsExtractor);
	   //when
	   VolumeRatio result = cubeDataCalculator
			 .calculateVolumeRatio(givenCube, CoordinateName.X);
    }
}
