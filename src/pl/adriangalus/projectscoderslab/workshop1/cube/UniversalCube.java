package pl.adriangalus.projectscoderslab.workshop1.cube;

import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class UniversalCube {

    public static void main(String[] args) {

        System.out.println("Wynik " + throwCube("7D6-1"));
    }
    static int throwCube(String code) {

        if(!code.matches("[0-9]*D([3-9]|([1-9][0-9]+))([\\+\\-]{0,1}[0-9]+){0,1}"))
        {
            throw new IllegalArgumentException("Kod ma być podany zgodnie ze wzorem xDy+z.");
        }
        int numberOfThrows = 1;
        int cubeSize = 3;
        int extraValue = 0;
        int sum = 0;
        String[] parameters = StringUtils.split(code, "[D+-]");
        switch(parameters.length) {
            case 1:
                cubeSize = Integer.parseInt(parameters[0]);
                break;
            case 2:
                if(code.contains("+") || code.contains("-")) {
                    cubeSize = Integer.parseInt(parameters[0]);
                    extraValue = Integer.parseInt(parameters[1]);
                }
                else {
                    numberOfThrows = Integer.parseInt(parameters[0]);
                    cubeSize = Integer.parseInt(parameters[1]);
                }
                break;
            case 3:
                numberOfThrows = Integer.parseInt(parameters[0]);
                cubeSize = Integer.parseInt(parameters[1]);
                extraValue = Integer.parseInt(parameters[2]);
                break;
        }
        Random random = new Random();
        for(int i = 1; i <= numberOfThrows; i++) {
            int number = random.nextInt(cubeSize)+1;
            System.out.println("Rzut kostką nr " + i + ": " + number);
            sum += number;
        }
        if(code.contains("-")) {
            extraValue *= -1;
        }
        return sum + extraValue;
    }
}
