package GDBC;

import java.sql.*;

public class GDBCIsert {
    public static void main(String[] args) throws SQLException {
//        insert1();
        insert2();
    }

    public static void insert1() throws SQLException {
        String JDBC_URL = "jdbc:mysql://47.102.40.68:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "little-java";
        String JDBC_PASSWORD = "little-java@mysql";

        try(Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (id, grade, name, gender, score) VALUES (?,?,?,?,?)")){
                ps.setObject(1, 999); // 注意：索引从1开始
                ps.setObject(2, 1); // grade
                ps.setObject(3, "Bob"); // name
                ps.setObject(4, 3); // gender
                ps.setObject(5, 100); // gender
                int n = ps.executeUpdate(); // 1 ,表示插入的记录数量。此处总是1，因为只插入了一条记录。
            }
        }
    }

    public static void insert2() throws SQLException {
        // 插入并获取主键
        String JDBC_URL = "jdbc:mysql://47.102.40.68:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "little-java";
        String JDBC_PASSWORD = "little-java@mysql";

        try(Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO students (grade, name, gender, score) VALUES (?,?,?,?)";
            try(PreparedStatement ps  = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, 1);
                ps.setObject(2, "Bob");
                ps.setObject(3, 3);
                ps.setObject(4, 99);
                int i = ps.executeUpdate();
                try(ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        long id = rs.getLong(1); // 注意：索引从1开始
                        System.out.println(id);
                    }
                }
            }
        }
    }
}
