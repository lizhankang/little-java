package GDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GDBCUpdate {
    public static void main(String[] args) {

    }

    public static void update1() throws SQLException {
        String JDBC_URL = "jdbc:mysql://47.102.40.68:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "little-java";
        String JDBC_PASSWORD = "little-java@mysql";

        try(Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "UPDATE students SET name=? WHERE id=?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setObject(1, "Bob"); // 注意：索引从1开始
                statement.setObject(2, 999);
                int n = statement.executeUpdate(); // 返回更新的行数
            }
        }
    }
}
