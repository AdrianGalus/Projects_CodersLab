package workshop2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserManager {

    public static void main(String[] args) {

        User[] users = new User[0];
        ConnectDB.registerDriver();
        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        while(active) {
            users = showUsers(users);
            Menu.showMenu("użytkownika");
            int index;
            String name;
            String email;
            String password;
            String choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    name = ArgumentReader.getString(scanner, ArgumentReader.NAME_PATTERN, "imię");
                    email = ArgumentReader.getString(scanner, ArgumentReader.EMAIL_PATTERN, "email");
                    password = ArgumentReader.getString(scanner,ArgumentReader.PASSWORD_PATTERN, "hasło");
                    User user = new User(name, email, password);
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        user.saveToDB(conn);
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "edit":
                    index = ArgumentReader.getIndex(scanner, ArgumentReader.ID_PATTERN, "id", users);
                    name = ArgumentReader.getString(scanner, ArgumentReader.NAME_PATTERN, "imię");
                    email = ArgumentReader.getString(scanner, ArgumentReader.EMAIL_PATTERN, "email");
                    password = ArgumentReader.getString(scanner, ArgumentReader.PASSWORD_PATTERN, "hasło");
                    users[index-1].setUserName(name);
                    users[index-1].setEmail(email);
                    users[index-1].setPassword(password);
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        users[index-1].saveToDB(conn);
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "delete":
                    index = ArgumentReader.getIndex(scanner, ArgumentReader.ID_PATTERN, "id", users);
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        users[index-1].delete(conn);
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "quit":
                    System.out.println("Nie będziesz tęsknić?");
                    active = false;
                    break;
            }
        }
    }
    static User[] showUsers(User[] users) {

        try {
            Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
            users = User.loadAllUsers(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Id\tName");
        int index = 1;
        for (User user : users) {
            System.out.println(index++ + "\t" + user.getUserName());
        }
        return users;
    }
}
