package src.model.human;

import java.util.Comparator;

import model.familyTree.TreeItem;

// Компаратор для сравнения объектов по имени
public class ComporatorByName<E extends TreeItem<E>> implements Comparator<E> {

  @Override
  public int compare(E o1, E o2){ // Сравнивает два объекта по имени
    return o1.getName().compareTo(o2.getName());
  }
}
