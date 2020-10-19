package cube.data.access.api;


import cube.data.access.impl.sort.*;
import cube.model.Cube;
import cube.model.comporators.*;
import org.junit.Assert;
 import org.testng.annotations.Test;

import java.util.Comparator;

public class SortSpecificationTest {
    @Test
    public void testGetComparatorShouldReturnAreaComparator() {
	   SortSpecification<Cube> sortSpecification = new AreaSortSpecification();
	   //when
	   Comparator<Cube> comparator = sortSpecification.getComparator();
	   //then
	   Assert.assertTrue(comparator instanceof AreaComparator);
    }

    @Test
    public void testGetComparatorShouldReturnVolumeComparator() {
	   SortSpecification<Cube> sortSpecification = new VolumeSortSpecification();
	   //when
	   Comparator<Cube> comparator = sortSpecification.getComparator();
	   //then
	   Assert.assertTrue(comparator instanceof VolumeComparator);
    }

    @Test
    public void testGetComparatorShouldReturnPerimeterComparator() {
	   SortSpecification<Cube> sortSpecification = new PerimeterSortSpecification();
	   //when
	   Comparator<Cube> comparator = sortSpecification.getComparator();
	   //then
	   Assert.assertTrue(comparator instanceof PerimeterComparator);
    }

    @Test
    public void testGetComparatorShouldReturnXCoordinateComparator() {
	   SortSpecification<Cube> sortSpecification = new XCoordinateSortSpecification();
	   //when
	   Comparator<Cube> comparator = sortSpecification.getComparator();
	   //then
	   Assert.assertTrue(comparator instanceof XCoordinateComparator);
    }

    @Test
    public void testGetComparatorShouldReturnYCoordinateComparator() {
	   SortSpecification<Cube> sortSpecification = new YCoordinateSortSpecification();
	   //when
	   Comparator<Cube> comparator = sortSpecification.getComparator();
	   //then
	   Assert.assertTrue(comparator instanceof YCoordinateComparator);
    }

    @Test
    public void testGetComparatorShouldReturnZCoordinateComparator() {
	   SortSpecification<Cube> sortSpecification = new ZCoordinateSortSpecification();
	   //when
	   Comparator<Cube> comparator = sortSpecification.getComparator();
	   //then
	   Assert.assertTrue(comparator instanceof ZCoordinateComparator);
    }

}
