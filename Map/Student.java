import java.util.HashMap;
import java.util.Map;

class StudentScoreDatabase {
    private Map<String, Integer> studentScores;

    public StudentScoreDatabase() {
        studentScores = new HashMap<>();
    }

    public void addStudent(String name, int score) {
        studentScores.put(name, score);
    }

    public void updateStudent(String name, int newScore) {
        if (studentScores.containsKey(name)) {
            studentScores.put(name, newScore);
        } else {
            System.out.println("Student not found: " + name);
        }
    }

    public void deleteStudent(String name) {
        studentScores.remove(name);
    }

    public void displayAllStudents() {
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Score: " + entry.getValue());
        }
    }
}


