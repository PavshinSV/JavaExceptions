package Lesson1;

//Урок 1. Обработка ошибок в программировании
//        1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
//
//        2. Посмотрите на код, и подумайте и напишите сколько разных типов исключений вы тут сможете получить?
//        код в материалах
//
//        3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
//        каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов
//        не равны, необходимо как-то оповестить пользователя.
//
//        4*. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый
//        массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины
//        массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное
//        исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше


public class Main {
    public static void main(String[] args) {
        int a =12;
        int b = 0;
        Integer[] arr = {1,2,null,4,5};
        //dividedByZero(a,b);
        //arraySizeBound(arr);
        //nullPointer(arr);
    }

    private static void nullPointer(Integer[] arr) {
        for (Integer item :
                arr) {
            int q = item*2;
            System.out.println(q);
        }
    }

    private static void arraySizeBound(Integer[] arr) {
        System.out.println(arr[arr.length]);
    }

    private static void dividedByZero(int a, int b) {
        System.out.println(a/b);
    }
}