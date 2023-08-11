package src.model.save;

import model.familyTree.FamilyTree;
import model.human.Human;

import java.io.*;

public class FamilyTreeFileManager implements FamilyTreeFileIO {

  // Метод для сохранения дерева в файл
  @Override
  public void saveToFile(FamilyTree<Human> familyTree, String filename) throws IOException {
    try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filename))) {
      objOut.writeObject(familyTree);  // Запись объекта семейного дерева в файл
      System.out.println("Семейное дерево успешно сохранено в файл " + filename);
    }
  }

  // Метод для загрузки дерева из файла
  @Override
  public FamilyTree<Human> loadFromFile(String filename) throws IOException, ClassNotFoundException {
    try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(filename))) {
      FamilyTree<Human> familyTree = (FamilyTree<Human>) objIn.readObject(); // Чтение объекта дерева из файла
      System.out.println("Семейное дерево успешно загружено из файла " + filename);
      return familyTree; // Возвращение загруженного дерева
    }
  }
}
