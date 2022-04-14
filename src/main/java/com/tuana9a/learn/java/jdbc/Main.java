package com.tuana9a.learn.java.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String databaseUrl = System.getenv("DATABASE_URL");
        String databaseUsername = System.getenv("DATABASE_USERNAME");
        String databasePassword = System.getenv("DATABASE_PASSWORD");
        MySqlConnection mySqlConnection = new MySqlConnection();
        if (mySqlConnection.connect(databaseUrl, databaseUsername, databasePassword)) {
            System.out.println("connect successfully");
        }
        Connection connection = mySqlConnection.getConnection();

        String sql0 = "SELECT * FROM product;";
        String sql1 = "SELECT * FROM brand;";
//            Statement statement = MySQLConnection.connection.prepareStatement(sql0, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        Statement statement = mySqlConnection.getConnection().createStatement();

        ResultSet rs0 = statement.executeQuery(sql0);
        while (rs0.next()) System.out.println(rs0.getInt("id") + " " + rs0.getString("name"));

        rs0 = statement.executeQuery(sql1);
        while (rs0.next()) System.out.println(rs0.getInt("id") + " " + rs0.getString("name"));

        ResultSet rs1 = statement.executeQuery(sql1);
        while (rs1.next()) System.out.println(rs1.getInt("id") + " " + rs1.getString("name"));

        statement.close();

          /* Statement
            là class để tạo các lệnh, quản lý thực thi chúng
            lấy được bằng .createStatement() của Connection
            tác dụng là thực thi các câu lệnh đó và có thể trả về int, boolean, ResultSet*/

        statement = connection.createStatement();

        /* PreparedStatement
            cũng là class để tạo các lệnh, quản lý thực thi chúng
            điểm khác là do dược prepared, đã được complied, nên thực thi nhanh hơn
            lấy được bằng .prepareStatement() của Connection
            đặc trưng query string sẽ có ký tự '?' chính là tham số sẽ truyền vào sau này
                nhưng thường dấu hỏi sẽ được thay bởi tên cột chứ không tên bảng được
                index tính từ 1, NOT từ 0 */

        PreparedStatement preparedStatement = connection.prepareStatement("SOME SQL");

        /* ResultSet
            là một class xử lý và chứa kết quả trả về từ SELECT
            lấy được sau khi Statement(hoặc PrepareStatement) được execute
            tác dụng là đọc kết quả trả về (có một con trỏ trỏ tới row của bảng trả về)
            có phương thức get để lấy data tương ứng */

        ResultSet resultSet = null;
        resultSet = statement.executeQuery("SOME SQL");
        resultSet = preparedStatement.executeQuery();

        /* ResultSetMetaData
            là một class chứa thông tin của kết quả trả về
            lấy được bằng phương thức .getMetaData() của ResultSet */

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        /* DatabaseMetaData
            là một class chứa thông tin của database
            lấy được bằng phương thức của .getMetaData() của Connection */

        DatabaseMetaData databaseMetaData = connection.getMetaData();

        /* Batch
            khi bạn muốn thực hiện nhiều câu lệnh một lúc
            thực hiện được bằng .addBath() của Statement hoặc
                PreparedStatement sau đó dùng .excuteBatch() để thực hiện */

        statement.addBatch("SOME SQL");
        statement.executeBatch();

        preparedStatement.addBatch("SOME SQL");
        preparedStatement.executeBatch();

        /*  Transaction Statement
            khi bạn muốn hủy giao kèo hoặc undo nhưng thứ đã làm
            .setAutoCommit(boolean b) của Connection mặc định là true nên mọi câu lệnh sẽ dược thực thi
            vậy nếu .setAutoCommit(false)
                thì có thể dùng phương thức là .commit() và .rollback()
                    .commit() sẽ thừa nhận là đã giao dịch và không hoàn trả
                    .rollback() sẽ hủy giao dịch và hoàn trả lại những gì đã làm
        *	trước khi commit mà có SQLException thì tất cả các câu lệnh trước nó đều sẽ bị hủy theo */

        connection.setAutoCommit(false);
        connection.commit();
        connection.rollback();

        /* CallableStatement
            dùng các procedure đã được lưu trong database
            lấy được bằng phương thức .prepareCall(String sql) của Connection, sau đó có thể set vị trí như prepareStatement
            thực thi bằng .executeQuery của chính nó
            trả về một bảng như select bình thường */

        CallableStatement callableStatement = connection.prepareCall("SOME PROCEDURE");

        if (mySqlConnection.disconnect()) {
            System.out.println("disconnect successfully");
        }
    }
}
