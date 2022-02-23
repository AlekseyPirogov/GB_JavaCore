package Lesson_3_Generics.Ex0_ExampleCode;

// Класс хранящий в себе ссылочный объект любого типа:

public class Box {

    public Object object;       // ссылочное поле для храения объектов ссылочного типа

    // Параметризированный конструктор класса
    public Box(Object object){
        this.object = object;
    }

    // Наборе геттеров и сеттеров:
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "Box{" +
                "object=" + object +
                '}';
    }

    public static void main(String[] args) {

        // Создание объектов:
        Box box1 = new Box(10);
        Box box2 = new Box(100);
        Box box3 = new Box("100");

        // Вывод информации о храними объекте в консоль:
        System.out.println("box1.getObject():\t" + box1.getObject());
        System.out.println("box1.getObject().getClass().getName():\t" + box1.getObject().getClass().getName());
        System.out.println("box1.getObject().getClass().getSimpleName():\t" + box1.getObject().getClass().getSimpleName());

        // Пример сложения объектов:
        System.out.println("\nbox2.getObject():\t" + box2.getObject());
        System.out.println("box2.getObject().getClass().getName():\t" + box2.getObject().getClass().getName());
        System.out.println("box2.getObject().getClass().getSimpleName():\t" + box2.getObject().getClass().getSimpleName());

        // Для сложения требуется обязательное приведение типов:
        System.out.println("\nОперация сложения объектов: (Integer) box1.getObject() + (Integer) box2.getObject() = " + ((Integer) box1.getObject() + (Integer) box2.getObject()));
        // В ином случае, при конкатенации строк:
        System.out.println("Операция конкатенации: box1.getObject().toString() + box2.getObject().toString() = " + box1.getObject().toString() + box2.getObject().toString());

        // Если в качестве второго аргемента для операции сложения будет использован тип String, а не Integer, то
        // возникнет ошибка:
        System.out.println("\nbox3.getObject():\t" +box3.getObject());
        System.out.println("box3.getObject().getClass().getName():\t" + box3.getObject().getClass().getName());
        System.out.println("box3.getObject().getClass().getSimpleName():\t" + box3.getObject().getClass().getSimpleName());

        // Пример:
        //System.out.println("(Integer) box1.getObject() + (Integer) box3.getObject() = " + (Integer) box1.getObject() + (Integer) box3.getObject());
        if (box1.getObject() instanceof Integer && box3.getObject() instanceof Integer)
            System.out.println("(Integer) box1.getObject() + (Integer) box3.getObject() = " + (Integer) box1.getObject() + (Integer) box3.getObject());
        // (!!!) Неудобство данного метода заключается в постоянной проверке типов и их приведении
        // Применяется для того чтобы создать обёртку над классом. Является одним из паттернов проектирования

        // Проверку instanceof из примера лучше не использовать в промышленном коде...
        // ... при этом данный код правильнее сделать типизированным, так как для данного метода характерны
        // следующие проблемы:
        // - каждый раз, когда требуется вытащить данные из коробки, то потребуется выполнять привидение типов;
        // - чтобы не получить ClassCastException, перед каждым привидением типов, необходимо делать проверку
        // типов данных с помощью instanceof;
        // - если где-то будет применяться приведение типов, и не будет instanceof, то появится вероятность
        // появления ClassCastExeption в этой части кода.
    }
}
