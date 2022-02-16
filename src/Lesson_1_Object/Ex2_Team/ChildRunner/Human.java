package Lesson_1_Object.Ex2_Team.ChildRunner;

import Lesson_1_Object.Ex2_Team.CalssRunner.Runner;

public class Human extends Runner {

    // Перечень атрибутов принадлежащих контексту класса:
    protected static int counterObject;     // счётчик количества объектов

    // Параметризированный конструктор класа
    public Human(String name, int age, int maxDistanceRun, int maxHeightJump) {
        // инициализация полей объекта класса
        this.setName(name);
        this.setAge(age);
        this.setColor(color);
        this.setMaxDistance(maxDistanceRun);
        this.setRemainsDistance(maxDistanceRun);
        this.setMaxHeight(maxHeightJump);
        this.setTakePart(true);
        // вывод информации об объекте, а также инкремент количества объектов класса Dog:
        if (showObject()) {
            counterObject++;
        }
    }

    //Неформатированный вывод данных об экземпляре класса
    @Override
    public String toString() {
        return "Human {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", maxDistance=" + maxDistance +
                ", remainsDistance=" + remainsDistance +
                ", maxHeight=" + maxHeight +
                ", takePart=" + takePart +
                ", currentPalace=" + currentPalace +
                '}';
    }

    // Метод класса для получения информации о всех созданных объектах класса
    public static int getCounterObject() {
        return counterObject;
    }

    // Переопределённый метод класса Runner
    @Override
    public String voice(){
        return this.getName() + " рад, что дошел до финиша!";
    }
}
