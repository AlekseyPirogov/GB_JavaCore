package Lesson_3_Generics.Ex2_FriutInBox;

import Lesson_3_Generics.Ex2_FriutInBox.Fruit.Apple;
import Lesson_3_Generics.Ex2_FriutInBox.Fruit.Fruit;
import Lesson_3_Generics.Ex2_FriutInBox.Fruit.Orange;

public class BoxFruit<TypeVariable extends Fruit> {

    // Поля класса:
    private TypeVariable[] objectArray;

    // Набор параметризованых конструкторов:
    public BoxFruit(TypeVariable... object) {
        this.objectArray = object;
    }

    // Для создания коробок с яблоками
    public <TypeApple extends Apple> BoxFruit(TypeApple[] objectArray) {
        this.objectArray = (TypeVariable[]) objectArray;
    }

    // Для создания коробок с апельсинами
    public <TypeApple extends Orange> BoxFruit(TypeApple[] objectArray) {
        this.objectArray = (TypeVariable[]) objectArray;
    }

    public TypeVariable[] getObjectArray() {
        return objectArray;
    }

    public void setObjectArray(TypeVariable[] objectArray) {
        this.objectArray = objectArray;
    }

    public void toStr() {
        System.out.println("Объект типа \"" + this.getClass().getSimpleName() + "\", содержит элементы типа \"" + this.objectArray[0].getClass().getSimpleName() + "\":");
        for (int i = 0; i < this.getObjectArray().length; i++)
            System.out.println(this.getObjectArray()[i].getClass().getName() + "\t[вес: " + this.getObjectArray()[i].getWeight() + "f]");
    }

    // Метод контекста объекта класса Box
    public float getWeightBox(boolean print) {

        Float weightBox = 10.0f;
        Float weightFruitInBox = 0.0f;
        Integer countObject = this.getObjectArray().length;

        for (int i = 0; i < countObject; i++) {
            weightFruitInBox += this.getObjectArray()[i].getWeight();
        }
        if (print) {
            System.out.println("Количество объектов в коробке: " + countObject);
            System.out.println("Вес коробки с фруктами: " + (weightBox + weightFruitInBox) + "f");
            System.out.println("Вес фруктов в коробке: " + weightFruitInBox + "f");

        }
        return weightFruitInBox;
    }

    // Метод контекста объекта класса Box
    public boolean compareBox(BoxFruit<?> cmpArray, boolean print) {

        boolean result = false;
        if ((this.getWeightBox(print)) == (cmpArray.getWeightBox(print))) {
            result = true;
            System.out.println("Значения коробок равны!");
        } else {
            System.out.println("Значения коробок не равны!");
        }
        return result;
    }

    // Метод контекста класса Box
    public static boolean compareObjects(BoxFruit<?> firstBox, BoxFruit<?> secondBox, boolean print) {

        boolean result = false;
        if (firstBox.getWeightBox(print) == secondBox.getWeightBox(print)) {
            System.out.println("Значения коробок равны!");
            result = true;
        } else {
            System.out.println("Значения коробок не равны!");
        }
        return result;
    }

    // Метод контекста класса Box для копирования объектов класса Apple
    public static <SameType1 extends Apple, SameType2 extends Apple> boolean copyBoxWithApple(BoxFruit<SameType1> firstArray, BoxFruit<SameType2> secondArray, boolean print) {

        boolean result = false;

        if (firstArray.objectArray.length == secondArray.objectArray.length) {
            System.out.println("Пример копирования данных из одного объекта (массива объекта) в другой, типы и размерность хранимых данных совпадают.");
            Float buffer;
            if (print) {
                System.out.println("firstBox: ");
                for (int i = 0; i < firstArray.objectArray.length; i++) {
                    System.out.print(firstArray.getObjectArray()[i].getWeight() + "\t");
                }

                System.out.println("\nsecondBox: ");
                for (int i = 0; i < secondArray.objectArray.length; i++) {
                    System.out.print(secondArray.getObjectArray()[i].getWeight() + "\t");
                }
            }
            System.out.println("\nОбмен массивов местами...");
            for (int i = 0; i < firstArray.objectArray.length; i++) {
                buffer = firstArray.getObjectArray()[i].getWeight();
                firstArray.getObjectArray()[i].setWeight(secondArray.getObjectArray()[i].getWeight());
                secondArray.getObjectArray()[i].setWeight(buffer);
                result = true;
            }
            if (print) {
                System.out.println("\nfirstBox: ");
                for (int i = 0; i < firstArray.objectArray.length; i++) {
                    System.out.print(firstArray.getObjectArray()[i].getWeight() + "\t");
                }

                System.out.println("\nsecondBox: ");
                for (int i = 0; i < secondArray.objectArray.length; i++) {
                    System.out.print(secondArray.getObjectArray()[i].getWeight() + "\t");
                }
            } else {
                System.out.println("Нельзя скопировать данные, разная размерность объектов (массивов объектов).");
            }
        }
        return result;
    }

    // Метод контекста класса Box для копирования объектов класса Orange
    public static <SameType1 extends Orange, SameType2 extends Orange> boolean copyBoxWithOrange(BoxFruit<SameType1> firstArray, BoxFruit<SameType2> secondArray, boolean print) {

        boolean result = false;

        if (firstArray.objectArray.length == secondArray.objectArray.length) {
            System.out.println("Пример копирования данных из одного объекта (массива объекта) в другой, типы и размерность хранимых данных совпадают.");
            Float buffer;
            if (print) {
                System.out.println("firstBox: ");
                for (int i = 0; i < firstArray.objectArray.length; i++) {
                    System.out.print(firstArray.getObjectArray()[i].getWeight() + "\t");
                }

                System.out.println("\nsecondBox: ");
                for (int i = 0; i < secondArray.objectArray.length; i++) {
                    System.out.print(secondArray.getObjectArray()[i].getWeight() + "\t");
                }
            }
            System.out.println("\nОбмен массивов местами...");
            for (int i = 0; i < firstArray.objectArray.length; i++) {
                buffer = firstArray.getObjectArray()[i].getWeight();
                firstArray.getObjectArray()[i].setWeight(secondArray.getObjectArray()[i].getWeight());
                secondArray.getObjectArray()[i].setWeight(buffer);
                result = true;
            }
            if (print) {
                System.out.println("\nfirstBox: ");
                for (int i = 0; i < firstArray.objectArray.length; i++) {
                    System.out.print(firstArray.getObjectArray()[i].getWeight() + "\t");
                }

                System.out.println("\nsecondBox: ");
                for (int i = 0; i < secondArray.objectArray.length; i++) {
                    System.out.print(secondArray.getObjectArray()[i].getWeight() + "\t");
                }
            } else {
                System.out.println("Нельзя скопировать данные, разная размерность объектов (массивов объектов).");
            }
        }
        return result;
    }

    // Метод контекста объекта класса Box для копирования объектов Apple
    public <SameType extends Apple> boolean copyBoxApple(BoxFruit<SameType> secondArray, boolean print) {

        boolean result = false;

        if (this.objectArray.length == secondArray.objectArray.length) {
            System.out.println("Пример копирования данных из одного объекта (массива объекта) в другой, типы и размерность хранимых данных совпадают.");
            Float buffer;
            if (print) {
                System.out.println("currentBox: ");
                for (int i = 0; i < this.objectArray.length; i++) {
                    System.out.print(this.getObjectArray()[i].getWeight() + "\t");
                }

                System.out.println("\nsecondBox: ");
                for (int i = 0; i < secondArray.objectArray.length; i++) {
                    System.out.print(secondArray.getObjectArray()[i].getWeight() + "\t");
                }
            }
            System.out.println("\nОбмен массивов местами...");
            for (int i = 0; i < this.objectArray.length; i++) {
                buffer = this.getObjectArray()[i].getWeight();
                this.getObjectArray()[i].setWeight(secondArray.getObjectArray()[i].getWeight());
                secondArray.getObjectArray()[i].setWeight(buffer);
                result = true;
            }
            if (print) {
                System.out.println("\nfirstBox: ");
                for (int i = 0; i < this.objectArray.length; i++) {
                    System.out.print(this.getObjectArray()[i].getWeight() + "\t");
                }

                System.out.println("\nsecondBox: ");
                for (int i = 0; i < secondArray.objectArray.length; i++) {
                    System.out.print(secondArray.getObjectArray()[i].getWeight() + "\t");
                }
            } else {
                System.out.println("Нельзя скопировать данные, разная размерность объектов (массивов объектов).");
            }
        }
        return result;
    }

    // Метод контекста объекта класса Box для копирования объектов Orange
    public <SameType extends Orange> boolean copyBoxOrange(BoxFruit<SameType> secondArray, boolean print) {

        boolean result = false;

        if (this.objectArray.length == secondArray.objectArray.length) {
            System.out.println("Пример копирования данных из одного объекта (массива объекта) в другой, типы и размерность хранимых данных совпадают.");
            Float buffer;
            if (print) {
                System.out.println("currentBox: ");
                for (int i = 0; i < this.objectArray.length; i++) {
                    System.out.print(this.getObjectArray()[i].getWeight() + "\t");
                }

                System.out.println("\nsecondBox: ");
                for (int i = 0; i < secondArray.objectArray.length; i++) {
                    System.out.print(secondArray.getObjectArray()[i].getWeight() + "\t");
                }
            }
            System.out.println("\nОбмен массивов местами...");
            for (int i = 0; i < this.objectArray.length; i++) {
                buffer = this.getObjectArray()[i].getWeight();
                this.getObjectArray()[i].setWeight(secondArray.getObjectArray()[i].getWeight());
                secondArray.getObjectArray()[i].setWeight(buffer);
                result = true;
            }
            if (print) {
                System.out.println("\nfirstBox: ");
                for (int i = 0; i < this.objectArray.length; i++) {
                    System.out.print(this.getObjectArray()[i].getWeight() + "\t");
                }

                System.out.println("\nsecondBox: ");
                for (int i = 0; i < secondArray.objectArray.length; i++) {
                    System.out.print(secondArray.getObjectArray()[i].getWeight() + "\t");
                }
            } else {
                System.out.println("Нельзя скопировать данные, разная размерность объектов (массивов объектов).");
            }
        }
        return result;
    }

    // Методы для добавления объекта к массиву:
    public BoxFruit<Apple> addAppleInBox(Apple apple) {
        Apple[] apples = new Apple[this.objectArray.length + 1];
        for (int i = 0; i < apples.length; i++)
            apples[i] = new Apple();
        BoxFruit<Apple> appleBox = new BoxFruit<>(apples);

        return appleBox;
    }

    public BoxFruit<Orange> addOrangeInBox(Orange orange) {
        Orange[] oranges = new Orange[this.objectArray.length + 1];
        for (int i = 0; i < oranges.length; i++)
            oranges[i] = new Orange();
        BoxFruit<Orange> orangeBox = new BoxFruit<>(oranges);

        return orangeBox;
    }

}

