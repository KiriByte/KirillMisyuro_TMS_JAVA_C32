import net.datafaker.Faker;
import org.tms.classes.model.Cat;
import org.tms.classes.model.Dog;
import org.tms.classes.model.Student;
import org.tms.classes.service.NameExtractorService;
import org.tms.classes.service.StudentService;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Создать метод который принимает два целых числа. Данный метод должен вернуть максимальное число.
        var random = new Random();
        var a = random.nextInt(100);
        var b = random.nextInt(100);
        System.out.println("Max value between " + a + " and " + b + " is " + Max(a, b));

        //Необходимо создать два перегруженных метода print. Один метод принимает обьект Cat, а второй объект Dog. Каждый из методов должен вернуть кличку животного.
        var cat = new Cat("catdog");
        var dog = new Dog("dogcat");
        var nameExtractor = new NameExtractorService();
        System.out.println("The name of the cat is " + nameExtractor.print(cat));
        System.out.println("The name of the dog is " + nameExtractor.print(dog));

        //Необходимо создать объект Student со следующими полями: имя студента, возраст студента, номер группы
        //Создать StudentService класс, с методом который принимает массив студентов и номер группы. Данный метод должен вернуть количество студентов, которые относятся к данной группе.
        Student[] students = new Student[50];
        var dataFaker = new Faker();
        for (var i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].setName(dataFaker.name().fullName());
            students[i].setAge(dataFaker.number().numberBetween(18, 25));
            students[i].setNumberGroup(dataFaker.number().numberBetween(1, 5));
        }

        var studentService = new StudentService();
        var groupNumber = 4;
        var countStudentInGroup = studentService.getCountStudentsInGroup(students, groupNumber);
        System.out.println("Group " + groupNumber + " has " + countStudentInGroup + " students");


    }

    public static int Max(int a, int b) {
        return a > b ? a : b;
    }
}


