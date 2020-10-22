package cube.model;


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
	   if (this == o) {
		  return true;
	   }
	   if (o == null || getClass() != o.getClass()) {
		  return false;
	   }

	   Spot spot = (Spot) o;

	   double thisXCoordinate = this.xCoordinate;
	   double thisYCoordinate = this.yCoordinate;
	   double thisZCoordinate = this.zCoordinate;
	   double xCoordinate = spot.xCoordinate;
	   double yCoordinate = spot.yCoordinate;
	   double zCoordinate = spot.zCoordinate;
	   if (Double.compare(xCoordinate, thisXCoordinate) != 0) {
		  return false;
	   }
	   if (Double.compare(yCoordinate, thisYCoordinate) != 0) {
		  return false;
	   }
	   return Double.compare(zCoordinate, thisZCoordinate) == 0;
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
	   return String
			 .format("Spot{xCoordinate=%s, yCoordinate=%s, zCoordinate=%s,}",
				    xCoordinate, yCoordinate, zCoordinate);
    }
}
