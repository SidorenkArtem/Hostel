import java.util.ArrayList;
import java.util.List;

public class Room{

    protected static final int room_size = 3;
    protected List<Person> room = new ArrayList<>();
    int room_number;
    int floor_number;

    protected Room( int room_number, int floor_number) {
        this.room_number = room_number;
        this.floor_number = floor_number;
    }

    protected List<Person> getRoom(){ return room;}

    protected void removeStudent(Student student) {
        room.remove(student);
    }

    protected boolean isFreeRoom(){
        return room.size() < room_size;
    }

    protected void addInRoomStudent(Student student){
        if (isFreeRoom()){
            room.add(student);
        }
    }
    protected void addInRoomPersonal(Person person){
        if (room.size() == 0){
            while(isFreeRoom()){
                room.add(person);
            }
        }
    }

    protected void deleteStudentFromRoom(Student student){
        room.remove(student);
    }

    public void accomodateInRoom(Person person) {
        if (person instanceof Guard){
            addInRoomPersonal(person);
        } else if (person instanceof Commandant){
            addInRoomPersonal(person);
        } else {
            addInRoomStudent((Student)person);
        }
    }
}
