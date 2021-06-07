package com.tuana9a.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCMain {
    public static void main(String[] args) {

        try {
            if (MySQLConnection.connect()) System.out.println("connect successfully");

            String sql0 = "select * from product;";
            String sql1 = "select * from brand;";
//            Statement statement = MySQLConnection.connection.prepareStatement(sql0, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Statement statement = MySQLConnection.connection.createStatement();

            ResultSet rs0 = statement.executeQuery(sql0);
            while (rs0.next()) System.out.println(rs0.getInt("id") + " " + rs0.getString("name"));

            rs0 = statement.executeQuery(sql1);
            while (rs0.next()) System.out.println(rs0.getInt("id") + " " + rs0.getString("name"));

            ResultSet rs1 = statement.executeQuery(sql1);
            while (rs1.next()) System.out.println(rs1.getInt("id") + " " + rs1.getString("name"));

            statement.close();

            if (MySQLConnection.disconnect()) System.out.println("disconnect successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
