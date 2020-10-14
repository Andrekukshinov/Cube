package cube.model;

public class Cube {
    private final Spot firstSpot;
    private final Spot secondSpot;
    private final Spot thirdSpot;
    private final Spot fourthSpot;
    private final Spot fifthSpot;
    private final Spot sixthSpot;
    private final Spot seventhSpot;
    private final Spot eighthSpot;

    public Cube(
		  Spot firstSpot, Spot secondSpot,
		  Spot thirdSpot, Spot lowPlaneTopRight,

		  Spot fifthSpot, Spot sixthSpot,
		  Spot seventhSpot, Spot eighthSpot) {
	   this.firstSpot = firstSpot;
	   this.secondSpot = secondSpot;
	   this.thirdSpot = thirdSpot;
	   this.fourthSpot = lowPlaneTopRight;
	   this.fifthSpot = fifthSpot;
	   this.sixthSpot = sixthSpot;
	   this.seventhSpot = seventhSpot;
	   this.eighthSpot = eighthSpot;
    }

    public Spot getFirstSpot() {
	   return firstSpot;
    }

    public Spot getSecondSpot() {
	   return secondSpot;
    }

    public Spot getThirdSpot() {
	   return thirdSpot;
    }

    public Spot getFourthSpot() {
	   return fourthSpot;
    }

    public Spot getFifthSpot() {
	   return fifthSpot;
    }

    public Spot getSixthSpot() {
	   return sixthSpot;
    }

    public Spot getSeventhSpot() {
	   return seventhSpot;
    }

    public Spot getEighthSpot() {
	   return eighthSpot;
    }

    @Override
    public boolean equals(Object o) {
	   if (this == o) {return true;}
	   if (o == null || getClass() != o.getClass()) {return false;}

	   Cube cube = (Cube) o;

	   if (!getFirstSpot().equals(cube.getFirstSpot())) {
		  return false;
	   }
	   if (!getSecondSpot().equals(cube.getSecondSpot())) {
		  return false;
	   }
	   if (!getThirdSpot().equals(cube.getThirdSpot())) {
		  return false;
	   }
	   if (!getFourthSpot().equals(cube.getFourthSpot())) {
		  return false;
	   }
	   if (!getFifthSpot().equals(cube.getFifthSpot())) {
		  return false;
	   }
	   if (!getSixthSpot().equals(cube.getSixthSpot())) {
		  return false;
	   }
	   if (!getSeventhSpot().equals(cube.getSeventhSpot())) {
		  return false;
	   }
	   return getEighthSpot().equals(cube.getEighthSpot());
    }

    @Override
    public int hashCode() {
	   int result = getFirstSpot().hashCode();
	   result = 31 * result + getSecondSpot().hashCode();
	   result = 31 * result + getThirdSpot().hashCode();
	   result = 31 * result + getFourthSpot().hashCode();
	   result = 31 * result + getFifthSpot().hashCode();
	   result = 31 * result + getSixthSpot().hashCode();
	   result = 31 * result + getSeventhSpot().hashCode();
	   result = 31 * result + getEighthSpot().hashCode();
	   return result;
    }

    @Override
    public String toString() {
	   return "Cube{" + "lowPlaneBottomLeft=" + firstSpot + ", lowPlaneBottomRight="
			 + secondSpot + ", lowPlaneTopLeft=" + thirdSpot + ", lowPlaneTopRight="
			 + fourthSpot + ", topPlaneBottomLeft=" + fifthSpot + ", topPlaneBottomRight="
			 + sixthSpot + ", topPlaneTopLeft=" + seventhSpot + ", topPlaneTopRight=" + eighthSpot + '}';
    }
}
