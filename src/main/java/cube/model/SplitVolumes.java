package cube.model;

public class SplitVolumes {
    private final double firstVolume;
    private final double secondVolume;

    public SplitVolumes(double firstVolume, double secondVolume) {
	   this.firstVolume = firstVolume;
	   this.secondVolume = secondVolume;
    }

    public double getFirstVolume() {
	   return firstVolume;
    }

    public double getSecondVolume() {
	   return secondVolume;
    }
}
