package src.view.cmd;

import view.Console;

public class exit { // Класс exit - команда для завершения программы
    private Console console;

    public exit(Console console) {// Принимающий объект
        this.console = console;
    }

    public String getDescription() { // Получение описания
        return "Завершить программу";
    }

    public void execute() { // Завершение программиы
        console.exit(); 
    }
}
