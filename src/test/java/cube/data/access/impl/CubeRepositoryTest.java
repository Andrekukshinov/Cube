package cube.data.access.impl;


import cube.data.access.api.CoordinateSearchSpecificationTest;
import cube.data.access.impl.search.AreaSearchSpecification;
import cube.data.access.impl.sort.AreaSortSpecification;
import cube.model.Cube;
import cube.model.Spot;
import cube.model.comporators.AreaComparator;
import org.junit.Assert;
 import org.testng.annotations.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CubeRepositoryTest {

    private static final Spot firstSpot = new Spot(-2.0, -2.0, -2.0);
    private static final Spot secondSpot = new Spot(1.0, -2.0, -2.0);
    private static final Spot thirdSpot = new Spot(1.0, 1.0, -2.0);
    private static final Spot fourthSpot = new Spot(-2.0, 1.0, -2.0);
    private static final Spot fifthSpot = new Spot(-2.0, -2.0, 1.0);
    private static final Spot sixthSpot = new Spot(1.0, -2.0, 1.0);
    private static final Spot seventhSpot = new Spot(1.0, 1.0, 1.0);
    private static final Spot eighthSpot = new Spot(-2.0, 1.0, 1.0);

    private static final Cube forCalculation = new Cube(firstSpot, secondSpot, thirdSpot,
		  fourthSpot, fifthSpot, sixthSpot, seventhSpot, eighthSpot);

    private static final int EXPECTED_LENGTH = 1;


    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testQueryShouldReturnItemWithSpecifiedParameter(Cube givenCube) {
	   CubeRepository repository = new CubeRepository();
	   AreaSearchSpecification specification = Mockito
			 .mock(AreaSearchSpecification.class);
	   when(specification.isSpecified(any(Cube.class))).thenReturn(true);
	   repository.add(givenCube);
	   repository.add(forCalculation);
	   List<Cube> expected = Arrays.asList(givenCube, forCalculation);
	   //when
	   List<Cube> result = repository.query(specification);
	   //then
	   Assert.assertEquals(expected, result);
    }

    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testSortShouldSortArrayByVolume(Cube givenCube) {
	   int negativeNumber = -1;
	   CubeRepository repository = new CubeRepository();
	   AreaSortSpecification specification = Mockito.mock(AreaSortSpecification.class);
	   AreaComparator comparator = Mockito.mock(AreaComparator.class);
	   when(specification.getComparator()).thenReturn(comparator);
	   when(comparator.compare(any(Cube.class), any(Cube.class)))
			 .thenReturn(negativeNumber);
	   repository.add(givenCube);
	   repository.add(forCalculation);
	   List<Cube> expected = Arrays.asList(forCalculation, givenCube);
	   //when
	   List<Cube> result = repository.sort(specification);
	   //then
	   Assert.assertEquals(expected, result);
    }

    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testAddShouldAddCubeToRepository(Cube givenCube) {
	   CubeRepository repository = new CubeRepository();
	   repository.add(givenCube);
	   //when
	   int actualLength = repository.getCubesLength();
	   //then
	   Assert.assertEquals(EXPECTED_LENGTH, actualLength);
    }

    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testRemoveShouldRemoveCubeToRepository(Cube givenCube) {
	   CubeRepository repository = new CubeRepository();
	   repository.add(givenCube);
	   repository.add(givenCube);
	   //when
	   repository.remove(givenCube);
	   //then
	   int result = repository.getCubesLength();
	   Assert.assertEquals(EXPECTED_LENGTH, result);
    }

    @Test(dataProvider = "cubeProvider", dataProviderClass = CoordinateSearchSpecificationTest.class)
    public void testUpdateShouldUpdateCubeCubeInRepository(Cube givenCube) {
	   CubeRepository repository = new CubeRepository();
	   repository.add(givenCube);
	   //when
	   repository.update(forCalculation, 0);
	   //then
	   Cube result = repository.getCube(0);
	   Assert.assertEquals(forCalculation, result);
    }
}
