package pl.adriangalus.projectscoderslab.workshop1.lottogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Lotto {

    public static void main(String[] args) throws InterruptedException{

        System.out.println("Za chwilę zostanie wylosowane 6 liczb całkowitych z zakresu 1 - 49, sprawdź czy trafisz!");
        List<Integer> userChoice = new ArrayList<>();
        List<Integer> randomNumbers = new ArrayList<>();
        int userNumber;
        int randomNumber;
        boolean incorrect;
        for(int i = 1; i <= 6; i++) {

            do {
                System.out.println("Wprowadź typowaną liczbę (typ " + i + " z 6)");
                userNumber = getData();
                if(userNumber < 1 || userNumber > 49) {
                    System.out.println("Ta liczba jest poza losowanym zakresem, wybierz inną!");
                    incorrect = true;
                }
                else if(userChoice.contains(userNumber)) {
                    System.out.println("Już typowałeś taką liczbę, wybierz inną!");
                    incorrect = true;
                }
                else {
                    incorrect = false;
                }
            }while(incorrect);
            userChoice.add(userNumber);
        }
        for(int i = 50; i > 44; i--)
        while(true) {
            randomNumber = numberGenerator(i);
            if(!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
                System.out.println("Wylosowano (" + (50 - i + 1) + " z 6): " + randomNumber);
                TimeUnit.MILLISECONDS.sleep(1000);
                break;
            }
        }
        userChoice.sort(null);
        randomNumbers.sort(null);
        int result = 0;
        for(int i : userChoice) {
            for(int j : randomNumbers) {
                if(i == j) {
                    result++;
                }
            }
        }
        System.out.println();
        System.out.println("Twoje liczby: " + userChoice);
        System.out.println("Wylosowane liczby: " + randomNumbers);
        System.out.println("Trafiłeś: " + result);
    }
    private static int getData() {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while(!scanner.hasNextInt()) {
            scanner.nextLine();
            System.err.println("To nie jest liczba całkowita!");
        }
        return scanner.nextInt();
    }
    private static int numberGenerator(int n) {

        Random generator = new Random();
        int m = generator.nextInt(n+1);
        return m;
    }
}
