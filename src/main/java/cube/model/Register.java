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

    @Override
    public String toString() {
	   return "Register{" + "area=" + area + ", volume=" + volume + ", perimeter=" + perimeter + '}';
    }

    @Override
    public boolean equals(Object o) {
	   if (this == o) {
		  return true;
	   }
	   if (o == null || getClass() != o.getClass()) {
		  return false;
	   }

	   Register register = (Register) o;

	   if (Double.compare(register.getArea(), getArea()) != 0) {
		  return false;
	   }
	   if (Double.compare(register.getVolume(), getVolume()) != 0) {
		  return false;
	   }
	   return Double.compare(register.getPerimeter(), getPerimeter()) == 0;
    }

    @Override
    public int hashCode() {
	   int result;
	   long temp;
	   temp = Double.doubleToLongBits(getArea());
	   result = (int) (temp ^ (temp >>> 32));
	   temp = Double.doubleToLongBits(getVolume());
	   result = 31 * result + (int) (temp ^ (temp >>> 32));
	   temp = Double.doubleToLongBits(getPerimeter());
	   result = 31 * result + (int) (temp ^ (temp >>> 32));
	   return result;
    }
}
