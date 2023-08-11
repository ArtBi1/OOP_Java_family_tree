package src.model.human;

import java.util.Comparator;

import model.familyTree.TreeItem;

// Класс ComparatorByBirthDate реализует компаратор для сравнения объектов по дате рождения
public class ComparatorByBirthDate<E extends TreeItem<E>> implements Comparator<E> {
  
    @Override
  public int compare(E o1, E o2){// Сравнивает два объекта по дате рождения
    return o2.getBirthDate().compareTo(o1.getBirthDate());
  }
}
