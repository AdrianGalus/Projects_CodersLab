package workshop2.utils;

import java.util.Scanner;

public class ArgumentReader {

    public static final String ID_PATTERN = "[1-9]+[0-9]*";
    public static final String NAME_PATTERN = "[A-Za-z0-9]+";
    public static final String EMAIL_PATTERN =
                    "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    public static final String TITLE_PATTERN = ".+";
    public static final String DESCRIPTION_PATTERN = ".+";

    public static int getIndex(Scanner scanner, String pattern, String text) {

        String maybeIndex;
        while (true) {
            System.out.println(String.format("Podaj %s", text));
            maybeIndex = scanner.nextLine();
            if (maybeIndex.matches(pattern)) {
                break;
            }
        }
        return Integer.parseInt(maybeIndex);
    }

    public static int getIndex(Scanner scanner, String pattern, String text, Object[] object) {

        String maybeIndex;
        while (true) {
            System.out.println(String.format("Podaj %s", text));
            maybeIndex = scanner.nextLine();
            if(maybeIndex.matches(pattern) && Integer.parseInt(maybeIndex) <= object.length) {
                break;
            }
        }
        return Integer.parseInt(maybeIndex);
    }
    public static String getString(Scanner scanner, String pattern, String text) {

        String maybeString = "";
        while (!maybeString.matches(pattern)) {
            System.out.println(String.format("Podaj %s", text));
            maybeString = scanner.nextLine();
        }
        return maybeString;
    }
}