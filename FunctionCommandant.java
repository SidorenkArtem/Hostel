public interface FunctionCommandant {

    void ApproveAccomodate();

    void ApproveAviction(Student student);

    Room findFreeRoom();

    void removeStudent(Student student);

    boolean checkCourse(Student student);

    boolean checkPayForHostel(Student student);

}
