import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String name;
    private String prerequisite;
    private int capacity;
    private int enrolled;

    public Course(String name, String prerequisite, int capacity) {
        this.name = name;
        this.prerequisite = prerequisite;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getName() {
        return name;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public boolean isFull() {
        return enrolled >= capacity;
    }

    public void enroll() throws CourseFullException {
        if (isFull()) {
            throw new CourseFullException("Error: Course " + name + " is full.");
        }
        enrolled++;
    }
}

public class UniversityEnrollment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Boolean> completedCourses = new HashMap<>();
        
        Course advancedJava = new Course("Advanced Java", "Core Java", 2);
        
        System.out.println("Enroll in Course: " + advancedJava.getName());
        System.out.print("Have you completed " + advancedJava.getPrerequisite() + "? (yes/no): ");
        String prerequisiteStatus = scanner.nextLine().toLowerCase();
        
        try {
            if (!prerequisiteStatus.equals("yes")) {
                throw new PrerequisiteNotMetException("Error: Complete " + advancedJava.getPrerequisite() + " before enrolling in " + advancedJava.getName() + ".");
            }
            
            advancedJava.enroll();
            System.out.println("Enrollment successful in " + advancedJava.getName() + ".");
        } catch (PrerequisiteNotMetException | CourseFullException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
