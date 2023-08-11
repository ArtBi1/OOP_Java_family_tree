package src.view;

import model.familyTree.FamilyTree;
import model.human.Human;
import model.save.FamilyTreeFileIO;

public interface View { // Для пользовательских интерфейсов
    void start(); // Метод для запуска пользовательского интерфейса
    
    public void setFamilyTree(FamilyTree<Human> tree);// Метод для установки семейного дерева
    
    void print(String text);// Метод для вывода текстовой информации
    
    public void setFileIo(FamilyTreeFileIO fileIo);// Метод для установки механизма сохранения/загрузки
    
    void exit();// Метод для завершения работы пользовательского интерфейса
}
