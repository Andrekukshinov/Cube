package cube.data;

import cube.data.impl.FileDataReader;

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
