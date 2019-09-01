import java.util.Map;

public class Commandant extends Administration implements Person, FunctionCommandant, Personal{

    private String name;
    private int room_address;

    protected Commandant(){
        name = Person.createName();
    }

    protected String getName(){ return name; }

    protected int getRoom_address(){ return room_address; }

    public void setRoom_address(int room_address){
        this.room_address = room_address;
    }

    @Override
    public int checkRooms(Map<Integer, Room> map_rooms) {
        return (int) randomNumber(Hostel.personal.size() + 1, map_rooms.size() / 2);
    }

    @Override
    public boolean checkObservation(Student student) {
        return student.getArray_comment().size() == 2;
    }

    @Override
    public boolean checkCourse(Student student) {
        return student.getCourse() < 4;
    }

    @Override
    public boolean checkPayForHostel(Student student) {
        return student.getIsPayForHostel();

    }

    @Override
    public void makeAnObservation(Student student)
    {
        student.getArray_comment().add(true);
    }

    @Override
    public void ApproveAccomodate() {
        Student student = new Student();
        Hostel.students.add(student);
        Room room = findFreeRoom();
        room.addInRoomStudent(student);
        System.out.println(student + " to accomode.");
    }

    @Override
    public Room findFreeRoom(){
        for(Integer count : Hostel.list_rooms.keySet()) {
            if (Hostel.list_rooms.get(count).isFreeRoom()) {
                System.out.println("We have a free room.\n");
                return Hostel.list_rooms.get(count);
            }
        }
        System.out.println("All rooms are occupied.\n");
        return null;
    }

    @Override
    public void ApproveAviction(Student student) {
        if (checkObservation(student) || checkCourse(student) || checkPayForHostel(student)) {
            System.out.println(student.getName() + " to evict.");
            removeStudent(student);
        } else {
            System.out.println("I can't evict this student.");
        }
    }

    @Override
    public void removeStudent(Student student) {
        int i = student.getRoom_address();
        System.out.println(" i " + i);
        Hostel.list_rooms.get(i).removeStudent(student);
        Hostel.students.remove(student);

    }


}
