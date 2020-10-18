package cube.data.access;

import cube.data.access.Repository;
import cube.data.access.specification.Specification;
import cube.model.Cube;

import java.util.ArrayList;
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
    public List<Cube> query(Specification<Cube> specification) {
	   List<Cube> resultCubes = new ArrayList<>();
	   for (Cube cube : cubes) {
		  if (specification.isSpecified(cube)) {
			 resultCubes.add(cube);
		  }
	   }
	   return resultCubes;
    }
}
