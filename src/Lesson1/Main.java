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
//       4*. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
//        каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов
//        не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение,
//        которое пользователь может увидеть - RuntimeException, т.е. ваше


public class Main {
    public static void main(String[] args) {
        int a = 12;
        int b = 0;
        Integer[] arr = {1, 2, null, 4, 5};
        //dividedByZero(a,b);
        //arraySizeBound(arr);
        //nullPointer(arr);
        Integer[][] arr1 = {{10, 20, 30}, {20, 30, 40}, {30, 40, 50}};
        Integer[][] arr2 = {{1, 2, 3}, {2, 3, 40}, {3, 4, 5}};
        Integer[][] arr3 = arrayDiff(arr1, arr2);
        Integer[][] arr4 = arrayDivided(arr1, arr3);
    }

    private static Integer[][] arrayDivided(Integer[][] arr1, Integer[][] arr2) throws RuntimeException {
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) {
            throw new RuntimeException("array sizes not equals");
        }
        Integer[][] temp = new Integer[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr2[i][j]==0) throw new RuntimeException("Number in arr2 is ZERO! We can not divided by zero!!!");
                temp[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        return new Integer[][]{{1}, {1}};
    }

    private static Integer[][] arrayDiff(Integer[][] arr1, Integer[][] arr2) throws RuntimeException {
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) {
            throw new RuntimeException("array sizes not equals");
        }
        Integer[][] temp = new Integer[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                temp[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        return temp;
    }

    private static void nullPointer(Integer[] arr) {
        for (Integer item :
                arr) {
            int q = item * 2;
            System.out.println(q);
        }
    }

    private static void arraySizeBound(Integer[] arr) {
        System.out.println(arr[arr.length]);
    }

    private static void dividedByZero(int a, int b) {
        System.out.println(a / b);
    }
}