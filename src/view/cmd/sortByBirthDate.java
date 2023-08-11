package src.view.cmd;

import view.Console;

public class sortByBirthDate { // Класс sortByBirthDate - команда для сортировки по дате рождения
    private Console console;

    public sortByBirthDate(Console console) { // Конструктор класса
        this.console = console;
    }

    public String getDescription() { // Описание команды
        return "Отсортировать по дате рождения";
    }

    public void execute() { // Метод для выполнения команды сортировки по дате рождения
        console.sortByBirthDate();
    }
}
