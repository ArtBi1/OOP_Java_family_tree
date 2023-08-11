package src.view;

import java.util.ArrayList;
import java.util.List;

import view.commands.addHuman;
import view.commands.exit;
import view.commands.getList;
import view.commands.saveToFile;
import view.commands.sortByBirthDate;
import view.commands.sortByName;

public class Menu {
    private List<getList> list; // Список команд для меню
    
    private addHuman addHumanCmd;// Команды для выполнения действий
    private sortByName sortByNameCmd;
    private sortByBirthDate sortByBirthDateCmd;
    private saveToFile saveToFile;
    private exit exit;

    public Menu(Console console) {// Конструктор класса Menu
        list = new ArrayList<>();
        list.add(new getList(console));// Добавление команды для получения списка

        sortByBirthDateCmd = new sortByBirthDate(console);// Инициализация остальных команд
        sortByNameCmd = new sortByName(console);
        addHumanCmd = new addHuman(console);
        saveToFile = new saveToFile(console);
        exit = new exit(console);
    }

    public String print() { // Генерация текста меню
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription()); // Описание команды
            stringBuilder.append("\n");
        }
        // Добавление остальных команд к меню
        stringBuilder.append(list.size() + 1);
        stringBuilder.append(". ");
        stringBuilder.append(addHumanCmd.getDescription());
        stringBuilder.append("\n");

        stringBuilder.append(list.size() + 2);
        stringBuilder.append(". ");
        stringBuilder.append(sortByNameCmd.getDescription());
        stringBuilder.append("\n");

        stringBuilder.append(list.size() + 3);
        stringBuilder.append(". ");
        stringBuilder.append(sortByBirthDateCmd.getDescription());
        stringBuilder.append("\n");

        stringBuilder.append(list.size() + 4);
        stringBuilder.append(". ");
        stringBuilder.append(saveToFile.getDescription());
        stringBuilder.append("\n");

        stringBuilder.append(list.size() + 5);
        stringBuilder.append(". ");
        stringBuilder.append(exit.getDescription());
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    public void execute(String choice) { // Выполнение выбранной команды
        int index = Integer.parseInt(choice) - 1;

        if (index == list.size()) {
            addHumanCmd.execute();
        } else if (index == list.size() + 1) {
            sortByNameCmd.execute();
        } else if (index == list.size() + 2) {
            sortByBirthDateCmd.execute();
        } else if (index == list.size() + 3) {
            saveToFile.execute();
        } else if (index == list.size() + 4) {
            exit.execute();
        } else {
            list.get(index).execute();
        }
    }
}
