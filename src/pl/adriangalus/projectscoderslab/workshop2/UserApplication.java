package pl.adriangalus.projectscoderslab.workshop2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserApplication{

    public static void main(String[] args) {

        int userId = 0;
        User[] users = new User[0];
        boolean findId = false;
        if (args.length > 0 && args[0].matches("[1-9]+[0-9]*")) {
            userId = Integer.parseInt(args[0]);
        } else {
            System.err.println("Musisz podać swoje id");
            System.exit(0);
        }
        try {
            Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
            users = User.loadAllUsers(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == userId) {
                System.out.println("Cześć " + users[i].getUserName());
                findId = true;
            }
        }
        if (!findId) {
            System.err.println("Nie ma użytkownika z takim id");
            System.exit(0);
        }
        Scanner scanner = new Scanner(System.in);
        Exercise[] exercises;
        boolean active = true;
        while (active) {
            Menu.showSolutionMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        exercises = Exercise.loadExercisesNotMadeByThisUser(conn, userId);
                        System.out.println("Id\tTitle");
                        int exerciseId = 1;
                        for (Exercise exercise : exercises) {
                            System.out.println(exerciseId++ + "\t" + exercise.getTitle());
                        }
                        exerciseId = ArgumentReader.getIndex(scanner, ArgumentReader.ID_PATTERN, "id", exercises);
                        int exerciseIdInDB = exercises[exerciseId - 1].getId();
                        String description = ArgumentReader.getString(scanner, ArgumentReader.DESCRIPTION_PATTERN, "opis");
                        Solution solution = new Solution(exerciseIdInDB, userId);
                        solution.setDescription(description);
                        solution.saveToDB(conn);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "view":
                    Solution[] solutions = new Solution[0];
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        solutions = Solution.loadAllByUserId(conn, userId);

                    }
                    catch(SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Id\tCreated\tDescription");
                    int index = 1;
                    for (Solution sol : solutions) {
                        System.out.println(index++ + "\t" + sol.getCreated() + "\t" + sol.getDescription());
                    }
                    break;
                case "quit":
                    active = false;
                    break;
            }
        }
    }
}
