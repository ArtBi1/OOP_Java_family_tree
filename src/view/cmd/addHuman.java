package src.view.cmd;

import view.Console;
import model.human.Gender;

import java.time.LocalDate;
import java.util.Scanner;

public class addHuman { // Класс addHuman - команда для добавления человека через консоль
    private Console console;

    public addHuman(Console console) {// Конструктор класса, принимающий объект консоли
        this.console = console;
    }

    public String getDescription() {// Метод для получения описания команды
        return "Добавить человека";
    }

    public void execute() { // Метод для выполнения команды добавления человека
        Scanner scanner = new Scanner(System.in);
        
        // Запрос данных у пользователя
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите пол (Male/Female): ");
        String genderString = scanner.nextLine();
        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        String birthDateString = scanner.nextLine();
        System.out.print("Введите ID отца (если известно, иначе введите -1): ");
        long idFather = scanner.nextLong();
        System.out.print("Введите ID матери (если известно, иначе введите -1): ");
        long idMother = scanner.nextLong();
        scanner.nextLine(); // Очистка
        
        // Преобразование данных и передача команды
        Gender gender = Gender.valueOf(genderString);
        LocalDate birthDate = LocalDate.parse(birthDateString);
        console.addHuman(name, gender, birthDate, idFather, idMother);
    }
}
