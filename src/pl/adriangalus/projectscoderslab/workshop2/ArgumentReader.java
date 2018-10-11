package pl.adriangalus.projectscoderslab.workshop2;

import java.util.Scanner;

class ArgumentReader {

    static final String ID_PATTERN = "[1-9]+[0-9]*";
    static final String NAME_PATTERN = "[A-Za-z0-9]+";
    static final String EMAIL_PATTERN =
                    "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";
    static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    static final String TITLE_PATTERN = ".+";
    static final String DESCRIPTION_PATTERN = ".+";

    static int getNumber(Scanner scanner, String pattern, String text) {

        String maybeNumber = "";
        while (!maybeNumber.matches(pattern)) {
            System.out.println(String.format("Podaj %s", text));
            maybeNumber = scanner.nextLine();
        }
        return Integer.parseInt(maybeNumber);
    }

    static String getString(Scanner scanner, String pattern, String text) {

        String maybeString = "";
        while (!maybeString.matches(pattern)) {
            System.out.println(String.format("Podaj %s", text));
            maybeString = scanner.nextLine();
        }
        return maybeString;
    }
}