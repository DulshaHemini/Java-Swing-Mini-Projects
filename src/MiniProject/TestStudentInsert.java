package MiniProject;

public class TestStudentInsert {

    public static void main(String[] args) {

        boolean success = StudentDAO.addStudent(
                "Dulsha",
                "TG/2024/2107",
                "ICT"
        );

        if (success) {
            System.out.println("Student inserted successfully");
        } else {
            System.out.println("Student insert failed");
        }
    }
}