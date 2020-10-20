package cube.logics.creator;


import cube.logics.DistancesBetweenSpotsProvider;
import cube.model.Spot;
import org.junit.Assert;
import org.mockito.Mockito;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.when;

public class CubeValidatorTest {
    @DataProvider(name = "spotsForValidator")
    public Object[][] spotsForValidator(Method method) {
	   Spot x1 = new Spot(2.0, 2.0, 2.0);
	   Spot x2 = new Spot(6.0, 2.0, 2.0);
	   Spot x3 = new Spot(2.0, 6.0, 2.0);
	   Spot x4 = new Spot(6.0, 6.0, 2.0);
	   Spot x5 = new Spot(2.0, 2.0, 6.0);
	   Spot x6 = new Spot(6.0, 2.0, 6.0);
	   Spot x7 = new Spot(2.0, 6.0, 6.0);
	   Spot x8 = new Spot(6.0, 6.0, 6.0);

	   Spot tooFar = new Spot(61.0, 6.0, 6.0);
	   Spot tooClose = new Spot(ZERO_COORDINATE, ZERO_COORDINATE, ZERO_COORDINATE);


	   Spot negativeX1 = new Spot(-2.0, -2.0, -2.0);
	   Spot negativeX2 = new Spot(-6.0, -2.0, -2.0);
	   Spot negativeX3 = new Spot(-2.0, -6.0, -2.0);
	   Spot negativeX4 = new Spot(-6.0, -6.0, -2.0);
	   Spot negativeX5 = new Spot(-2.0, -2.0, -6.0);
	   Spot negativeX6 = new Spot(-6.0, -2.0, -6.0);
	   Spot negativeX7 = new Spot(-2.0, -6.0, -6.0);
	   Spot negativeX8 = new Spot(-6.0, -6.0, -6.0);

	   List<Spot> spotsToValidatePositive = Arrays
			 .asList(x1, x2, x3, x4, x5, x6, x7, x8);
	   List<Spot> spotsToValidateNegative = Arrays
			 .asList(negativeX1, negativeX2, negativeX3, negativeX4, negativeX5,
				    negativeX6, negativeX7, negativeX8);


	   Object[][] result;
	   String methodName = method.getName();
	   if (methodName.equalsIgnoreCase("testIsValidForCubeShouldReturnTrue")) {
		  result = new Object[2][1];

		  result[0][0] = spotsToValidatePositive;

		  result[1][0] = spotsToValidateNegative;

		  return result;
	   } else {
		  result = new Object[4][1];

		  result[0][0] = Arrays.asList(x1, x2, x3, x4, x5, x6, x7);

		  result[1][0] = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, tooClose);

		  result[2][0] = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, x7);

		  result[3][0] = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, tooFar);

		  return result;
	   }
    }

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
	   when(provider.calculateDistances(any(List.class), any(Spot.class), anyInt()))
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

    @Test(dataProvider = "spotsForValidator")
    public void testIsValidForCubeShouldReturnTrue(List<Spot> spotsToValidate) {
	   //given
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


    @Test(dataProvider = "spotsForValidator")
    public void testIsValidForCubeShouldReturnFalse(List<Spot> spotsToValidate) {
	   //given
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
}
