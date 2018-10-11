package pl.adriangalus.projectscoderslab.workshop2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserGroupManager {

    public static void main(String[] args) {

        UserGroup[] groups = new UserGroup[0];
        ConnectDB.registerDriver();
        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        while(active) {
            try {
                Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                groups = UserGroup.loadAllGroups(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Id\tName");
            int index = 1;
            for (UserGroup group : groups) {
                System.out.println(index++ + "\t" + group.getName());
            }
            Menu.showMenu("grupy");
            String name;
            String choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    name = ArgumentReader.getString(scanner, ArgumentReader.TITLE_PATTERN, "nazwę");
                    UserGroup group = new UserGroup(name);
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        group.saveToDB(conn);
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "edit":
                    index = ArgumentReader.getNumber(scanner, ArgumentReader.ID_PATTERN, "id");
                    name = ArgumentReader.getString(scanner, ArgumentReader.TITLE_PATTERN, "nazwę");
                    groups[index-1].setName(name);
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        groups[index-1].saveToDB(conn);
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "delete":
                    index = ArgumentReader.getNumber(scanner, ArgumentReader.ID_PATTERN, "id");
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        groups[index-1].delete(conn);
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
}
