package pl.adriangalus.projectscoderslab.workshop1.randomnumbers;

import java.util.Scanner;

public class RandomNumbers2 {

    public static void main(String[] args) {

        playRandomNumbers();
    }
    private static void playRandomNumbers() {

        int max = 1000;
        int min = 0;
        int count = 1;
        boolean play = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pomyśl liczbę od 1 do 1000, a ja ją zgadnę w max 10 próbach.");
        while(count < 11 && play) {
            int guess = (max - min) / 2 + min;
            System.out.println("Zgaduję (próba " + count + "): " + guess);
            System.out.println("Wybierz odpowiednią opcję:");
            System.out.println("za dużo - 1\nza mało - 2\nzgadłeś - 0");
            String choice = scanner.nextLine();
            switch (choice) {
                case "0":
                    System.out.println("Zgadłem w próbie nr: " + count);
                    play = false;
                    break;
                case "1":
                    max = guess - 1;
                    count++;
                    if (count == 11) {
                        System.out.println("Nie oszukuj!");
                    }
                    break;
                case "2":
                    min = guess + 1;
                    count++;
                    if (count == 11) {
                        System.out.println("Nie oszukuj!");
                    }
                    break;
                default:
                    System.out.println("Niepoprawny wybór!");
                    break;
            }
        }
    }
}
