package Lesson_3_Generics.Ex0_ExampleCode;

// Пример параметризованного класса с двойной параметризацией и буквами T и U

public class MultipleGenBox<T, U> {

    private T objectT;
    private U objectU;

    // Параметризованный конструктор класа с двумя параметризованными аргументами
    public MultipleGenBox(T objectT, U objectU) {
        this.objectT = objectT;
        this.objectU = objectU;
    }

    // Набор геттеров и сеттеров:
    public T getObjectT() {
        return objectT;
    }

    public U getObjectU() {
        return objectU;
    }

    public void setObjectT(T objectT) {
        this.objectT = objectT;
    }

    public void setObjectU(U objectU) {
        this.objectU = objectU;
    }

    // Метод для вывода полей объекта
    @Override
    public String toString() {
        return "MultipleGenBox{" +
                "objectT=" + objectT +
                ", objectU=" + objectU +
                '}';
    }

    public static void main(String[] args) {

        // Пример вывода полей объекта:
        MultipleGenBox<Integer, String> multipleGenBox = new MultipleGenBox<>(145000000, "Нacеление России");

        System.out.println("multipleGenBox.getObjectT(): " + multipleGenBox.getObjectT());
        System.out.println("multipleGenBox.getObjectT().getClass().getName(): " + multipleGenBox.getObjectT().getClass().getName());

        System.out.println("multipleGenBox.getObjectU(): " + multipleGenBox.getObjectU());
        System.out.println("multipleGenBox.getObjectU().getClass().getName(): " + multipleGenBox.getObjectU().getClass().getName());

        System.out.println("\n" + multipleGenBox.getObjectU() + ": " + multipleGenBox.getObjectT());
    }
}
