package cube.data;

import org.junit.Assert;
import org.junit.Test;


public class DataValidatorTest {

    public static final String STRING_COORDINATES_VALID = "1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0";

    public static final String STRING_COORDINATES_INVALID_DOUBLE = "1.k0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    ";

    public static final String STRING_COORDINATES_INVALID_MIDDLE = "1.0 2.0 1.0  GHJ  1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    ";

    public static final String STRING_COORDINATES_INVALID_2_INSTEAD_3 = "1.0 2.0 1.0  2.0 1.0   1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    ";

    public static final String STRING_COORDINATES_INVALID_7_INSTEAD_8 = "1.0 2.0 1.0  3.5 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    ";

    public static final String STRING_COORDINATES_INVALID_9_INSTEAD_8 = "1.0 2.0 1.0  3.5 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0  1.0 2.0 1.0    1.0 2.0 1.0    ";

    @Test
    public void testValidateStringShouldValidateStringAndReturnTrue() {
	   DataValidator validator = new DataValidator();
	   //when
	   boolean result = validator.validateString(STRING_COORDINATES_VALID);
	   //then
	   Assert.assertTrue(result);
    }

    @Test
    public void testValidateStringShouldValidateStringAndReturnFalse() {
	   DataValidator validator = new DataValidator();
	   //when
	   boolean result = validator
			 .validateString(STRING_COORDINATES_INVALID_MIDDLE);
	   //then
	   Assert.assertFalse(result);
    }

    @Test
    public void testValidateStringShouldParseString2Instead3AndReturnFalse() {
	   DataValidator validator = new DataValidator();
	   //when
	   boolean result = validator
			 .validateString(STRING_COORDINATES_INVALID_2_INSTEAD_3);
	   //then
	   Assert.assertFalse(result);
    }

    @Test
    public void testValidateStringShouldParseString7Instead8AndReturnFalse() {
	   DataValidator validator = new DataValidator();
	   //when
	   boolean result = validator
			 .validateString(STRING_COORDINATES_INVALID_7_INSTEAD_8);
	   //then
	   Assert.assertFalse(result);
    }

    @Test
    public void testValidateStringShouldParseString9Instead8AndReturnFalse() {
	   DataValidator validator = new DataValidator();
	   //when
	   boolean result = validator
			 .validateString(STRING_COORDINATES_INVALID_9_INSTEAD_8);
	   //then
	   Assert.assertFalse(result);
    }

    @Test
    public void testValidateStringShouldParseStringWithCharInDoubleAndReturnFalse() {
	   DataValidator validator = new DataValidator();
	   //when
	   boolean result = validator
			 .validateString(STRING_COORDINATES_INVALID_DOUBLE);
	   //then
	   Assert.assertFalse(result);
    }
}
