package Lesson_1_Object.Ex3_Course;

public class Track extends ElementCourse {

    // Перечень атрибутов принадлежащих контексту класса:
    protected static int counterTrack;   // счётчик количества объектов
    // используется для нумерации объектов при создании полосы препятсвий с размерностью N

    // Перечень атрибутов объекта:
    private int numberTrack;             // номер сектора
    private int lengthTrack;             // длина сектора

    // инициализатор static отвечает за зануление счётчика количества препятствий (стен)
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterTrack = 0;
    }

    // инициализатор отвечает за инкремент поля counterObject
    // вызывается при каждом образещении к конструктору, создании объекта класса
    {
        // инкремент количества объектов в:
        super.counterTrack++;   // родительском классе
        counterTrack++;         // текущем классе
    }

    // !!! Нужно попробовать объединить конструкторы с использованием переменного числа параметров !!!

    // Непараметризированный конструктор класса Wall, используется по умолчанию
    public Track() {
        setNumberTrack(counterTrack);
        int length = (int)(Math.random() * 150 + 10);   // высота препятствия от 10 до 150 м.
        setLengthTrack(length);
        System.out.println(this.toString());  // Пример вывода информации с использование метода toString
        // Пример вывода информации с использование методов getNumberTrack() и getLengthTrack()
        // System.out.println("Создан объект класса Track: под номером " + getNumberTrack() + ", длина трека - " + getLengthTrack() + " м.");

    }

    // Параметризированный конструктор класса Wall
    public Track(int length) {
        if (length < 0) {
            System.out.println("Ошибка ввода данных, длина препятсвия не может быть отрицательной.");
        } else if (length == 0) {
            System.out.println("Ошибка ввода данных, длина препятсвия не может быть равна нулю.");
        } else {
            setNumberTrack(counterTrack); //
            setLengthTrack(length);
            System.out.println(this.toString()); // Пример вывода информации с использование метода toString
            // Пример вывода информации с использование методов getNumberTrack() и getLengthTrack()
            // System.out.print("\tСоздан объект класса Track: под номером " + getNumberTrack() + ", длина трека - " + getLengthTrack() + " м.");

        }
    }

    // Переопределение метода toString, принадлежазего классу Track
    @Override
    public String toString() {
        return "Track {" +
                "numberTrack=" + numberTrack +
                ", lengthTrack=" + lengthTrack +
                '}';
    }

    // Набор методов для инициализации атрибута объектов класса
    // Метод для получения номера дорожки
    public int getNumberTrack() {
        return numberTrack;
    }

    // Метод для получения номера дорожки
    public void setNumberTrack(int numberTrack) {
        this.numberTrack = numberTrack;
    }

    // Метод для получения высоты препятствия
    public int getLengthTrack() {
        return lengthTrack;
    }

    // Метод для получения высоты препятствия
    public void setLengthTrack(int lengthTrack) {
        this.lengthTrack = lengthTrack;
    }

    // Метод для зануления счётчика объектов
    public static void setCounterTrack(int counterTrack) {
        Track.counterTrack = counterTrack;
    }
}
