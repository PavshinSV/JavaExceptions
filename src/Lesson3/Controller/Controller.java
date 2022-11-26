package Lesson3.Controller;

import Lesson3.Controller.Exceptions.WrongArgumentsNumber;
import Lesson3.Controller.Exceptions.WrongParameter;
import Lesson3.Model.Person;
import Lesson3.View.ExportMethod;
import Lesson3.View.View;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Controller {
    public static Person enterPerson() throws WrongArgumentsNumber, WrongParameter {
        int args = 6;
        HashSet<String> exceptions = new HashSet<>();
        try (Scanner sc = new Scanner(System.in)){
            String str = sc.nextLine();
            String[] strArr = str.split(" ");
            if (strArr.length!=args) {
                throw new WrongArgumentsNumber("Введено неверное количество параметров");
            }
            String surname = null;
            String name = null;
            String patronymic = null;
            Long phone = null;
            String birthDate = null;
            Character sex = null;

            for (String element :
                    strArr) {
                if (element.length()==1 && (element.toLowerCase().equals("m")||element.toLowerCase().equals("f"))){
                    sex = element.toLowerCase().charAt(0);
                } else if (element.matches("^\\d*$")){
                        phone = Long.parseLong(element);
                } else if (element.matches("^\\d{2}\\.\\d{2}\\.\\d{4}$")) {
                        birthDate = element;
                } else if (element.matches("^[А-Я][а-я]*$")) {
                    if (surname == null) {
                        surname = element;
                    } else if (name == null) {
                        name = element;
                    } else if (patronymic == null){
                        patronymic = element;
                    }
                } else throw new WrongParameter("Неверно указанный параметр "+element);
            }
            if (surname == null) {
                exceptions.add("Ошибка при вводе Фамилии");
            }
            if (name == null) {
                exceptions.add("Ошибка при вводе Имени");
            }
            if (patronymic == null) {
                exceptions.add("Ошибка при вводе Отчества");
            }
            if (phone == null) {
                exceptions.add("Ошибка при вводе номера телефона");
            }
            if (sex == null) {
                exceptions.add("Ошибка при вводе пола");
            }
            if (birthDate == null) {
                exceptions.add("Ошибка при вводе даты рождения");
            }
            if (exceptions.size()!=0){
                StringBuilder exceptionString = new StringBuilder();
                Iterator<String> iterator = exceptions.iterator();
                while (iterator.hasNext()){
                    exceptionString.append(iterator.next());
                    if (iterator.hasNext()){
                        exceptionString.append(", ");
                    }
                }
                throw new WrongParameter(exceptionString.toString());

            }
            Person person = new Person(surname, name, patronymic,phone,sex,birthDate);
            return person;
        }
    }

    public static void fileWrite(Person newPerson, View view) {
        view.printPerson(newPerson);
    }
}
