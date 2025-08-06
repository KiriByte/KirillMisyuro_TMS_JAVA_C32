import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Main {

    static Random rand = new Random();

    public static void main(String[] args) {

        var task1 = new Task1(rand);
        task1.start();

        var task2 = new Task2(rand);
        task2.start();

    }

}