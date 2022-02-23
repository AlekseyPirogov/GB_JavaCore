// Дисциплина: Java Core для тестировщиков
// Домашнее задание №3 "Generics"
// Студент: Алексей Пирогов
// Дата: 23.02.2022

package Lesson_3_Generics;

// Задача №2:
// Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
// Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
// Для хранения фруктов внутри коробки можно использовать ArrayList (ArrayList обсудим на следующем уроке);
// Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
// Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны,
// false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
// Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
// Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
// Не забываем про метод добавления фрукта в коробку.

import Lesson_3_Generics.Ex2_FriutInBox.BoxFruit;
import Lesson_3_Generics.Ex2_FriutInBox.Fruit.Apple;
import Lesson_3_Generics.Ex2_FriutInBox.Fruit.Orange;

public class JavaCore_HWApp {

    public static void main(String[] args) {

        BoxFruit<Apple> appleBox1 = new BoxFruit<>(new Apple(1.0f), new Apple(1.0f), new Apple(1.0f));
        appleBox1.toStr();   // Вывод информации об объекте
        appleBox1.getWeightBox(true);    // Вес фруктов и коробки
        System.out.println("");

        BoxFruit<Apple> appleBox2 = new BoxFruit<>(new Apple(1.2f), new Apple(1.0f), new Apple(1.8f));
        appleBox2.toStr();   // Вывод информации об объекте
        appleBox2.getWeightBox(true);    // Вес фруктов и коробки
        System.out.println("");

        BoxFruit<Orange> orangeBox1 = new BoxFruit<>(new Orange(1.5f), new Orange(1.5f), new Orange(1.5f));
        orangeBox1.toStr();  // Вывод информации об объекте
        orangeBox1.getWeightBox(true);   // Вес фруктов и коробки
        System.out.println("");

        BoxFruit<Orange> orangeBox2 = new BoxFruit<>(new Orange(1.2f), new Orange(1.45f), new Orange(1.35f));
        orangeBox2.toStr();  // Вывод информации об объекте
        orangeBox2.getWeightBox(true);   // Вес фруктов, коробки, количество объектов
        System.out.println("");

        System.out.println("Сравнение коробоки \"appleBox1\" и \"orangeBox1\" с использованием метода \"compareBox\" контекста объекта: ");
        appleBox1.compareBox(orangeBox1, false);

        System.out.println("\nСравнение коробоки \"appleBox1\" и \"orangeBox1\" с использованием метода \"compareObjects\" контекста класса: ");
        BoxFruit.compareObjects(appleBox1, orangeBox1, false);

        System.out.println("\nСравнение коробоки \"appleBox2\" и \"orangeBox2\" с использованием метода \"compareObjects\" контекста объекта: ");
        appleBox2.compareBox(orangeBox2, false);


        System.out.println("\n\nКопирование коробок \"appleBox1\" и \"appleBox2\" с использованием метода \"Box.copyBoxWithApple\" контекста класса: ");
        BoxFruit.copyBoxWithApple(appleBox1, appleBox2, true);

        System.out.println("\n\nКопирование коробок \"orangeBox1\" и \"orangeBox2\" с использованием метода \"orangeBox1.copyBoxOrange\" контекста объекта: ");
        orangeBox1.copyBoxOrange(orangeBox2, true);

        //  Box.copyBox(appleBox,orangeBox,true);    < -- ошибка при попытке обменять местами объекты типа Box с разными данными

        System.out.println("\n\nПример работы функции по добавлению элементов в объект (массив):");

        BoxFruit<Apple> exampleBox = new BoxFruit<>(new Apple());
        exampleBox.toStr();
        exampleBox = exampleBox.addAppleInBox(new Apple());
        exampleBox.toStr();
        System.out.println("");

        BoxFruit<Orange> orangeBox = new BoxFruit<>(new Orange());
        orangeBox.toStr();
        orangeBox = orangeBox.addOrangeInBox(new Orange());
        orangeBox.toStr();
        orangeBox = orangeBox.addOrangeInBox(new Orange());
        orangeBox.toStr();

    }
}
