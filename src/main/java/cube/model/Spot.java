package cube.model;

import java.util.Objects;

public class Spot {
    private final double xCoordinate;
    private final double yCoordinate;
    private final double zCoordinate;

    public Spot(double xCoordinate, double yCoordinate, double zCoordinate) {
	   this.xCoordinate = xCoordinate;
	   this.yCoordinate = yCoordinate;
	   this.zCoordinate = zCoordinate;
    }

    public double getXCoordinate() {
	   return xCoordinate;
    }

    public double getYCoordinate() {
	   return yCoordinate;
    }

    public double getZCoordinate() {
	   return zCoordinate;
    }

    @Override
    public boolean equals(Object o) {
	   if (this == o) return true;
	   if (o == null || getClass() != o.getClass()) return false;

	   Spot spot = (Spot) o;

	   if (Double.compare(spot.xCoordinate, xCoordinate) != 0) return false;
	   if (Double.compare(spot.yCoordinate, yCoordinate) != 0) return false;
	   return Double.compare(spot.zCoordinate, zCoordinate) == 0;
    }

    @Override
    public int hashCode() {
	   int result;
	   long temp;
	   temp = Double.doubleToLongBits(xCoordinate);
	   result = (int) (temp ^ (temp >>> 32));
	   temp = Double.doubleToLongBits(yCoordinate);
	   result = 31 * result + (int) (temp ^ (temp >>> 32));
	   temp = Double.doubleToLongBits(zCoordinate);
	   result = 31 * result + (int) (temp ^ (temp >>> 32));
	   return result;
    }

    @Override
    public String toString() {
	   return "Spot{" + "xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", zCoordinate=" + zCoordinate + '}';
    }
}
