import java.util.Map;

public class Guard extends Administration implements Person, FunctionGuard{

    String name;
    private int room_address;

    protected Guard(){
        name = Person.createName();
    }

    protected String getName(){ return name; }

    protected int getRoom_address(){ return room_address; }

    public void setRoom_address(int room_address){
        this.room_address = room_address;
    }

    @Override
    public void toGuard() {
        System.out.println("Don't worry.)");
    }
}
