package Lesson_1_Object.Ex2_Team.ChildRunner;

import Lesson_1_Object.Ex2_Team.CalssRunner.Runner;
import Lesson_1_Object.Ex3_Course.Barrier;
import Lesson_1_Object.Ex3_Course.Track;

public class Dog extends Runner {

    // Перечень атрибутов принадлежащих контексту класса:
    protected static int counterObject;     // счётчик количества объектов

    // Параметризированный конструктор класа
    public Dog(String name, int age, String color, int maxDistanceRun, int maxHeightJump) {
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
        return "Dog {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
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

    // Набор методов для преодоления препятствий
    // метод для прыжка:
    final public void run(Track track) {
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

    // метод для бега:
    final public void jump(Barrier barrier) {
        if (this.getTakePart() == true) {
            if (barrier.getHeight() > this.getMaxHeight()) {
                this.setTakePart(false);
                this.setCurrentPalace(barrier.getNumberWall());
                System.out.println("Участник \"" + this.getName() + "\" не может перепрыгнуть. Высота препятствия " + barrier.getHeight() + " см., а максимальная высота прыжка - " + this.getMaxHeight() + " см.");
                System.out.println("Участник \"" + this.getName() + "\" участник выбыл из соревнований... Остановился на отрезке №" + this.getCurrentPalace() + " где-то перед препятствием.");
            } else {
                System.out.println("Участник \"" + this.getName() + "\" перепрыгнул ... препятсвие высотой " + barrier.getHeight() +
                        " см., максимальная высота прыжка - " + this.getMaxHeight() + " см.");
                this.setCurrentPalace(barrier.getNumberWall() + 1);
            }
        }
    }

    // Переопределённый метод класса Runner
    @Override
    public String voice(){
        return this.getName() + " громко лает на финише!";
    }
}
