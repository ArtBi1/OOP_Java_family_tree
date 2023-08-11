package src.view;

import java.time.LocalDate;
import java.util.Scanner;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.save.FamilyTreeFileIO;
import presenter.Presenter;

public class Console implements View {
    private Presenter presenter;
    private boolean work;
    private Scanner scanner;
    private Menu menu;

    public Console() { // Конструктор класса
        presenter = new Presenter(this, null);
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
    }

    @Override
    public void start() { // Реализация метода start() интерфейса View
        while (work) {
            System.out.println(menu.print()); // Вывод меню на консоль
            String choice = scanner.nextLine(); // Чтение выбора пользователя
            menu.execute(choice); // Выполнение выбранной опции меню
        }
    }

    @Override
    public void exit() { // Реализация метода exit() интерфейса View
        work = false;
        System.out.println("Программа завершена.");
    }

    @Override
    public void print(String text) { // Реализация метода print() интерфейса View
        System.out.println(text); // Вывод текста в консоли
    }

    public void setFamilyTree(FamilyTree<Human> tree) { // Установка семейного дерева
        presenter.setFamilyTree(tree);
    }

    public void getHumanList() { // Получение списка людей через презентера
        presenter.getHumanList();
    }

    // Добавление информации о человеке через презентера
    public void addHuman(String name, Gender gender, LocalDate birthDate, long idFather, long idMother) {
        String genderString = gender.toString();
        String birthDateString = birthDate.toString();
        presenter.addHuman(name, genderString, birthDateString, idFather, idMother);
    }

    // Сортировка списка по имени через презентера
    public void sortByName() {
        presenter.sortByName();
        getHumanList();
    }

    // Сортировка списка по дате рождения через презентера
    public void sortByBirthDate() {
        presenter.sortByBirthDate();
        getHumanList();
    }

    // Сохранение данных через презентера
    public void save() {
        presenter.save();
    }

    // Загрузка данных через презентера
    public void load() {
        presenter.load();
    }

    // Установка механизма сохранения/загрузки через презентера
    public void setFileIo(FamilyTreeFileIO fileIo) {
        presenter.setFileIo(fileIo);
    }
}
