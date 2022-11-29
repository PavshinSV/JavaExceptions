package Lesson3.View;

import Lesson3.Model.Person;

import java.io.FileWriter;
import java.io.IOException;

public class ExportMethod implements View {
    @Override
    public void printPerson(Person person) throws RuntimeException {

        try(FileWriter bw = new FileWriter(person.getSurname(),true)) {
            bw.append(person.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка в модуле записи в файл; "+e);
        }
    }
}
