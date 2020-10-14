package cube.logics.creator;


import cube.logics.DistancesBetweenSpotsCalculator;
import cube.model.Spot;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.*;

public class CubeValidatorTest {
    private final Spot x1 = new Spot(2.0, 2.0, 2.0);
    private final Spot x2 = new Spot(6.0, 2.0, 2.0);
    private final Spot x3 = new Spot(2.0, 6.0, 2.0);
    private final Spot x4 = new Spot(6.0, 6.0, 2.0);
    private final Spot x5 = new Spot(2.0, 2.0, 6.0);
    private final Spot x6 = new Spot(6.0, 2.0, 6.0);
    private final Spot x7 = new Spot(2.0, 6.0, 6.0);
    private final Spot x8 = new Spot(6.0, 6.0, 6.0);

    private final Spot negativeX1 = new Spot(-2.0, -2.0, -2.0);
    private final Spot negativeX2 = new Spot(-6.0, -2.0, -2.0);
    private final Spot negativeX3 = new Spot(-2.0, -6.0, -2.0);
    private final Spot negativeX4 = new Spot(-6.0, -6.0, -2.0);
    private final Spot negativeX5 = new Spot(-2.0, -2.0, -6.0);
    private final Spot negativeX6 = new Spot(-6.0, -2.0, -6.0);
    private final Spot negativeX7 = new Spot(-2.0, -6.0, -6.0);
    private final Spot negativeX8 = new Spot(-6.0, -6.0, -6.0);

    private final double cubeEdgeDistanceForValid = 4.0;
    private final double sideDiagonalDistanceForValid = 5.656854249492381;
    private final double cubeDiagonalDistanceForValid = 6.928203230275509;

    private List<Double> getDistancesFromLastSpot(double firstDistance, double secondDistance, double thirdDistance, double fourthDistance, double fifthDistance, double sixthDistance, double seventhDistance) {
	   return Arrays.asList(firstDistance, secondDistance, thirdDistance, fourthDistance, fifthDistance, sixthDistance, seventhDistance);
    }
    private List<Double> getDistancesFromFirstSpot(double cubeDiagonalDistance) {
	   return Arrays.asList(cubeEdgeDistanceForValid, cubeEdgeDistanceForValid, sideDiagonalDistanceForValid, cubeEdgeDistanceForValid, sideDiagonalDistanceForValid, sideDiagonalDistanceForValid, cubeDiagonalDistance);
    }
    private void distancesFromSpot(List<Spot> spotsToValidate, DistancesBetweenSpotsCalculator calculator, List<Double> distancesToCompare, int spotNumber) {
	   when(calculator.getDistancesFromGivenSpot(spotsToValidate, spotNumber))
			 .thenReturn(distancesToCompare);
    }
    private DistancesBetweenSpotsCalculator mockCalculator(List<Spot> spotsToValidate, List<Double> distancesToCompareFromFirst, List<Double> distancesToCompareFromLast) {
	   DistancesBetweenSpotsCalculator calculator = Mockito.mock(DistancesBetweenSpotsCalculator.class);
	   int FIRST_SPOT_NUMBER = 0;
	   int LAST_SPOT_NUMBER = spotsToValidate.size() - 1;
	   distancesFromSpot(spotsToValidate, calculator, distancesToCompareFromFirst, FIRST_SPOT_NUMBER);
	   distancesFromSpot(spotsToValidate, calculator, distancesToCompareFromLast, LAST_SPOT_NUMBER);
	   return calculator;
    }



    @Test
    public void testIsValidForCubePositiveDiapasonShouldReturnTrue() {
	   //given
	   List<Spot> spotsToValidate = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, x8);
	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(cubeDiagonalDistanceForValid);
	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(cubeDiagonalDistanceForValid, sideDiagonalDistanceForValid,  sideDiagonalDistanceForValid, cubeEdgeDistanceForValid, sideDiagonalDistanceForValid, cubeEdgeDistanceForValid,  cubeEdgeDistanceForValid);
	   DistancesBetweenSpotsCalculator calculator = mockCalculator(spotsToValidate, distancesToCompareFromFirst, distancesToCompareFromLast);
	   CubeValidator validator = new CubeValidator(calculator);
	   //when
	   boolean validationResult = validator.isValidForCube(spotsToValidate);
	   //then
	   Assert.assertTrue(validationResult);
    }
    @Test
    public void testIsValidForCubeNegativeDiapasonShouldReturnTrue() {
	   //given
	   List<Spot> spotsToValidate = Arrays.asList(negativeX1, negativeX2, negativeX3, negativeX4, negativeX5, negativeX6, negativeX7, negativeX8);
	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(cubeDiagonalDistanceForValid);
	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(cubeDiagonalDistanceForValid, sideDiagonalDistanceForValid,  sideDiagonalDistanceForValid, cubeEdgeDistanceForValid, sideDiagonalDistanceForValid, cubeEdgeDistanceForValid,  cubeEdgeDistanceForValid);
	   DistancesBetweenSpotsCalculator calculator = mockCalculator(spotsToValidate, distancesToCompareFromFirst, distancesToCompareFromLast);
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
	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(0);
	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(0, 0, 0, 0, 0, 0, 0);
	   DistancesBetweenSpotsCalculator calculator = mockCalculator(spotsToValidate, distancesToCompareFromFirst, distancesToCompareFromLast);
	   CubeValidator validator = new CubeValidator(calculator);
	   //when
	   boolean validationResult = validator.isValidForCube(spotsToValidate);
	   //then
	   Assert.assertFalse(validationResult);
    }

    @Test
    public void testIsValidForCubeShouldReturnFalseAsSpotIsTooClose() {
	   //given
	   Spot tooClose = new Spot(0.0, 0.0, 0.0);
	   List<Spot> spotsToValidate = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, tooClose);
	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(3.4641016151);
	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(8.7177978871, 8.7177978871, 6.6332495807, 8.7177978871, 6.6332495807, 6.6332495807, 3.4641016151);
	   DistancesBetweenSpotsCalculator calculator = mockCalculator(spotsToValidate, distancesToCompareFromFirst, distancesToCompareFromLast);
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
	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(0, sideDiagonalDistanceForValid, cubeEdgeDistanceForValid, sideDiagonalDistanceForValid, cubeEdgeDistanceForValid, cubeDiagonalDistanceForValid, sideDiagonalDistanceForValid);
	   DistancesBetweenSpotsCalculator calculator = mockCalculator(spotsToValidate, distancesToCompareFromFirst, distancesToCompareFromLast);
	   CubeValidator validator = new CubeValidator(calculator);
	   //when
	   boolean validationResult = validator.isValidForCube(spotsToValidate);
	   //then
	   Assert.assertFalse(validationResult);
    }

    @Test
    public void testIsValidForCubeShouldReturnFalseAsSpotIsTooFar() {
	   //given
	   Spot tooFar = new Spot(61.0, 6.0, 6.0);
	   List<Spot> spotsToValidate = Arrays.asList(x1, x2, x3, x4, x5, x6, x7, tooFar);
	   List<Double> distancesToCompareFromFirst = getDistancesFromFirstSpot(59);
	   List<Double> distancesToCompareFromLast = getDistancesFromLastSpot(59, 59.1452627158, 59.1354377679, 59.1452627158, 59.1354377679, 55.2901438781, 59.2705660509);
	   DistancesBetweenSpotsCalculator calculator = mockCalculator(spotsToValidate, distancesToCompareFromFirst, distancesToCompareFromLast);
	   CubeValidator validator = new CubeValidator(calculator);
	   //when
	   boolean validationResult = validator.isValidForCube(spotsToValidate);
	   //then
	   Assert.assertFalse(validationResult);
    }
}
