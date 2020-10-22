package cube.model;

public class VolumeRatio {
    private final double firstVolume;
    private final double secondVolume;

    public VolumeRatio(double firstVolume, double secondVolume) {
	   this.firstVolume = firstVolume;
	   this.secondVolume = secondVolume;
    }

    public double getFirstVolume() {
	   return firstVolume;
    }

    public double getSecondVolume() {
	   return secondVolume;
    }

    @Override
    public boolean equals(Object o) {
	   if (this == o) {
		  return true;
	   }
	   if (o == null || getClass() != o.getClass()) {
		  return false;
	   }

	   VolumeRatio that = (VolumeRatio) o;

	   double thatFirstVolume = that.getFirstVolume();
	   double thatSecondVolume = that.getSecondVolume();
	   if (Double.compare(thatFirstVolume, getFirstVolume()) != 0) {
		  return false;
	   }
	   return Double.compare(thatSecondVolume, getSecondVolume()) == 0;
    }

    @Override
    public int hashCode() {
	   int result;
	   long temp;
	   temp = Double.doubleToLongBits(getFirstVolume());
	   result = (int) (temp ^ (temp >>> 32));
	   temp = Double.doubleToLongBits(getSecondVolume());
	   result = 31 * result + (int) (temp ^ (temp >>> 32));
	   return result;
    }

    @Override
    public String toString() {
	   return String.format("VolumeRatio{firstVolume=%s, secondVolume=%s}",
			 firstVolume, secondVolume);
    }
}
