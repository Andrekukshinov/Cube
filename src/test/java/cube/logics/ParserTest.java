package cube.logics;


import cube.model.Spot;
import org.junit.Assert;
 import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ParserTest {
    private final String stringCoordinates = "-1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    1.0 2.0 1.0    ";
    private final Spot x1 = new Spot(1.0, 2.0, 1.0);
    private final Spot x2 = new Spot(-1.0, 2.0, 1.0);
    private final List<Spot> toCompare = Arrays
		  .asList(x2, x1, x1, x1, x1, x1, x1, x1);

    @Test
    public void testParseSpotsLineShouldReturnSpotsList() {
	   Parser parser = new Parser();
	   //when
	   List<Spot> result = parser.parseSpotsLines(stringCoordinates);
	   //then
	   Assert.assertEquals(toCompare, result);
    }
}
