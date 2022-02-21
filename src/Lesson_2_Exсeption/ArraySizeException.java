package Lesson_2_Exсeption;

// класс ArrayDataException является наследником класса Exception
public class ArraySizeException extends Exception {

    // Перегруженный параметризированный констурктор обрабатывающий объект типа String
    ArraySizeException(String str) {
        super(str);     // вызов родительского конструктора
    }

    // Перегруженный параметризированный констурктор обрабатывающий массив объектов типа String
    ArraySizeException(String[][] array) {
        super("ArraySizeExeption: в функцию передан массив размерности " + array.length + " x " + array[0].length + ", что отличается от 4 x 4 ...");
    }
}
