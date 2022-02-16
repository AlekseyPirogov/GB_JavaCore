package Lesson_1_Object.Ex3_Course;

public abstract class ElementCourse {

    // Перечень атрибутов принадлежащих контексту класса:
    protected static int counterTrack;   // счётчик количества объектов
    protected static int counterWall;    // счётчик количества объектов

    // Перечень атрибутов объекта:
    protected int number;           // номер препятствия


    // Набор геттеров и сеттеров
    public static int getCounterTrack() {
        return counterTrack;
    }

    public static void setCounterTrack(int counterTrack) {
        ElementCourse.counterTrack = counterTrack;
    }

    public static int getCounterWall() {
        return counterWall;
    }

    public static void setCounterWall(int counterWall) {
        ElementCourse.counterWall = counterWall;
    }
}
