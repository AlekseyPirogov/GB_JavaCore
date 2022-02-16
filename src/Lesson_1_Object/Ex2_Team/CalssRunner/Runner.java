package Lesson_1_Object.Ex2_Team.CalssRunner;

import Lesson_1_Object.Ex2_Team.ChildRunner.Dog;
import Lesson_1_Object.Ex2_Team.ChildRunner.Human;
import Lesson_1_Object.Ex2_Team.ChildRunner.Robot;
import Lesson_1_Object.Ex2_Team.ChildRunner.Tiger;
import Lesson_1_Object.Ex3_Course.Barrier;
import Lesson_1_Object.Ex3_Course.Track;
import Lesson_1_Object.Ex3_Course.Course;

public abstract class Runner implements Run, Jump {

    // Перечень атрибутов принадлежащих контексту класса:
    public String name;            // наименование участника
    public int age;                // возраста в месяцах
    public String color;           // окраска
    public int maxDistance;        // максимальная дистанция для бега
    public int remainsDistance;    // оставшийся запас сил для бега, потенциально возможное для бега расстояние
    public int maxHeight;          // максимальная высота для прыжка
    public boolean takePart;       // статус принятия участия в забеге
    public int currentPalace;      // текущее место или место где остановился учатники данного типа

    // Метод экземпляра класса для размещения текущего объекта в массиве объектов
    final public void putMeInArray(Object[] arrayWithObjects, int arrayIndex) {
        arrayWithObjects[arrayIndex] = this;
    }

    //
    public boolean showObject() {
        if (this instanceof Dog) {
            System.out.println("Создан объект класса \"Dog\"... ");
        } else if (this instanceof Human) {
            System.out.println("Создан объект класса \"Human\"... ");
        } else if (this instanceof Robot) {
            System.out.println("Создан объект класса \"Robot\"... ");
        } else if (this instanceof Tiger) {
            System.out.println("Создан объект класса \"Tiger\"... ");
        }
        if ((this instanceof Dog) || (this instanceof Tiger)) {
            System.out.println("Характеристики объекта:" +
                    "\n - имя: " + getName() +
                    "\n - возраст: " + getAge() + " мес., в годах - " + (getAge() / 12) +
                    "\n - окрас: " + getColor() +
                    "\n - максимальное расстояние для бега: " + getMaxDistance() + " см." +
                    "\n - максимальная высота для прыжка: " + getMaxHeight() + " см.\n");
        } else {
            System.out.println("Характеристики объекта:" +
                    "\n - имя: " + getName() +
                    "\n - возраст: " + getAge() + " мес., в годах - " + (getAge() / 12) +
                    "\n - максимальное расстояние для бега: " + getMaxDistance() + " см." +
                    "\n - максимальная высота для прыжка: " + getMaxHeight() + " см.\n");
        }

        return true;
    }

    // Набор геттеров и сеттеров для ввода данных в поля соответсвующие атрибутам объекта
    // набор методов для работы с полями "name":
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // набор методов для работы с полем "age":
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <=0 )
            System.out.println("Введено некорректное значение возраста.");
        else
            this.age = age;
    }

    // набор методов для работы с полем "color":
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // набор методов для работы с полем "maxDistance":
    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        if (maxDistance <= 0) {
            System.out.println("Введено некорректное значение для максимальной дистации для бега!");
        } else {
            this.maxDistance = maxDistance;
        }
    }

    // Набор методов для работы с полем "remainsDistance":
    public int getRemainsDistance() {
        return remainsDistance;
    }

    public void setRemainsDistance(int remainsDistance) {
        this.remainsDistance = remainsDistance;
    }

    // Набор методов для работы с полем "maxHeight":
    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        if (maxDistance <= 0) {
            System.out.println("Введено некорректное значение для максимальной высоты прыжка!");
        } else {
            this.maxHeight = maxHeight;
        }
    }

    // Набор методов для работы с полем "takePart":
    public boolean getTakePart() {
        return takePart;
    }

    public void setTakePart(boolean takePart) {
        this.takePart = takePart;
    }

    // набор методов для работы с полем "currentPlace":
    public int getCurrentPalace() {
        return currentPalace;
    }

    public void setCurrentPalace(int currentPalace) {
        this.currentPalace = currentPalace;
    }

    // Набор переопределённых методов для преодоления препятствий:
    // Метод для бега
    @Override
    public void run(Track track) {
        if (this.takePart == true) {
            if (track.getLengthTrack() > this.getMaxDistance()) {
                System.out.print("Участник \"" + this.getName() + "\" не может пробежать сектор № " + track.getNumberTrack() + ", длина сектора для бега "
                        + track.getLengthTrack() +  " м., что больше максимальной длины бега (" + this.getMaxDistance() + " м.). ");
                this.setTakePart(false);
                this.setCurrentPalace(track.getNumberTrack());
                System.out.println("Участник \"" + this.getName() + "\" выбыл из соревнований, остановился на отрезке № " + this.getCurrentPalace() + "...");
            } else {
                if ((this.getRemainsDistance() - track.getLengthTrack()) <= 0) {
                    System.out.println("Участник \"" + this.getName() + "\" выбыл из соревнований, остановился на отрезке № " + this.getCurrentPalace() + "...");
                    this.setTakePart(false);
                } else {
                    this.setRemainsDistance(this.getRemainsDistance() - track.getLengthTrack());
                    //this.remainsDistance -= track.getLengthTrack();
                    System.out.println("Участник \"" + this.getName() + "\" пробежал сектор № " + track.getNumberTrack() + " с длиной " + track.getLengthTrack() +
                            " м. Максимальная длина бега " + this.getMaxDistance() + " м., выносливости хватит чтобы пробежать ещё " + this.getRemainsDistance() + " м.");
                }
            }
        }
    }

    // Метод для прыжка
    @Override
    public void jump(Barrier barrier) {
        if (this.getTakePart() == true) {
            if (barrier.getHeight() > this.getMaxHeight()) {
                this.setTakePart(false);
                this.setCurrentPalace(barrier.getNumberWall());
                System.out.println("Участник \"" + this.getName() + "\" не может перепрыгнуть препятствие " + barrier.getNumberWall() +". Высота препятствия " + barrier.getHeight() + " см., а максимальная высота прыжка - " + this.getMaxHeight() + " см.");
                System.out.println("Участник \"" + this.getName() + "\" участник выбыл из соревнований... Остановился на отрезке №" + this.getCurrentPalace() + " где-то перед препятствием.");
            } else {
                System.out.println("Участник \"" + this.getName() + "\" перепрыгнул препятсвие " + barrier.getNumberWall() + " c высотой " + barrier.getHeight() +
                        " см., максимальная высота прыжка - " + this.getMaxHeight() + " см.");
                this.setCurrentPalace(barrier.getNumberWall() + 1);
            }
        }
    }

    // Абстрактный метод класса Runner
    abstract public String voice();
}
