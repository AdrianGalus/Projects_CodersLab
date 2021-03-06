package workshop2.managers;

import workshop2.models.Exercise;
import workshop2.models.Menu;
import workshop2.utils.ArgumentReader;
import workshop2.utils.ConnectDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ExerciseManager {

    public static void main(String[] args) {

        Exercise[] exercises = new Exercise[0];
        ConnectDB.registerDriver();
        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        while(active) {
            exercises = showExercises(exercises);
            Menu.showMenu("zadania");
            int index;
            String title;
            String description;
            String choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    title = ArgumentReader.getString(scanner, ArgumentReader.TITLE_PATTERN, "tytuł");
                    description = ArgumentReader.getString(scanner, ArgumentReader.DESCRIPTION_PATTERN, "opis");
                    Exercise exercise = new Exercise(title, description);
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        exercise.saveToDB(conn);
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "edit":
                    index = ArgumentReader.getIndex(scanner, ArgumentReader.ID_PATTERN, "id", exercises);
                    title = ArgumentReader.getString(scanner, ArgumentReader.TITLE_PATTERN, "tytuł");
                    description = ArgumentReader.getString(scanner, ArgumentReader.DESCRIPTION_PATTERN, "opis");
                    exercises[index-1].setTitle(title);
                    exercises[index-1].setDescription(description);
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        exercises[index-1].saveToDB(conn);
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "delete":
                    index = ArgumentReader.getIndex(scanner, ArgumentReader.ID_PATTERN, "id", exercises);
                    try {
                        Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
                        exercises[index-1].delete(conn);
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
    static Exercise[] showExercises(Exercise[] exercises) {

        try {
            Connection conn = ConnectDB.getConnection("programming_school", "root", "coderslab");
            exercises = Exercise.loadAllExercises(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Id\tTitle");
        int index = 1;
        for (Exercise exercise : exercises) {
            System.out.println(index++ + "\t" + exercise.getTitle());
        }
        return exercises;
    }
}
