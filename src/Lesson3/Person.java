package Lesson3;

import java.util.Date;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private Long phoneNumber;
    private Character sex;
    private String birthDate;

    Person(String surname, String name, String patronymic, Long phoneNumber, char sex, String birthDate){
        this.surname = surname;
        this.name=name;
        this.patronymic=patronymic;
        this.phoneNumber=phoneNumber;
        this.sex = sex;
        this.birthDate = birthDate;
    }
    Person(){
        this.surname = "Anonymous";
        this.name="Anonymous";
        this.patronymic="Anonimovich";
        this.phoneNumber=null;
        this.sex = null;
        this.birthDate = null;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Character getSex() {
        return sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                '}';
    }
}
