package pl.adriangalus.projectscoderslab.workshop2;

public class Menu {

    static void showMenu(String text) {

        System.out.println(String.format("dodanie %s -> add", text));
        System.out.println(String.format("edycja %s -> edit", text));
        System.out.println(String.format("usunięcie %s -> delete", text));
        System.out.println("zakończenie programu -> quit");
    }
}
