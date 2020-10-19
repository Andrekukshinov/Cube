package cube.model.observable;

import cube.model.Register;
import cube.model.Spot;

public interface Observable {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);



    void notifyObservers();

}
