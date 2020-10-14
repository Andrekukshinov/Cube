package cube.logics;

import cube.model.Spot;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String SPOT_PATTERN = "((-?\\d+\\.\\d+)(\\s+|$)){3}";

    private List<Spot> getSpots(Map<String, Spot> fields) {
	   List<Spot> spots = new ArrayList<>();
	   for (int runner = 0; runner < fields.size(); ++runner) {
		  Spot spotContainer =   fields.get(String.valueOf(runner + 1));
		  spots.add(spotContainer);
	   }
	   return spots;
    }

    private int fillFieldsMap(Matcher matcher, Map<String, Spot> fields, int runner) {
	   String coordinate = matcher.group();
	   Spot oneSpot = spotCoordinate(coordinate);
	   fields.put(String.valueOf(runner++), oneSpot);
	   return runner;
    }
    private Spot spotCoordinate(String coordinates) {
	   String[] stringCoordinates = coordinates.split("\\s");
	   double x = Double.parseDouble(stringCoordinates[0]);
	   double y = Double.parseDouble(stringCoordinates[1]);
	   double z = Double.parseDouble(stringCoordinates[2]);
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
