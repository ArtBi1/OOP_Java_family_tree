package src.model;

import java.io.IOException;
import java.time.LocalDate;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.save.FamilyTreeFileIO;

public class Service {
  private FamilyTree<Human> tree;  // Древо с объектами класса Human
  private FamilyTreeFileIO fileIo;  // Объект для работы с сохранением/загрузкой дерева

  // Конструктор для инициализации сервиса с указанием древа
  public Service(FamilyTree<Human> tree) {
    this.tree = tree;
  }

  // Конструктор для инициализации сервиса с указанием объекта для сохранения/загрузки
  public Service(FamilyTreeFileIO fileIo) {
    this.fileIo = fileIo;
  }

  // Метод для добавления человека в древо с указанными характеристиками
  public String addHuman(String name, String genderString, String birthDate, long idFather, long idMother) {
    Human father = tree.getById(idFather);
    Human mother = tree.getById(idMother);
    Gender gender = Gender.valueOf(genderString);
    LocalDate humanBirthDate = LocalDate.parse(birthDate);
    Human human = new Human(name, gender, humanBirthDate, father, mother);
    tree.add(human);
    return "Человек успешно добавлен в дерево";
  }

  // Метод для установки древа
  public void setFamilyTree(FamilyTree<Human> tree) {
    this.tree = tree;
  }

  // Метод для сортировки древа по имени
  public void sortByName() {
    tree.sortByName();
  }

  // Метод для сортировки древа по дате рождения
  public void sortByBirthDate() {
    tree.sortByBirthDate();
  }

  // Метод для получения информации о списках людей в древе
  public String getHumanList() {
    return tree.getInfo();
  }

  // Метод для сохранения древа в файл
  public void save() {
    try {
      fileIo.saveToFile(tree, FamilyTreeFileIO.filename);
    } catch (IOException e) {
      System.err.println("Ошибка при сохранении дерева: " + e.getMessage());
    }
  }

  // Метод для загрузки древа из файла
  public FamilyTree<Human> load() {
    try {
      return fileIo.loadFromFile(FamilyTreeFileIO.filename);
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Ошибка при загрузке дерева: " + e.getMessage());
      return null;
    }
  }

  // Метод для установки объекта для сохранения/загрузки
  public void setFileIo(FamilyTreeFileIO fileIo) {
    this.fileIo = fileIo;
  }
}
