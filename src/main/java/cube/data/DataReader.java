package cube.data;

import java.io.IOException;
import java.util.List;

public interface DataReader {
    List<String> readLines(String filepath) throws DataException;
}
