package cube.data;

import cube.data.reader.DataReader;
import cube.data.reader.FileDataReader;
import cube.data.reader.ReaderType;

public class DataReaderFactory {
    public DataReader createDataReader(ReaderType type) {
	   switch (type) {
		  case FILE:
			 return new FileDataReader();
		  default:
			 throw new IllegalArgumentException("such data reader doesn't exist");
	   }
    }
}
