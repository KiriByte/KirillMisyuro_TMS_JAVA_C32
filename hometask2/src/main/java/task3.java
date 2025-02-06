import java.util.Scanner;

//Пользователь вводит два числа. Необходимо найти среднее арифметическое между заданными числами (сумма чисел / количество чисел)
public class task3 {
    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int sum = 0;
        int countNum = 0;
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = a; i <= b; i++) {
            sum += i;
            countNum++;
        }
        float avg = (float) sum / countNum;
        System.out.println("Average between " + a + " and " + b + " = " + avg);
    }
}
