package cube.model;

public class Register {
    private final double area;
    private final double volume;
    private final double perimeter;

    public Register(double area, double volume, double perimeter) {
	   this.area = area;
	   this.volume = volume;
	   this.perimeter = perimeter;
    }

    public double getArea() {
	   return area;
    }

    public double getVolume() {
	   return volume;
    }

    public double getPerimeter() {
	   return perimeter;
    }
}
