public class Sturun {
    public static void main(String[] args) {
        StudentScoreDatabase database = new StudentScoreDatabase();

        database.addStudent("Alice", 95);
        database.addStudent("Bob", 88);
        database.addStudent("Charlie", 75);

        database.updateStudent("Bob", 90);
        database.updateStudent("David", 85); // Student not found

        database.deleteStudent("Charlie");

        database.displayAllStudents();
    }
}