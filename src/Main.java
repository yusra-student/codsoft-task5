import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int currentEnrollment;
    private String schedule;
    private ArrayList<Student> registeredStudents; // Optional for efficiency

    // Constructors, getters, setters

    public boolean isAvailable() {
        return currentEnrollment < capacity;
    }

    public void registerStudent(Student student) {
        if (isAvailable()) {
            registeredStudents.add(student);
            student.registeredCourses.add(this);
            currentEnrollment++;
        } else {
            System.out.println("Course " + courseCode + " is full.");
        }
    }

    public void removeStudent(Student student) {
        if (registeredStudents.contains(student)) {
            registeredStudents.remove(student);
            student.registeredCourses.remove(this);
            currentEnrollment--;
        } else {
            System.out.println("Student " + student.studentId + " is not registered for " + courseCode);
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + "\nSchedule: " + schedule;
    }
}

public class Student {
    private String studentId;
    private String name;
    private ArrayList<Course> registeredCourses;

    // Constructors, getters, setters

    public void displayRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            for (Course course : registeredCourses) {
                System.out.println(course.toString()); // Leverage Course's toString()
            }
        }
    }
}

public class DatabaseUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Methods for CRUD operations on Course and Student tables in the database
    // Implement methods to create tables, insert/update/delete data
}
public class CourseRegistrationSystem {

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean useDatabase; // Flag to indicate using database

    public CourseRegistrationSystem(boolean useDatabase) {
        this.useDatabase = useDatabase;
        courses = new ArrayList<>();
        students = new ArrayList<>();
        if (useDatabase) {
            // Initialize data from database (implement logic using DatabaseUtil)
        }
    }

    public void listAvailableCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course course : courses) {
                if (course.isAvailable()) {
                    System.out.println(course.toString());
                }
            }
        }
    }

    public void registerStudent(String studentId, String name, String courseCode) {
        Student student = findStudent(studentId);
        if (student == null)
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}