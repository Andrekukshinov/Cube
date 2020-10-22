package cube.data;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class DataValidatorTest {


    @DataProvider(name = "coordinatesProvider")
    public Object[][] coordinatesProvider(Method methodName) {
	   String stringCoordinatesValid = "-1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0";
	   String stringCoordinatesInvalidDouble = "1.k0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    ";
	   String stringCoordinatesInvalidMiddle = "1.0 2.0 1.0  GHJ  1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    ";
	   String stringCoordinatesInvalid2Instead3 = "1.0 2.0 1.0  2.0 1.0   1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    ";
	   String stringCoordinatesInvalid7Instead8 = "1.0 2.0 1.0  3.5 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    ";
	   String stringCoordinatesInvalid9Instead8 = "1.0 2.0 1.0  3.5 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0  1.0 2.0 1.0    1.0 2.0 1.0    ";

	   if (methodName.getName().equalsIgnoreCase("testValidateStringShouldValidateStringAndReturnFalse")) {
		  Object[][] result = new Object[5][1];

		  result[0][0] = stringCoordinatesInvalid9Instead8;

		  result[1][0] = stringCoordinatesInvalidDouble;

		  result[2][0] = stringCoordinatesInvalidMiddle;

		  result[3][0] = stringCoordinatesInvalid2Instead3;

		  result[4][0] = stringCoordinatesInvalid7Instead8;
		  return result;
	   } else {
		  return new Object[][]{{stringCoordinatesValid}};
	   }

    }

    @Test(dataProvider = "coordinatesProvider")
    public void testValidateStringShouldValidateStringAndReturnTrue(String coordinates) {
	   DataValidator validator = new DataValidator();
	   //when
	   boolean result = validator.isValid(coordinates);
	   //then
	   Assert.assertTrue(result);
    }


    @Test(dataProvider = "coordinatesProvider")
    public void testValidateStringShouldValidateStringAndReturnFalse(String coordinates) {
	   DataValidator validator = new DataValidator();
	   //when
	   boolean result = validator.isValid(coordinates);
	   //then
	   Assert.assertFalse(result);
    }
}
