package pl.adriangalus.projectscoderslab.workshop1.dice;

import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class UniversalDice {

    public static void main(String[] args) {

        System.out.println("Wynik " + throwDice("7D6-1"));
    }
    static int throwDice(String code) {

        if(!code.matches("[0-9]*D([3468]|(1[02]0?)|20)([\\+-]{0,1}[0-9]+){0,1}"))
        {
            throw new IllegalArgumentException("Kod ma być podany zgodnie ze wzorem xDy+z.");
        }
        int numberOfThrows = 1;
        int diceSize = 3;
        int extraValue = 0;
        int sum = 0;
        String[] parameters = StringUtils.split(code, "[D+-]");
        switch(parameters.length) {
            case 1:
                diceSize = Integer.parseInt(parameters[0]);
                break;
            case 2:
                if(code.contains("+") || code.contains("-")) {
                    diceSize = Integer.parseInt(parameters[0]);
                    extraValue = Integer.parseInt(parameters[1]);
                }
                else {
                    numberOfThrows = Integer.parseInt(parameters[0]);
                    diceSize = Integer.parseInt(parameters[1]);
                }
                break;
            case 3:
                numberOfThrows = Integer.parseInt(parameters[0]);
                diceSize = Integer.parseInt(parameters[1]);
                extraValue = Integer.parseInt(parameters[2]);
                break;
        }
        Random random = new Random();
        for(int i = 1; i <= numberOfThrows; i++) {
            int number = random.nextInt(diceSize)+1;
            System.out.println("Rzut kostką nr " + i + ": " + number);
            sum += number;
        }
        if(code.contains("-")) {
            extraValue *= -1;
        }
        return sum + extraValue;
    }
}
