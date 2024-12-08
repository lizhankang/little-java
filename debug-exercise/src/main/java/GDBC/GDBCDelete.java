package GDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GDBCDelete {
    public static void main(String[] args) throws SQLException {
        delete1();
    }

    public static void delete1() throws SQLException {
        String JDBC_URL = "jdbc:mysql://47.102.40.68:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "little-java";
        String JDBC_PASSWORD = "little-java@mysql";

        try(Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "DELETE FROM students WHERE id=?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setObject(1, 999);
                int i = statement.executeUpdate();
                System.out.println(i);
            }
        }
    }
}
