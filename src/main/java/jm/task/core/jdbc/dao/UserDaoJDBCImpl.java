package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String createTable = "create table users ( id int primary key auto_increment, name varchar(50) not null , lastName varchar(50) not null, age tinyint not null)";
        try(Connection con = Util.getConnection();
            Statement statement = con.createStatement()) {
//            Statement statement = Util.getConnection().createStatement();
//            statement.executeUpdate(createTable);
//            Util.getConnection().createStatement().executeUpdate(createTable);
            statement.executeUpdate(createTable);
            System.out.println("Таблица создана!");
        }
        catch (Exception e){
            System.out.println("Error1, таблица не заздалась!");
//            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        String dropTable = "drop table users";
        try (Connection con = Util.getConnection();
             Statement statement = con.createStatement()) {
//            Util.getConnection().createStatement().executeUpdate(dropTable);
            statement.executeUpdate(dropTable);
            System.out.println("Таблица удалена!");
        }
        catch (Exception e){
        System.out.println("Error2, таблица не существует!");
//            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {

//        String createUser = "insert into users (name, lastName, age) VALUE (?, ?, ?)";
        String createUser = "insert into users VALUE (id, ?, ?, ?)";
        try (Connection con = Util.getConnection()) {

//            Util.getConnection().createStatement().executeUpdate(createUser);
            PreparedStatement preparedStatement = con.prepareStatement(createUser);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.execute();

            System.out.println("User с именем " + name + " добавлен!");

        }
        catch (Exception e){
            System.out.println("Error3, User не добавлен!!");
//            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        String deleteUser = "delete from users where id = ?";
        try (Connection con = Util.getConnection()) {
//            Util.getConnection().createStatement().executeUpdate(deleteUser);
            PreparedStatement preparedStatement = con.prepareStatement(deleteUser);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            System.out.println("User удалён!");
        }
        catch (Exception e){
            System.out.println("Error3, User не удалён!");
//            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        String getAll = "select * from users";
        try (Connection con = Util.getConnection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getAll);

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
//                int id;
//                String name;
//                String lastName;
//                Byte age;
//                id = resultSet.getInt("id");
//                name = resultSet.getString("name");
//                lastName = resultSet.getString("lastName");
//                age = resultSet.getByte("age");
//                User u = new User(name, lastName, age);
//                System.out.println(u);
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);

            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void cleanUsersTable() {
        String cleanTable = "delete from users";
        try (Connection con = Util.getConnection();
             Statement statement = con.createStatement()) {
//            Util.getConnection().createStatement().executeUpdate(cleanTable);
            statement.executeUpdate(cleanTable);
            System.out.println("Все записи удалены!");
        }
        catch (Exception e){
            System.out.println("Error2, записи не удаляются!");
//            e.printStackTrace();
        }

    }

}
