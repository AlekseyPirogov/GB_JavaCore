// Дисциплина: Java Core для тестировщиков
// Домашнее задание №3 "Generics"
// Студент: Алексей Пирогов
// Дата: 23.02.2022

// Здача 1. Написать метод, который меняет два элемента массива местами
// (массив может быть любого ссылочного типа);

package Lesson_3_Generics.Ex1_ChangeItem;

// Класс содержит поле типа TypeVariable

public class ArrayForChangeItem_<T> {

    // Поле класса, тип Т
    public T object;

    // Конструктор параметризованного класса ArrayForChangeItem_<T>
    // Аргумент - ссылка на объект типа Т
    public ArrayForChangeItem_(T object) {
        this.object = object;
    }

    // Набор сеттеров и геттеров
    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    // Метод для вывода информации об объекте в виде строки
    @Override
    public String toString() {
        return "ArrayForChangeItem_{" +
                "object=" + object +
                '}';
    }

    // Метод контекста объекта для обмена элементов массива местами
    public void arrayChangeItem(ArrayForChangeItem_<T> changeItem) {
        ArrayForChangeItem_<T> buffer = new ArrayForChangeItem_<>(this.getObject());
        this.setObject(changeItem.getObject());
        changeItem.setObject(buffer.getObject());
    }

    // Метод контекста класса для обмена элементов массива местами
    public static void arrayChangeItem(ArrayForChangeItem_[] array, int firstItem, int secondItem) {
        //Объявление буферной переменной типа ArrayForChangeItem_<Object> с инициализацией первым элементом массива (первого аргумента ф-ции)
        ArrayForChangeItem_<Object> buffer = new ArrayForChangeItem_<>(array[firstItem].getObject());
        // Обмен элементов внутри массива (первого аргумента функции)
        array[firstItem].setObject(array[secondItem].getObject());
        // Присвоение второму элементу массива значения из буферной переменной
        array[secondItem].setObject(buffer.getObject());
    }

    // Метод контекста класса для вывода информации об элементах массива
    public static void printArray(ArrayForChangeItem_<?>[] array, String str) {
        System.out.println(str);
        // Цикл для вывода значений массива объектов типа ArrayForChangeItem_<?>
        for(int i=0; i < array.length; i++)
            System.out.print(array[i].getObject() + " ");
        System.out.println();
    }

    // Обмен элементов массива
    public static void main(String[] args) {

        ArrayForChangeItem_<Integer>[] integerArrayForChangeItem_ = new ArrayForChangeItem_[]{new ArrayForChangeItem_<>(0), new ArrayForChangeItem_<>(1), new ArrayForChangeItem_<>(2)};
        printArray(integerArrayForChangeItem_, "Массив до: ");
        arrayChangeItem(integerArrayForChangeItem_, 0, 2);
        printArray(integerArrayForChangeItem_, "Массив после: ");

        ArrayForChangeItem_<Float>[] floatArrayForChangeItem_ = new ArrayForChangeItem_[]{new ArrayForChangeItem_(1.0), new ArrayForChangeItem_(1.5), new ArrayForChangeItem_(0.75)};
        printArray(floatArrayForChangeItem_, "Массив до: ");
        arrayChangeItem(floatArrayForChangeItem_, 0, 1);
        printArray(floatArrayForChangeItem_, "Массив после: ");

        ArrayForChangeItem_<String>[] stringArrayForChangeItem_ = new ArrayForChangeItem_[]{new ArrayForChangeItem_("a"), new ArrayForChangeItem_("b"), new ArrayForChangeItem_("c")};
        printArray(stringArrayForChangeItem_, "Массив до: ");
        arrayChangeItem(stringArrayForChangeItem_, 2, 0);
        printArray(stringArrayForChangeItem_, "Массив после: ");

        ArrayForChangeItem_<Object>[] objectArrayForChangeItem_ = new ArrayForChangeItem_[]{new ArrayForChangeItem_(1), new ArrayForChangeItem_("srt"), new ArrayForChangeItem_(1.25)};
        printArray(objectArrayForChangeItem_, "Массив до: ");
        arrayChangeItem(objectArrayForChangeItem_, 1, 0);
        printArray(objectArrayForChangeItem_, "Массив после: ");

        ArrayForChangeItem_<Boolean>[] booleanArrayForChangeItem_ = new ArrayForChangeItem_[]{new ArrayForChangeItem_(true), new ArrayForChangeItem_(false), new ArrayForChangeItem_(true)};
        printArray(booleanArrayForChangeItem_, "Массив до: ");
        booleanArrayForChangeItem_[0].arrayChangeItem(booleanArrayForChangeItem_[1]);
        printArray(booleanArrayForChangeItem_, "Массив после: ");

    }
}
