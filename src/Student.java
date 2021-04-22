import java.util.ArrayList;
import java.util.List;

public class Student implements Person{

    private String name;
    private int course;
    private int room_address;
    private List<Boolean> array_comment = new ArrayList<>();
    private boolean isSenior;
    private boolean isPayForHostel;

    protected Student(){
        name = Person.createName();
        course = createCourse();
    }

    protected String getName(){ return name; }

    protected int getCourse(){
        return course;
    }

    protected int getRoom_address(){ return room_address; }

    protected boolean getIsSenior(){
        return isSenior;
    }

    protected boolean getIsPayForHostel(){ return isPayForHostel; }

    protected List<Boolean> getArray_comment(){ return array_comment; }


     public void setRoom_address(int room_address){
        this.room_address = room_address;
    }

    protected void setCourse(){ this.course = createCourse(); }

    protected void setCourse(int course){ this.course = course; }

    protected void setIsSenior(boolean isSenior){ this.isSenior = isSenior; }

    protected void setArray_comment(List<Boolean> array_comment) { this.array_comment = array_comment; }


    protected void payForHostel(){
        isPayForHostel = true;
    }

    protected void forgetToPayForHostel(){
        isPayForHostel = false;
    }

    protected void incrementCourse() {
        int course = getCourse();
        setCourse(course++);
    }

    private static int createCourse() {
        return (int) (Math.random() * 4) + 1;
    }
}
