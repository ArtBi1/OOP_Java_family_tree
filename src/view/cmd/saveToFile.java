package src.view.cmd;

import view.Console;

public class saveToFile { // Для сохранения дерева в файл
    private Console console;

    public saveToFile(Console console) { // Прием из консоли 
        this.console = console;
    }

    public String getDescription() { // Описание команды
        return "Сохранить дерево в файл";
    }

    public void execute() { // Метод для выполнения сохранения
        console.save();
    }
}

