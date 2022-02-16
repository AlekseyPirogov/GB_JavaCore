package Lesson_1_Object.Ex3_Course;

public class Barrier extends ElementCourse {

    // Перечень атрибутов принадлежащих контексту класса:
    protected static int counterWall;   // счётчик количества объектов
    // используется для нумерации объектов при создании полосы препятсвий с размерностью N

    // Перечень атрибутов объекта:
    protected int numberWall;           // номер препятствия
    private int height;                 // высота препятствия

    // инициализатор static отвечает за зануление счётчика количества препятствий (стен)
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterWall = 0;
    }

    // инициализатор отвечает за инкремент поля counterWall
    // вызывается при каждом образещении к конструктору, создании объекта класса
    {
        // инкремент количества объектов в:
        super.counterWall++;   // родительском классе
        counterWall++;         // текущем классе
    }

    // Непараметризированный конструктор класса Wall, используется по умолчанию
    public Barrier() {
        setNumberWall(counterWall); // вызов метода для нумерации препятствий
        int height = (int)(Math.random() * 100 + 30);   // высота препятствия от 30 до 150
        setHeight(height);  // вызов метода для установки высоты препятствия
        System.out.println(this.toString());
        //System.out.println("Создан объект класса Wall: под номером " + getNumberWall() + " и высотой " + getHeight() + " см.");
    }

    // Параметризированный конструктор класса Wall
    public Barrier(int height) {
        // набор условий для проверки принадлежности параметра height интервалу целых положительных чисел
        if (height < 0) {
            System.out.println("Ошибка ввода данных, высота препятсвия не может быть отрицательной.");
        } else if (height == 0) {
            System.out.println("Ошибка ввода данных, высота препятсвия не может быть равна нулю.");
        } else if (height >= 0) {
            setNumberWall(counterWall); // вызов метода для нумерации препятствий
            setHeight(height);  // вызов метода для установки высоты препятствия
            // вывод информации о созданном объекте
            System.out.println(this.toString());
            //System.out.println("Создан объект класса Wall: под номером " + getNumberWall() + " и высотой " + getHeight() + " см.");
        }
    }

    // Переопределение метода toString, принадлежазего классу Object
    @Override
    public String toString() {
        return "Barrier {" +
                "numberWall=" + numberWall +
                ", height=" + height +
                '}';
    }

    // Набор методов для инициализации атрибута объектов класса
    // Метод для получения номера препятствия
    public int getNumberWall() {
        return numberWall;
    }

    // Метод для установки номера препятствия
    public void setNumberWall(int numberWall) {
        this.numberWall = numberWall;
    }

    // Метод для получения высоты препятствия
    public int getHeight() {
        return height;
    }

    // Метод для установки высоты препятствия
    public void setHeight(int height) {
        this.height = height;
    }

    // Метод для зануления счётчика объектов
    public static void setCounterWall(int counterWall) {
        Barrier.counterWall = counterWall;
    }

}
