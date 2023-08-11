package src.view.cmd;

import view.Console;

public class getList { // Класс getList - команда для получения списка людей
    private Console console;

    public getList(Console console) { // Прием с консоли
        this.console = console;
    }

    public String getDescription() { // Описание команды
        return "Получить список людей";
    }

    public void execute() { // Метод для выполнения команды получения списка людей
        console.getHumanList(); // Вызов метода getHumanList() в объекте консоли
    }
}
