import model.Service;
import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.save.FamilyTreeFileIO;
import model.save.FamilyTreeFileManager;
import view.Console;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Human> tree = new FamilyTree<>(); // Создание объекта FamilyTree для хранения информации о с.дереве

        Human vanya = new Human("Ваня", Gender.Male, LocalDate.of(1963, 12, 10)); // Создание объектов Human для 
        Human katya = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15)); // представления членов семьи
        Human olya = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5), // с различными данными
                vanya, katya); // Оля - дочь Вани и Кати
        Human igor = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25),
                vanya, katya); // Игорь - сын Вани и Кати

        tree.add(vanya);// Добавление объектов Human в семейное дерево
        tree.add(katya);
        tree.add(olya);
        tree.add(igor);

        // Создание и добавление бабушки в семейное дерево
        Human grandMother = new Human("Маша", Gender.Female, LocalDate.of(1945, 9, 1));
        grandMother.addChild(vanya); // Внесение Василия как ребенка бабушки

        tree.add(grandMother);

// Создание объекта FamilyTreeFileIO для сохранения и загрузки данных
        FamilyTreeFileIO fileIo = new FamilyTreeFileManager();

        Service service = new Service(tree); // Создание объекта Service для управления семейным деревом
        service.setFileIo(fileIo);

        tree = service.load(); // Загрузка данных о семейном дереве из файла

        View view = new Console(); // Создание объекта View для взаимодействия с пользователем через консоль
        view.setFileIo(fileIo);
        view.setFamilyTree(tree);

        view.start();// Запуск консольного взаимодействия с пользователем
    }
}
