package MiniProject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public static boolean addStudent(
            String name,
            String studentId,
            String course
    ) {

        String sql =
                "INSERT INTO students (name, student_id, course) VALUES (?, ?, ?)";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, studentId);
            statement.setString(3, course);

            int rows =
                    statement.executeUpdate();

            statement.close();
            connection.close();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }


    public static java.sql.ResultSet getAllStudents() {

        String sql = "SELECT * FROM students";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            return statement.executeQuery();

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    public static boolean updateStudent(
            int id,
            String name,
            String studentId,
            String course
    ) {

        String sql =
                "UPDATE students SET name = ?, student_id = ?, course = ? WHERE id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, studentId);
            statement.setString(3, course);
            statement.setInt(4, id);

            int rows = statement.executeUpdate();

            statement.close();
            connection.close();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    public static boolean deleteStudent(int id) {

        String sql =
                "DELETE FROM students WHERE id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows =
                    statement.executeUpdate();

            statement.close();
            connection.close();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}