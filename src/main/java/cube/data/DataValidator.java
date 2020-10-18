package cube.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private static final String VALID_STRING = "((\\d+\\.\\d+\\s*){3}){8}\\s*$";

    public boolean isValid(String toBeValidated) {
	   Pattern pattern = Pattern.compile(VALID_STRING);
	   Matcher matcher = pattern.matcher(toBeValidated);
	   return matcher.matches();
    }
}
