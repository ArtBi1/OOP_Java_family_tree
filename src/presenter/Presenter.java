package src.presenter;

import model.Service;
import model.familyTree.FamilyTree;
import model.human.Human;
import model.save.FamilyTreeFileIO;
import view.View;

public class Presenter {
    private View view;

    private Service service;

    public Presenter(View view, FamilyTree<Human> tree) {
        this.view = view;
        service = new Service(tree);
    }

    // Метод для добавления информации о человеке
    public void addHuman(String name, String gender, String birthDate, long idFather, long idMother) {
        String answer = service.addHuman(name, gender, birthDate, idFather, idMother);
        view.print(answer); // Вывод ответа
    }

    public void getHumanList() { // Метод для получения списка людей
        String answer = service.getHumanList();
        view.print(answer); // Вывод списка
    }

    public void sortByName() { // Метод для сортировки списка людей по имени
        service.sortByName(); // Вызов метода для сортировки по имени
    }

    public void sortByBirthDate() { // Метод сорт по ДР
        service.sortByBirthDate();
    }

    public void setFamilyTree(FamilyTree<Human> tree) { // Метод уст древа
        service.setFamilyTree(tree);
    }

    public void save() { // Сохранение
        service.save();
    }

    public void load() { // Загрузка данных
        service.load();
    }

    public void setFileIo(FamilyTreeFileIO fileIo) { // Механизм сохранения/загрузки
        service.setFileIo(fileIo);
    }
}
