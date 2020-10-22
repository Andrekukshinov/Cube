package cube.model;

public class Cube {
    private Spot firstSpot;
    private Spot secondSpot;
    private Spot thirdSpot;
    private Spot fourthSpot;
    private Spot fifthSpot;
    private Spot sixthSpot;
    private Spot seventhSpot;
    private Spot eighthSpot;

    public Cube(
		  Spot firstSpot, Spot secondSpot, Spot thirdSpot, Spot lowPlaneTopRight,
		  Spot fifthSpot, Spot sixthSpot, Spot seventhSpot, Spot eighthSpot) {
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

    public void setFirstSpot(Spot firstSpot) {
	   this.firstSpot = firstSpot;
    }

    public void setSecondSpot(Spot secondSpot) {
	   this.secondSpot = secondSpot;
    }

    public void setThirdSpot(Spot thirdSpot) {
	   this.thirdSpot = thirdSpot;
    }

    public void setFourthSpot(Spot fourthSpot) {
	   this.fourthSpot = fourthSpot;
    }

    public void setFifthSpot(Spot fifthSpot) {
	   this.fifthSpot = fifthSpot;
    }

    public void setSixthSpot(Spot sixthSpot) {
	   this.sixthSpot = sixthSpot;
    }

    public void setSeventhSpot(Spot seventhSpot) {
	   this.seventhSpot = seventhSpot;
    }

    public void setEighthSpot(Spot eighthSpot) {
	   this.eighthSpot = eighthSpot;
    }

    @Override
    public boolean equals(Object o) {
	   if (this == o) {
		  return true;
	   }
	   if (o == null || getClass() != o.getClass()) {
		  return false;
	   }

	   Cube cube = (Cube) o;

	   Spot firstSpot = cube.getFirstSpot();
	   if (!getFirstSpot().equals(firstSpot)) {
		  return false;
	   }
	   Spot secondSpot = cube.getSecondSpot();
	   if (!getSecondSpot().equals(secondSpot)) {
		  return false;
	   }
	   Spot thirdSpot = cube.getThirdSpot();
	   if (!getThirdSpot().equals(thirdSpot)) {
		  return false;
	   }
	   Spot fourthSpot = cube.getFourthSpot();
	   if (!getFourthSpot().equals(fourthSpot)) {
		  return false;
	   }
	   Spot fifthSpot = cube.getFifthSpot();
	   if (!getFifthSpot().equals(fifthSpot)) {
		  return false;
	   }
	   Spot sixthSpot = cube.getSixthSpot();
	   if (!getSixthSpot().equals(sixthSpot)) {
		  return false;
	   }
	   Spot seventhSpot = cube.getSeventhSpot();
	   if (!getSeventhSpot().equals(seventhSpot)) {
		  return false;
	   }
	   Spot eighthSpot = cube.getEighthSpot();
	   return getEighthSpot().equals(eighthSpot);
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
	   StringBuilder builder = new StringBuilder("Cube{lowPlaneBottomLeft=");
	   builder.append(firstSpot);
	   builder.append(", lowPlaneBottomRight=");
	   builder.append(secondSpot);
	   builder.append(", lowPlaneTopLeft=");
	   builder.append(thirdSpot);
	   builder.append(", lowPlaneTopRight=");
	   builder.append(fourthSpot);
	   builder.append(", topPlaneBottomLeft=");
	   builder.append(fifthSpot);
	   builder.append(", topPlaneBottomRight=");
	   builder.append(sixthSpot);
	   builder.append(", topPlaneTopLeft=");
	   builder.append(seventhSpot);
	   builder.append(", topPlaneTopRight=");
	   builder.append(eighthSpot);
	   builder.append('}');
	   return builder.toString();
    }
}
