package pl.adriangalus.projectscoderslab.workshop2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SolutionManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        while(active) {
            System.out.println("dodanie rozwiązania -> add");
            System.out.println("przeglądanie rozwiązań -> view");
            System.out.println("zakończenie programu -> quit");
            int exerciseId;
            int usersId;
            String choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    User[] users = new User[0];
                    Exercise[] exercises = new Exercise[0];
                    UserManager.showUsers(users);
                    usersId = ArgumentReader.getNumber(scanner, ArgumentReader.ID_PATTERN, "id");
                    ExerciseManager.showExercises(exercises);
                    exerciseId = ArgumentReader.getNumber(scanner, ArgumentReader.ID_PATTERN, "id zadania");
                    Solution solution = new Solution(exerciseId, usersId);
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
                    usersId = ArgumentReader.getNumber(scanner, ArgumentReader.ID_PATTERN, "id");
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        solutions = Solution.loadAllByUserId(conn, usersId);
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
