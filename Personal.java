import java.util.Map;

public interface Personal {

    int checkRooms(Map<Integer, Room> map);

    boolean checkObservation(Student student);

    void makeAnObservation(Student student);
}
