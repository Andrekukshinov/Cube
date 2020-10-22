package cube.data.reader;

import cube.data.DataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileDataReader implements DataReader {
    @Override
    public List<String> readLines(String filePath) throws DataException {
	   List<String> result = new ArrayList<>();
	   try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		  String line = reader.readLine();
		  while (line != null) {
			 result.add(line);
			 line = reader.readLine();
		  }
	   } catch (IOException e) {
		  throw new DataException(e.getMessage(), e);
	   }

	   return result;
    }
}

