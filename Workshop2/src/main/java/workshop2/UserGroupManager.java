package workshop2;

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
            groups = showGroups(groups);
            Menu.showMenu("grupy");
            int index;
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
                    index = ArgumentReader.getIndex(scanner, ArgumentReader.ID_PATTERN, "id", groups);
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
                    index = ArgumentReader.getIndex(scanner, ArgumentReader.ID_PATTERN, "id", groups);
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
    static UserGroup[] showGroups(UserGroup[] groups) {

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
        return groups;
    }
}
