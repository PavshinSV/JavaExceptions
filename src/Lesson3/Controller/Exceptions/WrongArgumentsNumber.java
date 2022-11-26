package Lesson3.Controller.Exceptions;

public class WrongArgumentsNumber extends Exception {
    public WrongArgumentsNumber(String message){
        super(message);
    }
}
