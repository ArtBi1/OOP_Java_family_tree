package src.model.familyTree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends TreeItem<E>> implements Iterator<E> {//Итератор для прохода по элементам FamilyTree
  private List<E> list; // Список элементов
  private int index; // Текущий индекс

  public FamilyTreeIterator(List<E> list){  // Прием списка элементов
    this.list = list;
    index = 0;
  }

  @Override
  public boolean hasNext() { // Проверка наличия следующего элемента
    return index < list.size();
  }

  @Override
  public E next() { // Получение следующего элемента
    return list.get(index++);
  }
}
