import java.util.*;

public class Hostel {

    static Map<Integer, Room> list_rooms = new HashMap<>();
    static List<Student> students = new ArrayList<>();
    static List<Person> personal = new ArrayList<>();
    static int number_of_rooms_on_one_floor;
    static int number_of_floors;
    static int number_of_students;
    static int number_of_rooms_in_hostel;
    static Calendar calendar = new GregorianCalendar();


    public Hostel(int number_of_rooms_on_one_floor, int number_of_floors, int number_of_students) {
        if (number_of_floors >= 4 && number_of_rooms_on_one_floor >= 2 ) {
            this.number_of_rooms_on_one_floor = number_of_rooms_on_one_floor;
            this.number_of_floors = number_of_floors;
            this.number_of_students = number_of_students;
            number_of_rooms_in_hostel = number_of_rooms_on_one_floor * number_of_floors;
            createRooms();
            personal.add(createCommandant());
            personal.add(createGuard());
            accomodatePersonal();
            createStudents();
            accomodateStudents();
        } else {
            System.out.println("You can't create this hostel.");
        }
    }

    protected void accomodatePersonal() {
            for (int count = 1; count <= personal.size(); count++) {
                list_rooms.get(count).accomodateInRoom(personal.get(count - 1));
                personal.get(count - 1).setRoom_address(count - 1);
            }

    }

    protected void accomodateStudents() {
        int limit_student = 0;
        for (int count_of_rooms = personal.size() + 1; count_of_rooms <= list_rooms.size(); count_of_rooms++) {
            while (list_rooms.get(count_of_rooms).isFreeRoom() && limit_student != students.size()){
                list_rooms.get(count_of_rooms).addInRoomStudent(students.get(limit_student));
                students.get(limit_student).setRoom_address(count_of_rooms);
                limit_student++;
            }
        }
    }

    private void createRooms() {
        for (int floor = 1; floor <= number_of_floors; floor++) {
            for (int room = 1; room <= number_of_rooms_on_one_floor; room++) {
                Room intermediate_room = new Room(room + (floor-1) * number_of_rooms_on_one_floor, floor);
                list_rooms.put(room + (floor - 1) * number_of_rooms_on_one_floor, intermediate_room);
            }
        }
    }

    protected Person createCommandant() {
        return new Commandant();
    }

    protected Person createGuard() {
        return new Guard();
    }

    protected Senior chooseSenior() {
        List<Student> list = sortByTheCourse();
        if (list.size() != 0) {
            return new Senior(students.get(((int) Math.random() * list.size()) + 1));
        }
        else {
            return null;
        }
    }

    protected List<Student> sortByTheCourse() {
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getCourse() >= 2){
                list.add(student);
            }
        }
        return list;
    }

    protected void removeSenior(Senior senior) {
        senior.deleteSenior();
        senior = null;
    }

    private void createStudents(){
        int limit;
        if ((number_of_students + (personal.size() * Room.room_size)) >
                (number_of_rooms_on_one_floor * number_of_floors * Room.room_size)){
            limit = (number_of_rooms_on_one_floor * number_of_floors - personal.size()) * Room.room_size;
            System.out.println("We can accommodate only " + limit +  " students.");
        } else {
            limit = number_of_students;
            System.out.println("We can accommodate all students.");
        }

        for (int count = 0; count < limit; count++) {
            students.add(new Student());
        }

    }

    protected static Commandant findCommandant(){
        return (Commandant) personal.get(0);
    }

    protected static Guard findGuard(){
        return (Guard) personal.get(1);
    }


    protected void incrementCourse() {
        for (Student student : students){
            if (student.getCourse() < 4){
                student.setCourse(student.getCourse() + 1);
            } else {
                findCommandant().ApproveAviction(student);
            }
        }
    }

    private void initTime() {
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 8);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
    }

    private void printCalendar(){
        System.out.println(calendar.getTime());
    }

    private void toGoInFuture(){
        calendar.roll(Calendar.YEAR,1);
        incrementCourse();
    }
}
