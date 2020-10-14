package cube.data.impl;

import cube.data.DataReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements DataReader {
    @Override
    public List<String> readLines(String filePath) throws IOException {
	   List<String> result = new ArrayList<>();
	   try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		  String line;
		  while ((line = reader.readLine()) != null) {
			 result.add(line);
		  }
	   }
	   return result;
    }
}
