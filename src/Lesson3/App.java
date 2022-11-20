package Lesson3;

import Lesson3.Exceptions.WrongArgumentsNumber;
import Lesson3.Exceptions.WrongParameter;

public class App {
    public static void start() {
        //while (true) {
            try{
                Person newPerson = Controller.enterPerson();
                System.out.println("Введенные данные корректны. Приступаем к формированию записи ...");
                System.out.println(newPerson);
                Controller.fileWrite(newPerson);
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            } catch (WrongArgumentsNumber e) {
                System.out.println(e.getMessage());
            } catch (WrongParameter e) {
                System.out.println(e.getMessage());
            }
        //}
    }
}
