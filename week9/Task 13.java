import java.util.*;

class EntityRecord {
    int enrollmentID;
    String student;
    String course;
    String instructor;
    String startDate;
    int duration;

    // Constructor
    EntityRecord(int enrollmentID, String student, String course, String instructor, String startDate, int duration) {
        this.enrollmentID = enrollmentID;
        this.student = student;
        this.course = course;
        this.instructor = instructor;
        this.startDate = startDate;
        this.duration = duration;
    }

    // Method to display record
    void display() {
        System.out.println("Enrollment_ID: " + enrollmentID +
                ", Student: " + student +
                ", Course: " + course +
                ", Instructor: " + instructor +
                ", Start Date: " + startDate +
                ", Duration: " + duration + " weeks");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of records
        ArrayList<EntityRecord> records = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String student = sc.next();
            String course = sc.next();
            String instructor = sc.next();
            String startDate = sc.next();
            int duration = sc.nextInt();

            EntityRecord er = new EntityRecord(id, student, course, instructor, startDate, duration);
            records.add(er);
        }

        // Display all records
        for (EntityRecord r : records) {
            r.display();
        }

        sc.close();
    }
}