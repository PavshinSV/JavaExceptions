package Lesson3;

import Lesson3.Exceptions.WrongArgumentsNumber;
import Lesson3.Exceptions.WrongParameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    public static Person enterPerson() throws WrongArgumentsNumber, WrongParameter {
        int args = 6;
        System.out.println("Введите, через пробел, ФИО, телефон (без разделителей и спецсимволов, только цифры), дату рождения(dd.mm.YYYY) и пол (f-женский, m-мужской)");
        System.out.println("Например: Иванов Иван Иванович 79504278456 01.01.2001 m");
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
                throw new WrongParameter("Ошибка при вводе Фамилии");
            }
            if (name == null) {
                throw new WrongParameter("Ошибка при вводе Имени");
            }
            if (patronymic == null) {
                throw new WrongParameter("Ошибка при вводе Отчества");
            }
            if (phone == null) {
                throw new WrongParameter("Ошибка при вводе номера телефона");
            }
            if (sex == null) {
                throw new WrongParameter("Ошибка при вводе пола");
            }
            if (birthDate == null) {
                throw new WrongParameter("Ошибка при вводе даты рождения");
            }
            Person person = new Person(surname, name, patronymic,phone,sex,birthDate);
            return person;
        }
    }

    public static void fileWrite(Person newPerson) {
        //todo
    }
}
