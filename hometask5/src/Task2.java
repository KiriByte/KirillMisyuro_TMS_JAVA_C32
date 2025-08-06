import java.util.Arrays;
import java.util.Random;

public class Task2 {

    //Дан массив целых чисел. Необходимо удалить элемент, расположенный по середине.
    private Random rand;

    public Task2(Random rand) {
        this.rand = rand;
    }

    public void start() {
        int[] arr = new int[getRandomNumber(3, 15)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNumber(100);
        }
        int[] newArr;
        if (arr.length % 2 == 1) {
            newArr = new int[arr.length - 1];
            System.arraycopy(arr, 0, newArr, 0, arr.length / 2);
            System.arraycopy(arr, arr.length / 2 + 1, newArr, arr.length / 2, newArr.length - arr.length / 2);
        } else {
            newArr = new int[arr.length - 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length / 2 - 1);
            System.arraycopy(arr, arr.length / 2 + 1, newArr, arr.length / 2 - 1, arr.length / 2 - 1);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr));
    }

    private int getRandomNumber(int max) {
        return rand.nextInt((max + 1));
    }

    private int getRandomNumber(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}
