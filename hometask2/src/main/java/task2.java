import java.util.Scanner;

//Необходимо найти интервал числа n (интервал это произведение всех целых чисел от 1 до n)
public class task2 {
    public void start() {
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int result = 0;
        for (int i = 1; i <= a; i++) {
            result += i;
        }
        System.out.println("The sum of the numbers from 1 to " + a + " = " + result);
    }
}
