package Lesson3.Controller;

import Lesson3.Controller.Exceptions.WrongArgumentsNumber;
import Lesson3.Controller.Exceptions.WrongParameter;
import Lesson3.Model.Person;
import Lesson3.View.ExportMethod;
import Lesson3.View.MainWindow;
import Lesson3.View.View;
import Lesson3.View.WindowInterface;

public class App {
    public static void start() {
        View view = new MainWindow();
        View fileWr = new ExportMethod();

//        try {
//            Person newPerson = Controller.enterPerson();
//            System.out.println("Введенные данные корректны. Приступаем к формированию записи ...");
//            System.out.println(newPerson);
//            Controller.fileWrite(newPerson);
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        } catch (WrongArgumentsNumber e) {
//            System.out.println(e.getMessage());
//        } catch (WrongParameter e) {
//            System.out.println(e.getMessage());
//        }
        Controller.fileWrite(new Person(),fileWr);

    }
}
