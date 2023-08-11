package src.model.save;

import model.familyTree.FamilyTree;
import model.human.Human;

import java.io.IOException;

public interface FamilyTreeFileIO {
    String filename = "family_tree_data.ser";  // Имя файла по умолчанию для сохранения и загрузки

    // Метод для сохранения древа в файл
    void saveToFile(FamilyTree<Human> familyTree, String filename) throws IOException;

    // Метод для загрузки древа из файла
    FamilyTree<Human> loadFromFile(String filename) throws IOException, ClassNotFoundException;
}
