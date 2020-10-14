package cube.logics;

import cube.data.DataReader;
import cube.data.DataReaderFactory;
import cube.data.DataValidator;
import cube.data.ReaderType;
import cube.logics.creator.CubeCreator;
import cube.logics.creator.CubeValidator;
import cube.model.CoordinatePlanes;
import cube.model.Cube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CubeDirector {
    private static final Logger LOGGER = LogManager.getLogger(CubeDirector.class.getName());
    private final DataReaderFactory dataFactory;
    private final CubeDataCalculator dataCalculator;
    private final CubeValidator cubeValidator;
    private final CubeCreator cubeCreator;
    private final DataValidator validator;


    public CubeDirector(DataReaderFactory dataFactory, CubeDataCalculator dataCalculator, CubeValidator cubeValidator, CubeCreator cubeCreator, DataValidator validator) {
	   this.dataFactory = dataFactory;
	   this.dataCalculator = dataCalculator;
	   this.cubeValidator = cubeValidator;
	   this.cubeCreator = cubeCreator;
	   this.validator = validator;
    }

    public void run(ReaderType type, String filePath) {
	   DataReaderFactory readerFactory = dataFactory;
	   DataReader reader = readerFactory.createDataReader(type);
	   DataValidator validator = this.validator;
	   CubeCreator cubeCreator = this.cubeCreator;
	   List<String> lines;
	   try {
		  lines = reader.readLines(filePath);
		  List<String> validForCube = new ArrayList<>();
		  for (int runner = 0; runner < lines.size(); ++runner) {
			 if (validator.validateString(lines.get(runner))) {
				validForCube.add(lines.get(runner));
			 }
		  }
		  //todo deal with get without check + 0 to const
		  List<Optional<Cube>> cubes = cubeCreator.createCubes(validForCube);
		  dataCalculator.calculateCubeVolume(cubes.get(0).get());
		  dataCalculator.calculateCubeArea(cubes.get(0).get());
		  dataCalculator.isZeroedCoordinatePlaced(cubes.get(0).get());
		  dataCalculator.calculateVolumeRatio(cubes.get(0).get(), CoordinatePlanes.Y);
	   } catch (LogicsException e) {
		  LOGGER.error(e.getMessage(), e);
	   } catch (IOException e) {
	       StringBuilder stringBuilder = new StringBuilder("File withs path");
	       stringBuilder.append(filePath);
	       stringBuilder.append(" not found\n ");
		  LOGGER.error(stringBuilder.toString(), e);
	   }
    }
}
