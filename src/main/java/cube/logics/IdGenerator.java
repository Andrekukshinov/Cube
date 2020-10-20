package cube.logics;


public class IdGenerator {
    private static long id = 0;

    public long getId() {
        return id++;
    }
}
