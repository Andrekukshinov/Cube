package cube.model.observable;

import cube.logics.IdGenerator;
import cube.model.Cube;
import cube.model.Spot;

import java.util.ArrayList;
import java.util.List;

public class CubeObservable extends Cube implements Observable {
    private final long id;
    private final List<Observer> observers = new ArrayList<>();
    private final IdGenerator generator = new IdGenerator();

    public CubeObservable(
		  Spot firstSpot, Spot secondSpot, Spot thirdSpot, Spot lowPlaneTopRight,
		  Spot fifthSpot, Spot sixthSpot, Spot seventhSpot, Spot eighthSpot) {
	   super(firstSpot, secondSpot, thirdSpot, lowPlaneTopRight, fifthSpot, sixthSpot,
			 seventhSpot, eighthSpot);
	   this.id = generator.getId();
    }


    @Override
    public void notifyObservers() {
	   for (Observer observer : observers) {
		  observer.update(this);
	   }
    }

    @Override
    public void setFirstSpot(Spot firstSpot) {
	   super.setFirstSpot(firstSpot);
	   notifyObservers();
    }

    @Override
    public void setSecondSpot(Spot secondSpot) {
	   super.setSecondSpot(secondSpot);
	   notifyObservers();
    }

    @Override
    public void setThirdSpot(Spot thirdSpot) {
	   super.setThirdSpot(thirdSpot);
	   notifyObservers();
    }

    @Override
    public void setFourthSpot(Spot fourthSpot) {
	   super.setFourthSpot(fourthSpot);
	   notifyObservers();
    }

    @Override
    public void setFifthSpot(Spot fifthSpot) {
	   super.setFifthSpot(fifthSpot);
	   notifyObservers();
    }

    @Override
    public void setSixthSpot(Spot sixthSpot) {
	   super.setSixthSpot(sixthSpot);
	   notifyObservers();
    }

    @Override
    public void setSeventhSpot(Spot seventhSpot) {
	   super.setSeventhSpot(seventhSpot);
	   notifyObservers();
    }

    @Override
    public void setEighthSpot(Spot eighthSpot) {
	   super.setEighthSpot(eighthSpot);
	   notifyObservers();
    }

    public long getId() {
	   return id;
    }

    @Override
    public void addObserver(Observer observer) {
	   observers.add(observer);
	   notifyObservers();
    }

    @Override
    public void removeObserver(Observer observer) {
	   observers.remove(observer);
    }

  //package access for testing
    List<Observer> getObserves() {
	   return new ArrayList<>(observers);
    }
}
