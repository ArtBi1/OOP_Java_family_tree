package src.model.familyTree;

import java.util.Iterator;
import java.util.List;

// Итератор для прохода по элементам FamilyTree
public class FamilyTreeIterator<E extends TreeItem<E>> implements Iterator<E> {
  private List<E> list; // Список элементов
  private int index; // Текущий индекс

  public FamilyTreeIterator(List<E> list){ // Конструктор, принимающий список элементов
    this.list = list;
    index = 0;
  }

  @Override
  public boolean hasNext() { // Метод для проверки наличия следующего элемента
    return index < list.size();
  }

  @Override
  public E next() { // Для получения следующего элемента
    return list.get(index++);
  }
}

