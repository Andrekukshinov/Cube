package cube.data;

import cube.model.Cube;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DataReader {
    List<String> readLines(String filepath) throws IOException;
}
