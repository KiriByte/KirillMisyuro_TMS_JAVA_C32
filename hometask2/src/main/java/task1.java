import java.util.Scanner;

//Дано произвольное число. Необходимо узнать, сколько в конце числа нулей.
public class task1 {
    public void start() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        int oiriginalValue = a;
        int count = 0;
        if (a == 0) {
            count = 1;
        } else {
            while (a % 10 == 0) {
                count++;
                a = a / 10;
            }
        }
        System.out.println(oiriginalValue + " has " + count + " zeros");
    }
}
