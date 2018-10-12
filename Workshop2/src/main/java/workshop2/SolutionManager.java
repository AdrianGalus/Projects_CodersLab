package workshop2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SolutionManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        while(active) {
            Menu.showSolutionMenu();
            int exerciseId;
            int usersId;
            User[] users = new User[0];
            int userIdInDB;
            int exerciseIdInDB;
            String choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    Exercise[] exercises = new Exercise[0];
                    users = UserManager.showUsers(users);
                    usersId = ArgumentReader.getIndex(scanner, ArgumentReader.ID_PATTERN, "id", users);
                    userIdInDB = users[usersId-1].getId();
                    exercises = ExerciseManager.showExercises(exercises);
                    exerciseId = ArgumentReader.getIndex(scanner, ArgumentReader.ID_PATTERN, "id zadania", exercises);
                    exerciseIdInDB = exercises[exerciseId-1].getId();
                    Solution solution = new Solution(exerciseIdInDB, userIdInDB);
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        solution.saveToDB(conn);
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "view":
                    Solution[] solutions = new Solution[0];
                    users = UserManager.showUsers(users);
                    usersId = ArgumentReader.getIndex(scanner, ArgumentReader.ID_PATTERN, "id", users);
                    userIdInDB = users[usersId-1].getId();
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        solutions = Solution.loadAllByUserId(conn, userIdInDB);
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Id\tCreated\tDescription");
                    int index = 1;
                    for (Solution sol : solutions) {
                        System.out.println(index++ + "\t" + sol.getCreated() + "\t" + sol.getDescription());
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
