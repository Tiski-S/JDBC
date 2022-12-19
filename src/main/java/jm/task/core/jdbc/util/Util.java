package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    // реализуйте настройку соеденения с БД

        private static String Url = "jdbc:mysql://localhost:3306/bd";
        private static String UserName = "root";
        private static String Password = "root";

        public static Connection getConnection() throws SQLException {
            Connection connection = null;

            try {
                connection = DriverManager.getConnection(Url, UserName, Password);
                System.out.println("Подклютение к бд есть!");

            } catch (SQLException e) {
                System.out.println("Подключения к бд нет!");
                throw new RuntimeException(e);

            }






        return connection;
        }

}
