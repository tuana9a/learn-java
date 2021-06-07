package com.tuana9a.jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;

public class MySQLPicture {

    public static void uploadImage(String imgUrl){
        try {
            FileInputStream fis = new FileInputStream(imgUrl);

            if(!MySQLConnection.connect()) return;
            Connection connection = MySQLConnection.connection;
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into test.image_table value(?,?)");
            preparedStatement.setString(1,"Untitled");

            preparedStatement.setBinaryStream(2,fis,fis.available());

            System.out.println(preparedStatement.executeUpdate()+ " image is uploaded");

            connection.commit();
            connection.close();

            System.out.println("\n============================DONE============================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void downloadImage(String imgUrl){
        try {
            FileOutputStream fos = new FileOutputStream(imgUrl);

            Connection connection = MySQLConnection.connection;
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("select * from test.image_table");

            ResultSet rs = preparedStatement.executeQuery();
            Blob b = null;
            int imgCount = 0;
            while(rs.next()) {
                b = rs.getBlob(2);
                imgCount++;
            }

            System.out.println(imgCount + " image(s) downloaded");

//            assert b != null;
            fos.write(b.getBytes(1,(int) b.length()));

            connection.commit();
            connection.close();

            System.out.println("\n============================DONE============================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
