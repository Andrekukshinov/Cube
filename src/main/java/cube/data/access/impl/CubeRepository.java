package cube.data.access.impl;

import cube.data.access.api.Repository;
import cube.data.access.api.SearchSpecification;
import cube.data.access.api.SortSpecification;
import cube.model.Cube;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CubeRepository implements Repository<Cube> {
    private final List<Cube> cubes = new ArrayList<>();

    @Override
    public void add(Cube cube) {
	   cubes.add(cube);
    }

    @Override
    public void remove(Cube cube) {
	   cubes.remove(cube);
    }

    @Override
    public void update(Cube cube, int index) {
	   cubes.set(index, cube);
    }

    @Override
    public List<Cube> query(SearchSpecification<Cube> searchSpecification) {
	   List<Cube> resultCubes = new ArrayList<>();
	   for (Cube cube : cubes) {
		  if (searchSpecification.isSpecified(cube)) {
			 resultCubes.add(cube);
		  }
	   }
	   return resultCubes;
    }

    @Override
    public List<Cube> sort(SortSpecification<Cube> sortSpecification) {
	   List<Cube> result = new ArrayList<>(cubes);
	   Comparator<Cube> comparator = sortSpecification.getComparator();
	   result.sort(comparator);
	   return result;
    }
}
