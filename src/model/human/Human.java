package src.model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import model.familyTree.TreeItem;

public class Human implements Serializable, TreeItem<Human> {
    private long id;  // Уникальный идентификатор человека
    private String name;  // Имя человека
    private Gender gender;  // Пол человека (Male или Female)
    private LocalDate birthDate;  // Дата рождения человека
    private LocalDate deathDate;  // Дата смерти человека (null, если человек жив)
    private List<Human> parents;  // Родители человека
    private List<Human> children;  // Дети человека
    private Human spouse;  // Супруг человека

    // Конструктор для создания человека с известными родителями и датой смерти
    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                 Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    // Конструктор для создания человека с известными родителями и неизвестной датой смерти
    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    // Конструктор создания человека с известными родителями и неизвестной датой смерти
    public Human(String name, Gender gender, LocalDate birthDate,
                 Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    public boolean addChild(Human child){ // Добавление ребенка к списку детей
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){ // Добавление родителя к списку родителей
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() { // Получение отца человека
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public Human getMother() { // Получение мамы человека
        for (Human parent: parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public int getAge(){ // Плучение возраста человека
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){ // Разница в годах между двумя датами
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) { // Установка супруга человека
        this.spouse = spouse;
    }

    public Human getSpouse() { // Получение супруга человека
        return spouse;
    }

    public String getName() { // Получение имени человека
        return name;
    }

    public long getId() { // Получение идентификатора человека
        return id;
    }

    public void setId(long id) { // Установка идентификатора человека
        this.id = id;
    }

    public LocalDate getBirthDate() { // Получение даты рождения человека
        return birthDate;
    }

    public LocalDate getDeathDate() { // Получение даты смерти человека
        return deathDate;
    }

    public List<Human> getParents() { // Получение списка родителей человека
        return parents;
    }

    public List<Human> getChildren() { // Получение списка детей человека
        return children;
    }

    public void setBirthDate(LocalDate birthDate) { // Установление даты рождения человека
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {  // Установка даты смерти человека
        this.deathDate = deathDate;
    }

    public Gender getGender() { // Получение пола человека
        return gender;
    }

    @Override
    public String toString() { // Переопределение метода toString для вывода информации о человеке
        return getInfo();
    }

    public String getInfo(){ // Метод для получения подробной информации о человеке
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getSpouseInfo(){ // Получение информации о супруге человека
        String res = "супруг(а): ";
        if (spouse == null){
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo(){ // Получение информации о матери человека
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){ // Получение информации об отце человека
        String res = "отец: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){ // Получение информации о детях человека
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) { // Сравнение объектов Human по идентификатору
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
