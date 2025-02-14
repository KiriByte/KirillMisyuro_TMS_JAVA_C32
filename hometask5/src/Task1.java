import java.util.Arrays;
import java.util.Random;

public class Task1 {
    //Дан одноместный массив целых чисел. Необходимо получить второй, который будут зеркальной копией первого (элементы наоборот - с последнего до первого)
    public Random rand;

    public Task1(Random rand) {
        this.rand = rand;
    }

    public void start() {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNumber(100);
        }
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[arr.length - 1 - i];
        }
        System.out.println(Arrays.toString(arr2));
    }

    private int getRandomNumber(int max) {
        return rand.nextInt((max + 1));
    }
}
