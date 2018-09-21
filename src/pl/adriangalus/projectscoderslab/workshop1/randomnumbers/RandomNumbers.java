package pl.adriangalus.projectscoderslab.workshop1.randomnumbers;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {

    public static void main(String[] args) {

        int randomNumber = random(100);

        System.out.println("Zgadnij liczbę (od 1 do 100). Jeżeli chcesz się poddać, wybierz 0");
        int userNumber;
        while((userNumber = getData()) != 0) {
            if (userNumber < randomNumber) {
                System.out.println("Za mało!");
            } else if (userNumber > randomNumber) {
                System.out.println("Za dużo!");
            } else {
                System.out.println("Zgadłeś!");
                break;
            }
        }
    }
    private static int random(int size) {

        Random generator = new Random();
        return generator.nextInt(size)+1;
    }
    private static int getData() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while(!scanner.hasNextInt()) {
            scanner.nextLine();
            System.err.println("To nie jest liczba całkowita");
        }
        return scanner.nextInt();
    }
}
