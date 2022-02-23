// Дисциплина: Java Core для тестировщиков
// Домашнее задание №3 "Generics"
// Студент: Алексей Пирогов
// Дата: 23.02.2022

package Lesson_3_Generics.Ex1_ChangeItem;

// Здача 1. Написать метод, который меняет два элемента массива местами
// (массив может быть любого ссылочного типа);

import java.util.Arrays;

// Класс содержит поле (массив) типа TypeVariable

public class ArrayForChangeItem<TypeVariable> {

    // Поле класса, тип Т
    public TypeVariable[] object;

    // Конструктор параметризованного класса ArrayForChangeItem<Type>
    // Аргумент - синтаксический сахар, набор ссылок на объекты типа Т
    public ArrayForChangeItem(TypeVariable... object){
        this.object = object;
    }

    // Набор геттеров и сеттеров:
    public TypeVariable[] getObject() {
        return object;
    }

    public void setObject(TypeVariable[] object) {
        this.object = object;
    }

    // Метод для вывода информации об объекте в виде строки:
    @Override
    public String toString() {
        return "ArrayForChangeItem{" +
                "object=" + Arrays.toString(object) +
                '}';
    }

    // Метод для вывода информации об элементах массива
    public void printArray(String str, boolean formatPrint) {
        System.out.println(str);    // Вывод строки
        // Форматированный вывод данных
        if (formatPrint) {
            for (int i=0; i < this.getObject().length; i++)
                System.out.println(this.getObject()[i] + " ");
        } else {
            System.out.println(this.toString() + " ");
        }
        System.out.println();
    }

    // Метод контекста объекта для обмена местами двух элементов в массиве строке
    public void arrayChangeItem(int firstItem, int secondItem) {
        // Объявление буферной переменной типа ArrayForChangeItem<TypeVariable> с инициализацией
        // первым элементом массива
        ArrayForChangeItem<TypeVariable> variable = new ArrayForChangeItem<>(this.getObject()[firstItem]);
        // Обмен элементов массива местами:
        this.getObject()[firstItem] = this.getObject()[secondItem];
        // Присвоение второму элементу массива значения из буферной переменной
        this.getObject()[secondItem] = variable.getObject()[0];
    }

    // Метод контекста класса для обмена метами двух элементов в массиве строке
    public static void arrayChangeItem(ArrayForChangeItem array, int firstItem, int secondItem) {
        // Объявление буферной переменной типа ArrayForChangeItem<?> с инициализацией первым элементом массива
        ArrayForChangeItem<?> bufferVariable = new ArrayForChangeItem<>(array.getObject()[firstItem]);
        // Обмен элементов массива местами:
        array.getObject()[firstItem] = array.getObject()[secondItem];
        // Присвоение второму элементу массива значения из буферной переменной
        array.object[secondItem] = bufferVariable.getObject()[0];
    }

    public static void main(String[] args) {

        System.out.println("Пример обмена элементов в массиве местами. Исходный массив: ");
        ArrayForChangeItem<Integer> arrayInteger = new ArrayForChangeItem(0,1,2,3,4,5);
        System.out.println(arrayInteger.toString());
        System.out.println("Массив после обмена нулевого и первого элемента: ");
        arrayInteger.arrayChangeItem(0,1);
        System.out.println(arrayInteger.toString());
        System.out.println("Массив после обмена первого и второго элемента: ");
        arrayChangeItem(arrayInteger,1,2);
        System.out.println(arrayInteger.toString());

    }

}
