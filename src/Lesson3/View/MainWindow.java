package Lesson3.View;

import Lesson3.Model.Person;

import javax.swing.*;

public class MainWindow extends JFrame implements WindowInterface {

    private JFrame frame;

    public MainWindow() {
        setTitle("Продвинутая работа с исключениями в Java");
        JButton button = new JButton("Ok");
        button.setBounds(400, 100, 115, 55);
        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setLayout(null);
        setVisible(true);


//        System.out.println("Введите, через пробел, ФИО, телефон (без разделителей и спецсимволов, только цифры), дату рождения(dd.mm.YYYY) и пол (f-женский, m-мужской)");
//        System.out.println("Например: Иванов Иван Иванович 79504278456 01.01.2001 m");
    }

    @Override
    public void printPerson(Person person) {
        // TODO: 26.11.2022
    }

    @Override
    public void showErrorMessage() {
        // TODO: 26.11.2022
    }
}