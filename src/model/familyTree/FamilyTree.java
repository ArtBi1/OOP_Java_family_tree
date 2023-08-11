package src.model.familyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.human.ComparatorByBirthDate;
import model.human.ComporatorByName;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E> { // Представляет семейное дерево
    private long humansId; // Счетчик для генерации уникальных идентификаторов людей
    private List<E> humanList; // Список объектов в дереве

    public FamilyTree() { // Конструктор по умолчанию
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) { // Конструктор, принимающий список объектов в дереве
        this.humanList = humanList;
    }

    public boolean add(E human) { // Метод для добавления объекта в дерево
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    public E getPersonByName(String name) { // Получение объекта по имени
        for (E person : humanList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    private void addToParents(E human) {// Приватные методы для обновления связей в дереве
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getSiblings(int id) { // Получение списка братьев и сестер по идентификатору
        E human = getById(id);
        if (human == null) {
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name) { // Получение списка объектов по имени
        List<E> res = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2) { // Установка брака между объектами
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setDivorce(long humanId1, long humanId2) { // Развод между объектами
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            if (human1.getSpouse() != null && human2.getSpouse() != null) {
                human1.setSpouse(null);
                human2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(long humansId) { // Удаление объекта по идентификатору
        if (checkId(humansId)) {
            E e = getById(humansId);
            return humanList.remove(e);
        }
        return false;
    }

    private boolean checkId(long id) { // Приватный, для проверки валидности идентификатора
        if (id >= humansId || id < 0) {
            return false;
        }
        for (E human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public E getById(long id) { // Получение объекта по идентификатору
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<E> getPeople() { // Получение списка объектов в дереве
        return humanList;
    }

    @Override
    public String toString() { // Переопределение метода тоСтринг()
        return getInfo();
    }

    @Override
    public Iterator<E> iterator() { // Переопределение итератора
        return new FamilyTreeIterator<>(humanList);
    }

    public void sortByName() {// Сортировка по имени
        humanList.sort(new ComporatorByName<>());
    }

    public void sortByBirthDate() {// Сортировка по ДР
        humanList.sort(new ComparatorByBirthDate<>());
    }

    public String getInfo() { // Метод для получения информации о дереве
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
