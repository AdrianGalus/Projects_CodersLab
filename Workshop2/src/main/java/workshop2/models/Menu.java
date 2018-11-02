package workshop2.models;

public class Menu {

    public static void showMenu(String text) {

        System.out.println(String.format("dodanie %s -> add", text));
        System.out.println(String.format("edycja %s -> edit", text));
        System.out.println(String.format("usunięcie %s -> delete", text));
        System.out.println("zakończenie programu -> quit");
    }
    public static void showSolutionMenu() {

        System.out.println("dodanie rozwiązania -> add");
        System.out.println("przeglądanie rozwiązań -> view");
        System.out.println("zakończenie programu -> quit");
    }
}
