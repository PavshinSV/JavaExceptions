package Lesson3.View;

import Lesson3.Model.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportMethod implements View {
    @Override
    public void printPerson(Person person) throws RuntimeException {
        String fileName = person.getSurname();
        File dir = new File("./");
        File[] arrFiles = dir.listFiles();
        for (File file: arrFiles){
            System.out.println(file.toString().replace(dir.toString()+"\\",""));
        }

        try(FileWriter bw = new FileWriter(person.getSurname(),true)) {
            bw.append(person.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка в модуле записи в файл; "+e);
        }
    }
}
