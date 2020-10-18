package cube.logics;

import cube.model.Spot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String SPOT_PATTERN = "((-?\\d+\\.\\d+)(\\s+|$)){3}";
    private static final int X_PLACEMENT = 0;
    private static final int Y_PLACEMENT = 1;
    private static final int Z_PLACEMENT = 2;


    private List<Spot> getSpots(Map<String, Spot> fields) {
	   List<Spot> spots = new ArrayList<>();
	   for (int runner = 0; runner < fields.size(); ++runner) {
		  String key = String.valueOf(runner + 1);
		  Spot spotContainer = fields.get(key);
		  spots.add(spotContainer);
	   }
	   return spots;
    }

    private int fillFieldsMap(
		  Matcher matcher, Map<String, Spot> fields, int runner) {
	   String coordinate = matcher.group();
	   Spot oneSpot = spotCoordinate(coordinate);
	   String key = String.valueOf(runner++);
	   fields.put(key, oneSpot);
	   return runner;
    }

    private Spot spotCoordinate(String coordinates) {
	   String[] stringCoordinates = coordinates.split("\\s");
	   double x = Double.parseDouble(stringCoordinates[X_PLACEMENT]);
	   double y = Double.parseDouble(stringCoordinates[Y_PLACEMENT]);
	   double z = Double.parseDouble(stringCoordinates[Z_PLACEMENT]);
	   return new Spot(x, y, z);
    }

    public List<Spot> parseSpotsLines(String coordinates) {
	   Pattern pattern = Pattern.compile(SPOT_PATTERN);
	   Matcher matcher = pattern.matcher(coordinates);
	   Map<String, Spot> fields = new HashMap<>();
	   int runner = 1;
	   while (matcher.find()) {
		  runner = fillFieldsMap(matcher, fields, runner);
	   }
	   return getSpots(fields);
    }


}
