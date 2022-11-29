package Lesson3.View;

import Lesson3.Controller.Controller;
import Lesson3.Controller.Exceptions.WrongArgumentsNumber;
import Lesson3.Controller.Exceptions.WrongParameter;
import Lesson3.Model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements WindowInterface {

    private JFrame frame;
    private View fileWr = new ExportMethod();

    public MainWindow() {
        frame = new JFrame();
        frame.setTitle("Продвинутая работа с исключениями в Java");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel headingPanel = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.insets=new Insets(5,5,5,5);
        con.anchor = GridBagConstraints.NORTH;
        con.gridx=0; con.gridy=0;
        con.gridwidth=2;
        JLabel headingLabel = new JLabel("Введите, через пробел, ФИО, телефон (без разделителей и спецсимволов, " +
                "только цифры), дату рождения(dd.mm.YYYY) и пол (f-женский, m-мужской)");
        JLabel headingLabel2 = new JLabel("Например: Иванов Иван Иванович 79504278456 01.01.2001 m");
        headingPanel.add(headingLabel,con);
        con.gridx=0; con.gridy=1;
        con.gridwidth=2;
        headingPanel.add(headingLabel2,con);
        JTextField inputField = new JTextField(80);
        con.gridx=0; con.gridy=2;
        con.gridwidth=2;
        headingPanel.add(inputField,con);

        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Person p = Controller.enterPerson(inputField.getText());
                    printPerson(p);
                    inputField.setText("");
                } catch (WrongArgumentsNumber ex) {
                    showErrorMessage(ex.getMessage());
                } catch (WrongParameter ex) {
                    showErrorMessage(ex.getMessage());
                }
             }
        });
        con.gridx=0; con.gridy=3;
        con.gridwidth=2;
        headingPanel.add(button,con);
        mainPanel.add(headingPanel);
        frame.add(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void printPerson(Person person) {
        try {
            fileWr.printPerson(person);
            JFrame personFrame = new JFrame();
            JPanel personPanel = new JPanel(new GridBagLayout());
            GridBagConstraints personCon = new GridBagConstraints();
            personCon.insets=new Insets(5,5,5,5);
            personCon.gridy=0;
            JLabel header = new JLabel("Запись успешно добавлена!");
            personPanel.add(header,personCon);
            personCon.gridy=1;
            JLabel surname = new JLabel("Фамилия: "+person.getSurname());
            personPanel.add(surname,personCon);
            personCon.gridy=2;
            JLabel name = new JLabel("Имя: "+person.getName());
            personPanel.add(name,personCon);
            personCon.gridy=3;
            JLabel patronymic = new JLabel("Отчество: "+person.getPatronymic());
            personPanel.add(patronymic,personCon);
            personCon.gridy=4;
            JLabel phone = new JLabel("Телефон: "+person.getPhoneNumber());
            personPanel.add(phone,personCon);
            personCon.gridy=5;
            JLabel birthdate = new JLabel("Дата рождения: "+person.getBirthDate());
            personPanel.add(birthdate,personCon);
            personCon.gridy=6;
            JLabel sex = new JLabel("Пол: "+person.getSex());
            personPanel.add(sex,personCon);
            personCon.gridy=7;
            JButton personButton = new JButton("Ok");
            personPanel.add(personButton,personCon);

            personButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    personFrame.setVisible(false);
                }
            });

            personFrame.add(personPanel);
            personFrame.setSize(400,400);
            personFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            personFrame.setLocationRelativeTo(null);
            personFrame.setVisible(true);




        } catch (RuntimeException ex) {
            showErrorMessage(ex.getMessage());
        }
    }

    @Override
    public void showErrorMessage(String str) {
        JFrame errorFrame = new JFrame();
        errorFrame.setSize(400,100);
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        errorFrame.setLocationRelativeTo(null);
        JPanel errorPanel = new JPanel(new GridBagLayout());
        JLabel errorLabel = new JLabel(str);
        JButton okButton = new JButton("Ok");
        GridBagConstraints bag = new GridBagConstraints();
        bag.insets= new Insets(5,5,5,5);
        bag.gridy=0;
        errorPanel.add(errorLabel,bag);
        bag.gridy=1;
        errorPanel.add(okButton,bag);
        errorFrame.add(errorPanel);
        errorFrame.setVisible(true);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorFrame.setVisible(false);
            }
        });
    }
}