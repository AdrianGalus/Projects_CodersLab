package pl.adriangalus.projectscoderslab.workshop2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserManager {

    public static void main(String[] args) {

        User[] users = new User[0];
        SQLHelper.registerDriver();
        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        while(active) {
            try {
                Connection conn = SQLHelper.getConnection("programming_school", "root", "coderslab");
                users = User.loadAllUsers(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Id\tName");
            for (User user : users) {
                System.out.println(user.getId() + "\t" + user.getUserName());
            }
            System.out.println("dodanie użytkownika -> add");
            System.out.println("edycja użytkownika -> edit");
            System.out.println("usunięcie użytkownika -> delete");
            System.out.println("zakończenie programu -> quit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    System.out.println("Podaj imię");
                    System.out.println("Podaj email");
                    System.out.println("Podaj hasło");
                    break;
                case "edit":
                    System.out.println("Podaj id");
                    System.out.println("Podaj imię");
                    System.out.println("Podaj email");
                    System.out.println("Podaj hasło");
                    break;
                case "delete":
                    System.out.println("Podaj id");
                    break;
                case "quit":
                    System.out.println("Nie będziesz tęsknić?");
                    active = false;
                    break;
            }
        }
    }
}
