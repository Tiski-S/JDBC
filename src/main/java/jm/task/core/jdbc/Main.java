package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
//        Util util = new Util();
//        util.getConnection();
//        Util.getConnection();
        UserServiceImpl user1 = new UserServiceImpl();
//        user.createUsersTable();
//        user.dropUsersTable();
//        user1.saveUser("Иван", "Семёныч", (byte) 23);
//        user1.saveUser("Андрей", "Сидорович", (byte) 34);
//        user1.saveUser("Вика", "Петрович", (byte) 45);
//        user1.saveUser("Да", "Нет", (byte) 103);
//        user.removeUserById(6);
//        user.cleanUsersTable();
        System.out.println(user1.getAllUsers());

    }
}
