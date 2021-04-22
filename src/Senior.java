import java.util.Map;

public class Senior extends Administration implements Person, Personal{

    private Student student;
    private static int index = 0;

    protected Senior(Student student){
        if (index == 0) {
            student.setIsSenior(true);
            this.student = student;
            index++;
        } else {
            System.out.println("Senior was chosen.");
        }
    }

    protected Student getSenior() { return student; }

    protected void deleteSenior() {
        this.student = null;
        index--;
    }

    public int checkRooms(Map<Integer, Room> map_rooms) {
        return (int) randomNumber(Hostel.personal.size() + 1, map_rooms.size() / 2);
    }

    public boolean checkObservation(Student student) {
        return student.getArray_comment().size() == 2;
    }

    public void makeAnObservation(Student student)
    {
        student.getArray_comment().add(true);
    }

    @Override
    public void setRoom_address(int i) {
    }
}
