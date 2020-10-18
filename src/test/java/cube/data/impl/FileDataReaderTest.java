package cube.data.impl;


import cube.data.DataReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileDataReaderTest {
    public static final String FILE_PATH = "src/test/resources/resources.txt";
    public static final String FIRST_STRING = "3.0 2.0 2.0    6.0 2.0 2.0    2.0 6.0 2.0    6.0 6.0 2.0    2.0 2.0 6.0    6.0 2.0 6.0    2.0 6.0 6.0    6.0 6.0 6.0";
    public static final String SECOND_STRING = "1.0 1.0 1.0   zxc 3.j0 1.0 1.0    1.0 3.0 1.0    3.0 3.0 1.0      1.0 1.0 3.0    3.0 1.0 3.0    1.0 3.0 3.0    3.0 3.0 3.0";
    public static final String THIRD_STRING = "1.0 1.0 1.0    3.0 1.0 1.0    1.0 3.0 1.0    3.0 3.0 1.0      1.0 1.0 3.0    3.0 1.0 3.0    1.0 3.0 3.0    3.0 3.0 3.0";

    @Test
    public void testReadLinesShouldReadDataFromFile() throws IOException {
	   DataReader acquirer = new FileDataReader();
	   List<String> toCompare = new ArrayList<>();
	   Collections
			 .addAll(toCompare, FIRST_STRING, SECOND_STRING, THIRD_STRING);
	   //when
	   List<String> result = acquirer.readLines(FILE_PATH);
	   //then
	   Assert.assertEquals(toCompare, result);
    }
}
