package Lesson2;
//Исключения в программировании и их обработка (семинары)
//Урок 2. Исключения и их обработка
//        1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает
//        введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
//        необходимо повторно запросить у пользователя ввод данных.
//        2. Если необходимо, исправьте данный код (задание 2
//        https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//        3 Дан следующий код, исправьте его там, где требуется (задание 3
//        https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//        4 Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.


import java.util.Optional;
import java.util.Scanner;

public class Lesson2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//  Код к заданию 1
//        Optional<Float> fl = inputFloat();
//        while (fl.isEmpty()){
//            System.out.println("Try again!");
//            fl=inputFloat();
//        }
//        System.out.println("You entered float number: "+fl.get());
//        sc.close();

// Код к заданию 2
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }

    public static Optional inputFloat() {
        System.out.println("Enter float number:");
        Optional<Float> result = Optional.empty();
        try {
            String inp = sc.nextLine();
            result = Optional.of(Float.parseFloat(inp));
        } catch (NumberFormatException e) {
            System.out.println("The number entered is not float\nPlease enter float number!\n");
        }
        return result;
    }
}
