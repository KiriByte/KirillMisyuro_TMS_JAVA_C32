package com.kiribyte.strings;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Дана произвольная строка.
        var rand = new Random();
        char[] chars = new char[rand.nextInt(50) + 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = getRandomChar(rand);
        }
        var str = new String(chars);

        System.out.println(str);
        //1) Вывести длину строки
        System.out.println("String length: " + str.length());

        //2) Разбить строку по любому разделителю и вывести количество элементов
        var subStrings = str.split("[\\W_]+");
        System.out.println(Arrays.toString(subStrings));
        System.out.println("Substrings elements: " + subStrings.length);

        //3) получить подстроку с определенной позиции до конца
        var beginIndex = rand.nextInt(str.length());
        var subString = str.substring(beginIndex);
        System.out.println("Substring from " + beginIndex + " to end: " + subString);

        //4) сделать строку которая будет зеркальна текущей
        System.out.println("Reversed String: " + reverseString(str));

        //Создать произвольный шаблон
        //Сделать строку используя данный шаблон (String.format), вставим некоторые значения
        var dt = LocalDateTime.now();
        var pattern = "DateTime now: %s\nDay: %s\nMonth: %s\nYear: %s";
        var message = String.format(pattern, dt, dt.getDayOfMonth(), dt.getMonth(), dt.getYear());
        System.out.println(message);
    }

    public static char getRandomChar(Random random) {
        return (char) (random.nextInt(95) + ' ');
    }

    public static String reverseString(String str) {
        var sb = new StringBuilder();
        return sb.append(str).reverse().toString();
    }
}