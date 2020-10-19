package cube.logics.creator;


import cube.logics.DistancesBetweenSpotsProvider;
import cube.model.Spot;
import org.junit.Assert;
 import org.testng.annotations.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.when;

public class CubeValidatorTest {
    private static final Spot x1 = new Spot(2.0, 2.0, 2.0);
    private static final Spot x2 = new Spot(6.0, 2.0, 2.0);
    private static final Spot x3 = new Spot(2.0, 6.0, 2.0);
    private static final Spot x4 = new Spot(6.0, 6.0, 2.0);
    private static final Spot x5 = new Spot(2.0, 2.0, 6.0);
    private static final Spot x6 = new Spot(6.0, 2.0, 6.0);
    private static final Spot x7 = new Spot(2.0, 6.0, 6.0);
    private static final Spot x8 = new Spot(6.0, 6.0, 6.0);

    private static final Spot tooFar = new Spot(61.0, 6.0, 6.0);


    private static final Spot negativeX1 = new Spot(-2.0, -2.0, -2.0);
    private static final Spot negativeX2 = new Spot(-6.0, -2.0, -2.0);
    private static final Spot negativeX3 = new Spot(-2.0, -6.0, -2.0);
    private static final Spot negativeX4 = new Spot(-6.0, -6.0, -2.0);
    private static final Spot negativeX5 = new Spot(-2.0, -2.0, -6.0);
    private static final Spot negativeX6 = new Spot(-6.0, -2.0, -6.0);
    private static final Spot negativeX7 = new Spot(-2.0, -6.0, -6.0);
    private static final Spot negativeX8 = new Spot(-6.0, -6.0, -6.0);

    private static final double CUBE_EDGE_DISTANCE_FOR_VALID = 4.0;
    private static final double SIDE_DIAGONAL_DISTANCE_FOR_VALID = 5.656854249492381;
    private static final double CUBE_DIAGONAL_DISTANCE_FOR_VALID = 6.928203230275509;
    private static final double ZERO_COORDINATE = 0.0;


    private List<Double> getDistancesFromLastSpot(
		  double firstDistance, double secondDistance, double thirdDistance,
		  double fourthDistance, double fifthDistance, double sixthDistance,
		  double seventhDistance) {
	   return Arrays.asList(firstDistance, secondDistance, thirdDistance, fourthDistance,
			 fifthDistance, sixthDistance, seventhDistance);
    }

    private List<Double> getDistancesFromFirstSpot(
		  double cubeDiagonalDistance) {
	   return Arrays.asList(CUBE_EDGE_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
			 SIDE_DIAGONAL_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
			 SIDE_DIAGONAL_DISTANCE_FOR_VALID, SIDE_DIAGONAL_DISTANCE_FOR_VALID,
			 cubeDiagonalDistance);
    }

    private void distancesFromSpot(
		  DistancesBetweenSpotsProvider provider, List<Double> distancesToCompare) {
	   when(provider.calculateDistances(any(List.class), any(Spot.class),anyInt()))
			 .thenReturn(distancesToCompare);
    }

    private DistancesBetweenSpotsProvider mockCalculator(
		  List<Double> distancesToCompareFromFirst,
		  List<Double> distancesToCompareFromLast) {
	   DistancesBetweenSpotsProvider calculator = Mockito
			 .mock(DistancesBetweenSpotsProvider.class);

	   distancesFromSpot(calculator, distancesToCompareFromFirst);
	   distancesFromSpot(calculator, distancesToCompareFromLast);
	   return calculator;
    }

    @Test
    public void testIsValidForCubePositiveDiapasonShouldReturnTrue() {
	   //given
	   List<Spot> spotsToValidate = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, x8);
	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(
			 CUBE_DIAGONAL_DISTANCE_FOR_VALID);

	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(
			 CUBE_DIAGONAL_DISTANCE_FOR_VALID, SIDE_DIAGONAL_DISTANCE_FOR_VALID,
			 SIDE_DIAGONAL_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
			 SIDE_DIAGONAL_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
			 CUBE_EDGE_DISTANCE_FOR_VALID);
	   DistancesBetweenSpotsProvider calculator = mockCalculator(
			 distancesToCompareFromFirst, distancesToCompareFromLast);

	   CubeValidator validator = new CubeValidator(calculator);
	   //when
	   boolean validationResult = validator.isValidForCube(spotsToValidate);
	   //then
	   Assert.assertTrue(validationResult);
    }

    @Test
    public void testIsValidForCubeNegativeDiapasonShouldReturnTrue() {
	   //given
	   List<Spot> spotsToValidate = Arrays
			 .asList(negativeX1, negativeX2, negativeX3, negativeX4, negativeX5,
				    negativeX6, negativeX7, negativeX8);

	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(
			 CUBE_DIAGONAL_DISTANCE_FOR_VALID);

	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(
			 CUBE_DIAGONAL_DISTANCE_FOR_VALID, SIDE_DIAGONAL_DISTANCE_FOR_VALID,
			 SIDE_DIAGONAL_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
			 SIDE_DIAGONAL_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
			 CUBE_EDGE_DISTANCE_FOR_VALID);
	   DistancesBetweenSpotsProvider calculator = mockCalculator(
			 distancesToCompareFromFirst, distancesToCompareFromLast);

	   CubeValidator validator = new CubeValidator(calculator);
	   //when
	   boolean validationResult = validator.isValidForCube(spotsToValidate);
	   //then
	   Assert.assertTrue(validationResult);
    }


    @Test
    public void testIsValidForCubeShouldReturnFalseAsNotEnoughSpots() {
	   //given
	   List<Spot> spotsToValidate = Arrays.asList(x1, x2, x3, x4, x5, x6, x7);
	   int zeroDistance = 0;
	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(
			 zeroDistance);
	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(zeroDistance,
			 zeroDistance, zeroDistance, zeroDistance, zeroDistance, zeroDistance,
			 zeroDistance);
	   DistancesBetweenSpotsProvider calculator = mockCalculator(
			 distancesToCompareFromFirst, distancesToCompareFromLast);

	   CubeValidator validator = new CubeValidator(calculator);
	   //when
	   boolean validationResult = validator.isValidForCube(spotsToValidate);
	   //then
	   Assert.assertFalse(validationResult);
    }

    @Test
    public void testIsValidForCubeShouldReturnFalseAsSpotIsTooClose() {
	   //given
	   Spot tooClose = new Spot(ZERO_COORDINATE, ZERO_COORDINATE, ZERO_COORDINATE);
	   List<Spot> spotsToValidate = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, tooClose);
	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(
			 3.4641016151);
	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(8.7177978871,
			 8.7177978871, 6.6332495807, 8.7177978871, 6.6332495807, 6.6332495807,
			 3.4641016151);
	   DistancesBetweenSpotsProvider calculator = mockCalculator(
			 distancesToCompareFromFirst, distancesToCompareFromLast);

	   CubeValidator validator = new CubeValidator(calculator);
	   //when
	   boolean validationResult = validator.isValidForCube(spotsToValidate);
	   //then
	   Assert.assertFalse(validationResult);
    }

    @Test
    public void testIsValidForCubeShouldReturnFalseAsSpotRepeats() {
	   //given
	   List<Spot> spotsToValidate = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, x7);
	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(0);

	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(0,
			 SIDE_DIAGONAL_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
			 SIDE_DIAGONAL_DISTANCE_FOR_VALID, CUBE_EDGE_DISTANCE_FOR_VALID,
			 CUBE_DIAGONAL_DISTANCE_FOR_VALID, SIDE_DIAGONAL_DISTANCE_FOR_VALID);
	   DistancesBetweenSpotsProvider calculator = mockCalculator(
			 distancesToCompareFromFirst, distancesToCompareFromLast);

	   CubeValidator validator = new CubeValidator(calculator);
	   //when
	   boolean validationResult = validator.isValidForCube(spotsToValidate);
	   //then
	   Assert.assertFalse(validationResult);
    }

    @Test
    public void testIsValidForCubeShouldReturnFalseAsSpotIsTooFar() {
	   //given
	   List<Spot> spotsToValidate = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, tooFar);
	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(59);
	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(59,
			 59.1452627158, 59.1354377679, 59.1452627158, 59.1354377679, 55.2901438781,
			 59.2705660509);
	   DistancesBetweenSpotsProvider calculator = mockCalculator(
			 distancesToCompareFromFirst, distancesToCompareFromLast);
	   CubeValidator validator = new CubeValidator(calculator);
	   //when
	   boolean validationResult = validator.isValidForCube(spotsToValidate);
	   //then
	   Assert.assertFalse(validationResult);
    }
}
//todo data provider!
