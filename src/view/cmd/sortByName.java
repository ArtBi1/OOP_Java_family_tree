package src.view.cmd;

import view.Console;

public class sortByName { // Класс для сортировки по имени
    private Console console;

    public sortByName(Console console) { // Конструктор класса, принимает объект консоли
        this.console = console;
    }

    public String getDescription() { // Метод для получения описания команды
        return "Отсортировать по имени";
    }

    public void execute() { // Метод для выполнения команды сортировки по имени
        console.sortByName();
    }
}
