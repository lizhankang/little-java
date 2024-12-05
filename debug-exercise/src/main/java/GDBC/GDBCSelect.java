package GDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class GDBCSelect {
    public static void main(String[] args) throws SQLException {
        connectDatabase();
    }

    public static void connectDatabase() throws SQLException {
        String JDBC_URL = "jdbc:mysql://47.102.40.68:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "little-java";
        String JDBC_PASSWORD = "little-java@mysql";
        // 获取连接:
        try(Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);) {
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT id, grade, name, gender FROM `students` WHERE gender=1;";
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        long id = rs.getLong(1); // 注意：索引从1开始
                        long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                        String formattedStr = String.format("id：%s, grade：%s, name：%s, gender: %s", id, grade, name, gender);
                        System.out.println(formattedStr);

                    }
                }
            }
        }
    }
}
